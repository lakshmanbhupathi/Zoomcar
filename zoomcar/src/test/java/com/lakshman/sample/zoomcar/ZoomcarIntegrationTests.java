package com.lakshman.sample.zoomcar;

import com.lakshman.sample.zoomcar.entity.Vehicle;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ZoomcarIntegrationTests {

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    public void testAddUsersController() {
        ResponseEntity<Boolean> responseEntity =
                restTemplate.postForEntity("/addUsers", null, Boolean.class);
        Boolean response = responseEntity.getBody();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertTrue(response);
    }

    @Test
    public void testAddVehiclesController() {
        ResponseEntity<Boolean> responseEntity =
                restTemplate.postForEntity("/vehicle/addVehicles", null, Boolean.class);
        Boolean response = responseEntity.getBody();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertTrue(response);
    }

    @Test
    public void testGetAllVehicleController() {
        ResponseEntity<Vehicle[]> responseEntity =
                restTemplate.getForEntity("/vehicle/getAll", Vehicle[].class);
        Vehicle[] response = responseEntity.getBody();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(response);
        assertEquals(4, response.length);
    }


    @Test
    public void testGetVehicleByTypeController() {
        ResponseEntity<Vehicle[]> responseEntity =
                restTemplate.getForEntity("/vehicle/byType/SEDAN", Vehicle[].class);
        Vehicle[] response = responseEntity.getBody();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(response);
        assertEquals(2, response.length);
    }

    @Test
    public void testGetVehicleByTypeControllerWhenNotFound() {
        ResponseEntity<Vehicle[]> responseEntity =
                restTemplate.getForEntity("/vehicle/byType/CROSSOVER", Vehicle[].class);
        Vehicle[] response = responseEntity.getBody();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(response);
        assertEquals(0, response.length);
    }

    @Test
    public void testGetVehicleByTypeControllerWhenNotEnumFound() {
        ResponseEntity<Object> responseEntity =
                restTemplate.getForEntity("/vehicle/byType/SomeUnknownVehicleType", Object.class);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }

    @Test
    public void testGetVehicleByTypeControllerWhenNoVehicleType() {
        ResponseEntity<Object> responseEntity =
                restTemplate.getForEntity("/vehicle/byType", Object.class);
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }

}

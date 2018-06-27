package com.lakshman.sample.zoomcar;

import com.lakshman.sample.zoomcar.entity.Booking;
import com.lakshman.sample.zoomcar.entity.Vehicle;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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


}

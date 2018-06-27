package com.lakshman.sample.zoomcar;

import com.lakshman.sample.zoomcar.controller.BookingController;
import com.lakshman.sample.zoomcar.controller.UserController;
import com.lakshman.sample.zoomcar.controller.VehicleController;
import com.lakshman.sample.zoomcar.service.BookingService;
import com.lakshman.sample.zoomcar.service.BookingServiceImpl;
import com.lakshman.sample.zoomcar.service.UserService;
import com.lakshman.sample.zoomcar.service.UserServiceImpl;
import com.lakshman.sample.zoomcar.service.VehicleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZoomcarApplicationTests {

	@Autowired
	private BookingController bookingController;
	@Autowired
	private UserController userController;
	@Autowired
	private VehicleController vehicleController;

	@Autowired
	private BookingService bookingService;
	@Autowired
	private UserService userService;
	@Autowired
	private VehicleService vehicleService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void contextLoadControllerTests() {
		assertThat(bookingController).isNotNull();
		assertThat(vehicleController).isNotNull();
		assertThat(userController).isNotNull();
	}

	@Test
	public void contextLoadServiceTests() {
		assertThat(bookingService).isNotNull();
		assertThat(bookingService instanceof BookingServiceImpl).isTrue();


		assertThat(userService).isNotNull();
		assertThat(userService instanceof UserServiceImpl).isTrue();


		assertThat(userService).isNotNull();
		assertThat(userService instanceof UserServiceImpl).isTrue();
	}
}

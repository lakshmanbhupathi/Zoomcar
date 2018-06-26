package com.lakshman.sample.zoomcar.controller;

import com.lakshman.sample.zoomcar.dto.BookingRequest;
import com.lakshman.sample.zoomcar.dto.BookingResponse;
import com.lakshman.sample.zoomcar.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/bookVehicle")
    BookingResponse bookVehicle(@Valid @RequestBody BookingRequest bookingRequest) {
        return bookingService.bookVehicle(bookingRequest);
    }

//    @PostMapping("/bookVehicle")
//    BookingResponse bookVehicleDemo(BookingRequest bookingRequest) {
//        Booking booking = new Booking();
//        booking.setFromDate(new Date());
//        booking.setToDate(new Date(2018, 6, 29));
//
//        Optional<User> user = userRepository.findById(1L);
//        booking.setUser(user.get());
//        Optional<Vehicle> vehicle = vehicleRepository.findById(5L);
//        booking.setVehicle(vehicle.get());
//
//        bookingRepository.save(booking);
//
//        return null;
//    }


}

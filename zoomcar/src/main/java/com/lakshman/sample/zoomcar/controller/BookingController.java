package com.lakshman.sample.zoomcar.controller;

import com.lakshman.sample.zoomcar.dao.BookingRepository;
import com.lakshman.sample.zoomcar.dao.UserRepository;
import com.lakshman.sample.zoomcar.dao.VehicleRepository;
import com.lakshman.sample.zoomcar.dto.BookingResponse;
import com.lakshman.sample.zoomcar.dto.BookingRequest;
import com.lakshman.sample.zoomcar.entity.Booking;
import com.lakshman.sample.zoomcar.entity.User;
import com.lakshman.sample.zoomcar.entity.Vehicle;
import com.lakshman.sample.zoomcar.exceptions.ContentNotFoundException;
import com.lakshman.sample.zoomcar.exceptions.InternalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Optional;

@RestController
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    VehicleRepository vehicleRepository;


    @PostMapping("/bookVehicle")
    BookingResponse bookVehicle(@RequestBody BookingRequest bookingRequest) {

        Booking booking = new Booking();
        booking.setFromDate(bookingRequest.getFromDate());
        booking.setToDate(bookingRequest.getToDate());

        Optional<User> userOptional = userRepository.findById(bookingRequest.getUserId());
        if (userOptional.isPresent()) {
            booking.setUser(userOptional.get());
        } else {
            throw new ContentNotFoundException("User not found");
        }

        Optional<Vehicle> vehicleOptional = vehicleRepository.findById(bookingRequest.getVehicleId());
        if (vehicleOptional.isPresent()) {
            booking.setVehicle(vehicleOptional.get());
        } else {
            throw new ContentNotFoundException("Vehicle not found");
        }
        try {
            Booking bookingRepoResponse = bookingRepository.save(booking);
            return new BookingResponse(true, bookingRepoResponse.getBookingId());
        } catch (Exception e) {
            throw new InternalException(e.getMessage());
        }
    }

    @PostMapping("/bookVehicle")
    BookingResponse bookVehicleDemo(BookingRequest bookingRequest) {
        Booking booking = new Booking();
        booking.setFromDate(new Date());
        booking.setToDate(new Date(2018, 6, 29));

        Optional<User> user = userRepository.findById(1L);
        booking.setUser(user.get());
        Optional<Vehicle> vehicle = vehicleRepository.findById(5L);
        booking.setVehicle(vehicle.get());

        bookingRepository.save(booking);

        return null;
    }


}

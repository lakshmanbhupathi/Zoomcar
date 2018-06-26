package com.lakshman.sample.zoomcar.service;

import com.lakshman.sample.zoomcar.dao.BookingRepository;
import com.lakshman.sample.zoomcar.dao.UserRepository;
import com.lakshman.sample.zoomcar.dao.VehicleRepository;
import com.lakshman.sample.zoomcar.dto.BookingRequest;
import com.lakshman.sample.zoomcar.dto.BookingResponse;
import com.lakshman.sample.zoomcar.entity.Booking;
import com.lakshman.sample.zoomcar.entity.User;
import com.lakshman.sample.zoomcar.entity.Vehicle;
import com.lakshman.sample.zoomcar.exceptions.ContentNotFoundException;
import com.lakshman.sample.zoomcar.exceptions.InternalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VehicleRepository vehicleRepository;


    @Override
    public BookingResponse bookVehicle(BookingRequest bookingRequest) {
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
}

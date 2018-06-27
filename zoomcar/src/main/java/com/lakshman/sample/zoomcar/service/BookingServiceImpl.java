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

import java.util.List;
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

        booking.setUser(fetchUser(bookingRequest.getUserId()));

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

    @Override
    public List<Booking> getBookingHistory(String userId) {
        User user = fetchUser(Long.parseLong(userId));
        return bookingRepository.getPastHistoryByUser(user);
    }

    private User fetchUser(final Long userId) {
        User user;
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            user = userOptional.get();
        } else {
            throw new ContentNotFoundException("User not found");
        }
        return user;
    }
}

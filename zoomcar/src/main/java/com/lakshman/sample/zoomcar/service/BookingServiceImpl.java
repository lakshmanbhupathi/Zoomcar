package com.lakshman.sample.zoomcar.service;

import com.lakshman.sample.zoomcar.dao.BookingRepository;
import com.lakshman.sample.zoomcar.dto.BookingRequest;
import com.lakshman.sample.zoomcar.dto.BookingResponse;
import com.lakshman.sample.zoomcar.entity.Booking;
import com.lakshman.sample.zoomcar.entity.User;
import com.lakshman.sample.zoomcar.entity.Vehicle;
import com.lakshman.sample.zoomcar.exceptions.BookingFailedException;
import com.lakshman.sample.zoomcar.exceptions.InternalException;
import com.lakshman.sample.zoomcar.helper.BookingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private BookingHelper bookingHelper;


    @Override
    public BookingResponse bookVehicle(BookingRequest bookingRequest) {
        Booking booking = new Booking();

        booking.setFromDate(bookingRequest.getFromDate());
        booking.setToDate(bookingRequest.getToDate());

        booking.setUser(userService.getUserById(bookingRequest.getUserId()));

        Vehicle vehicle = vehicleService.getVehicleById(bookingRequest.getVehicleId());
        booking.setVehicle(vehicle);

        if(!bookingHelper.validateBooking(bookingRequest, vehicle)){
            throw new BookingFailedException();
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
        User user = userService.getUserById(Long.parseLong(userId));
        return bookingRepository.getPastHistoryByUser(user);
    }


}

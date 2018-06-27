package com.lakshman.sample.zoomcar.helper;

import com.lakshman.sample.zoomcar.dao.BookingRepository;
import com.lakshman.sample.zoomcar.dto.BookingRequest;
import com.lakshman.sample.zoomcar.entity.Booking;
import com.lakshman.sample.zoomcar.entity.Vehicle;
import com.lakshman.sample.zoomcar.exceptions.BookingBadRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.lakshman.sample.zoomcar.utils.DateUtils.areDatesEqual;
import static com.lakshman.sample.zoomcar.utils.DateUtils.isBetween;

@Component
public class BookingHelperImpl implements BookingHelper {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public boolean validateBooking(BookingRequest bookingRequest, Vehicle vehicle) {
        boolean result = true;

        if (bookingRequest.getFromDate().after(bookingRequest.getToDate())) {
            throw new BookingBadRequest();
        }

        List<Booking> bookingList = bookingRepository.getBookingsByVehicle(vehicle);
        for (Booking b : bookingList) {
            if (isVehicleOccupied(bookingRequest, b)) {
                result = false;
                break;
            }
        }
        return result;
    }

    private boolean isVehicleOccupied(BookingRequest bookingRequest, Booking b) {
        return isBetween(bookingRequest.getFromDate(), b.getFromDate(), b.getToDate()) ||
                isBetween(bookingRequest.getToDate(), b.getFromDate(), b.getToDate()) ||
                areDatesEqual(bookingRequest.getFromDate(), b.getFromDate(), b.getToDate()) ||
                areDatesEqual(bookingRequest.getToDate(), b.getFromDate(), b.getToDate());
    }


}

package com.lakshman.sample.zoomcar.service;

import com.lakshman.sample.zoomcar.dto.BookingRequest;
import com.lakshman.sample.zoomcar.dto.BookingResponse;
import com.lakshman.sample.zoomcar.entity.Booking;

import java.util.List;

public interface BookingService {
    BookingResponse bookVehicle(BookingRequest bookingRequest);

    List<Booking> getBookingHistory(final String userId);
}

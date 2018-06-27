package com.lakshman.sample.zoomcar.helper;

import com.lakshman.sample.zoomcar.dto.BookingRequest;
import com.lakshman.sample.zoomcar.entity.Vehicle;

public interface BookingHelper {
    boolean validateBooking(BookingRequest bookingRequest, Vehicle vehicle);
}

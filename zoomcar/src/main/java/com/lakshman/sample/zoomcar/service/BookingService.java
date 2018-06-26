package com.lakshman.sample.zoomcar.service;

import com.lakshman.sample.zoomcar.dto.BookingRequest;
import com.lakshman.sample.zoomcar.dto.BookingResponse;

public interface BookingService {
    BookingResponse bookVehicle(BookingRequest bookingRequest);
}

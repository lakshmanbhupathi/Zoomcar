package com.lakshman.sample.zoomcar.dao;

import com.lakshman.sample.zoomcar.entity.Booking;
import com.lakshman.sample.zoomcar.entity.Vehicle;

import java.util.List;

public interface BookingByVehicle {
    List<Booking> getBookingsByVehicle(Vehicle vehicle);
}

package com.lakshman.sample.zoomcar.dao;

import com.lakshman.sample.zoomcar.entity.Booking;
import org.springframework.data.repository.CrudRepository;

public interface BookingRepository extends CrudRepository<Booking,Long> {
}

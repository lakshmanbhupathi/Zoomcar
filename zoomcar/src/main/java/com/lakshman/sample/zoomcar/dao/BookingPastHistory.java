package com.lakshman.sample.zoomcar.dao;

import com.lakshman.sample.zoomcar.entity.Booking;
import com.lakshman.sample.zoomcar.entity.User;

import java.util.List;

public interface BookingPastHistory {
    List<Booking> getPastHistoryByUser(User userId);
}

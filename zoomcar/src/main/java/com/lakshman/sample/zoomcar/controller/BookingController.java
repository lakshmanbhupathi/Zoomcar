package com.lakshman.sample.zoomcar.controller;

import com.lakshman.sample.zoomcar.dto.BookingRequest;
import com.lakshman.sample.zoomcar.dto.BookingResponse;
import com.lakshman.sample.zoomcar.entity.Booking;
import com.lakshman.sample.zoomcar.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/bookVehicle")
    BookingResponse bookVehicle(@Valid @RequestBody BookingRequest bookingRequest) {
        return bookingService.bookVehicle(bookingRequest);
    }

    @GetMapping("/history/{userId}")
    List<Booking> getBookingHistory(@PathVariable final String userId){
        return bookingService.getBookingHistory(userId);
    }

}

package com.lakshman.sample.zoomcar.dto;

public class BookingResponse {

    private boolean status;
    private Long bookingId;

    public BookingResponse() {
    }

    public BookingResponse(boolean status, Long bookingId) {
        this.status = status;
        this.bookingId = bookingId;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}

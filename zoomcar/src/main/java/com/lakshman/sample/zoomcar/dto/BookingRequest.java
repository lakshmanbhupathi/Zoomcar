package com.lakshman.sample.zoomcar.dto;


import java.util.Date;

public class BookingRequest {

    private Date toDate;
    private Date fromDate;
    private Long vehicleId;
    private Long userId;

    public BookingRequest() {
    }

    public BookingRequest(Date toDate, Date fromDate, Long vehicleId, Long userId) {
        this.toDate = toDate;
        this.fromDate = fromDate;
        this.vehicleId = vehicleId;
        this.userId = userId;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}

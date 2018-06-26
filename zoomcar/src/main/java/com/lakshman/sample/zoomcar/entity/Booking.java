package com.lakshman.sample.zoomcar.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookingId;

    @ManyToOne
    private User user;

    @ManyToOne
    private Vehicle vehicle;

    @Column
    private Date fromDate;

    @Column
    private Date toDate;

    public Booking() {
    }

    public Booking(long bookingId, User user, Vehicle vehicle, Date fromDate, Date toDate) {
        this.bookingId = bookingId;
        this.user = user;
        this.vehicle = vehicle;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public long getBookingId() {
        return bookingId;
    }

    public void setBookingId(long bookingId) {
        this.bookingId = bookingId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }
}

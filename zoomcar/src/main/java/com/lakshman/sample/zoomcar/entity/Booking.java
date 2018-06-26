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
}

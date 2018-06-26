package com.lakshman.sample.zoomcar.entity;


import javax.persistence.*;

@Entity
@Table
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long vehicleId;

    @Column(unique = true, nullable = false)
    private String vehicleNumber;

}

package com.lakshman.sample.zoomcar.entity;

import javax.persistence.*;

@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;

    @Column
    private String name;

//    @Column
//    private String name;
}

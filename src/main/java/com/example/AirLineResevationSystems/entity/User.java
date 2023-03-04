package com.example.AirLineResevationSystems.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="user")
public class User {
    @Id
    @Column(name="id")
    private String id;
    @Column(name="passenger_Name")
    private String passengerName;
    @Column(name="priority_Boarding")
    private String priorityBoarding;

    @OneToMany
   @JoinColumn(name = "user_id")
     List<Reservation> reservations;


}

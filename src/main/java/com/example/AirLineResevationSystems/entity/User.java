package com.example.AirLineResevationSystems.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name="user")
public class User {
    @Id
    @Column(name="user_id")
    private int id;
    @Column(name="passenger_Name")
    private String passengerName;
    @Column(name="priority_Boarding")
    private String priorityBoarding;

    @ManyToOne
    private FlightSchedule flightSchedule;



}

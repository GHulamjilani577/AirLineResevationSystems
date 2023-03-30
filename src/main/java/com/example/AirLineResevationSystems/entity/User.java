package com.example.AirLineResevationSystems.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name="user_id",nullable = false)
    private Long id;
    @Column(name="user_Name",nullable = false)
    private String userName;
    @Column(name="CNIC_Number",nullable = false)
    private String CNICNumber;
    @Column(name="Phone_number",nullable = false)
    private String phoneNumber;
    @OneToMany
    private List<FlightSchedule>flightScheduleList;

}

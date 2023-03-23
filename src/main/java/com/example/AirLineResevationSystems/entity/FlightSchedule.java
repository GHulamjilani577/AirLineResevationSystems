package com.example.AirLineResevationSystems.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name="flightSchedule")
public class FlightSchedule {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name="flightSchedule_Id")
    private Long flightScheduleId;
    @Column(name="flight_Code")
    private String flightCode;
    @Column(name="destination")
    private String destination;
    @Column(name="flight_status ")
    private String flightStatus;
    @Column(name="flight_Type")
    private String flightType;
    @Column(name="departure")
    private String departure;
    @Column(name="time")
    private String time;
    @OneToMany
    private List<User> user;
    @OneToMany
    private List<Reservation>reservation ;

}

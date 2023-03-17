package com.example.AirLineResevationSystems.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name="flightSchedule")
public class FlightSchedule {
    @Id
    @Column(name="flightSchedule_Id")
    private int flightScheduleId;
    @Column(name="flight_Available")
    private String flightAvailable;
    @Column(name="flight_getPrice")
    private String flightPrice;
    @Column(name="flight_getFlight")
    private String flightGetFlight;
    @OneToMany
    private List<User> user;
    @OneToMany
    private List<Reservation>reservation ;

}

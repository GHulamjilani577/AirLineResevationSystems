package com.example.AirLineResevationSystems.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="flightSchedule")
public class FlightSchedule {
    @Id
    @Column(name="flightSchedule_Id")
    private String flightScheduleId;
    @Column(name="flight_Available")
    private String flightAvailable;
    @Column(name="flight_getPrice")
    private String flightPrice;
    @Column(name="flight_getFlight")
    private String flightGetFlight;

}

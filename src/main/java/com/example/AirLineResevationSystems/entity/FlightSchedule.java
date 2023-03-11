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
    private String flightScheduleId;
    @Column(name="flight_Available")
    private String flightAvailable;
    @Column(name="flight_getPrice")
    private String flightPrice;
    @Column(name="flight_getFlight")
    private String flightGetFlight;
    @OneToMany
    @JoinColumn(name = "user_id")
    private List<User> user;
    @OneToMany
    @JoinColumn(name = "reservation_id")
    private List<Reservation>reservation ;

}

package com.example.AirLineResevationSystems.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name="airline")
public class Airline {
    @Id
    @Column(name="air_Line_Id")
    private String airLineId;
    @Column(name="airline_flight")
    private String flight;
    @Column(name="airline_capacity")
    private String capacity;
    @Column(name="airline_passangers")
    private String passangers;
    @Column(name="airline_phonenumer")
    private String phonenumer;
    @Column(name="airline_ price")
    private String price;
    @OneToMany
    @JoinColumn(name = "airLine_flight_Id")
    private List<AirLineFlight> airLineFlights;
    @ManyToOne
    private Airport airport;


}

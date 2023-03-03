package com.example.AirLineResevationSystems.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
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

}

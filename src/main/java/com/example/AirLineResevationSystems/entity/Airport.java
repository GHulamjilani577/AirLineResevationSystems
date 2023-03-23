package com.example.AirLineResevationSystems.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name="airport")
public class Airport {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name="airport_Id")
    private Long airPortId;
    @Column(name="airPort_Name")
    private String airportname;
    @Column(name="airPort_Location")
    private String location;
    /*@OneToMany
    @JoinColumn(name = "air_line_Id")
    private List<Airline> airline;*/

    @OneToMany
    private List<Airline>airlines;




}

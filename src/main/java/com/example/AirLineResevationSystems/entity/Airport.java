package com.example.AirLineResevationSystems.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name="airport")
public class Airport {

    @Id
    @Column(name="airport_Id")
    private String airPortId;
    @Column(name="airPort_Name")
    private String airportname;
    @Column(name="airPort_Location")
    private String location;
    @OneToMany
    @JoinColumn(name = "air_Line_Id")
    private List<Airline> airline;


}

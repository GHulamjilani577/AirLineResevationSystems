package com.example.AirLineResevationSystems.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Data
@Table(name="airport")
public class Airport {

    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    @Column(name="airport_Id")
    private int airPortId;
    @Column(name="airPort_Name")
    private String airportname;
    @Column(name="airPort_Location")
    private String location;
    /*@OneToMany
    @JoinColumn(name = "air_line_Id")
    private List<Airline> airline;*/

    @OneToMany
    @JoinColumn(name = "air_line_Id")
    private List<Airline>airlines;



}

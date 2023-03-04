package com.example.AirLineResevationSystems.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="airport")
public class Airport {

    @Id
    @Column(name="airport_Id")
    private String airPortId;
    @Column(name="airPort_Name")
    private String airportname;
    @Column(name="airPort_Location")
    private String location;

}

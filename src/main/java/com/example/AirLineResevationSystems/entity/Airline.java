package com.example.AirLineResevationSystems.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name="airline")
public class Airline {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name="air_line_Id")
    private Long airLineId;
    @Column(name="airline_Name")
    private String flight;
    @Column(name="businessClass_capacity")
    private String businessCapacity;
    @Column(name="economyClass_capacity")
    private String economyCapacity;
    @Column(name="airline_phoneNumber")
    private String phoneNumber;
    @Column(name="airline_ price")
    private String price;
/*   @OneToMany
 @JoinColumn(name = "airLine_flight_Id")
  private List<AirLineFlight> airLineFlights;*/
@ManyToOne
@JoinColumn(name = "airport_Id")
private Airport airport;
   @OneToMany
    private List<AirLineFlight>airLineFlights;



}

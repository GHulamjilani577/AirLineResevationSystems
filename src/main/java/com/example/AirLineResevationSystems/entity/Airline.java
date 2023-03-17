package com.example.AirLineResevationSystems.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    private int airLineId;
    @Column(name="airline_flight")
    private String flight;
    @Column(name="airline_capacity")
    private String capacity;
    @Column(name="airline_passangers")
    @JsonProperty("airline_passangers")
    private String passangers;
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

package com.example.AirLineResevationSystems.entity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name="airline_flight")
public class AirLineFlight {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name="airLine_flight_Id")
    private Long airLineFlightId;
    @Column(name="airLine_name")
    private String airlineName;
    @Column(name="airline_ type")
    private String type;
    @Column(name="businessClass_capacity")
    private String businessCapacity;
    @Column(name="economyClass_capacity")
    private String economyCapacity;
    @Column(name="originAirport")
    private String originAirport;
    @Column(name="destinationAirport")
    private String destinationAirport;


    @OneToMany
    private List<FlightSchedule> flightSchedules;
   /* @ManyToOne
    @JoinColumn(name = "air_line_Id")
   private Airline airlines;*/






   /* public AirLineFlight(List<AirLineFlight> airLineFlights) {
    }*/
}

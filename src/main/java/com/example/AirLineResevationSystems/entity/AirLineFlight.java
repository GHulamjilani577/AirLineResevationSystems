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
    @Column(name="airLineFlight_Id")
    private Long airLineFlightId;
    @Column(name="airLine_name")
    private String airlineName;
    @Column(name="airline_ type")
    private String type;
    @Column(name="businessClass_capacity")
    private String businessCapacity;
    @Column(name="economyClass_capacity")
    private String economyCapacity;
    @Column(name="origin_Airport")
    private String originAirport;
    @Column(name="destination_Airport")
    private String destinationAirport;
    @OneToMany(mappedBy = "airLineFlight", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FlightSchedule> flightSchedule;

    public AirLineFlight() {
        // Default constructor
    }
    public AirLineFlight(Long airLineFlightId) {
    }
}

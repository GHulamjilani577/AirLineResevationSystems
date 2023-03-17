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
    private int airLineFlightId;
    @OneToMany
    private List<Reservation> reservation;
    @ManyToOne
    @JoinColumn(name = "air_line_Id")
   private Airline airlines;





}

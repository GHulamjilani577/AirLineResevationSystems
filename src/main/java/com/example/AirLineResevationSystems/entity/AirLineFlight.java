package com.example.AirLineResevationSystems.entity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name="airline_flight")
public class AirLineFlight {
    @Id
    @Column(name="airLine_flight_Id")
    private String airLineId;
    @OneToMany
    @JoinColumn(name = "reservation_id")
    private List<Reservation> reservation;





}

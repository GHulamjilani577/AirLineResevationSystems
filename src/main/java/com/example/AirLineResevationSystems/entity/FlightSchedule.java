package com.example.AirLineResevationSystems.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name="flight_Schedule")
public class FlightSchedule {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name="flightSchedule_Id")
    private Long flightScheduleId;
    @Column(name="flight_Code")
    private String flightCode;
    @Column(name="departure_Day")
    private String departureDay;
    @Column(name="flight_status ")
    private String flightStatus;
    @Column(name="flight_Type")
    private String flightType;
    //Add Date at the end
    @Column(name="departure_Date")
    private String departureDate;
    @Column(name="time")
    private String time;
    @Column(name="businessClass_Price")
    private String businessClassPrice;
    @Column(name="economyClass_Price")
    private String economyClassPrice;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airLineFlight_Id")
    private AirLineFlight airLineFlight;
    @OneToMany
    private List<Reservation>reservation ;


}

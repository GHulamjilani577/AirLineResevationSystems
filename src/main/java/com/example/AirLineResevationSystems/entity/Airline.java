/*package com.example.AirLineResevationSystems.entity;

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
    private String airlineName;
    @Column(name="airline_phoneNumber")
    private String phoneNumber;

*//*   @OneToMany
 @JoinColumn(name = "airLine_flight_Id")
  private List<AirLineFlight> airLineFlights;*//*
  @ManyToOne
  @JoinColumn(name = "flightSchedule_Id")
  private FlightSchedule flightSchedule;
  @OneToMany
    private AirLineFlight airLineFlight;
  *//* @OneToMany
    private List<AirLineFlight>airLineFlights;
*//*


}*/
/*
* FlightSchedule
*
*   id
*   StartDate
*   EndDate
*   OriginAirport (id)
*   DestinationAirport (id)
*   Airline
* */
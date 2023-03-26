/*
package com.example.AirLineResevationSystems.model;

import com.example.AirLineResevationSystems.entity.AirLineFlight;
import com.example.AirLineResevationSystems.entity.Airline;
import com.example.AirLineResevationSystems.entity.Airport;
import lombok.Data;

import java.util.List;

@Data
public class AirlineModel {
    private  Long id;
    private String airlineName;
    private String phoneNumber;
   */
/* private String businessCapacity;
    private String economyCapacity;
    private String price;*//*

    */
/*private AirportModel airportModel;
    private AirLineFlightModel airLineFlightModel;*//*


*/
/*
    public AirlineModel(Long id, String flight, String capacity, String passangers, String phoneNumber, String price, Airport airport, AirLineFlight airLineFlight) {
        this.id = id;
        this.flight = flight;
        this.capacity = capacity;
        this.passangers = passangers;
        this.phoneNumber = phoneNumber;
        this.price = price;
        this.airport = airport;
        this.airLineFlight = airLineFlight;
    }
    public AirlineModel(AirlineModel airline){
        this.id=airline.getId();
        this.flight=airline.getFlight();
        this.capacity = airline.getCapacity();
        this.passangers = airline.getPassangers();
        this.phoneNumber = airline.getPhoneNumber();
        this.price = airline.getPrice();
        this.airport = new Airport(airline.getAirport());
        this.airLineFlight = new AirLineFlight(airline.getAirLineFlights());
    }

    private List<AirLineFlight> getAirLineFlights() {
        return getAirLineFlights();
    }
*//*



    public AirlineModel() {

    }

    public Airline disassemble(){
        Airline airline=new Airline();
        airline.setAirLineId(id);
        airline.setAirlineName(airlineName);
        airline.setPhoneNumber(phoneNumber);
        return airline;
    }
    public AirlineModel assemble(Airline airline){
        AirlineModel airlineModel=new AirlineModel();
        */
/*AirportModel airportModel1=new AirportModel();
        AirLineFlightModel airLineFlightModel1=new AirLineFlightModel();*//*

        airlineModel.setId(airline.getAirLineId());
        airlineModel.setAirlineName(airline.getAirlineName());
        airlineModel.setPhoneNumber(airline.getPhoneNumber());
        */
/*airlineModel.setAirportModel(airportModel1.assemble(airline.getAirport()));
        airlineModel.setAirLineFlightModel(airLineFlightModel1.assemble((AirLineFlight) airline.getAirLineFlights()));*//*

        return airlineModel;
    }




}
*/

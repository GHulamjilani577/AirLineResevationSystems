package com.example.AirLineResevationSystems.model;

import com.example.AirLineResevationSystems.entity.AirLineFlight;
import com.example.AirLineResevationSystems.entity.Airline;
import com.example.AirLineResevationSystems.entity.Airport;
import lombok.Data;

import java.util.List;

@Data
public class AirlineModel {
    private  Long id;
    private String flight;
    private String businessCapacity;
    private String economyCapacity;
    private String phoneNumber;
    private String price;
    private AirportModel airportModel;
    private AirLineFlightModel airLineFlightModel;

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
*/


    public AirlineModel() {

    }

    public Airline disassemble(){
        Airline airline=new Airline();
        airline.setFlight(flight);
        airline.setBusinessCapacity(businessCapacity);
        airline.setEconomyCapacity(economyCapacity);
        airline.setPhoneNumber(phoneNumber);
        airline.setPrice(price);
        return airline;
    }
    public AirlineModel assemble(Airline airline){
        AirlineModel airlineModel=new AirlineModel();
        AirportModel airportModel1=new AirportModel();
        AirLineFlightModel airLineFlightModel1=new AirLineFlightModel();
        airlineModel.setId(airline.getAirLineId());
        airlineModel.setFlight(airline.getFlight());
        airlineModel.setEconomyCapacity(airline.getEconomyCapacity());
        airlineModel.setBusinessCapacity(airline.getBusinessCapacity());
        airlineModel.setPhoneNumber(airline.getPhoneNumber());
        airlineModel.setPrice(airline.getPrice());
        airlineModel.setAirportModel(airportModel1.assemble(airline.getAirport()));
        //airlineModel.setAirLineFlightModel(airLineFlightModel1.assemble(airline.setAirLineFlights()));
        return airlineModel;
    }




}

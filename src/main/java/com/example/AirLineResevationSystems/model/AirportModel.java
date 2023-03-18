package com.example.AirLineResevationSystems.model;


import com.example.AirLineResevationSystems.entity.Airline;
import com.example.AirLineResevationSystems.entity.Airport;
import lombok.Data;

@Data
public class AirportModel {
    private Long airPortId;

    private String airportname;

    private String location;
    public Airport disassemble(){
       Airport airport=new Airport();
       airport.setAirPortId(airPortId);
       airport.setAirportname(airportname);
       airport.setLocation(location);

        return airport;
    }
    public AirportModel assemble(Airport airport){
        AirportModel airportModel=new AirportModel();
        airportModel.setAirPortId(airport.getAirPortId());
        airportModel.setAirportname(airport.getAirportname());
        airportModel.setLocation(airport.getLocation());
        return airportModel;
    }
}

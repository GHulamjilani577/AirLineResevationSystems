/*
package com.example.AirLineResevationSystems.model;



import com.example.AirLineResevationSystems.entity.Airport;
import lombok.Data;

import java.util.List;
import java.util.Optional;

@Data
public class AirportModel {
    private Long airPortId;
    private String airportname;
    private String location;

    public AirportModel(Airport save) {
    }

    public AirportModel(Long airPortId, String airportname, String location) {
        this.airPortId = airPortId;
        this.airportname = airportname;
        this.location = location;
    }

     public Airport disassemble(){
       Airport airport=new Airport();
       airport.setAirPortId(airPortId);
       airport.setAirportname(airportname);
       airport.setLocation(location);

        return airport;
    }
    public AirportModel assemble(Airport airport){
        AirportModel airportModel=new AirportModel(airport);
        airportModel.setAirPortId(airport.getAirPortId());
        airportModel.setAirportname(airport.getAirportname());
        airportModel.setLocation(airport.getLocation());
        return airportModel;
    }
}
*/

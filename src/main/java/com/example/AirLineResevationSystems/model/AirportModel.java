package com.example.AirLineResevationSystems.model;



import com.example.AirLineResevationSystems.entity.Airport;
import lombok.Data;

import java.util.List;

@Data
public class AirportModel {
    private Long airPortId;
    private String airportname;
    private String location;

    public AirportModel(Airport save) {
    }


    // private Airline airline;

  /*  public AirportModel(Long airPortId, String airportname, String location, Airline airline) {
        this.airPortId = airPortId;
        this.airportname = airportname;
        this.location = location;
        this.airline = airline;
    }
    public AirportModel(AirportModel airport){
        this.airPortId=airport.getAirPortId();
        this.airportname=airport.getAirportname();
        this.location=airport.getLocation();
        this.airline=new Airline(airport.getAirlines());
    }

    private List<Airline> getAirlines() {
        return getAirlines();
    }

*/
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

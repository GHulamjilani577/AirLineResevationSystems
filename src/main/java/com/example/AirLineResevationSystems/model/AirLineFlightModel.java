package com.example.AirLineResevationSystems.model;


import com.example.AirLineResevationSystems.entity.AirLineFlight;
import com.example.AirLineResevationSystems.entity.Airline;
import lombok.Data;


import java.util.List;

@Data
public class AirLineFlightModel
{
    private Long airLineFlightId;
    private String flightCode;
    private String flightType;

    /*public AirLineFlightModel(Long airLineFlightId, String airLineName, Airline airline) {
        this.airLineFlightId = airLineFlightId;
        this.airLineName = airLineName;
        this.airline = airline;
    }
    public AirLineFlightModel(AirLineFlightModel airLineFlight){
        this.airLineFlightId=airLineFlight.getAirLineFlightId();
        this.airLineName=airLineFlight.getAirLineName();
        this.airline=new Airline((List<Airline>) airLineFlight.getAirlines());
    }*/

public AirLineFlight disassemble(){
        AirLineFlight airLineFlight=new AirLineFlight();
        airLineFlight.setAirLineFlightId(airLineFlightId);
        airLineFlight.setFlightCode(flightCode);
        airLineFlight.setFlightType(getFlightType());
        return airLineFlight;
    }
    public AirLineFlightModel assemble(AirLineFlight airLineFlight){
        AirLineFlightModel airLineFlightModel=new AirLineFlightModel();
        airLineFlightModel.setAirLineFlightId(airLineFlight.getAirLineFlightId());
        airLineFlightModel.setFlightCode(airLineFlight.getFlightCode());
        airLineFlightModel.setFlightType(airLineFlight.getFlightType());
        return airLineFlightModel;
    }
}

package com.example.AirLineResevationSystems.model;


import com.example.AirLineResevationSystems.entity.AirLineFlight;
import lombok.Data;


import java.util.List;

@Data
public class AirLineFlightModel
{
    private Long airLineFlightId;
    private String airlineName;
    private String type;
    private String businessCapacity;
    private String economyCapacity;
    private String originAirport;
    private String destinationAirport;

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
        airLineFlight.setAirlineName(airlineName);
        airLineFlight.setType(type);
        airLineFlight.setBusinessCapacity(businessCapacity);
        airLineFlight.setEconomyCapacity(economyCapacity);
        airLineFlight.setOriginAirport(originAirport);
        airLineFlight.setDestinationAirport(destinationAirport);
        return airLineFlight;
    }
    public AirLineFlightModel assemble(AirLineFlight airLineFlight){
        AirLineFlightModel airLineFlightModel=new AirLineFlightModel();
        airLineFlightModel.setAirLineFlightId(airLineFlight.getAirLineFlightId());
        airLineFlightModel.setAirlineName(airLineFlight.getAirlineName());
        airLineFlightModel.setType(airLineFlight.getType());
        airLineFlightModel.setBusinessCapacity(airLineFlight.getBusinessCapacity());
        airLineFlightModel.setEconomyCapacity(airLineFlight.getEconomyCapacity());
        airLineFlightModel.setOriginAirport(airLineFlight.getOriginAirport());
        airLineFlightModel.setDestinationAirport(airLineFlight.getDestinationAirport());
        return airLineFlightModel;
    }
}

package com.example.AirLineResevationSystems.model;

import com.example.AirLineResevationSystems.entity.AirLineFlight;
import com.example.AirLineResevationSystems.entity.FlightSchedule;
import lombok.Data;

@Data
public class FlightScheduleModel {
    private Long flightScheduleId;
    private String flightCode;
    private String destination;
    private String flightStatus;
    private String flightType;
    private String departure;
    private String time;

    private AirLineFlightModel airLineFlightModel;




    public FlightSchedule disassemble() {
        FlightSchedule flightSchedule = new FlightSchedule();
        flightSchedule.setFlightScheduleId(flightScheduleId);
        flightSchedule.setFlightCode(flightCode);
        flightSchedule.setDestination(destination);
        flightSchedule.setFlightStatus(flightStatus);
        flightSchedule.setFlightType(flightType);
        flightSchedule.setDeparture(departure);
        flightSchedule.setTime(time);
        flightSchedule.setAirLineFlight((airLineFlightModel.disassemble()));
        return flightSchedule;
    }
    public static FlightScheduleModel assemble(FlightSchedule flightSchedule) {
        FlightScheduleModel flightScheduleModel = new FlightScheduleModel();
        flightScheduleModel.setFlightScheduleId(flightSchedule.getFlightScheduleId());
        flightScheduleModel.setFlightCode(flightSchedule.getFlightCode());
        flightScheduleModel.setDestination(flightSchedule.getDestination());
        flightScheduleModel.setFlightStatus(flightSchedule.getFlightStatus());
        flightScheduleModel.setFlightType(flightSchedule.getFlightType());
        flightScheduleModel.setDeparture(flightSchedule.getDeparture());
        flightScheduleModel.setTime(flightSchedule.getTime());
        flightScheduleModel.setAirLineFlightModel(new AirLineFlightModel().assemble(flightSchedule.getAirLineFlight()));
        return flightScheduleModel;
    }

  /*  public FlightSchedule disassemble(){
        FlightSchedule flightSchedule=new FlightSchedule();
        flightSchedule.setFlightScheduleId(flightScheduleId);
        flightSchedule.setFlightCode(flightCode);
        flightSchedule.setDestination(destination);
        flightSchedule.setFlightStatus(flightStatus);
        flightSchedule.setFlightType(flightType);
        flightSchedule.setDeparture(departure);
        flightSchedule.setTime(time);
        return flightSchedule;
    }
    public static FlightScheduleModel assemble(FlightSchedule flightSchedule){
        FlightScheduleModel flightScheduleModel=new FlightScheduleModel();
        flightScheduleModel.setFlightScheduleId(flightSchedule.getFlightScheduleId());
        flightScheduleModel.setFlightCode(flightSchedule.getFlightCode());
        flightScheduleModel.setDestination(flightSchedule.getDestination());
        flightScheduleModel.setFlightStatus(flightSchedule.getFlightStatus());
        flightScheduleModel.setFlightType(flightSchedule.getFlightType());
        flightScheduleModel.setDeparture(flightSchedule.getDeparture());
        flightScheduleModel.setTime(flightSchedule.getTime());
        return flightScheduleModel;
    }
*/

}

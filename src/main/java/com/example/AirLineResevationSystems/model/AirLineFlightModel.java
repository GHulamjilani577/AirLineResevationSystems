package com.example.AirLineResevationSystems.model;


import com.example.AirLineResevationSystems.entity.AirLineFlight;
import com.example.AirLineResevationSystems.entity.FlightSchedule;
import lombok.Data;


import java.util.ArrayList;
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
    private List<FlightScheduleModel> flightSchedules;

public AirLineFlight disassemble() {
    AirLineFlight airLineFlight = new AirLineFlight();
    airLineFlight.setAirLineFlightId(airLineFlightId);
    airLineFlight.setAirlineName(airlineName);
    airLineFlight.setType(type);
    airLineFlight.setBusinessCapacity(businessCapacity);
    airLineFlight.setEconomyCapacity(economyCapacity);
    airLineFlight.setOriginAirport(originAirport);
    airLineFlight.setDestinationAirport(destinationAirport);
    if (flightSchedules != null) {
        List<FlightSchedule> schedules = new ArrayList<>();
        for (FlightScheduleModel schedule : flightSchedules) {
            schedules.add(schedule.disassemble());
        }
        airLineFlight.setFlightSchedules(schedules);
    }
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

        List<FlightScheduleModel> flightScheduleModels = new ArrayList<>();
        for (FlightSchedule flightSchedule : airLineFlight.getFlightSchedules()) {
            flightScheduleModels.add(new FlightScheduleModel());
        }
        airLineFlightModel.setFlightSchedules(flightScheduleModels);
        return airLineFlightModel;
    }

}

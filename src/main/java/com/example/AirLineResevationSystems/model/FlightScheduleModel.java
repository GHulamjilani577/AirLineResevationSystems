package com.example.AirLineResevationSystems.model;

import com.example.AirLineResevationSystems.entity.AirLineFlight;
import com.example.AirLineResevationSystems.entity.FlightSchedule;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
public class FlightScheduleModel {
    private Long flightScheduleId;
    private String flightCode;
    private String departureDay;
    private String flightStatus;
    private String flightType;
    private String departureDate;
    private String time;
    private String businessClassPrice;
    private String economyClassPrice;

    private AirLineFlightModel airLineFlightModel;


    public FlightScheduleModel(Long flightScheduleId, String flightCode, String departureDay, String flightStatus, String flightType, String departureDate, String time, String businessClassPrice, String economyClassPrice, AirLineFlightModel airLineFlightModel) {
        this.flightScheduleId = flightScheduleId;
        this.flightCode = flightCode;
        this.departureDay = departureDay;
        this.flightStatus = flightStatus;
        this.flightType = flightType;
        this.departureDate = departureDate;
        this.time = time;
        this.businessClassPrice = businessClassPrice;
        this.economyClassPrice = economyClassPrice;
        this.airLineFlightModel = airLineFlightModel;
    }

    public FlightScheduleModel(FlightSchedule flightSchedule) {
    }
    public FlightSchedule disassemble() {
        FlightSchedule flightSchedule = new FlightSchedule();

        flightSchedule.setFlightScheduleId(flightScheduleId);
        flightSchedule.setFlightCode(flightCode);
        flightSchedule.setDepartureDay(flightSchedule.getDepartureDay());
        flightSchedule.setFlightStatus(flightStatus);
        flightSchedule.setFlightType(flightType);
        flightSchedule.setDepartureDate(flightSchedule.getDepartureDate());
        flightSchedule.setTime(time);
        flightSchedule.setBusinessClassPrice(businessClassPrice);
        flightSchedule.setEconomyClassPrice(economyClassPrice);
        flightSchedule.setAirLineFlight((airLineFlightModel.disassemble()));
        return flightSchedule;
    }
    public FlightScheduleModel assemble(FlightSchedule flightSchedule) {
        FlightScheduleModel flightScheduleModel = new FlightScheduleModel(flightSchedule);
        flightScheduleModel.setFlightScheduleId(flightSchedule.getFlightScheduleId());
        flightScheduleModel.setFlightCode(flightSchedule.getFlightCode());
        flightScheduleModel.setDepartureDay(flightSchedule.getDepartureDay());
        flightScheduleModel.setFlightStatus(flightSchedule.getFlightStatus());
        flightScheduleModel.setFlightType(flightSchedule.getFlightType());
        flightScheduleModel.setDepartureDate(flightSchedule.getDepartureDate());
        flightScheduleModel.setTime(flightSchedule.getTime());
        flightScheduleModel.setBusinessClassPrice(flightSchedule.getBusinessClassPrice());
        flightScheduleModel.setEconomyClassPrice(flightSchedule.getEconomyClassPrice());
        flightScheduleModel.setAirLineFlightModel(new AirLineFlightModel().assemble(flightSchedule.getAirLineFlight()));
        return flightScheduleModel;
    }

}

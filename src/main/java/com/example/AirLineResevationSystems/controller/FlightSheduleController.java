package com.example.AirLineResevationSystems.controller;

import com.example.AirLineResevationSystems.model.AirportModel;
import com.example.AirLineResevationSystems.model.FlightScheduleModel;
import com.example.AirLineResevationSystems.service.FlightScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlightSheduleController {
    @Autowired
    public FlightScheduleService flightScheduleService;
    @PostMapping("/add-flightSchedule")
    public FlightScheduleModel addFlights(@RequestBody FlightScheduleModel flightScheduleModel){
        return flightScheduleService.insert(flightScheduleModel);
    }
}

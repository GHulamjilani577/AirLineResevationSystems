package com.example.AirLineResevationSystems.controller;

import com.example.AirLineResevationSystems.entity.FlightSchedule;
import com.example.AirLineResevationSystems.model.AirportModel;
import com.example.AirLineResevationSystems.model.FlightScheduleModel;
import com.example.AirLineResevationSystems.service.FlightScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FlightSheduleController {
    @Autowired
    public FlightScheduleService flightScheduleService;
    @PostMapping("/add-flightSchedule")
    public FlightScheduleModel addFlights(@RequestBody FlightScheduleModel flightScheduleModel){
        return flightScheduleService.insert(flightScheduleModel);
    }
    @GetMapping("/flight-schedules")
    public List<FlightScheduleModel> getAllFlightSchedules(){
        List<FlightSchedule> flightSchedules = flightScheduleService.findAll();
        return flightSchedules.stream().map(FlightScheduleModel::assemble).collect(Collectors.toList());

    }
    @GetMapping("/flight-schedules/{id}")
    public FlightScheduleModel getFlightScheduleById(@PathVariable Long id){
        FlightSchedule flightSchedule = flightScheduleService.findById(id).orElseThrow(() -> new RuntimeException("Flight schedule not found"));
        return FlightScheduleModel.assemble(flightSchedule);
    }
    @DeleteMapping("/{id}")
    public void deleteFlightSchedule(@PathVariable Long id) {
        flightScheduleService.delete(id);
    }
    }


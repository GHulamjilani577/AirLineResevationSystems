package com.example.AirLineResevationSystems.controller;

import com.example.AirLineResevationSystems.model.AirLineFlightModel;
import com.example.AirLineResevationSystems.model.FlightScheduleModel;
import com.example.AirLineResevationSystems.service.FlightScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flight-schedules")
public class FlightSheduleController {

    @Autowired
    private FlightScheduleService flightScheduleService;

    @PostMapping("/create_schedules")
    public ResponseEntity<FlightScheduleModel> insert(@RequestBody FlightScheduleModel flightScheduleModel) {
        FlightScheduleModel insertedFlightScheduleModel = flightScheduleService.insert(flightScheduleModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(insertedFlightScheduleModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        flightScheduleService.delete(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/flight-schedules")
    public List<FlightScheduleModel> getAllFlightSchedules(){

        return flightScheduleService.findAll();

    }

    @GetMapping("/flight-schedules/{id}")
    public AirLineFlightModel getFlightScheduleById(@PathVariable Long id){
        return flightScheduleService.findById(id);
    }

    @GetMapping("/flight-schedulesByAirlineId/{id}")
    public List<FlightScheduleModel> getFlightScheduleByAirLineId(@PathVariable Long id){
        return flightScheduleService.findByAirLineFlightId(id);
    }
    }



package com.example.AirLineResevationSystems.controller;

import com.example.AirLineResevationSystems.model.AirLineFlightModel;
import com.example.AirLineResevationSystems.service.AirLineFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AirlineFlightController {
    @Autowired
    private AirLineFlightService airLineFlightService;
    @PostMapping("/add-flights")
    public AirLineFlightModel addAirlineFlight(@RequestBody AirLineFlightModel airLineFlightModel){
        return airLineFlightService.insert(airLineFlightModel);
    }
}

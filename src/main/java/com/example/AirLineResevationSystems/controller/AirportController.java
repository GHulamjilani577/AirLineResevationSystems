package com.example.AirLineResevationSystems.controller;


import com.example.AirLineResevationSystems.model.AirportModel;
import com.example.AirLineResevationSystems.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AirportController {
    @Autowired
    public AirportService airportService;
    @PostMapping("/add-airport")
    public AirportModel addAirPort(@RequestBody AirportModel airportModel){
        return airportService.insert(airportModel);
    }
}

package com.example.AirLineResevationSystems.controller;

import com.example.AirLineResevationSystems.entity.Airline;
import com.example.AirLineResevationSystems.repository.AirLineRepository;
import com.example.AirLineResevationSystems.service.AirLineServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AirLineController {
    @Autowired
    public AirLineServices airLineServices;
    @PostMapping("/Airport")
    public Airline AddAirline(@RequestBody Airline airline){
        return airLineServices.insert(airline);
    }
}

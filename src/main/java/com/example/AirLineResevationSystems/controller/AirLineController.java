package com.example.AirLineResevationSystems.controller;

import com.example.AirLineResevationSystems.model.AirlineModel;
import com.example.AirLineResevationSystems.service.AirLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AirLineController {
    @Autowired
    public AirLineService airLineServices;
    @PostMapping("/add-airline")
    public AirlineModel addAirline(@RequestBody AirlineModel airlineModel){
        return airLineServices.insert(airlineModel);
    }
}

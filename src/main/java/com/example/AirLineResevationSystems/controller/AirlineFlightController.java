package com.example.AirLineResevationSystems.controller;

import com.example.AirLineResevationSystems.model.AirLineFlightModel;
import com.example.AirLineResevationSystems.service.AirLineFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airline-flight")
public class AirlineFlightController {
    @Autowired
    private AirLineFlightService airLineFlightService;

    @PostMapping("/add-AirlineFlight")
    public AirLineFlightModel createAirLineFlight(@RequestBody AirLineFlightModel airLineFlightModel) {
        return airLineFlightService.insert(airLineFlightModel);
    }

    @GetMapping("/{id}")
    public AirLineFlightModel getAirLineFlightById(@PathVariable Long id) {
        return airLineFlightService.getById(id);
    }


    @GetMapping
    public List<AirLineFlightModel> getAllAirLineFlights() {
        return airLineFlightService.getAll();
    }

    @PutMapping("/{id}")
    public AirLineFlightModel updateAirLineFlight(@PathVariable Long id, @RequestBody AirLineFlightModel airLineFlightModel) {
        return airLineFlightService.update(id, airLineFlightModel);
    }

    @DeleteMapping("/{id}")
    public void deleteAirLineFlight(@PathVariable Long id) {
        airLineFlightService.delete(id);
    }
}

/*@RestController
@RequestMapping("/airline-flights")
public class AirLineFlightController {

    @Autowired
    private AirLineFlightService airLineFlightService;

    @PostMapping
    public AirLineFlightModel createAirLineFlight(@RequestBody AirLineFlightModel airLineFlightModel) {
        return airLineFlightService.insert(airLineFlightModel);
    }

  *//*  @GetMapping("/{id}")
    public AirLineFlightModel getAirLineFlightById(@PathVariable Long id) {
        return airLineFlightService.getById(id);
    }

    @GetMapping
    public List<AirLineFlightModel> getAllAirLineFlights() {
        return airLineFlightService.getAll();
    }

    @PutMapping("/{id}")
    public AirLineFlightModel updateAirLineFlight(@PathVariable Long id, @RequestBody AirLineFlightModel airLineFlightModel) {
        return airLineFlightService.update(id, airLineFlightModel);
    }

    @DeleteMapping("/{id}")
    public void deleteAirLineFlight(@PathVariable Long id) {
        airLineFlightService.delete(id);
    }
}*/


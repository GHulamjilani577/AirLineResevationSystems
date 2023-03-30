package com.example.AirLineResevationSystems.controller;


import com.example.AirLineResevationSystems.model.AirportModel;
import com.example.AirLineResevationSystems.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airport")
public class AirportController {

    @Autowired
    private AirportService airportService;

    @PostMapping("/")
    public ResponseEntity<AirportModel> createAirport(@RequestBody AirportModel airportModel) {
        AirportModel savedAirportModel = airportService.save(airportModel);
        return new ResponseEntity<>(savedAirportModel, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AirportModel> getAirportById(@PathVariable Long id) {
        AirportModel airportModel = airportService.findById(id);
        return new ResponseEntity<>(airportModel, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<AirportModel>> getAllAirports() {
        List<AirportModel> airportModels = airportService.findAll();
        return new ResponseEntity<>(airportModels, HttpStatus.OK);
    }

    @GetMapping("/location/{location}")
    public ResponseEntity<List<AirportModel>> getAirportsByLocation(@PathVariable String location) {
        List<AirportModel> airportModels = airportService.findByLocation(location);
        return new ResponseEntity<>(airportModels, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AirportModel> updateAirport(@PathVariable Long id, @RequestBody AirportModel airportModel) {
        AirportModel updatedAirportModel = airportService.update(id, airportModel);
        return new ResponseEntity<>(updatedAirportModel, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirport(@PathVariable Long id) {
        airportService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

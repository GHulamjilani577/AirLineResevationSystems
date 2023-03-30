package com.example.AirLineResevationSystems.service;

import com.example.AirLineResevationSystems.entity.Airport;
import com.example.AirLineResevationSystems.model.AirportModel;

import com.example.AirLineResevationSystems.repository.AirportRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AirportService {
    @Autowired
    public AirportRepository airportRepository;

 @Transactional
 public AirportModel save(AirportModel airportModel) {
     Airport airport = null;
     if (!ObjectUtils.isEmpty(airportModel)) {
         airport = findExistingAirport(airportModel);
         if (ObjectUtils.isEmpty(airport)) {
             airport = airportModel.disassemble();
         } else {
             airport.setAirportname(airportModel.getAirportname());
             airport.setLocation(airportModel.getLocation());
         }
         airport = airportRepository.save(airport);
     }
     return airportModel.assemble(airport);
 }

    public AirportModel findById(Long id) {
        Airport airport = airportRepository.findByairPortId(id);
        return ObjectUtils.isEmpty(airport) ? null : new AirportModel(airport.getAirPortId(), airport.getAirportname(), airport.getLocation());
    }

    public List<AirportModel> findAll() {
        List<Airport> airports = airportRepository.findAll();
        return airports.stream().map(airport -> new AirportModel(airport.getAirPortId(), airport.getAirportname(), airport.getLocation())).collect(Collectors.toList());
    }

    public List<AirportModel> findByLocation(String location) {
        List<Airport> airports = airportRepository.findByLocation(location);
        return airports.stream().map(airport -> new AirportModel(airport.getAirPortId(), airport.getAirportname(), airport.getLocation())).collect(Collectors.toList());
    }

    @Transactional
    public AirportModel update(Long id, AirportModel airportModel) {
        Airport airport = airportRepository.findByairPortId(id);
        if (!ObjectUtils.isEmpty(airport)) {
            airport.setAirportname(airportModel.getAirportname());
            airport.setLocation(airportModel.getLocation());
            airport = airportRepository.save(airport);
            return new AirportModel(airport.getAirPortId(), airport.getAirportname(), airport.getLocation());
        }
        return null;
    }
    @Transactional
    private Airport findExistingAirport(AirportModel airportModel) {

        Airport airport = null;
        if (!StringUtils.isEmpty(airportModel.getAirportname())) {
            airport = airportRepository.findByairportname(airportModel.getAirportname());
        }
        return airport;
    }

    @Transactional
    public void delete(Long id) {
        airportRepository.deleteById(id);
    }
}




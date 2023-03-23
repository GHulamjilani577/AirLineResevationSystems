package com.example.AirLineResevationSystems.service;

import com.example.AirLineResevationSystems.model.AirportModel;
import com.example.AirLineResevationSystems.repository.AirLineRepository;
import com.example.AirLineResevationSystems.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirportService {
    @Autowired
    public AirportRepository airportRepository;
    public AirportModel insert(AirportModel airportModel){
        return airportModel.assemble(airportRepository.save(airportModel.disassemble()));
    }
}


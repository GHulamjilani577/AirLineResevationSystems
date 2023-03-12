package com.example.AirLineResevationSystems.service;

import com.example.AirLineResevationSystems.entity.Airline;
import com.example.AirLineResevationSystems.repository.AirLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirLineServices {
    @Autowired
    public AirLineRepository airLineRepository;
    public Airline insert(Airline airline){
        return airLineRepository.save(airline);
    }
}

package com.example.AirLineResevationSystems.service;

import com.example.AirLineResevationSystems.model.AirLineFlightModel;
import com.example.AirLineResevationSystems.repository.AirLineFlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirLineFlightService
{
    @Autowired
    private AirLineFlightRepository airLineFlightRepository;
    public AirLineFlightModel insert(AirLineFlightModel airLineFlightModel){
        return airLineFlightModel.assemble(airLineFlightRepository.save(airLineFlightModel.disassemble()));
    }


}

package com.example.AirLineResevationSystems.service;

import com.example.AirLineResevationSystems.model.AirlineModel;
import com.example.AirLineResevationSystems.repository.AirLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirLineService {
    @Autowired
    public AirLineRepository airLineRepository;
    public AirlineModel insert(AirlineModel airlineModel){
        return airlineModel.assemble(airLineRepository.save(airlineModel.disassemble()));
    }
}

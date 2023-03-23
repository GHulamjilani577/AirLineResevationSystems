package com.example.AirLineResevationSystems.service;
import com.example.AirLineResevationSystems.model.FlightScheduleModel;
import com.example.AirLineResevationSystems.repository.FlightScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightScheduleService {
    @Autowired
    public FlightScheduleRepository flightScheduleRepository;
    public FlightScheduleModel insert(FlightScheduleModel flightScheduleModel){
        return flightScheduleModel.assemble(flightScheduleRepository.save(flightScheduleModel.disassemble()));
    }
}

package com.example.AirLineResevationSystems.service;
import com.example.AirLineResevationSystems.entity.FlightSchedule;
import com.example.AirLineResevationSystems.model.FlightScheduleModel;
import com.example.AirLineResevationSystems.repository.FlightScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightScheduleService {
    @Autowired
    public FlightScheduleRepository flightScheduleRepository;
    public FlightScheduleModel insert(FlightScheduleModel flightScheduleModel){
        return flightScheduleModel.assemble(flightScheduleRepository.save(flightScheduleModel.disassemble()));
    }

    public List<FlightSchedule> findAll() {
        return flightScheduleRepository.findAll();
    }

    public Optional<FlightSchedule> findById(Long id) {
        return flightScheduleRepository.findById(id);
    }

    public void delete(FlightSchedule flightSchedule) {
        flightScheduleRepository.delete(flightSchedule);
    }
}

package com.example.AirLineResevationSystems.service;
import com.example.AirLineResevationSystems.entity.AirLineFlight;
import com.example.AirLineResevationSystems.entity.FlightSchedule;
import com.example.AirLineResevationSystems.entity.User;
import com.example.AirLineResevationSystems.model.FlightScheduleModel;
import com.example.AirLineResevationSystems.repository.AirLineFlightRepository;
import com.example.AirLineResevationSystems.repository.FlightScheduleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlightScheduleService {
    @Autowired
    public FlightScheduleRepository flightScheduleRepository;
    @Autowired
    AirLineFlightRepository airLineFlightRepository;
    public FlightScheduleModel insert(FlightScheduleModel flightScheduleModel){
        AirLineFlight airLineFlight =airLineFlightRepository.findById(flightScheduleModel.getAirLineFlightModel().getAirLineFlightId()).get();
        FlightSchedule flightSchedule=new FlightSchedule();
        flightSchedule.setAirLineFlight(airLineFlight);
        return flightScheduleModel.assemble(flightScheduleRepository.save(flightScheduleModel.disassemble()));
    }

    public List<FlightSchedule> findAll() {
        return flightScheduleRepository.findAll();
    }

    public Optional<FlightSchedule> findById(Long id) {
        return flightScheduleRepository.findById(id);
    }

    public  List<FlightScheduleModel> findByAirLineFlightId(Long id){
        List<FlightScheduleModel> list=flightScheduleRepository.findFlightScheduleByAirLineFlight_AirLineFlightId(id).stream().map(FlightScheduleModel::new).collect(Collectors.toList());
        return  list;
    }

    public void delete(Long id) {
        FlightSchedule flightSchedule = flightScheduleRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Airline flight not found with id: " + id));
        flightScheduleRepository.delete(flightSchedule);
    }

}

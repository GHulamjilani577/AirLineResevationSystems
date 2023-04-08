package com.example.AirLineResevationSystems.service;
import com.example.AirLineResevationSystems.entity.AirLineFlight;
import com.example.AirLineResevationSystems.entity.FlightSchedule;
import com.example.AirLineResevationSystems.model.AirLineFlightModel;
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
    private FlightScheduleRepository flightScheduleRepository;

    @Autowired
    private AirLineFlightRepository airLineFlightRepository;
    public FlightScheduleModel insert(FlightScheduleModel flightScheduleModel) {
        FlightSchedule flightSchedule = flightScheduleModel.disassemble();
        AirLineFlight airLineFlight = airLineFlightRepository.findById(flightSchedule.getAirLineFlight().getAirLineFlightId())
                .orElseThrow(() -> new RuntimeException("Airline flight not found"));
        flightSchedule.setAirLineFlight(airLineFlight);
        FlightSchedule savedFlightSchedule = flightScheduleRepository.save(flightSchedule);
        return new FlightScheduleModel().assemble(savedFlightSchedule);
    }

    public AirLineFlightModel findById(Long id) {
        FlightSchedule flightSchedule = flightScheduleRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Airline flight not found with id: " + id));
        return new FlightScheduleModel().assemble(flightSchedule).getAirLineFlightModel();
    }

    public List<FlightScheduleModel> findAll() {
        List<FlightSchedule> flightSchedules = flightScheduleRepository.findAll();
        return flightSchedules.stream().map(flightSchedule -> new FlightScheduleModel().assemble(flightSchedule)).collect(Collectors.toList());
    }

    public void delete(Long id) {

        FlightSchedule flightSchedule = flightScheduleRepository.findById(id).orElseThrow(() -> new RuntimeException("Flight schedule not found"));
        flightScheduleRepository.delete(flightSchedule);
    }
    public  List<FlightScheduleModel> findByAirLineFlightId(Long id){
        List<FlightScheduleModel> list=flightScheduleRepository.findFlightScheduleByAirLineFlight_AirLineFlightId(id)
                .stream().map(FlightScheduleModel::new).collect(Collectors.toList());

        return  list;
    }

}

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
import java.util.stream.Collectors;

@Service
public class AirLineFlightService
{
    @Autowired
    private FlightScheduleService flightScheduleService;

   /* public AirLineFlightModel getById(Long id) {
        AirLineFlight airLineFlight = airLineFlightRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Airline flight not found with id: " + id));
        List<FlightSchedule> flightSchedules = flightScheduleRepository.findByAirLineFlight(airLineFlight);
        AirLineFlightModel airLineFlightModel = new AirLineFlightModel().assemble(airLineFlight);
        airLineFlightModel.setFlightSchedules(flightSchedules.stream()
                .map(FlightScheduleModel::assemble)
                .collect(Collectors.toList()));
        return airLineFlightModel;
    }*/
    @Autowired
    private AirLineFlightRepository airLineFlightRepository;
    /*public AirLineFlightModel insert(AirLineFlightModel airLineFlightModel){
        return airLineFlightModel.assemble(airLineFlightRepository.save(airLineFlightModel.disassemble()));
    }*/
    public AirLineFlightModel insert(AirLineFlightModel airLineFlightModel) {
        AirLineFlight airLineFlight = airLineFlightModel.disassemble();
        airLineFlight = airLineFlightRepository.save(airLineFlight);

       /* if (airLineFlightModel.getFlightSchedules() != null) {
            for (FlightScheduleModel flightScheduleModel : airLineFlightModel.getFlightSchedules()) {
                FlightSchedule flightSchedule = flightScheduleModel.disassemble();
                flightSchedule.setAirLineFlight(airLineFlight);
                flightScheduleService.insert(FlightScheduleModel.assemble(flightSchedule));
            }
        }*/

        return airLineFlightModel.assemble(airLineFlight);
    }
    /*public AirLineFlightModel insert(AirLineFlightModel airLineFlightModel) {
        AirLineFlight airLineFlight = airLineFlightModel.disassemble();
        airLineFlight = airLineFlightRepository.save(airLineFlight);
        return airLineFlightModel.assemble(airLineFlight);
    }*/

    public AirLineFlightModel getById(Long id) {
        AirLineFlight airLineFlight = airLineFlightRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Airline flight not found with id: " + id));
        return new AirLineFlightModel().assemble(airLineFlight);
    }

    public List<AirLineFlightModel> getAll() {
        List<AirLineFlight> airLineFlights = airLineFlightRepository.findAll();
        return airLineFlights.stream().map(airLineFlight -> new AirLineFlightModel().assemble(airLineFlight)).collect(Collectors.toList());
    }

    public AirLineFlightModel update(Long id, AirLineFlightModel airLineFlightModel) {
        AirLineFlight existingAirLineFlight = airLineFlightRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Airline flight not found with id: " + id));
        AirLineFlight updatedAirLineFlight = airLineFlightModel.disassemble();
        updatedAirLineFlight.setAirLineFlightId(existingAirLineFlight.getAirLineFlightId());
        updatedAirLineFlight = airLineFlightRepository.save(updatedAirLineFlight);
        return airLineFlightModel.assemble(updatedAirLineFlight);
    }

    public void delete(Long id) {
        AirLineFlight airLineFlight = airLineFlightRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Airline flight not found with id: " + id));
        airLineFlightRepository.delete(airLineFlight);
    }


}

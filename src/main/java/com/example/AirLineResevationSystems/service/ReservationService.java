package com.example.AirLineResevationSystems.service;
import com.example.AirLineResevationSystems.entity.AirLineFlight;
import com.example.AirLineResevationSystems.entity.FlightSchedule;
import com.example.AirLineResevationSystems.entity.Reservation;
import com.example.AirLineResevationSystems.model.ReservationModel;
import com.example.AirLineResevationSystems.repository.FlightScheduleRepository;
import com.example.AirLineResevationSystems.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReservationService {

    @Autowired
    public ReservationRepository reservationRepository;
    @Autowired
    public FlightScheduleRepository flightScheduleRepository;
    public ReservationModel insert(ReservationModel reservationModel){
        FlightSchedule flightSchedule=flightScheduleRepository.findById(reservationModel.getFlightScheduleModel().getFlightScheduleId()).get();
        Reservation reservation=new Reservation();
        reservation.setFlightSchedule(flightSchedule);
        return reservationModel.assemble(reservationRepository.save(reservationModel.disassemble()));
    }

    public Optional<Reservation> getById(int id) {

        return reservationRepository.findById(id);
    }

    public Reservation deleteById(int id) {

        return reservationRepository.deleteById(getById(id));
    }

    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }
}


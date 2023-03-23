package com.example.AirLineResevationSystems.service;
import com.example.AirLineResevationSystems.model.ReservationModel;
import com.example.AirLineResevationSystems.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    @Autowired
    public ReservationRepository reservationRepository;
    public ReservationModel insert(ReservationModel reservationModel){
        return reservationModel.assemble(reservationRepository.save(reservationModel.disassemble()));
    }
}


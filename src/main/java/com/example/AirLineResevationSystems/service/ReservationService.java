package com.example.AirLineResevationSystems.service;
import com.example.AirLineResevationSystems.entity.AirLineFlight;
import com.example.AirLineResevationSystems.entity.FlightSchedule;
import com.example.AirLineResevationSystems.entity.Reservation;
import com.example.AirLineResevationSystems.entity.User;
import com.example.AirLineResevationSystems.model.ReservationModel;
import com.example.AirLineResevationSystems.model.UserModel;
import com.example.AirLineResevationSystems.repository.AirLineFlightRepository;
import com.example.AirLineResevationSystems.repository.FlightScheduleRepository;
import com.example.AirLineResevationSystems.repository.ReservationRepository;
import com.example.AirLineResevationSystems.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private FlightScheduleRepository flightScheduleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AirLineFlightRepository airLineFlightRepository;
    @Autowired
    private UserModel userModel;

    public ReservationModel createReservation( ReservationModel reservationModel){
        // Get the flight schedule for the reservation
        FlightSchedule flightSchedule = flightScheduleRepository.findById(reservationModel.getFlightScheduleModel().getFlightScheduleId())
                .orElseThrow(() -> new RuntimeException("FlightSchedule not found"));

        // Check the reservation category and update the corresponding capacity in the airline flight
        AirLineFlight airLineFlight = flightSchedule.getAirLineFlight();
        if ("economy".equalsIgnoreCase(reservationModel.getReservationCategory())) {
            int economyCapacity = Integer.parseInt(airLineFlight.getEconomyCapacity());
            if (economyCapacity > 0) {
                airLineFlight.setEconomyCapacity(String.valueOf(economyCapacity - 1));
                airLineFlightRepository.save(airLineFlight);
            } else {
                // Set the flight status to "CLOSE" if economy capacity is 0
                flightSchedule.setFlightStatus("CLOSE");
                flightScheduleRepository.save(flightSchedule);
                throw new RuntimeException("Economy capacity is full for the selected flight");
            }
        } else if ("business".equalsIgnoreCase(reservationModel.getReservationCategory())) {
            int businessCapacity = Integer.parseInt(airLineFlight.getBusinessCapacity());
            if (businessCapacity > 0) {
                airLineFlight.setBusinessCapacity(String.valueOf(businessCapacity - 1));
                airLineFlightRepository.save(airLineFlight);
            } else {
                // Set the flight status to "CLOSE" if business capacity is 0
                flightSchedule.setFlightStatus("CLOSE");
                flightScheduleRepository.save(flightSchedule);
                throw new RuntimeException("Business capacity is full for the selected flight");
            }
        } else {
            throw new RuntimeException("Invalid reservation category");
        }

        // Save the reservation
        Reservation reservation = reservationModel.disassemble();
        reservation.setFlightSchedule(flightSchedule);
        User user=userRepository.findById(reservation.getUser().getId())
                .orElseThrow(() -> new RuntimeException("user not found"));
        reservation.setUser(user);
        return reservationModel.assemble(reservationRepository.save(reservationModel.disassemble()));
    }
    public List<ReservationModel> getAllReservations() {
        List<Reservation> reservations = reservationRepository.findAll();
        List<ReservationModel> reservationModels = new ArrayList<>();
        for (Reservation reservation : reservations) {
            ReservationModel reservationModel = new ReservationModel(reservation).assemble(reservation);
            reservationModels.add(reservationModel);
        }
        return reservationModels;
    }

    public ReservationModel getReservationById(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));
        ReservationModel reservationModel = new ReservationModel(reservation).assemble(reservation);
        return reservationModel;
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

}



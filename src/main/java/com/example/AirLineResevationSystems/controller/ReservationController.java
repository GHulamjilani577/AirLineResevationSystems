package com.example.AirLineResevationSystems.controller;

import com.example.AirLineResevationSystems.entity.Reservation;
import com.example.AirLineResevationSystems.model.FlightScheduleModel;
import com.example.AirLineResevationSystems.model.ReservationModel;
import com.example.AirLineResevationSystems.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;
    @PostMapping("/Create_reservation")
    public ReservationModel createReservation(@RequestBody ReservationModel reservationModel){
        return reservationService.insert(reservationModel);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ReservationModel> getReservation(@PathVariable("id") int id) {
        Optional<Reservation> reservationOptional = reservationService.getById(id);
        if (reservationOptional.isPresent()) {
            ReservationModel reservationModel = new ReservationModel().assemble(reservationOptional.get());
            return new ResponseEntity<>(reservationModel, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<ReservationModel>> getAllReservations() {
        List<Reservation> reservations = reservationService.getAll();
        List<ReservationModel> reservationModels = reservations.stream()
                .map(reservation -> new ReservationModel().assemble(reservation))
                .collect(Collectors.toList());
        return new ResponseEntity<>(reservationModels, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservationModel> updateReservation(@PathVariable("id") int id,
                                                              @RequestBody ReservationModel reservationModel) {
        Optional<Reservation> reservationOptional = reservationService.getById(id);
        if (reservationOptional.isPresent()) {
            reservationModel.setId(id);
            ReservationModel updatedReservation = reservationService.insert(reservationModel);
            return new ResponseEntity<>(updatedReservation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable("id") int id) {
        Optional<Reservation> reservationOptional = reservationService.getById(id);
        if (reservationOptional.isPresent()) {
            reservationService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

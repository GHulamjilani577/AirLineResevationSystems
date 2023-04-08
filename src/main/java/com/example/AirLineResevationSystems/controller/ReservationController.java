package com.example.AirLineResevationSystems.controller;

import com.example.AirLineResevationSystems.entity.Reservation;
import com.example.AirLineResevationSystems.model.FlightScheduleModel;
import com.example.AirLineResevationSystems.model.ReservationModel;
import com.example.AirLineResevationSystems.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;
    @PostMapping("/create_Reservation")
  public ReservationModel createReservation(@RequestBody ReservationModel reservationModel){

        return reservationService.createReservation(reservationModel);
    }
    @GetMapping
    public ResponseEntity<List<ReservationModel>> getAllReservations() {
        List<ReservationModel> reservationModels = reservationService.getAllReservations();
        return new ResponseEntity<>(reservationModels, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationModel> getReservationById(@PathVariable Long id) {
        ReservationModel reservationModel = reservationService.getReservationById(id);
        return new ResponseEntity<>(reservationModel, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

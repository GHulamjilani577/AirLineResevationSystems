package com.example.AirLineResevationSystems.controller;

import com.example.AirLineResevationSystems.model.FlightScheduleModel;
import com.example.AirLineResevationSystems.model.ReservationModel;
import com.example.AirLineResevationSystems.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationController {
    @Autowired
    private ReservationService reservationService;
    @PostMapping("/Create_reservation")
    public ReservationModel createReservation(@RequestBody ReservationModel reservationModel){
        return reservationService.insert(reservationModel);
    }
}

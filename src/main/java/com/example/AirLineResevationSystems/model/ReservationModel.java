package com.example.AirLineResevationSystems.model;

import com.example.AirLineResevationSystems.entity.Reservation;
import lombok.Data;

@Data
public class ReservationModel
{
    private Long id;
    private int reservationNumber;
    private String reservationCategory;
    private String reservationCreateDate;
    private String reservationPayment;
    private String reservationPaymentMode;
    private String reservationBillingAddress;
    private FlightScheduleModel flightScheduleModel;
    private UserModel userModel;


    public ReservationModel(Reservation reservation) {
        this.id = reservation.getId();
        this.reservationNumber = reservation.getReservationNumber();
        this.reservationCategory = reservation.getReservationCategory();
        this.reservationCreateDate = reservation.getReservationCreateDate();
        this.reservationPayment = reservation.getReservationPayment();
        this.reservationPaymentMode = reservation.getReservationPaymentMode();
        this.reservationBillingAddress = reservation.getReservationBillingAddress();
        this.flightScheduleModel = new FlightScheduleModel(reservation.getFlightSchedule());
        this.userModel = new UserModel(reservation.getUser());
    }
public ReservationModel(ReservationModel reservationModel){

}

    public ReservationModel(){}

    public Reservation disassemble(){
        Reservation reservation=new Reservation();
        reservation.setReservationNumber(reservationNumber);
        reservation.setReservationCategory(reservationCategory);
        reservation.setReservationCreateDate(reservationCreateDate);
        reservation.setReservationPayment(reservationPayment);
        reservation.setReservationPaymentMode(reservationPaymentMode);
        reservation.setReservationBillingAddress(reservationBillingAddress);
        reservation.setFlightSchedule(flightScheduleModel.disassemble());
        reservation.setUser(userModel.disassemble());
        return reservation;
    }
    public ReservationModel assemble(Reservation reservation){
        ReservationModel reservationModel=new ReservationModel(reservation);
        reservationModel.setId(id);
        reservationModel.setReservationNumber(reservationNumber);
        reservationModel.setReservationCategory(reservation.getReservationCategory());
        reservationModel.setReservationCreateDate(reservation.getReservationCreateDate());
        reservationModel.setReservationPayment(reservation.getReservationPayment());
        reservationModel.setReservationPaymentMode(reservation.getReservationPaymentMode());
        reservationModel.setReservationBillingAddress(reservation.getReservationBillingAddress());
        reservationModel.setFlightScheduleModel(new FlightScheduleModel().assemble(reservation.getFlightSchedule()));
        reservationModel.setUserModel(new UserModel().assemble(reservation.getUser()));
        return reservationModel;
    }

}


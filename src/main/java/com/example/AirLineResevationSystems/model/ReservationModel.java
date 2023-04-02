package com.example.AirLineResevationSystems.model;

import com.example.AirLineResevationSystems.entity.Reservation;
import lombok.Data;

@Data
public class ReservationModel
{
    private int id;
    private String reservationNumber;
    private String location;
    private String reservationState;
    private String reservationCreateDate;
    private String reservationPayment;
    private String reservationPaymentMode;
    private String reservationBillingAddress;
    private FlightScheduleModel flightScheduleModel;
    private UserModel userModel;

  public ReservationModel(){}

    public Reservation disassemble(){
        Reservation reservation=new Reservation();
        reservation.setId(id);
        reservation.setReservationNumber(reservationNumber);
        reservation.setLocation(location);
        reservation.setReservationState(reservationState);
        reservation.setReservationCreateDate(reservationCreateDate);
        reservation.setReservationPayment(reservationPayment);
        reservation.setReservationPaymentMode(reservationPaymentMode);
        reservation.setReservationBillingAddress(reservationBillingAddress);
        reservation.setFlightSchedule(flightScheduleModel.disassemble());
        reservation.setUser(userModel.disassemble());
        return reservation;
    }
    public ReservationModel assemble(Reservation reservation){
        ReservationModel reservationModel=new ReservationModel();
        reservationModel.setId(reservation.getId());
        reservationModel.setReservationNumber(reservation.getReservationNumber());
        reservationModel.setLocation(reservation.getLocation());
        reservationModel.setReservationState(reservation.getReservationState());
        reservationModel.setReservationCreateDate(reservation.getReservationCreateDate());
        reservationModel.setReservationPayment(reservation.getReservationPayment());
        reservationModel.setReservationPaymentMode(reservation.getReservationPaymentMode());
        reservationModel.setReservationBillingAddress(reservation.getReservationBillingAddress());
        reservationModel.setFlightScheduleModel(FlightScheduleModel.assemble(reservation.getFlightSchedule()));
        reservationModel.setUserModel(userModel.assemble(reservation.getUser()));
        return reservationModel;
    }
}

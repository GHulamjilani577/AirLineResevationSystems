package com.example.AirLineResevationSystems.model;

import com.example.AirLineResevationSystems.entity.Airline;
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
        return reservation;
    }
    public ReservationModel assemble(Reservation reservation){
        ReservationModel reservationModel=new ReservationModel();
        reservationModel.setId(reservationModel.getId());
        reservationModel.setReservationNumber(reservationModel.getReservationNumber());
        reservationModel.setLocation(reservationModel.getLocation());
        reservationModel.setReservationState(reservationModel.getReservationState());
        reservationModel.setReservationCreateDate(reservationModel.getReservationCreateDate());
        reservationModel.setReservationPayment(reservationModel.getReservationPayment());
        reservationModel.setReservationPaymentMode(reservationModel.getReservationPaymentMode());
        reservationModel.setReservationBillingAddress(reservationModel.getReservationBillingAddress());
        return reservationModel;
    }
}

package com.example.AirLineResevationSystems.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="reservation_id")
    private int id;
    @Column(name="reservation_Number")
    private String reservationNumber;
    @Column(name="reservation_Price")
    private String location;
    @Column(name="reservation_State")
    private String reservationState;
    @Column(name="reservation_CreateDate")
    private String reservationCreateDate;
    @Column(name="reservation_Payment")
    private String reservationPayment;
    @Column(name="reservation_PaymentMode")
    private String reservationPaymentMode;
    @Column(name="reservation_BillingAddress")
    private String reservationBillingAddress;
   @ManyToOne
    private FlightSchedule flightSchedule;
   @ManyToOne
    private User user;

}

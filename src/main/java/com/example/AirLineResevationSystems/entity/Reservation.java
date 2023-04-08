package com.example.AirLineResevationSystems.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Random;

@Entity
@Data
@Table(name="reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="reservation_id")
    private Long id;
    @Column(name = "seat_Code")
    private int seatCode = generateSeatCode();

    private int generateSeatCode() {
        Random rand = new Random();
        return rand.nextInt(9000) + 1000;
    }
    @Column(name="reservation_category")
    private String reservationCategory;
    @Column(name="reservation_CreateDate")
    private String reservationCreateDate;
    //is py condition lagani hai k jis cteogry ko slete kry ga us k price a jai gi yha  ye agr ma na ticket bnai tu us ma khud sy a dd krwa lo ga ma
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

package com.example.AirLineResevationSystems.model;

import com.example.AirLineResevationSystems.entity.Airline;
import lombok.Data;

@Data
public class AirlineModel {
    private  Long id;
    private String flight;
    private String capacity;
    private String passangers;
    private String phoneNumber;
    private String price;

    /*public AirlineModel(String flight, String capacity, String passangers, String phoneNumber, String price) {
        this.flight = flight;
        this.capacity = capacity;
        this.passangers = passangers;
        this.phoneNumber = phoneNumber;
        this.price = price;
    }*/

    public AirlineModel() {

    }

    public Airline disassemble(){
        Airline airline=new Airline();
        airline.setFlight(flight);
        airline.setCapacity(capacity);
        airline.setPassangers(passangers);
        airline.setPhoneNumber(phoneNumber);
        airline.setPrice(price);
        return airline;
    }
    public AirlineModel assemble(Airline airline){
        AirlineModel airlineModel=new AirlineModel();
        airlineModel.setId(airline.getAirLineId());
        airlineModel.setFlight(airline.getFlight());
        airlineModel.setPassangers(airline.getPassangers());
        airlineModel.setCapacity(airline.getCapacity());
        airlineModel.setPhoneNumber(airline.getPhoneNumber());
        airlineModel.setPrice(airline.getPrice());
        return airlineModel;
    }



}

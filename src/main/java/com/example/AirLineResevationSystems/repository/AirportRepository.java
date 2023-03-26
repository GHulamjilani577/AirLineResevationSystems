package com.example.AirLineResevationSystems.repository;

import com.example.AirLineResevationSystems.entity.Airport;
import com.example.AirLineResevationSystems.model.AirportModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<Airport,Long> {

    Airport findAirportByairPortId(Long airPortId);

    Airport findAirportByairportname(String airportname);
}

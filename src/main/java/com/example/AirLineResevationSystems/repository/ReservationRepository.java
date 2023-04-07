package com.example.AirLineResevationSystems.repository;
import com.example.AirLineResevationSystems.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {


    Optional<Reservation> findById(Long id);

    Reservation deleteById(Optional<Reservation> byId);
}

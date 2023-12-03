package com.urbanBites.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.urbanBites.Model.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
  
}

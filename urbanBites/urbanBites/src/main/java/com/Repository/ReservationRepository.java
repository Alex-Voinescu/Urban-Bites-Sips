package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.urbanBites.urbanBites.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
  
}

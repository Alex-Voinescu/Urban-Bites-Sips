package com.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Repository.ReservationRepository;
import com.urbanBites.urbanBites.Reservation;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public ResponseEntity<Reservation> getReservationById(Long reservationId) {
        Optional<Reservation> reservationOptional = reservationRepository.findById(reservationId);
        return reservationOptional.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Reservation> makeReservation(Reservation reservation) {
    	
        Reservation savedReservation = reservationRepository.save(reservation);
        return ResponseEntity.ok(savedReservation);
    }

}

package com.urbanBites.Model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "\"reservation\"")
public class Reservation {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    private LocalDateTime reservationDate;
	    private int numberOfPeople;
	    private Integer tableNumber;
	 
	    public Reservation() {}

	    

		public Reservation(Long id, LocalDateTime reservationDate, int numberOfPeople, Integer tableNumber) {
			super();
			this.id = id;
			this.reservationDate = reservationDate;
			this.numberOfPeople = numberOfPeople;
			this.tableNumber = tableNumber;
		}



		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public LocalDateTime getReservationDate() {
			return reservationDate;
		}

		public void setReservationDate(LocalDateTime reservationDateTime) {
			this.reservationDate = reservationDateTime;
		}

		public int getNumberOfPeople() {
			return numberOfPeople;
		}

		public void setNumberOfPeople(int numberOfPeople) {
			this.numberOfPeople = numberOfPeople;
		}
		
		public Integer getTableNumber() {
			return tableNumber;
		}

		public void setTableNumber(Integer tableNumber) {
			this.tableNumber = tableNumber;
		}

		@Override
		public String toString() {
			return "Reservation [id=" + id + ", reservationDate=" + reservationDate + ", numberOfPeople="
					+ numberOfPeople + ", tableNumber=" + tableNumber + "]";
		}
		
		
	    
}

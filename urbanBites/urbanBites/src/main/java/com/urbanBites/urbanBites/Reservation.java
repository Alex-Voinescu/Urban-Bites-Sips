package com.urbanBites.urbanBites;

import java.time.LocalDateTime;

public class Reservation {
	  private Long id;
	    private LocalDateTime reservationDateTime;
	    private int numberOfPeople;
	 
	    public Reservation() {}

	    public Reservation(LocalDateTime reservationDateTime, int numberOfPeople) {
	        this.reservationDateTime = reservationDateTime;
	        this.numberOfPeople = numberOfPeople;
	    }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public LocalDateTime getReservationDateTime() {
			return reservationDateTime;
		}

		public void setReservationDateTime(LocalDateTime reservationDateTime) {
			this.reservationDateTime = reservationDateTime;
		}

		public int getNumberOfPeople() {
			return numberOfPeople;
		}

		public void setNumberOfPeople(int numberOfPeople) {
			this.numberOfPeople = numberOfPeople;
		}

		@Override
		public String toString() {
			return "Reservation [id=" + id + ", reservationDateTime=" + reservationDateTime + ", numberOfPeople="
					+ numberOfPeople + "]";
		}
	    
}

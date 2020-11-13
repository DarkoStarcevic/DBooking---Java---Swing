package com.comtrade.domen;

public class Availability {
	
	private int id_Availability;
	private Reservation reservation;
	private int number_of_availableRooms;
	
	public Availability(int id_Availability, Reservation reservation, int number_of_availableRooms) {
		super();
		this.id_Availability = id_Availability;
		this.reservation = reservation;
		this.number_of_availableRooms = number_of_availableRooms;
	}
	
	
	public Availability() {
		super();
	}


	public int getId_Availability() {
		return id_Availability;
	}
	public void setId_Availability(int id_Availability) {
		this.id_Availability = id_Availability;
	}
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public int getNumber_of_availableRooms() {
		return number_of_availableRooms;
	}

	public void setNumber_of_availableRooms(int number_of_availableRooms) {
		this.number_of_availableRooms = number_of_availableRooms;
	}


	

}

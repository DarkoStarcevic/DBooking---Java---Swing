package com.comtrade.controlerUI;

import java.io.IOException;

import com.comtrade.comunication.Comunication;
import com.comtrade.domen.Destination;
import com.comtrade.domen.Message;
import com.comtrade.domen.Operations;
import com.comtrade.domen.Payment;
import com.comtrade.domen.PhotoAlbum;
import com.comtrade.domen.Reservation;
import com.comtrade.domen.Residence;
import com.comtrade.domen.Review;
import com.comtrade.domen.Room;
import com.comtrade.domen.Room_Info;
import com.comtrade.domen.User;
import com.comtrade.transfer.TransferClass;


public class ControlerUI {
	
	private static ControlerUI instanca;
	
	
	private ControlerUI() {
		
	}
	
	public static ControlerUI getInstanca(){
		if(instanca == null) {
			instanca = new ControlerUI();
		}
		return instanca;
	}
	
	public TransferClass vrati(TransferClass transferKlasa) throws ClassNotFoundException, IOException {
		Comunication.getKomunikacija().send(transferKlasa);
		TransferClass transferKlasa1 = Comunication.getKomunikacija().read();
		return transferKlasa1;
		
		
	}

	public TransferClass sacuvajUsera(User user) throws ClassNotFoundException, IOException {
		TransferClass transferKlasa = new TransferClass();
		transferKlasa.setClient_object_request(user);
		transferKlasa.setOperation(Operations.SACUVAJ_USERA);
		return vrati(transferKlasa);
		
		
	}

	public TransferClass login(User user) throws ClassNotFoundException, IOException {
		TransferClass transferKlasa = new TransferClass();
		transferKlasa.setClient_object_request(user);
		transferKlasa.setOperation(Operations.USER_LOGIN);
		return vrati(transferKlasa);
				
	}
	
	public TransferClass logout(User user) throws ClassNotFoundException, IOException {
		TransferClass transferKlasa = new TransferClass();
		transferKlasa.setClient_object_request(user);
		transferKlasa.setOperation(Operations.USER_LOGOUT);
		return vrati(transferKlasa);
	
	}
	
	public TransferClass sacuvajNoviPassword(User user) throws ClassNotFoundException, IOException {
		TransferClass transferKlasa = new TransferClass();
		transferKlasa.setClient_object_request(user);
		transferKlasa.setOperation(Operations.SACUVAJ_NOVI_PASSWORD);
		return vrati(transferKlasa);
	}
	
	public TransferClass getUserListBack() throws ClassNotFoundException, IOException {
		TransferClass transferKlasa = new TransferClass();
		transferKlasa.setOperation(Operations.GET_BACK_USER_LIST);
		return vrati(transferKlasa);
		
	}

	public TransferClass insertResidence(Residence residence) throws ClassNotFoundException, IOException {
		TransferClass transferKlasa = new TransferClass();
		transferKlasa.setClient_object_request(residence);
		transferKlasa.setOperation(Operations.INSERT_RESIDENCE);
		return vrati(transferKlasa);
	}
	
	public TransferClass putAllResidenceIntoTable() throws ClassNotFoundException, IOException {
		TransferClass transferKlasa = new TransferClass();
		transferKlasa.setOperation(Operations.PUT_ALL_RESIDENCE_INTO_TABLE);
		return vrati(transferKlasa);
	}

	public TransferClass updateResidence(Residence residence) throws ClassNotFoundException, IOException {
		TransferClass transferKlasa = new TransferClass();
		transferKlasa.setClient_object_request(residence);
		transferKlasa.setOperation(Operations.RESIDENCE_UPDATE);
		return vrati(transferKlasa);
	}

	public TransferClass deleteResidence(Residence residence) throws ClassNotFoundException, IOException {
		TransferClass transferKlasa = new TransferClass();
		transferKlasa.setClient_object_request(residence);
		transferKlasa.setOperation(Operations.DELETE_RESIDENCE);
		return vrati(transferKlasa);
		
	}
	
	public TransferClass insertDestination(Destination destination) throws ClassNotFoundException, IOException {
		TransferClass transferKlasa = new TransferClass();
		transferKlasa.setClient_object_request(destination);
		transferKlasa.setOperation(Operations.INSERT_DESTINATION);
		return vrati(transferKlasa);
		
	}
	
	public TransferClass putDestinationIntoTable() throws ClassNotFoundException, IOException {
		TransferClass transferKlasa = new TransferClass();
		transferKlasa.setOperation(Operations.PUT_DESTINATION_INTO_TABLE);
		return vrati(transferKlasa);
	}

	public TransferClass updateDestination(Destination destination) throws ClassNotFoundException, IOException {
		TransferClass transferKlasa = new TransferClass();
		transferKlasa.setClient_object_request(destination);
		transferKlasa.setOperation(Operations.UPDATE_DESTINATION);
		return vrati(transferKlasa);
	}

	public TransferClass insertRoom(Room room) throws ClassNotFoundException, IOException {
		TransferClass transferKlasa = new TransferClass();
		transferKlasa.setClient_object_request(room);
		transferKlasa.setOperation(Operations.INSERT_ROOM);
		return vrati(transferKlasa);
	}

	public TransferClass insertPhoto(PhotoAlbum photoAlbum) throws ClassNotFoundException, IOException {
		TransferClass transferKlasa = new TransferClass();
		transferKlasa.setClient_object_request(photoAlbum);
		transferKlasa.setOperation(Operations.INSERT_PHOTO_IMAGE);
		return vrati(transferKlasa);
	}
	
	public TransferClass returnPhoto() throws ClassNotFoundException, IOException {
		TransferClass transferKlasa = new TransferClass();
		transferKlasa.setOperation(Operations.RETURN_PHOTO);
		return vrati(transferKlasa);
	}

	public TransferClass insertRoomServices(Room_Info room_Info) throws ClassNotFoundException, IOException {
		TransferClass transferKlasa = new TransferClass();
		transferKlasa.setClient_object_request(room_Info);
		transferKlasa.setOperation(Operations.INSERT_ROOM_SERVICES);
		return vrati(transferKlasa);
		
	}
	
	public TransferClass getBackRoomInfo() throws ClassNotFoundException, IOException {
		TransferClass transferKlasa = new TransferClass();
		transferKlasa.setOperation(Operations.GET_BACK_ROOM_INFO);
		return vrati(transferKlasa);
	}
	
	public TransferClass getAllRoomsBack() throws ClassNotFoundException, IOException {
		TransferClass transferKlasa = new TransferClass();
		transferKlasa.setOperation(Operations.GET_ALL_ROOMS_BACK);
		return vrati(transferKlasa);
	}

	public TransferClass confirmReservation(Reservation reservation) throws ClassNotFoundException, IOException {
		TransferClass transferKlasa = new TransferClass();
		transferKlasa.setClient_object_request(reservation);
		transferKlasa.setOperation(Operations.CONFIRM_RESERVATION);
		return vrati(transferKlasa);
		
	}

	public TransferClass getReservationBack() throws ClassNotFoundException, IOException {
		TransferClass transferKlasa = new TransferClass();
		transferKlasa.setOperation(Operations.GET_RESERVATION_BACK);
		return vrati(transferKlasa);
	}
	
	public TransferClass checkAvailability() throws ClassNotFoundException, IOException {
		TransferClass transferKlasa = new TransferClass();
		transferKlasa.setOperation(Operations.CHECK_AVAILABILITY);
		return vrati(transferKlasa);
	}
	
	public TransferClass confirmPayment(Payment payment) throws ClassNotFoundException, IOException {
		TransferClass transferKlasa = new TransferClass();
		transferKlasa.setClient_object_request(payment);
		transferKlasa.setOperation(Operations.CONFIRM_PAYMENT);
		return vrati(transferKlasa);
		
	}
	
	public TransferClass getPaymentBack() throws ClassNotFoundException, IOException {
		TransferClass transferKlasa = new TransferClass();
		transferKlasa.setOperation(Operations.GET_PAYMENT_BACK);
		return vrati(transferKlasa);
	}

	public TransferClass updatePersonalData(User user) throws ClassNotFoundException, IOException {
		TransferClass transferKlasa = new TransferClass();
		transferKlasa.setClient_object_request(user);
		transferKlasa.setOperation(Operations.UPDATE_USER);
		return vrati(transferKlasa);
	}

	public TransferClass cancelReservation(Reservation reservation) throws ClassNotFoundException, IOException {
		TransferClass transferKlasa = new TransferClass();
		transferKlasa.setClient_object_request(reservation);
		transferKlasa.setOperation(Operations.CANCEL_RESERVATION);
		return vrati(transferKlasa);
	}

	public TransferClass cancelPayment(Payment payment) throws ClassNotFoundException, IOException {
		TransferClass transferKlasa = new TransferClass();
		transferKlasa.setClient_object_request(payment);
		transferKlasa.setOperation(Operations.CANCEL_PAYMENT);
		return vrati(transferKlasa);
	}

	public TransferClass insertRevirew(Review review) throws ClassNotFoundException, IOException {
		TransferClass transferKlasa = new TransferClass();
		transferKlasa.setClient_object_request(review);
		transferKlasa.setOperation(Operations.INSERT_REVIEW);
		return vrati(transferKlasa);
	}
	
	public TransferClass getReviewBack() throws ClassNotFoundException, IOException {
		TransferClass transferKlasa = new TransferClass();
		transferKlasa.setOperation(Operations.GET_REVIEW_BACK);
		return vrati(transferKlasa);
	}
	
	public TransferClass getAvgReview() throws ClassNotFoundException, IOException {
		TransferClass transferKlasa = new TransferClass();
		transferKlasa.setOperation(Operations.GET_AVERAGE_REVIEW);
		return vrati(transferKlasa);
	}
	
	public TransferClass startChat(User user, Message message) throws ClassNotFoundException, IOException {
		TransferClass transferKlasa = new TransferClass();
		transferKlasa.setClient_object_request(message);
		transferKlasa.setServer_object_response(user);
		transferKlasa.setOperation(Operations.START_CHAT);
		return vrati(transferKlasa);
	}

	public TransferClass updateResidenceAvgRating(Residence residence) throws ClassNotFoundException, IOException {
		TransferClass transferKlasa = new TransferClass();
		transferKlasa.setClient_object_request(residence);
		transferKlasa.setOperation(Operations.UPDATE_RESIDENCE_AVG_RATING);
		return vrati(transferKlasa);
	}

	
	
}

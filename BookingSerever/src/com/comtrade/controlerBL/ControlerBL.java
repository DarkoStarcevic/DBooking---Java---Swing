package com.comtrade.controlerBL;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import com.comtrade.So.OpstaSistemskaOperacija;
import com.comtrade.So.Payment.CancelPaymentSo;
import com.comtrade.So.Payment.ConfirmPaymentSo;
import com.comtrade.So.Payment.GetPaymentBackSo;
import com.comtrade.So.Reservation.CancelReservationSo;
import com.comtrade.So.Reservation.checkAvailabilitySo;
import com.comtrade.So.Reservation.confirmReservationSo;
import com.comtrade.So.Reservation.getReservationBackSo;
import com.comtrade.So.Review.UpdateResidenceAvgRatingSo;
import com.comtrade.So.Review.getAvgReviewSo;
import com.comtrade.So.Review.getReviewBackSo;
import com.comtrade.So.Review.insertReviewSo;
import com.comtrade.So.RoomInfo.RoomInfoSo;
import com.comtrade.So.RoomInfo.getRoomInfoBackSO;
import com.comtrade.So.destination.InsertDestinationSO;
import com.comtrade.So.destination.PutDestinationBack;
import com.comtrade.So.destination.UpdateDestinationSo;
import com.comtrade.So.residence.DeleteResidenceSo;
import com.comtrade.So.residence.ResidenceSo;
import com.comtrade.So.residence.UpdateResidenceSo;
import com.comtrade.So.residence.putResidenceBack;
import com.comtrade.So.room.GetRoomsBackSo;
import com.comtrade.So.room.InsertRoomSO;
import com.comtrade.So.user.LoginUser;
import com.comtrade.So.user.LogoutUser;
import com.comtrade.So.user.UpdatePersonalDataSo;
import com.comtrade.So.user.UserPasswordReset;
import com.comtrade.So.user.UserSo;
import com.comtrade.So.user.getBackUserSo;
import com.comtrade.domen.Destination;
import com.comtrade.domen.Payment;
import com.comtrade.domen.PhotoAlbum;
import com.comtrade.domen.Reservation;
import com.comtrade.domen.Residence;
import com.comtrade.domen.Review;
import com.comtrade.domen.Room;
import com.comtrade.domen.Room_Info;
import com.comtrade.domen.User;
import com.comtrade.photoAlbumSo.InsertPhotoSo;
import com.comtrade.photoAlbumSo.getPhotosBackSo;
import com.comtrade.threads.ClientThread;
import com.comtrade.view.ServerForm;

public class ControlerBL {
	
	private static volatile ControlerBL instanca;
	private ServerForm serverForma;
	private List<ClientThread>list;
	
	private ControlerBL() {
		list = new ArrayList<>();
	}
	
	public static ControlerBL getInstanca() {
		if(instanca == null) {
			synchronized (ControlerBL.class) {
				if(instanca == null) {
					instanca = new ControlerBL();
				}
			}
			
		}
		return instanca;
	}
	
	public void setFrame(ServerForm serverForma) {
		this.serverForma = serverForma;
		}
	
	public void setUserInfoOnServer(String text) {
		serverForma.setTextArea(text);
		
	}
	

	public void sacuvajUsera(User user) {
		OpstaSistemskaOperacija opstaSistemskaOperacija = new UserSo();
		opstaSistemskaOperacija.izvrsiSistemskuOperaciju(user);
	}

	public User login(User user1) {
		List<User>list = new ArrayList<>();
		list.add(user1);
		OpstaSistemskaOperacija opstaSistemskaOperacija = new LoginUser();
		opstaSistemskaOperacija.izvrsiSistemskuOperaciju(list);	
		return list.get(1);	
	}
	
	public User logout(User userLogout) {
		List<User>listUser = new ArrayList<>();
		listUser.add(userLogout);
		OpstaSistemskaOperacija operacija = new LogoutUser();
		operacija.izvrsiSistemskuOperaciju(listUser);
		return userLogout;
		
	}
	
	public User sacuvajNoviPassword(User user3) {
		OpstaSistemskaOperacija opstaSistemskaOperacija = new UserPasswordReset();
		opstaSistemskaOperacija.izvrsiSistemskuOperaciju(user3);
		return user3;
				
	}

	public Residence insertResidence(Residence residence) {
	
		List<Residence>list = new ArrayList<>();
		list.add(residence);
		OpstaSistemskaOperacija opstaSistemskaOperacija = new ResidenceSo();
		opstaSistemskaOperacija.izvrsiSistemskuOperaciju(list);
		return list.get(1);
		
	}

	public List<Residence> putListOfResidence() {
		List<Residence>list = new ArrayList<>();
		OpstaSistemskaOperacija operacija = new putResidenceBack();
		operacija.izvrsiSistemskuOperaciju(list);
		return list;
		
	}

	public Residence updateResidence(Residence residence2) {
		OpstaSistemskaOperacija opstaSistemskaOperacija = new UpdateResidenceSo();
		opstaSistemskaOperacija.izvrsiSistemskuOperaciju(residence2);
		return residence2;
	}

	public void deleteResidence(Residence residence2) {
		OpstaSistemskaOperacija opstaSistemskaOperacija = new DeleteResidenceSo();
		opstaSistemskaOperacija.izvrsiSistemskuOperaciju(residence2);
		
	}

	public Destination insertDestination(Destination destination) {
		List<Destination>list = new ArrayList<>();
		list.add(destination);
		OpstaSistemskaOperacija opstaSistemskaOperacija = new InsertDestinationSO();
		opstaSistemskaOperacija.izvrsiSistemskuOperaciju(list);
		return list.get(1);
		
		/*Set<Destination>set = new HashSet<>();
		set.add(destination);
		OpstaSistemskaOperacija opstaSistemskaOperacija = new InsertDestinationSO();
		opstaSistemskaOperacija.izvrsiSistemskuOperaciju(set);
		return destination;*/
		
		
	}

	public List<Destination> putDestinationList() {
		List<Destination>list1 = new ArrayList<>();
		OpstaSistemskaOperacija operacija = new PutDestinationBack();
		operacija.izvrsiSistemskuOperaciju(list1);
		return list1;
	}

	public Destination updateDestination(Destination destination2) {
		OpstaSistemskaOperacija opstaSistemskaOperacija = new UpdateDestinationSo();
		opstaSistemskaOperacija.izvrsiSistemskuOperaciju(destination2);
		return destination2;
	}

	public Room insertRoom(Room room) {
		/*OpstaSistemskaOperacija opstaSistemskaOperacija = new InsertRoomSO();
		opstaSistemskaOperacija.izvrsiSistemskuOperaciju(room);
		return room;*/
		
		List<Room>list = new ArrayList<>();
		list.add(room);
		OpstaSistemskaOperacija opstaSistemskaOperacija = new InsertRoomSO();
		opstaSistemskaOperacija.izvrsiSistemskuOperaciju(list);
		return list.get(1);
	}

	public PhotoAlbum insertPhotoImage(PhotoAlbum photoAlbum) {
		/*OpstaSistemskaOperacija opstaSistemskaOperacija = new InsertPhotoSo();
		opstaSistemskaOperacija.izvrsiSistemskuOperaciju(photoAlbum);
		return photoAlbum;*/
		
		List<PhotoAlbum>photoLIst = new ArrayList<>();
		photoLIst.add(photoAlbum);
		OpstaSistemskaOperacija operacija = new InsertPhotoSo();
		operacija.izvrsiSistemskuOperaciju(photoLIst);
		return photoLIst.get(1);
		
			 
	}

	public Room_Info insertRoomServices(Room_Info room_Info) {
		/*OpstaSistemskaOperacija opstaSistemskaOperacija = new RoomInfoSo();
		opstaSistemskaOperacija.izvrsiSistemskuOperaciju(room_Info);
		return room_Info;*/
		List<Room_Info>list = new ArrayList<>();
		list.add(room_Info);
		OpstaSistemskaOperacija opstaSistemskaOperacija = new RoomInfoSo();
		opstaSistemskaOperacija.izvrsiSistemskuOperaciju(list);
		return list.get(1);
	}

	public List<Room> getRoomsBack() {
		List<Room>list = new ArrayList<>();
		OpstaSistemskaOperacija operacija = new GetRoomsBackSo();
		operacija.izvrsiSistemskuOperaciju(list);
		return list;
		
	}

	public List<Room_Info> getBackRoomInfo() {
		List<Room_Info>listRoomInfo = new ArrayList<>();
		OpstaSistemskaOperacija operacija = new getRoomInfoBackSO();
		operacija.izvrsiSistemskuOperaciju(listRoomInfo);
		return listRoomInfo;
	}

	public List<PhotoAlbum> getPhotosBack() {
		List<PhotoAlbum>photoList = new LinkedList<PhotoAlbum>();
		OpstaSistemskaOperacija operacija = new getPhotosBackSo();
		operacija.izvrsiSistemskuOperaciju(photoList);
		return photoList;
	}

	public Reservation insertReservation(Reservation reservation) {
		List<Reservation>reservationList = new ArrayList<>();
		reservationList.add(reservation);
		OpstaSistemskaOperacija operacija = new confirmReservationSo();
		operacija.izvrsiSistemskuOperaciju(reservationList);
		return reservationList.get(1);
		
		
	}

	public List<Reservation> getReservationBack() {
		List<Reservation>listReservation = new ArrayList<>();
		OpstaSistemskaOperacija operacija = new getReservationBackSo();
		operacija.izvrsiSistemskuOperaciju(listReservation);
		return listReservation;
	}
	
	public List<Reservation> checkAvailability() {
		List<Reservation>listReserv = new ArrayList<>();
		OpstaSistemskaOperacija operacija = new checkAvailabilitySo();
		operacija.izvrsiSistemskuOperaciju(listReserv);
		return listReserv;
		
	}

	public List<User> getBackUserList() {
		List<User>listUser = new ArrayList<>();
		OpstaSistemskaOperacija operacija = new getBackUserSo();
		operacija.izvrsiSistemskuOperaciju(listUser);
		return listUser;
	}

	public Payment insertPayment(Payment payment) {
	
		List<Payment>paymantList = new ArrayList<>();
		paymantList.add(payment);
		OpstaSistemskaOperacija operacija = new ConfirmPaymentSo();
		operacija.izvrsiSistemskuOperaciju(paymantList);
		return paymantList.get(1);
		
	}

	public List<Payment> getPaymentBack() {
		List<Payment>listPayment = new ArrayList<>();
		OpstaSistemskaOperacija operacija = new GetPaymentBackSo();
		operacija.izvrsiSistemskuOperaciju(listPayment);
		return listPayment;
	}

	public User updatePersonalData(User user4) {
		OpstaSistemskaOperacija opstaSistemskaOperacija = new UpdatePersonalDataSo();
		opstaSistemskaOperacija.izvrsiSistemskuOperaciju(user4);
		return user4;
	}

	public void cancelReservation(Reservation reservation3) {
		OpstaSistemskaOperacija opstaSistemskaOperacija = new CancelReservationSo();
		opstaSistemskaOperacija.izvrsiSistemskuOperaciju(reservation3);
		
	}

	public void cancelPayment(Payment payment3) {
		OpstaSistemskaOperacija opstaSistemskaOperacija = new CancelPaymentSo();
		opstaSistemskaOperacija.izvrsiSistemskuOperaciju(payment3);
		
	}

	public Review insertReview(Review review) {
		List<Review>list = new ArrayList<>();
		list.add(review);
		OpstaSistemskaOperacija opstaSistemskaOperacija = new insertReviewSo();
		opstaSistemskaOperacija.izvrsiSistemskuOperaciju(list);
		return list.get(1);
		
		/*OpstaSistemskaOperacija opstaSistemskaOperacija = new insertReviewSo();
		opstaSistemskaOperacija.izvrsiSistemskuOperaciju(review);
		return review;*/
		
	}

	public List<Review> getReviewBack() {
		List<Review>reviewList = new ArrayList<>();
		OpstaSistemskaOperacija operacija = new getReviewBackSo();
		operacija.izvrsiSistemskuOperaciju(reviewList);
		return reviewList;
	}

	public List<Review> getAvgReview() {
		List<Review>reviewList1 = new ArrayList<>();
		OpstaSistemskaOperacija opstaSistemskaOperacija = new getAvgReviewSo();
		opstaSistemskaOperacija.izvrsiSistemskuOperaciju(reviewList1);
		return reviewList1;
	}

	public Residence updateResidenceAvgRating(Residence residence3) {
		OpstaSistemskaOperacija opstaSistemskaOperacija = new UpdateResidenceAvgRatingSo();
		opstaSistemskaOperacija.izvrsiSistemskuOperaciju(residence3);
		return residence3;
	}

	

	public void obavestiKlijente(String poruka, ClientThread klijentThread) {
		for(ClientThread thread : list) {
			if(!thread.equals(klijentThread)) {
				thread.posalji(poruka);
			}
		}
		
	}

	public void dodajKlijent(ClientThread klijentThread) {
		list.add(klijentThread);
		
	}
	
	
	

}

	
	
	
	

	
 


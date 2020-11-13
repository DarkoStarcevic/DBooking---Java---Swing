 package com.comtrade.threads;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import com.comtrade.controlerBL.ControlerBL;
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


public class ClientThread extends Thread {
	
	private Socket socket;
	
	
	
	
	public void setSocket(Socket socket) {
		this.socket = socket;
		
		
	}
	
	public void run() {
		
		while(true) {
		  
		try {
			ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
			TransferClass transferKlasa = (TransferClass) objectInputStream.readObject();
			obradaKlijenta(transferKlasa);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
}
	

	private void obradaKlijenta(TransferClass transferKlasa) {
		TransferClass transferKlasa1 = new TransferClass();
		switch (transferKlasa.getOperation()) {
		
		case Operations.SACUVAJ_USERA:
			User user = (User) transferKlasa.getClient_object_request();
		    ControlerBL.getInstanca().sacuvajUsera(user);
			transferKlasa1.setMessage_response("user has been successfully saved");
			send(transferKlasa1);
			
			
		    break;

		case Operations.USER_LOGIN:
			User user1 = (User) transferKlasa.getClient_object_request();
			User user2 = ControlerBL.getInstanca().login(user1);
			DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");
			DateTimeFormatter date = DateTimeFormatter.ofPattern("MMMM - dd - YYYY.");
			ControlerBL.getInstanca().setUserInfoOnServer(("\n"+" user "+ user2.getUsername() + " is connected " + "(" +LocalDate.now().format(date) +"  at  "+ LocalTime.now().format(time)+")"));
			transferKlasa1.setServer_object_response(user2);         
			send(transferKlasa1);		
			break;
			
		case Operations.USER_LOGOUT:
			User userLogout = (User) transferKlasa.getClient_object_request();
			User userLogout1 = ControlerBL.getInstanca().logout(userLogout);
			DateTimeFormatter time1 = DateTimeFormatter.ofPattern("HH:mm:ss");
			DateTimeFormatter date1 = DateTimeFormatter.ofPattern("MMMM - dd - YYYY.");
		    ControlerBL.getInstanca().setUserInfoOnServer(("\n"+" user "+ userLogout1.getUsername() + " is logged out " + "(" +LocalDate.now().format(date1) +"  at  "+ LocalTime.now().format(time1)+")"));
			transferKlasa1.setServer_object_response(userLogout1);         
			send(transferKlasa1);		
			break;
			
		case Operations.SACUVAJ_NOVI_PASSWORD:	
	        User user3 =  (User) transferKlasa.getClient_object_request();
	        user3 = ControlerBL.getInstanca().sacuvajNoviPassword(user3);
			transferKlasa1.setServer_object_response(user3);
		    transferKlasa1.setMessage_response("Password reset successfully");
		    send(transferKlasa1);
			break;
			
		case Operations.INSERT_RESIDENCE:
			Residence residence = (Residence) transferKlasa.getClient_object_request();
			Residence residence1 = ControlerBL.getInstanca().insertResidence(residence);
			transferKlasa1.setServer_object_response(residence1);
			send(transferKlasa1);
			break;
			
		case Operations.PUT_ALL_RESIDENCE_INTO_TABLE:
			List<Residence>list = ControlerBL.getInstanca().putListOfResidence();
			transferKlasa1.setServer_object_response(list);
			send(transferKlasa1);
			break;
			
		case Operations.RESIDENCE_UPDATE:	
			try {
			Residence residence2 = (Residence) transferKlasa.getClient_object_request();
			residence2 = ControlerBL.getInstanca().updateResidence(residence2);
			transferKlasa1.setServer_object_response(residence2);
			send(transferKlasa1);
			}catch (Exception e) {
				transferKlasa1.setMessage_response("Update error");
				send(transferKlasa1);
			}
			break;
			
       case Operations.DELETE_RESIDENCE:
    	   try {
			Residence residence2 = (Residence) transferKlasa.getClient_object_request();
			ControlerBL.getInstanca().deleteResidence(residence2);
			transferKlasa1.setMessage_response("successfully deleted");
			send(transferKlasa1);
    	   }catch (Exception e) {
    		   transferKlasa1.setMessage_response("Delete error");
				send(transferKlasa1);
		}
			break;
			
       case Operations.INSERT_DESTINATION:
			Destination destination = (Destination) transferKlasa.getClient_object_request();
			Destination destination1 = ControlerBL.getInstanca().insertDestination(destination);
			transferKlasa1.setServer_object_response(destination1);
			send(transferKlasa1);
			break;
			
       case Operations.PUT_DESTINATION_INTO_TABLE:
			List<Destination>list1 = ControlerBL.getInstanca().putDestinationList();
			transferKlasa1.setServer_object_response(list1);
			send(transferKlasa1);
			break;
			
       case Operations.UPDATE_DESTINATION:	
			try {
			Destination destination2 = (Destination) transferKlasa.getClient_object_request();
			destination2 = ControlerBL.getInstanca().updateDestination(destination2);
			transferKlasa1.setServer_object_response(destination2);
			send(transferKlasa1);
			}catch (Exception e) {
				transferKlasa1.setMessage_response("Update error");
				send(transferKlasa1);
			}
			break;
			
       case Operations.INSERT_ROOM:
			Room room = (Room) transferKlasa.getClient_object_request();
			Room room1 = ControlerBL.getInstanca().insertRoom(room);
			transferKlasa1.setServer_object_response(room1);
			transferKlasa1.setMessage_response(" successfully saved ");
			send(transferKlasa1);
			break;
			
       case Operations.INSERT_PHOTO_IMAGE:
			PhotoAlbum photoAlbum =  (PhotoAlbum) transferKlasa.getClient_object_request();
			PhotoAlbum photoAlbum1 = ControlerBL.getInstanca().insertPhotoImage(photoAlbum);
			transferKlasa1.setServer_object_response(photoAlbum1);
			transferKlasa1.setMessage_response(" successfully saved ");
			send(transferKlasa1);
			break;
			
       case Operations.RETURN_PHOTO:
			List<PhotoAlbum>PhotoList =  ControlerBL.getInstanca().getPhotosBack();
			transferKlasa1.setServer_object_response(PhotoList);
			send(transferKlasa1);
			break;
			
       case Operations.INSERT_ROOM_SERVICES:
			Room_Info room_Info = (Room_Info) transferKlasa.getClient_object_request();
			Room_Info room_Info1 = ControlerBL.getInstanca().insertRoomServices(room_Info);
			transferKlasa1.setServer_object_response(room_Info1);
			transferKlasa1.setMessage_response(" successfully saved ");
			send(transferKlasa1);
			break;
			
       case Operations.GET_ALL_ROOMS_BACK:
			List<Room>list2 =  ControlerBL.getInstanca().getRoomsBack();
			transferKlasa1.setServer_object_response(list2);
			send(transferKlasa1);
			break;
			
       case Operations.GET_BACK_ROOM_INFO:
    	    List<Room_Info>list3 = ControlerBL.getInstanca().getBackRoomInfo();
			transferKlasa1.setServer_object_response(list3);
			send(transferKlasa1);
			break;
			
       case Operations.CONFIRM_RESERVATION:
			Reservation reservation = (Reservation) transferKlasa.getClient_object_request();
			Reservation reservation2 = ControlerBL.getInstanca().insertReservation(reservation);
			transferKlasa1.setServer_object_response(reservation2);
			transferKlasa1.setMessage_response(" Your reservation is confirmed ");
			send(transferKlasa1);
			break;
			
       case Operations.GET_RESERVATION_BACK:
   	    	List<Reservation>listReservation = ControlerBL.getInstanca().getReservationBack();
			transferKlasa1.setServer_object_response(listReservation);
			send(transferKlasa1);
			break;
			
       case Operations.CHECK_AVAILABILITY:
  	    	List<Reservation>listReserv = ControlerBL.getInstanca().checkAvailability();
			transferKlasa1.setServer_object_response(listReserv);
			send(transferKlasa1);
			break;
			
       case Operations.GET_BACK_USER_LIST:
      	    List<User>listUser = ControlerBL.getInstanca().getBackUserList();
   			transferKlasa1.setServer_object_response(listUser);
   			send(transferKlasa1);
   			break;
			
       case Operations.CONFIRM_PAYMENT:
			Payment payment = (Payment) transferKlasa.getClient_object_request();
			Payment payment2 = ControlerBL.getInstanca().insertPayment(payment);
			transferKlasa1.setServer_object_response(payment2);
			transferKlasa1.setMessage_response(" Your payment is procesing ");
			send(transferKlasa1);
			break;
			
       case Operations.GET_PAYMENT_BACK:
     	    List<Payment>listPayment = ControlerBL.getInstanca().getPaymentBack();
  			transferKlasa1.setServer_object_response(listPayment);
  			send(transferKlasa1);
  			break;
  			
       case Operations.UPDATE_USER:	
			try {
			User user4 = (User) transferKlasa.getClient_object_request();
			user4 = ControlerBL.getInstanca().updatePersonalData(user4);
			transferKlasa1.setMessage_response("successfully updated");
			transferKlasa1.setServer_object_response(user4);
			send(transferKlasa1);
			}catch (Exception e) {
				transferKlasa1.setMessage_response("Update error");
				send(transferKlasa1);
			}
			break;
			
       case Operations.CANCEL_RESERVATION:
    	   try {
			Reservation reservation3 = (Reservation) transferKlasa.getClient_object_request();
			ControlerBL.getInstanca().cancelReservation(reservation3);
			transferKlasa1.setMessage_response("reservation is canceled");
			send(transferKlasa1);
    	   }catch (Exception e) {
    		   transferKlasa1.setMessage_response("Cancel error");
				send(transferKlasa1);
		}
			break;
			
       case Operations.CANCEL_PAYMENT:
    	   try {
			Payment payment3 = (Payment) transferKlasa.getClient_object_request();
			ControlerBL.getInstanca().cancelPayment(payment3);
			transferKlasa1.setMessage_response("payment is canceled");
			send(transferKlasa1);
    	   }catch (Exception e) {
    		   transferKlasa1.setMessage_response("Cancel error");
				send(transferKlasa1);
		}
			break;
			
       case Operations.INSERT_REVIEW:
			Review review = (Review) transferKlasa.getClient_object_request();
			Review review1 = ControlerBL.getInstanca().insertReview(review);
			transferKlasa1.setServer_object_response(review1);
			send(transferKlasa1);
			break;
			
       case Operations.GET_REVIEW_BACK:
			List<Review>reviewList = ControlerBL.getInstanca().getReviewBack();
			transferKlasa1.setServer_object_response(reviewList);
			send(transferKlasa1);
			break;
			
       case Operations.GET_AVERAGE_REVIEW:
  	   		List<Review>reviewList1 =  ControlerBL.getInstanca().getAvgReview();
			transferKlasa1.setServer_object_response(reviewList1);
			send(transferKlasa1);
			break;
			
       case Operations.UPDATE_RESIDENCE_AVG_RATING:	
			try {
			Residence residence3 = (Residence) transferKlasa.getClient_object_request();
			residence3 = ControlerBL.getInstanca().updateResidenceAvgRating(residence3);
			transferKlasa1.setServer_object_response(residence3);
			send(transferKlasa1);
			}catch (Exception e) {
				transferKlasa1.setMessage_response("Update error");
				send(transferKlasa1);
			}
			break;
			
     		
     case Operations.START_CHAT:
    	 	Message chatMessage = (Message) transferKlasa.getClient_object_request();
   	  		User user11 = (User) transferKlasa.getServer_object_response();
   	  		transferKlasa1.setServer_object_response(user11); 
   	  		transferKlasa1.setServer_object_response(chatMessage);	
   	  		send(transferKlasa1);	
		
   	  	try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String username = user11.getUsername();
			username = bufferedReader.readLine();
			String poruka;
			ControlerBL.getInstanca().dodajKlijent(this);
			while(true) {
				poruka = bufferedReader.readLine();
				if(poruka != null && !poruka.isEmpty()) {
					ControlerBL.getInstanca().obavestiKlijente("\n"+username +" kaze: "+poruka+"\n", this);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	break;

	
		
   	 
		default:
			break;
		}
		
	}

public void posalji(String poruka) {
	PrintWriter printWriter;
	try {
		printWriter = new PrintWriter(socket.getOutputStream(), true);
		printWriter.println(poruka);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}

	
		
	private void send(TransferClass transferKlasa) {
		ObjectOutputStream objectOutputStream;
		try {
			objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
			objectOutputStream.writeObject(transferKlasa);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

	
	
	
		
  		
  		
  	}
	
	


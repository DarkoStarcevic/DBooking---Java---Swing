package com.comtrade.user.view;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.comtrade.controlerUI.ControlerUI;
import com.comtrade.domen.Destination;
import com.comtrade.domen.Reservation;
import com.comtrade.domen.Residence;
import com.comtrade.domen.Room;
import com.comtrade.domen.Room_Info;
import com.comtrade.domen.User;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class BookingConfirmationForm extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String residence_name, room_type, number_of_beds,destination;
	private LocalDate checkInDate, checkOutDate;
	private int id_usera, room_num, adults, children, id_room, id_residence;
	private String room;
	private double total_price;
	private JTextArea textAreaBookingDetails;
	private JTextArea textAreaUserInfo;
	private List<Destination> listDestination;
	private List<Residence> listResidence; 
	private List<Room>listRoom;
	private List<Room_Info>listRoomInfo;
	private List<Reservation>listReservation;
	private List<User>listUser;
	private int id_reservation;
	private int availableRooms;
	private String userInfo;
	private JButton btnCancel;
	
	public BookingConfirmationForm(int id_room, int id_residence, String destination, int id_usera, LocalDate checkInDate, LocalDate checkOutDate, int room_num, int adults, int children, double total_price, String residence_name2, String room_type2, String number_of_beds2) throws ClassNotFoundException, IOException {
		this.destination = destination;
		this.id_usera = id_usera;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.total_price = total_price;
		this.residence_name = residence_name2;
		this.room_type = room_type2;
		this.number_of_beds = number_of_beds2;
		this.adults = adults;
		this.children = children;
		this.room_num = room_num;
		this.id_room = id_room;
		this.id_residence = id_residence;
		
		listDestination =  (List<Destination>) ControlerUI.getInstanca().putDestinationIntoTable().getServer_object_response();
		listResidence =  (List<Residence>) ControlerUI.getInstanca().putAllResidenceIntoTable().getServer_object_response();
		listRoom = (List<Room>) ControlerUI.getInstanca().getAllRoomsBack().getServer_object_response();
		listRoomInfo = (List<Room_Info>) ControlerUI.getInstanca().getBackRoomInfo().getServer_object_response();
		listReservation = (List<Reservation>) ControlerUI.getInstanca().getReservationBack().getServer_object_response();
		listUser = (List<User>) ControlerUI.getInstanca().getUserListBack().getServer_object_response();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 645, 504);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBookingDetails = new JLabel("Booking details");
		lblBookingDetails.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblBookingDetails.setBounds(10, 58, 234, 30);
		contentPane.add(lblBookingDetails);
		
		JButton btnConfirmReservation = new JButton("Confirm your reservation");
		btnConfirmReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					Reservation reservation = new Reservation();
					
					reservation.setId_usera(id_usera);
					reservation.setId_residence(id_residence);
					reservation.setCheck_in_date(checkInDate);
					reservation.setCheck_out_date(checkOutDate);
					reservation.setNumber_of_rooms(room_num);
					reservation.setNumber_of_adults(adults);
					reservation.setNumber_of_children(children);
					reservation.setTotal_price(total_price);
					reservation.setId_room(id_room);
					
					try {
					reservation = (Reservation) ControlerUI.getInstanca().confirmReservation(reservation).getServer_object_response();
					listReservation.add(reservation);
					JOptionPane.showMessageDialog(null," Your reservation is confirmed ");
					btnCancel.setEnabled(false);
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
					btnConfirmReservation.setEnabled(false);
		}
		});
		btnConfirmReservation.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnConfirmReservation.setBounds(122, 392, 195, 23);
		contentPane.add(btnConfirmReservation);
		
		btnCancel = new JButton("Cancel reservation");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 JFrame frame = new JFrame();
					
					int answer = JOptionPane.showConfirmDialog(frame, "Are you sure you want to cancel reservation process ?");
					if(answer == JOptionPane.NO_OPTION) {
					   frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					}else if(answer == JOptionPane.CANCEL_OPTION) {
						 frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					}else {
					
					   dispose();
					   
					   
					}  
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnCancel.setBounds(151, 76, 155, 23);
		contentPane.add(btnCancel);
		
		JScrollPane scrollPane = new JScrollPane(textAreaBookingDetails);
		scrollPane.setBounds(10, 110, 296, 251);
		contentPane.add(scrollPane);
		
		textAreaBookingDetails = new JTextArea();
		scrollPane.setViewportView(textAreaBookingDetails);
		textAreaBookingDetails.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 17));
		textAreaBookingDetails.setVisible(true);
		textAreaBookingDetails.setEditable(false);
		//setDisplayReservationInfo(textAreaBookingDetails, textAreaUserInfo);
		
		JScrollPane scrollPane_2 = new JScrollPane(textAreaUserInfo);
		scrollPane_2.setBounds(360, 110, 259, 251);
		contentPane.add(scrollPane_2);
		
		textAreaUserInfo = new JTextArea();
		scrollPane_2.setViewportView(textAreaUserInfo);
		textAreaUserInfo.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 17));
		textAreaUserInfo.setVisible(true);
		textAreaUserInfo.setEditable(false);
		setDisplayReservationInfo(textAreaBookingDetails, textAreaUserInfo);
		
		
		JButton btnProceedToPayment = new JButton("Proceed  To  Payment");
		btnProceedToPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				Reservation res = new Reservation();
				
				for(Reservation reservation :listReservation) {
					id_reservation = reservation.getId_reservation();
				}
				try {
					PaymentForm paymentForm = new PaymentForm(id_reservation, id_residence, id_usera, total_price);
					res.setId_reservation(id_reservation);
					res.setId_residence(id_residence);
					res.setId_usera(id_usera);
					res.setTotal_price(total_price);
					paymentForm.setVisible(true);
					
					dispose();
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnProceedToPayment.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnProceedToPayment.setBounds(410, 392, 170, 23);
		contentPane.add(btnProceedToPayment);
		
	}


	private void setDisplayReservationInfo(JTextArea textArea2, JTextArea textArea3) {
		
		long overnightStay = ChronoUnit.DAYS.between(checkInDate, checkOutDate);
		String  data = residence_name + "\n" + "Type of room : " + room_type 
				+ "\n" + "Arrival : " + checkInDate + "\n"+ "Departure : " + checkOutDate + "\n" 
				+ "adults : " + adults + " " + "children : "+ children + "\n" 
				+ "No of reserved rooms : " + room_num + "\n"
				+"Total price : " + total_price + "\n"
				+ "for " + overnightStay + "  nights "
				+ "\n" + "\n" + destination;
		
		
		  for(User user : listUser) { 
			  if(id_usera == user.getId_usera()) { 
				 userInfo = "Name : "+ user.getFirstName() + "\n" +"LastName : "+user.getLastName()+ "\n" + "Phone number : "+ user.getPhoneNum()+ "\n" + "email : "+user.getEmail();
				 textArea3.setText(userInfo);	
		 
			 }
			 
		 }
		 	
		textArea2.setText(data);
		
	}
}  

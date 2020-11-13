package com.comtrade.user.view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import com.comtrade.controlerUI.ControlerUI;
import com.comtrade.domen.Destination;
import com.comtrade.domen.Payment;
import com.comtrade.domen.PhotoAlbum;
import com.comtrade.domen.Reservation;
import com.comtrade.domen.Residence;
import com.comtrade.domen.Review;
import com.comtrade.domen.Room;
import com.comtrade.domen.User;
import com.comtrade.transfer.TransferClass;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Image;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.JTextArea;


import java.awt.Cursor;
import java.awt.Dimension;



public class ProfilePanel extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private List<User>userList;
	private List<Reservation>reservationList;
	private List<Residence>residenceList;
	private List<Destination>listDestination;
	private List<Room>listRoom;
	private List<Payment>paymentList;
	private LinkedList<PhotoAlbum> listPhoto;
	private int id_usera, id_reservation, id_payment, id_residence;
	private int adults, children, room_num;
	private double total_price;
	private String prop, destination, rooom;
	private LocalDate checkInDate; 
	private LocalDate checkOutDate;
	private JTextField tfFirstName;
	private JTextField tfUsername;
	private JTextField tfEmail;
	private JTextField tfPhoneNumber;
	private JTextField tfPassword;
	private JTextField tfPassConfirm;
	private JTextField tfLastName;
	private ImageIcon labelImg;
	private JLabel lblEmail, lblPhoneNum, lblPassword, lblConfirmPass, lblUsername, lblLastName, lblFirstName;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JButton btnAddReview;
	private List<Review>listReview;
	private DefaultTableModel dtm = new DefaultTableModel();
	private JTable table;
	private DefaultTableCellRenderer cellRenderer;
	private JLabel lblResidencePhoto;
	private ImageIcon residencePhoto;
	
	
	
	public ProfilePanel(User user) throws ClassNotFoundException, IOException {
		this.id_usera = user.getId_usera();
		userList = (List<User>) ControlerUI.getInstanca().getUserListBack().getServer_object_response();
		reservationList = (List<Reservation>) ControlerUI.getInstanca().getReservationBack().getServer_object_response();
		residenceList = (List<Residence>) ControlerUI.getInstanca().putAllResidenceIntoTable().getServer_object_response();
		listDestination =  (List<Destination>) ControlerUI.getInstanca().putDestinationIntoTable().getServer_object_response();
		listRoom = (List<Room>) ControlerUI.getInstanca().getAllRoomsBack().getServer_object_response();
		paymentList = (List<Payment>) ControlerUI.getInstanca().getPaymentBack().getServer_object_response();
		listReview = (List<Review>) ControlerUI.getInstanca().getReviewBack().getServer_object_response();
		listPhoto = (LinkedList<PhotoAlbum>) ControlerUI.getInstanca().returnPhoto().getServer_object_response();
		setTitle("My Profile");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 520, 650);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnUpdateInfo = new JButton("Update personal info");
		btnUpdateInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TransferClass transferKlasa = null;
				try {
					String firstName = tfFirstName.getText();
					String lastName = tfLastName.getText();
					String username = tfUsername.getText();
					String password = tfPassword.getText();
					String passConfirm = tfPassConfirm.getText();
					String email = tfEmail.getText();
					String phoneNum = tfPhoneNumber.getText();
				
					if(password.equals(passConfirm)) {
						
					
					User user = new User();
					
					user.setFirstName(firstName);
					user.setLastName(lastName);
					user.setUsername(username);
					user.setPassword(password); 
					user.setEmail(email);
					user.setPhoneNum(phoneNum);
					user.setId_usera(id_usera);
			
				transferKlasa = ControlerUI.getInstanca().updatePersonalData(user);
				setUpdate(transferKlasa);
				String message = transferKlasa.getMessage_response();
				JOptionPane.showMessageDialog(null,message);
				
					}else JOptionPane.showMessageDialog(null, "Sorry. Wrong password. Please try again");
					
			}catch (Exception e) {
		
			}
			 
			}
		});
		btnUpdateInfo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnUpdateInfo.setBounds(168, 136, 155, 23);
		contentPane.add(btnUpdateInfo);
		
		JLabel label_4 = new JLabel("My Reservations");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_4.setBounds(10, 170, 217, 14);
		contentPane.add(label_4);
		
		JButton btnCancelReservation = new JButton("Cancel reservation");
		btnCancelReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Reservation reservation = new Reservation();
				Payment payment = new Payment();
				reservation.setId_reservation(id_reservation);
				
				for(Payment payment1 : paymentList) {
					if(id_reservation == payment1.getId_reservation()) {
						id_payment = payment1.getId_payment();
						payment.setId_payment(id_payment);
				}
			}
						
				JFrame frame = new JFrame();
				
				int answer = JOptionPane.showConfirmDialog(frame, "Are you sure you want to cancel reservation ?");
				if(answer == JOptionPane.NO_OPTION) {
				   frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}else if(answer == JOptionPane.CANCEL_OPTION) {
					 frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}else
					
				try {
				
				payment = (Payment) ControlerUI.getInstanca().cancelPayment(payment).getServer_object_response();
				
				TransferClass transferKlasa = ControlerUI.getInstanca().cancelReservation(reservation);
				
				cancelReservation(reservation);
				
				displayReservationInfo();
				JOptionPane.showMessageDialog(null, transferKlasa.getMessage_response());
				
				
				
				
				
				} catch (ClassNotFoundException | IOException e) {
					
					e.printStackTrace();
				}
				
			}
		});
		btnCancelReservation.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelReservation.setBounds(67, 577, 155, 23);
		contentPane.add(btnCancelReservation);
		

		btnAddReview = new JButton("Add a review");
		btnAddReview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					listReview = (List<Review>) ControlerUI.getInstanca().getReviewBack().getServer_object_response();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				checkReviews();
				
				if(checkReviews() == true) {
					JOptionPane.showMessageDialog(null, " You have already left a review for this location ");
					//btnAddReview.setEnabled(false);
				}else
					
					openReviewForm();
				
			}
			
		});
		btnAddReview.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAddReview.setBounds(257, 577, 155, 23);
		contentPane.add(btnAddReview);
		
		tfFirstName = new JTextField();
		tfFirstName.setEnabled(false);
		tfFirstName.setBounds(10, 19, 125, 20);
		contentPane.add(tfFirstName);
		tfFirstName.setColumns(10);
		
		tfLastName = new JTextField();
		tfLastName.setEnabled(false);
		tfLastName.setColumns(10);
		tfLastName.setBounds(10, 57, 125, 20);
		contentPane.add(tfLastName);

		tfUsername = new JTextField();
		tfUsername.setEnabled(false);
		tfUsername.setColumns(10);
		tfUsername.setBounds(10, 94, 125, 20);
		contentPane.add(tfUsername);
		
		tfEmail = new JTextField();
		tfEmail.setEnabled(false);
		tfEmail.setColumns(10);
		tfEmail.setBounds(334, 19, 125, 20);
		contentPane.add(tfEmail);
		
		tfPassword = new JTextField();
		tfPassword.setEnabled(false);
		tfPassword.setColumns(10);
		tfPassword.setBounds(168, 19, 125, 20);
		contentPane.add(tfPassword);
		
		tfPassConfirm = new JTextField();
		tfPassConfirm.setEnabled(false);
		tfPassConfirm.setColumns(10);
		tfPassConfirm.setBounds(169, 57, 125, 20);
		contentPane.add(tfPassConfirm);
		
		tfPhoneNumber = new JTextField();
		tfPhoneNumber.setEnabled(false);
		tfPhoneNumber.setColumns(10);
		tfPhoneNumber.setBounds(334, 57, 125, 20);
		contentPane.add(tfPhoneNumber);
		setInfoinTextField();
		
		
		lblEmail = new JLabel("");
		lblEmail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfEmail.setEnabled(true);
			}
		});
		lblEmail.setBounds(463, 15, 38, 23);
		contentPane.add(lblEmail);
		
		lblPhoneNum = new JLabel("");
		lblPhoneNum.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfPhoneNumber.setEnabled(true);
			}
		});
		lblPhoneNum.setBounds(463, 54, 38, 23);
		contentPane.add(lblPhoneNum);
		
		lblPassword = new JLabel("");
		lblPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfPassword.setEnabled(true);
				tfPassConfirm.setEnabled(true);
			}
		});
		lblPassword.setBounds(296, 15, 38, 23);
		contentPane.add(lblPassword);
		
		lblConfirmPass = new JLabel("");
		lblConfirmPass.setBounds(296, 54, 38, 23);
		contentPane.add(lblConfirmPass);
		
		lblUsername = new JLabel("");
		lblUsername.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfUsername.setEnabled(true);
			}
		});
		lblUsername.setBounds(138, 93, 38, 23);
		contentPane.add(lblUsername);
		
		lblLastName = new JLabel("");
		lblLastName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfLastName.setEnabled(true);
			}
		});
		lblLastName.setBounds(138, 54, 38, 23);
		contentPane.add(lblLastName);
		
		lblFirstName = new JLabel("");
		lblFirstName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfFirstName.setEnabled(true);
			}
		});
		lblFirstName.setBounds(138, 15, 38, 23);
		contentPane.add(lblFirstName);
		
		setIconstoLabels();
		
		lblResidencePhoto = new JLabel("");
		lblResidencePhoto.setBounds(10, 277, 200, 180);
		//contentPane.add(lblResidencePhoto);
		
		
		JScrollPane scrollPane_reservations = new JScrollPane(table);
		scrollPane_reservations.setBounds(10, 195, 476, 360);
		contentPane.add(scrollPane_reservations);
		
		Object[] kolone = new Object[3];
		kolone[0] = "ID";
		kolone[1] = "RESERVATION";
		kolone[2] = "PHOTO";
		
		dtm.addColumn(kolone[0]);
		dtm.addColumn(kolone[1]);
		dtm.addColumn(kolone[2]);
		
		displayReservationInfo();
		
		
		table = new JTable(dtm) {
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
	            Component comp = super.prepareRenderer(renderer, row, column);
	            Color alternateColor = Color.LIGHT_GRAY;
	            Color whiteColor = Color.WHITE;
	            if(!comp.getBackground().equals(getSelectionBackground())) {
	               Color c = (row % 2 == 0 ? whiteColor : alternateColor);
	               
				comp.setBackground(c);
	               c = null;
	            }
	            
				return comp;
	         }
			
			 public Class<?> getColumnClass(int column) {
			        switch (column) {
			            case 2: return ImageIcon.class;
			            default: return String.class;
			        }
			 }
		/*	public Class<String> getColumnClass(int columnIndex) {
				return String.class;
			}*/

			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
			    	
			    
	      };
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = table.getSelectedRow();
				id_reservation = Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
				destination = table.getModel().getValueAt(row, 1).toString();
				
				
				for(Reservation reservation : reservationList) {
					
					if(reservation.getId_usera() == id_usera && 
							reservation.getId_reservation() == id_reservation && reservation.getCheck_in_date().getDayOfYear() <= LocalDate.now().getDayOfYear()) {
						
						btnCancelReservation.setEnabled(false);
						
					}else {
						
							if(reservation.getId_usera() == id_usera && reservation.getId_reservation() == id_reservation && reservation.getCheck_in_date().getDayOfYear() > LocalDate.now().getDayOfYear()) {
								btnCancelReservation.setEnabled(true);
						}
					}
					
			}
		}
			
		});
		
		
		
		table.setDefaultRenderer(String.class, new MultiLineTableCellRenderer());
		table.setGridColor(Color.BLACK);
		table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		table.getColumnModel().getColumn(0).setPreferredWidth(2);
	    table.getColumnModel().getColumn(1).setPreferredWidth(220);
	    table.getColumnModel().getColumn(2).setPreferredWidth(130);
	    cellRenderer = new DefaultTableCellRenderer();
	    cellRenderer.setHorizontalAlignment(JLabel.CENTER);
	    table.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
	    table.getColumn("PHOTO").setMaxWidth(200);
	    table.getColumn("PHOTO").setMinWidth(190);
		scrollPane_reservations.setViewportView(table);
		
		
		
		lblNewLabel_5 = new JLabel("First Name");
		lblNewLabel_5.setBounds(10, 5, 78, 13);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Last Name");
		lblNewLabel_6.setBounds(10, 41, 78, 13);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Username");
		lblNewLabel_7.setBounds(10, 79, 78, 13);
		contentPane.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("Password");
		lblNewLabel_8.setBounds(168, 5, 78, 13);
		contentPane.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("Email");
		lblNewLabel_9.setBounds(334, 5, 78, 13);
		contentPane.add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("Confirm password");
		lblNewLabel_10.setBounds(168, 41, 125, 13);
		contentPane.add(lblNewLabel_10);
		
		lblNewLabel_11 = new JLabel("Phone number");
		lblNewLabel_11.setBounds(334, 41, 125, 13);
		contentPane.add(lblNewLabel_11);
			
	}
	

	private void setIconstoLabels() {
		labelImg = new ImageIcon(getClass().getResource("/TextEdit.png"));
		lblEmail.setIcon(labelImg);
		lblPhoneNum.setIcon(labelImg);
		lblPassword.setIcon(labelImg);
		lblConfirmPass.setIcon(labelImg);
		lblUsername.setIcon(labelImg);
		lblLastName.setIcon(labelImg);
		lblFirstName.setIcon(labelImg);
		
		
	}
	

	private void displayReservationInfo() {
		dtm.setRowCount(0);
		Object[] row = new Object[3];
		
		for (Reservation res : reservationList) {
			for (Residence residence : residenceList) {
				for (Destination dest : listDestination) {
					for (Room room : listRoom) {
						
						if ((res.getId_usera() == id_usera) 
							&& (residence.getId_residence() == res.getId_residence()) 
							//&& res.getId_usera() == id_usera)
							&& (dest.getId_residence() == residence.getId_residence())
							//&& residence.getId_residence() == res.getId_residence())
							&& (room.getId_room() == res.getId_room())) {

							checkInDate = res.getCheck_in_date();
							checkOutDate = res.getCheck_out_date();
							adults = res.getNumber_of_adults();
							children = res.getNumber_of_children();
							room_num = res.getNumber_of_rooms();
							total_price = res.getTotal_price();
							id_reservation = res.getId_reservation();
							prop = residence.getNameOfResidence();
							//id_residence = res.getId_residence();
							destination = dest.getCountry() + "\n" + dest.getCity() + "\n" + "address : "
										+ dest.getAddress() + "\n" + "zip code : " + dest.getZipcode() + "\n"
										+ "email : " + dest.getEmail() + "\n" + "phone number: "
										+ dest.getPhone_number();
							rooom = room.getRoom_type();	
							long overnightStay = ChronoUnit.DAYS.between(checkInDate, checkOutDate);
							row[0] = id_reservation;
							row[1] = prop + "\n" + "Type of room : " + rooom + "\n" + "Arrival : " + checkInDate + "\n"
									+ "Departure : " + checkOutDate + "\n" + "adults : " + adults + " " + "children : "
									+ children + "\n" + "No of reserved rooms : " + room_num + "\n" + "Total price : "
									+ total_price + "\n" + "for "
									+ overnightStay + "  nights " + "\n"
									+ "\n" + destination;
							
							for (PhotoAlbum photoAlbum : listPhoto) {
								
										if (res.getId_residence() == residence.getId_residence()
												&& photoAlbum.getId_residence() == residence.getId_residence()) {

											residencePhoto = new ImageIcon(photoAlbum.getPhoto_image());
											Image img = residencePhoto.getImage().getScaledInstance(200,190, Image.SCALE_SMOOTH);
											residencePhoto.setImage(img);
											
											
											row[2] = residencePhoto;
										}
									}
							dtm.addRow(row);
								
						} 
					}
				}
			}
			
		}
		
	}
	
	public  boolean  checkReviews() {

		for (Review review1 : listReview) {

			if ((review1.getId_user() == id_usera) //&& (review1.getId_residence() == id_residence)
					&& (review1.getId_reservation() == id_reservation)) {

				return true;
			}
		}
		return false;

	}
	
	protected void openReviewForm() {
		for(Reservation res : reservationList) {
			if ((res.getCheck_out_date().getDayOfYear() <= LocalDate.now().getDayOfYear())
					&& (res.getId_reservation() == id_reservation)) {
				id_residence = res.getId_residence();
				ReviewForm form;
				try {
					form = new ReviewForm(id_usera, id_reservation, id_residence);
					res.setId_residence(id_residence);
					
					form.setVisible(true);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				
				if ((res.getCheck_out_date().getDayOfYear() >= LocalDate.now().getDayOfYear())
						&& (res.getId_reservation() == id_reservation))  {
				JOptionPane.showMessageDialog(null, "You can leave a review only after check-out date. Thank you.");
				//btnAddReview.setEnabled(false);
			}
			}
		}
		
	}
	
	
	public  boolean  checkReservations() {

		for (Reservation reservation : reservationList) {

			if (reservation.getId_usera() == id_usera){

				return true;
			}
		}
		return false;

	}


	public void setUpdate(TransferClass transferKlasa) {
		User user = (User) transferKlasa.getServer_object_response();
		int id = user.getId_usera();
		for(int i = 0; i < userList.size(); i++ ) {
			if(userList.get(i).getId_usera() == id) {
				userList.set(i, user);
			}
		
		}
		
	}
	
	
	public void cancelReservation(Reservation reservation) {
		for(int i = 0; i < reservationList.size(); i++ ) {
			if(reservationList.get(i).getId_reservation() == reservation.getId_reservation()) {
				reservationList.remove(i);
			}
		}
		
	}
	
	public void setInfoinTextField() {
		for (User user : userList) {
			
			if (user.getId_usera() == id_usera) {
				
				tfFirstName.setText(user.getFirstName());
				tfLastName.setText(user.getLastName());
				tfEmail.setText(user.getEmail());
				tfPhoneNumber.setText(user.getPhoneNum());
				tfUsername.setText(user.getUsername());
				tfPassword.setText(user.getPassword());
				tfPassConfirm.setText(user.getPassword());
			}
		}	
		
	}
	
	
	class MultiLineTableCellRenderer extends JTextArea implements TableCellRenderer {
		private List<List<Integer>> rowColHeight = new ArrayList<List<Integer>>();

		public MultiLineTableCellRenderer() {
			setLineWrap(true);
			setWrapStyleWord(true);
			setOpaque(true);
		}

		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			if (isSelected) {
				setForeground(table.getSelectionForeground());
				setBackground(table.getSelectionBackground());
			} else {
				setForeground(table.getForeground());
				setBackground(table.getBackground());
			}
			setFont(table.getFont());
			if (hasFocus) {
				setBorder(UIManager.getBorder("Table.focusCellHighlightBorder"));
				if (table.isCellEditable(row, column)) {
					setForeground(UIManager.getColor("Table.focusCellForeground"));
					setBackground(UIManager.getColor("Table.focusCellBackground"));
				}
			} else {
				setBorder(new EmptyBorder(1, 2, 1, 2));
			}
			if (value != null) {
				setText(value.toString());
			} else {
				setText("");
			}
			adjustRowHeight(table, row, column);
			return this;
		}
		
		public void adjustRowHeight(JTable table2, int row, int column) {
			int cWidth = table.getTableHeader().getColumnModel().getColumn(column).getWidth();
			setSize(new Dimension(cWidth, 1000));
			int prefH = getPreferredSize().height;
			while (rowColHeight.size() <= row) {
				rowColHeight.add(new ArrayList<Integer>(column));
			}
			List<Integer> colHeights = rowColHeight.get(row);
			while (colHeights.size() <= column) {
				colHeights.add(0);
			}
			colHeights.set(column, prefH);
			int maxH = prefH;
			for (Integer colHeight : colHeights) {
				if (colHeight > maxH) {
					maxH = colHeight;
				}
			}
			if (table.getRowHeight(row) != maxH) {
				table.setRowHeight(row, maxH);
			}
			
		}
		
		
}

}	

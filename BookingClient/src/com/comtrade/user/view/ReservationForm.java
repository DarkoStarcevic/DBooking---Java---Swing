package com.comtrade.user.view;


import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.comtrade.controlerUI.ControlerUI;
import com.comtrade.domen.Destination;
import com.comtrade.domen.PhotoAlbum;
import com.comtrade.domen.Reservation;
import com.comtrade.domen.Residence;
import com.comtrade.domen.Review;
import com.comtrade.domen.Room;
import com.comtrade.domen.Room_Info;
import com.comtrade.domen.User;
import com.comtrade.view.adminforme.CircularLinkedListPhoto;
import com.comtrade.view.adminforme.IteratorLinkedList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.DecimalFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class ReservationForm extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel dtm = new DefaultTableModel();
	private JCheckBox  chckbxAc,  chckbxKitchen, chckbxWifi, chckbxTv, chckbxPrivatebathroom, chckbxBalcony, chckbxParking, chckbxRestaurant;
    private JButton btnPrevious, btnNext;
    private JLabel lblDescription;
    private JLabel lblPhotos;
    private JButton btnBook;
    private JLabel lblMap;
    private JLabel lblChat;
    private List<Destination> listDestination;
	private List<Residence> listResidence; 
	private List<Room>listRoom;
	private List<Room_Info>listRoomInfo;
	private LinkedList<PhotoAlbum>photoList;
	private String destination;
	private int id_room_info;
	private int id_room;
	private LocalDate checkInDate, checkOutDate;
	private int room_num, adults,  children,  id_residence, id_usera, id_destination;
	private int overnight_stay;
	private JTextArea description1;
	private String  room_description;
	private String residence_name;
	private double total_price;
	private String room_type;
	private String number_of_beds;
	private IteratorLinkedList<PhotoAlbum> iter;
	private PhotoAlbum current;
	private String image;
	private List<Reservation>availableRoomsList;
	private List<Reservation>listReservation;
	private List<Review>reviewList;
	private int availableRooms;
	private JTextArea textAreaReviews;
	private List<User>userList;
	private DecimalFormat df = new DecimalFormat("#.##");
	private JScrollPane scrollPane_1;
	
	public ReservationForm(String destination, LocalDate checkInDate, LocalDate checkOutDate, int room_num, int adults, int children, int id_residence, int id_usera, int overnight_stay) throws ClassNotFoundException, IOException {
		this.destination = destination;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.room_num = room_num;
		this.adults = adults;
		this.children = children;
		this.id_residence = id_residence;
		this.id_usera = id_usera;
		this.overnight_stay = overnight_stay;
		listDestination =  (List<Destination>) ControlerUI.getInstanca().putDestinationIntoTable().getServer_object_response();
		listResidence =  (List<Residence>) ControlerUI.getInstanca().putAllResidenceIntoTable().getServer_object_response();
		listRoom = (List<Room>) ControlerUI.getInstanca().getAllRoomsBack().getServer_object_response();
		listRoomInfo = (List<Room_Info>) ControlerUI.getInstanca().getBackRoomInfo().getServer_object_response();
		photoList = (LinkedList<PhotoAlbum>) ControlerUI.getInstanca().returnPhoto().getServer_object_response();
		availableRoomsList = (List<Reservation>) ControlerUI.getInstanca().checkAvailability().getServer_object_response();
		iter = new CircularLinkedListPhoto<PhotoAlbum>(photoList).iterator();
		reviewList = (List<Review>) ControlerUI.getInstanca().getReviewBack().getServer_object_response();			
		userList = (List<User>) ControlerUI.getInstanca().getUserListBack().getServer_object_response();
		listReservation = (List<Reservation>) ControlerUI.getInstanca().getReservationBack().getServer_object_response();
		setTitle("Reservation");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 903, 697);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblPhotos = new JLabel("Photos");
		lblPhotos.setBounds(68, 11, 277, 208);
		for(PhotoAlbum photoAlbum : photoList) {
			if(id_residence == photoAlbum.getId_residence()) {
				lblPhotos.setIcon(ResizeImage(photoAlbum.getPhoto_image()));
			}
		}
		contentPane.add(lblPhotos);
		
		btnPrevious = new JButton("<<");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(current == null) {
					current = iter.previous();
				}
				
				while(current != null) {	
					
					if(current.getId_residence() == id_residence) {
						image = current.getPhoto_image();
						current = iter.previous();
						
						break;
						
					}
					current = iter.previous();
				}
				
				lblPhotos.setIcon(ResizeImage(image));
				
			}
		});
		btnPrevious.setBounds(10, 104, 48, 23);
		contentPane.add(btnPrevious);
		
		btnNext = new JButton(">>");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
					if(current == null) {
						
						current = iter.next();
					}
					while(current != null) {	
						
						if(current.getId_residence() == id_residence) {
							image = current.getPhoto_image();
							current = iter.next();
							
							break;
							
						}
						current = iter.next();
					}			
					lblPhotos.setIcon(ResizeImage(image));
			}
		});
		btnNext.setBounds(355, 104, 48, 23);
		contentPane.add(btnNext);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 251, 393, 197);
		contentPane.add(scrollPane);
		
		table = new JTable(dtm);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int row = table.getSelectedRow();
				String residenceName = table.getModel().getValueAt(row, 0).toString();
				String roomType = table.getModel().getValueAt(row, 1).toString();
				String numberOfBeds = table.getModel().getValueAt(row, 2).toString();
			    double totalPrice = Double.parseDouble(table.getModel().getValueAt(row, 3).toString());
			    
			   total_price = totalPrice;
			     
			  for(Residence res : listResidence) {
				   if(residenceName.equals(res.getNameOfResidence()) && res.getId_residence() == id_residence)  {
					   
					   residence_name = res.getNameOfResidence();
					  
				   }
			   }
			  
				for (Room_Info room_Info : listRoomInfo) {
					for (Room room : listRoom) {
						
						if(room.getId_room() == room_Info.getId_room() && room.getId_residence() == id_residence 
						&&(room.getRoom_type().equals(roomType)) && (room.getNumber_of_beds().equals(numberOfBeds))
								&& room_Info.getId_room() == room.getId_room()) {
							  
						   room_type = room.getRoom_type();
						   number_of_beds = room.getNumber_of_beds();
						   id_room = room.getId_room();
						   room_description = room_Info.getDescription();
						   setRoomInfoVisibleToUser(room_Info);
						}

					}
				}
				
				

			}
			   		
		});
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setRowHeight(30);
		scrollPane.setViewportView(table);
		
		Object[] kolone = new Object[4];
		kolone[0] = "Residence name";
		kolone[1] = "Room Type";
		kolone[2] = "Number of beds";
		kolone[3] = "Total Price €";

		dtm.addColumn(kolone[0]);
		dtm.addColumn(kolone[1]);
		dtm.addColumn(kolone[2]);
		dtm.addColumn(kolone[3]);
		
		setRoomInformation();
		
		chckbxAc = new JCheckBox("AC");
		chckbxAc.setBounds(458, 251, 46, 23);
		chckbxAc.setEnabled(false);
		contentPane.add(chckbxAc);

	    chckbxKitchen = new JCheckBox("kitchen\t");
		chckbxKitchen.setBounds(458, 292, 76, 23);
		chckbxKitchen.setEnabled(false);
		contentPane.add(chckbxKitchen);

		chckbxWifi = new JCheckBox("WiFi");
		chckbxWifi.setBounds(562, 251, 71, 23);
		chckbxWifi.setEnabled(false);
		contentPane.add(chckbxWifi);

		chckbxTv = new JCheckBox("TV");
		chckbxTv.setBounds(672, 251, 58, 23);
		chckbxTv.setEnabled(false);
		contentPane.add(chckbxTv);

		chckbxPrivatebathroom = new JCheckBox("private_bathroom\t");
		chckbxPrivatebathroom.setBounds(458, 330, 137, 23);
		chckbxPrivatebathroom.setEnabled(false);
		contentPane.add(chckbxPrivatebathroom);

		chckbxBalcony = new JCheckBox("balcony");
		chckbxBalcony.setBounds(672, 292, 76, 23);
		chckbxBalcony.setEnabled(false);
		contentPane.add(chckbxBalcony);

		chckbxParking = new JCheckBox("parking");
		chckbxParking.setBounds(562, 292, 76, 23);
		chckbxParking.setEnabled(false);
		contentPane.add(chckbxParking);

		chckbxRestaurant = new JCheckBox("restaurant");
		chckbxRestaurant.setBounds(632, 330, 116, 23);
		chckbxRestaurant.setEnabled(false);
		contentPane.add(chckbxRestaurant);

		JLabel lblAC = new JLabel("");
		lblAC.setHorizontalAlignment(SwingConstants.RIGHT);
		ImageIcon img = new ImageIcon(getClass().getResource("/ac.png"));
		lblAC.setIcon(img);
		lblAC.setBounds(394, 251, 58, 31);
		contentPane.add(lblAC);

		JLabel lblWiFi = new JLabel("");
		lblWiFi.setHorizontalAlignment(SwingConstants.RIGHT);
		ImageIcon img1 = new ImageIcon(getClass().getResource("/wifi.png"));
		lblWiFi.setIcon(img1);
		lblWiFi.setBounds(510, 251, 46, 31);
		contentPane.add(lblWiFi);

		JLabel lblTV = new JLabel("");
		lblTV.setHorizontalAlignment(SwingConstants.RIGHT);
		ImageIcon img2 = new ImageIcon(getClass().getResource("/tv1.png"));
		lblTV.setIcon(img2);
		lblTV.setBounds(610, 251, 56, 23);
		contentPane.add(lblTV);

		JLabel lblKitchen = new JLabel("");
		lblKitchen.setHorizontalAlignment(SwingConstants.RIGHT);
		ImageIcon img3 = new ImageIcon(getClass().getResource("/kitchen.png"));
		lblKitchen.setIcon(img3);
		lblKitchen.setBounds(406, 286, 46, 24);
		contentPane.add(lblKitchen);

		JLabel lblParking = new JLabel("");
		lblParking.setHorizontalAlignment(SwingConstants.RIGHT);
		ImageIcon img4 = new ImageIcon(getClass().getResource("/parking.png"));
		lblParking.setIcon(img4);
		lblParking.setBounds(510, 286, 46, 37);
		contentPane.add(lblParking);

		JLabel lblBalcony = new JLabel("");
		lblBalcony.setHorizontalAlignment(SwingConstants.RIGHT);
		ImageIcon img5 = new ImageIcon(getClass().getResource("/balcony.png"));
		lblBalcony.setIcon(img5);
		lblBalcony.setBounds(620, 286, 46, 29);
		contentPane.add(lblBalcony);

		JLabel lblBath = new JLabel("");
		lblBath.setHorizontalAlignment(SwingConstants.RIGHT);
		ImageIcon img6 = new ImageIcon(getClass().getResource("/bathtub.png"));
		lblBath.setIcon(img6);
		lblBath.setBounds(376, 322, 76, 31);
		contentPane.add(lblBath);

		JLabel lblJavaCup = new JLabel("");
		lblJavaCup.setHorizontalAlignment(SwingConstants.RIGHT);
		ImageIcon img7 = new ImageIcon(getClass().getResource("/Java.png"));
		lblJavaCup.setIcon(img7);
		lblJavaCup.setBounds(580, 322, 46, 31);
		contentPane.add(lblJavaCup);
		
		lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDescription.setBounds(458, 23, 168, 14);
		contentPane.add(lblDescription);
		
		lblChat = new JLabel("");
		lblChat.addMouseListener(new MouseAdapter() {
			

			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				Residence residence = new Residence();

				        ChatUser chatUser;
						try {
							chatUser = new ChatUser(id_usera, id_residence);
							residence.setId_residence(id_residence);
							residence.setId_usera(id_usera);
							chatUser.setVisible(true);
							
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
			}
		});
		lblChat.setHorizontalAlignment(SwingConstants.RIGHT);
		ImageIcon img13 = new ImageIcon(getClass().getResource("/chatt.jpg"));
		lblChat.setIcon(img13);
		lblChat.setBounds(773, 53, 104, 74);
		contentPane.add(lblChat);
		
		

		description1 = new JTextArea();
		description1.setWrapStyleWord(true);
		description1.setLineWrap(true);
		description1.setFont(new Font("Monospaced", Font.BOLD, 13));
		description1.setEditable(false);
		contentPane.add(description1);
		
		btnBook = new JButton("Book");
		btnBook.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent arg0) {
				
				Residence residence = new Residence();
			    Room room = new Room();
			   
			    for(Reservation reservation : listReservation ) {
			   for(Reservation res : availableRoomsList) {
				   for(Room r : listRoom) {
					   if((res.getId_room() == id_room ) || (res.getId_room() == id_room && res.getCheck_out_date().isBefore(checkInDate))) {
						   availableRooms = res.getNumber_of_rooms();
					   
					   
					   }else {
						   
							   if(r.getId_room() == id_room) {
								   availableRooms = r.getNumber_of_rooms(); 
						   }
						   
					   }
				   }
			   }
				}
			   
			   if(id_room == 0) {
				   JOptionPane.showMessageDialog(null, "please select a room ");
				} else {
			   
	
				BookingConfirmationForm bc;
				try {
									
					if( availableRooms >= room_num) { 	
					
					bc = new BookingConfirmationForm(id_room, id_residence, destination, id_usera, checkInDate, checkOutDate, room_num, adults, children, total_price, residence_name, room_type, number_of_beds);
		
					residence.setNameOfResidence(residence_name);
					room.setRoom_type(room_type);
					room.setNumber_of_beds(number_of_beds);
				
					bc.setVisible(true);
					btnBook.setEnabled(false);
					}else {
						
						JFrame frame = new JFrame();
						int answer = JOptionPane.showConfirmDialog(frame, " We sincerely apologize for the inconvenience but selected rooms are not available. You could try to choose the other room or change your dates");
						if(answer == JOptionPane.OK_OPTION) {
							btnBook.setEnabled(true);
							frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
						
						}else 
						
						   dispose();
						
					/*	JOptionPane.showMessageDialog(null, " We sincerely apologize for the inconvenience but selected rooms are not available. You could try to choose the other room or change your dates" );
						btnBook.setEnabled(true);*/
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			}
		});
		btnBook.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnBook.setBounds(754, 474, 89, 23);
		contentPane.add(btnBook);
		
		lblMap = new JLabel("Map");
		lblMap.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblMap.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				if (e.getClickCount() > 0) {
			          if (Desktop.isDesktopSupported()) {
			                Desktop desktop = Desktop.getDesktop();
			                try {
			                    URI uri = new URI("https://www.google.com/maps/@44.826956,20.3927275,15z");
			                    desktop.browse(uri);
			                } catch (IOException ex) {
			                    ex.printStackTrace();
			                } catch (URISyntaxException ex) {
			                    ex.printStackTrace();
			                }
			        }
			      }
				
			}
		});
		ImageIcon img8 = new ImageIcon(getClass().getResource("/map2.jpg"));
		lblMap.setIcon(img8);
		lblMap.setBounds(432, 364, 145, 84);
		contentPane.add(lblMap);
		
		JTextArea address = new JTextArea(destination);
		address.setEditable(false);
		address.setBounds(610, 364, 267, 84);
		contentPane.add(address);
		
		JLabel lblNewLabel = new JLabel("Read reviews from other travelers");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel.setBounds(10, 492, 289, 14);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPaneReviews = new JScrollPane(textAreaReviews);
		scrollPaneReviews.setBounds(10, 510, 393, 137);
		contentPane.add(scrollPaneReviews);
		
		textAreaReviews = new JTextArea();
		textAreaReviews.setEditable(false);
		scrollPaneReviews.setViewportView(textAreaReviews);
		setReviews(textAreaReviews);
		
		scrollPane_1 = new JScrollPane(description1);
		scrollPane_1.setBounds(448, 48, 300, 171);
		contentPane.add(scrollPane_1);
			
	}

	
	private void setReviews(JTextArea textAreaReviews2) {

		for (Review review : reviewList) {
			for (User user : userList) {

				if (id_residence == review.getId_residence() && review.getId_user() == user.getId_usera()) {

					textAreaReviews2.append(user.getFirstName()+ ":" + "   " + "review rating   "+ " " + (df.format(review.getRating()) + "\n" + review.getComment() + "   " + "   "
							 + "\n" + "\n"));
				} else {

					if (reviewList.isEmpty()) {

						textAreaReviews2.setText(" no reviews yet for this destination ");
					}
				}
			}
		}

	}


	private void setRoomInformation() {
		dtm.setRowCount(0);
		Object[] row = new Object[4];
		
		for(Room room : listRoom) {
			for(Residence residence : listResidence) {
			if( residence.getId_residence() == id_residence && room.getId_residence() == residence.getId_residence())  {    
				
				row[0]= residence.getNameOfResidence();
				row[1]= room.getRoom_type();
				row[2]= room.getNumber_of_beds();
				row[3]= room.getPrice_per_night() * overnight_stay * room_num;
				
				dtm.addRow(row);
			}
		
		}
		
		}
	}

	private void setRoomInfoVisibleToUser(Room_Info room_Info) {
			
		if(room_Info.isAC()) {
			chckbxAc.setSelected(true);
		}else {
			chckbxAc.setSelected(false);
		}
		
		if(room_Info.isBalcony()) {
			chckbxBalcony.setSelected(true);
		}else {
			chckbxBalcony.setSelected(false);
		}
		
		if(room_Info.isKitchen()) {
			chckbxKitchen.setSelected(true);
		}else {
			chckbxKitchen.setSelected(false);
		}
		
		if(room_Info.isParking()) {
			chckbxParking.setSelected(true);
		}else {
			chckbxParking.setSelected(false);
		}
		
		if(room_Info.isPrivate_bathroom()) {
			chckbxPrivatebathroom.setSelected(true);
		}else {
			chckbxPrivatebathroom.setSelected(false);
		}
		
		if(room_Info.isRestaurant()) {
			chckbxRestaurant.setSelected(true);
		}else {
			chckbxRestaurant.setSelected(false);
		}
		
		if(room_Info.isTV()) {
			chckbxTv.setSelected(true);
		}else {
			chckbxTv.setSelected(false);
		}
		
		if(room_Info.isWiFi()) {
			chckbxWifi.setSelected(true);
		}else {
			chckbxWifi.setSelected(false);
		}
		
		description1.setText(room_description);
		
		
	}
	
	public ImageIcon ResizeImage(String path) {
		ImageIcon MyImage = new ImageIcon(path);
		Image img = MyImage.getImage().getScaledInstance(lblPhotos.getWidth(), lblPhotos.getHeight(),
				Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(img);
		return image;

	}
}






package com.comtrade.user.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import com.comtrade.controlerUI.ControlerUI;
import com.comtrade.domen.Destination;
import com.comtrade.domen.PhotoAlbum;
import com.comtrade.domen.Reservation;
import com.comtrade.domen.Residence;
import com.comtrade.domen.Review;
import com.comtrade.domen.Room;
import com.comtrade.domen.User;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDateChooserCellEditor;
import com.toedter.calendar.demo.DateChooserPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class UserForm extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField tfDestination;
	private JLabel lblNewLabel;
	private JDateChooser dateChooserArrival;
	private JDateChooser dateChooserDeparture;
	private LocalDate checkInDate;
	private LocalDate checkOutDate;
	private JSpinner spinnerRoom, spinnerAdults, spinnerChild;
	private List<Destination> listDestination;
	private List<Residence> listResidence;
	private LinkedList<PhotoAlbum> listPhoto;
	private JTable table;
	private DefaultTableCellRenderer cellRenderer;
	private DefaultTableModel dtm = new DefaultTableModel();
	private JLabel lblValdisere;
	private JLabel lblResidencePhotos;
	private String destination;
	private int id_usera;
	private int id_residence;
	private JButton btnSearch;
	private int overnight_stay;
	private List<Reservation> reservationList;
	private List<Room> roomList;
	private List<Review> avgReviewList;
	private List<Review> listReview;
	private double avg;
	private static DecimalFormat df2 = new DecimalFormat("#.##");
	

	public UserForm(User user) throws ClassNotFoundException, IOException {
		setTitle("Welcome to @DBooking");
		this.id_usera = user.getId_usera();

		checkInDate = LocalDate.now();
		checkOutDate = checkInDate.plusDays(1);
		
		listDestination = (List<Destination>) ControlerUI.getInstanca().putDestinationIntoTable().getServer_object_response();
		listResidence = (List<Residence>) ControlerUI.getInstanca().putAllResidenceIntoTable().getServer_object_response();
		reservationList = (List<Reservation>) ControlerUI.getInstanca().checkAvailability().getServer_object_response();
		listPhoto = (LinkedList<PhotoAlbum>) ControlerUI.getInstanca().returnPhoto().getServer_object_response();
		roomList = (List<Room>) ControlerUI.getInstanca().getAllRoomsBack().getServer_object_response();
		avgReviewList = (List<Review>) ControlerUI.getInstanca().getAvgReview().getServer_object_response();
		listReview = (List<Review>) ControlerUI.getInstanca().getReviewBack().getServer_object_response();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 974, 754);
		contentPane = new JPanel();
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblDestination = new JLabel("Search by destination / residence name");
		lblDestination.setBounds(251, 82, 286, 23);
		lblDestination.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(lblDestination);

		JLabel lblNewLabel_3 = new JLabel("Logout");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				JFrame frame = new JFrame();

				int answer = JOptionPane.showConfirmDialog(frame, "Are you sure you want to logout?");
				if (answer == JOptionPane.NO_OPTION) {
					frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				} else if (answer == JOptionPane.CANCEL_OPTION) {
					frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				} else {

					dispose();

					try {
						ControlerUI.getInstanca().logout(user).getServer_object_response();
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
		ImageIcon img = new ImageIcon(getClass().getResource("/logout1.png"));
		lblNewLabel_3.setIcon(img);
		lblNewLabel_3.setBackground(new Color(153, 255, 255));
		lblNewLabel_3.setForeground(new Color(0, 51, 153));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_3.setBounds(859, 17, 89, 26);
		contentPane.add(lblNewLabel_3);

		lblNewLabel = new JLabel("   Welcome, " + user.getUsername());
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(0, 0, 958, 52);
		lblNewLabel.setBackground(new Color(153, 255, 255));
		lblNewLabel.setForeground(new Color(0, 51, 153));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		contentPane.add(lblNewLabel);

		tfDestination = new JTextField();
		tfDestination.setBackground(new Color(255, 255, 255));
		tfDestination.setBounds(251, 111, 286, 41);
		contentPane.add(tfDestination);
		tfDestination.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Arrival");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(251, 189, 92, 14);
		contentPane.add(lblNewLabel_1);

		dateChooserArrival = new JDateChooser();
		/*dateChooserArrival.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				dateChooserDeparture.setCalendar(null);
				dateChooserDeparture.setMinSelectableDate(dateChooserArrival.getDate());
				 
			}
		}
	
	  );
	 */

		dateChooserArrival.setMinSelectableDate(new Date());
		dateChooserArrival.setBounds(320, 178, 217, 23);
		contentPane.add(dateChooserArrival);

		JLabel lblDeparture = new JLabel("Departure");
		lblDeparture.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDeparture.setBounds(251, 230, 92, 14);
		contentPane.add(lblDeparture);

		dateChooserDeparture = new JDateChooser();
		dateChooserDeparture.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dateChooserDeparture.setCalendar(null);
				dateChooserDeparture.setMinSelectableDate(dateChooserArrival.getDate());
				
			}
		});
		dateChooserDeparture.setBounds(320, 221, 217, 21);
		contentPane.add(dateChooserDeparture);

		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					avgReviewList = (List<Review>) ControlerUI.getInstanca().getAvgReview().getServer_object_response();
					listResidence = (List<Residence>) ControlerUI.getInstanca().putAllResidenceIntoTable().getServer_object_response();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				String destination = tfDestination.getText();

				search_ByCountry_City_Residence(destination);
				tfDestination.setText("");
				
				

				DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
				if (dateChooserArrival.getDate() != null && dateChooserDeparture.getDate() != null) {
					setDates(date);
				} else if (dateChooserArrival.getDate() == null && dateChooserDeparture.getDate() == null) {
					setAutomaticDates(date);

				} else {

					JOptionPane.showMessageDialog(null, "Please select date of departure");
				}

			}
		});

		btnSearch.setBounds(578, 206, 89, 23);
		contentPane.add(btnSearch);

		spinnerRoom = new JSpinner();
		spinnerRoom.setModel(new SpinnerNumberModel(1, 1, 1249, 1));
		spinnerRoom.setBounds(282, 264, 46, 20);
		contentPane.add(spinnerRoom);

		JLabel lblRoom = new JLabel("Room");
		lblRoom.setBounds(251, 270, 46, 14);
		contentPane.add(lblRoom);

		JLabel lblAdults = new JLabel("Adults");
		lblAdults.setBounds(347, 270, 56, 14);
		contentPane.add(lblAdults);

		JLabel lblChild = new JLabel("Child");
		lblChild.setBounds(438, 270, 46, 14);
		contentPane.add(lblChild);

		spinnerAdults = new JSpinner();
		spinnerAdults.setModel(new SpinnerNumberModel(1, 1, 30, 1));
		spinnerAdults.setBounds(382, 264, 46, 20);
		contentPane.add(spinnerAdults);

		spinnerChild = new JSpinner();
		spinnerChild.setModel(new SpinnerNumberModel(0, 0, 108, 1));
		spinnerChild.setBounds(465, 264, 46, 20);
		contentPane.add(spinnerChild);

		JLabel lblNewLabel_2 = new JLabel("My profile");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				User user = new User();
				user.setId_usera(id_usera);
				ProfilePanel profile;
				try {
					profile = new ProfilePanel(user);
					user.setId_usera(id_usera);
					profile.setVisible(true);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_2.setBounds(10, 54, 131, 46);
		contentPane.add(lblNewLabel_2);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(251, 314, 512, 181);
		contentPane.add(scrollPane);
		
		Object[] kolone = new Object[4];
		kolone[0] = "COUNTRY";
		kolone[1] = "CITY";
		kolone[2] = "RESIDENCE";
		kolone[3] = "RATING";

		dtm.addColumn(kolone[0]);
		dtm.addColumn(kolone[1]);
		dtm.addColumn(kolone[2]);
		dtm.addColumn(kolone[3]);

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
			public Class<String> getColumnClass(int columnIndex) {
				return String.class;
			}

			public boolean isCellEditable(int row, int column) {
				return false;
			}
	      };
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = table.getSelectedRow();
				String country = table.getModel().getValueAt(row, 0).toString();
				String city = table.getModel().getValueAt(row, 1).toString();
				String residence = table.getModel().getValueAt(row, 2).toString();

				for (Residence res : listResidence) {
					if (res.getNameOfResidence().equals(residence)) {
						id_residence = res.getId_residence();
					}
				}

				for (Destination des : listDestination) {
					if ((des.getCountry().equals(country)) && des.getCity().equals(city)) {
						destination = des.getCountry() + " " + "\n" + des.getCity() + " " + "\n" + des.getAddress()
								+ " " + "\n" + des.getPhone_number() + " " + "\n" + des.getEmail();
					}
				}

				for (PhotoAlbum photoAlbum : listPhoto) {
					if (id_residence == photoAlbum.getId_residence()) {
						lblResidencePhotos.setIcon(ResizeImage(photoAlbum.getPhoto_image()));
					}
				}

			}
		});
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		table.setRowHeight(30);
		table.getColumnModel().getColumn(0).setPreferredWidth(70);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
	    table.getColumnModel().getColumn(2).setPreferredWidth(200);
	    cellRenderer = new DefaultTableCellRenderer();
	    //ako hocu prva kolona tj na indexu 0 da mi bude na sredini kolone onda ide kod - cellRenderer.setHorizontalAlignment(JLabel.CENTER);
	    //cellRenderer.setHorizontalAlignment(JLabel.CENTER);
	    table.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
		scrollPane.setViewportView(table);

		JLabel lblBoraBora = new JLabel("Bora Bora");
		lblBoraBora.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				JDialog mydialog;
				mydialog = new JDialog();
                mydialog.setSize(new Dimension(650,130));
                mydialog.setTitle(" Something about Bora Bora");
                mydialog.add(JTextArea());
                mydialog.setVisible(true);
				
			}

			private Component JTextArea() {
				JTextArea text = new JTextArea();
				text.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
				text.setText("  Bora Bora is the quintessential South Pacific paradise." +"\n"+
				" This lush and dramatically beautiful island in French Polynesia" + " \n " +
				" rises to a sharp emerald peak ringed by an azure lagoon. " + " \n" + 
				" Clusters of coconut palms bristle along the beaches, and luxury bungalows perch over the crystal-clear waters," 
				+ " \n "+ " some with glass floor panels, so you can peer into the thriving sea below.");
				return text;		 
			}
		});
		lblBoraBora.setBackground(new Color(255, 255, 204));
		lblBoraBora.setOpaque(true);
		lblBoraBora.setBounds(646, 526, 154, 163);
		ImageIcon img14 = new ImageIcon(getClass().getResource("/bora-bora tahiti.jpg"));
		Image image1 = img14.getImage().getScaledInstance(lblBoraBora.getWidth(), lblBoraBora.getHeight(), Image.SCALE_SMOOTH);
		img14.setImage(image1);
		lblBoraBora.setIcon(img14);
		contentPane.add(lblBoraBora);

		JLabel lblAitutaki = new JLabel("Aitutaki, Cook Islands");
		lblAitutaki.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				JDialog mydialog;
				mydialog = new JDialog();
                mydialog.setSize(new Dimension(650,130));
                mydialog.setTitle(" Something about Aitutaki, Cook Islands");
                mydialog.add(JTextArea());
                mydialog.setVisible(true);
				
			}

			private Component JTextArea() {
				JTextArea text = new JTextArea();
				text.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
				text.setText("  Aitutaki in the Cook Islands, with close ties to New Zealand, is a dream destination for would-be castaways." + " \n " +
				" Blessed with a luminous aqua lagoon, lush peaks, sublime beaches bristling with palms, " +" \n" + 
				" and some of the friendliest people in the South Pacific, "
				+ " \n "+ " Aitutaki ticks all the boxes for the perfect exotic tropical vacation.");
				return text;				 
			}
		});
		lblAitutaki.setBackground(new Color(255, 255, 204));
		lblAitutaki.setOpaque(true);
		lblAitutaki.setBounds(448, 526, 154, 163);
		ImageIcon img13 = new ImageIcon(getClass().getResource("/Aitutaki, Cook Islands.jpg"));
		Image image = img13.getImage().getScaledInstance(lblAitutaki.getWidth(), lblAitutaki.getHeight(), Image.SCALE_SMOOTH);
		img13.setImage(image);
		lblAitutaki.setIcon(img13);
		contentPane.add(lblAitutaki);

		lblValdisere = new JLabel("Val d'Isere");
		lblValdisere.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				JDialog mydialog;
				mydialog = new JDialog();
                mydialog.setSize(new Dimension(650,130));
                mydialog.setTitle(" Something about Val d'Isere");
                mydialog.add(JTextArea());
                mydialog.setVisible(true);
				
			}

			private Component JTextArea() {
				JTextArea text = new JTextArea();
				text.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
				text.setText("  Skiing legend Jean-Claude Killy made his home-town one of the best-known ski resorts in Europe," + " \n " +
				" after his breathtaking sweep of three gold medals at the 1968 Winter Olympics in Grenoble. " +" \n" + 
				"  Val d'Isere shares the high valley with neighboring Tignes to provide more than 300 kilometers of interconnected "
				+ " \n "+ " ski terrain served by more than 150 ski lifts.");
				return text;
				
			}
		});
		lblValdisere.setOpaque(true);
		lblValdisere.setBounds(251, 526, 154, 163);
		ImageIcon img1 = new ImageIcon(getClass().getResource("/Val d'Isere.jpg"));
		Image image3 = img1.getImage().getScaledInstance(lblAitutaki.getWidth(), lblAitutaki.getHeight(), Image.SCALE_SMOOTH);
		img1.setImage(image3);
		lblValdisere.setIcon(img1);
		contentPane.add(lblValdisere);
		
		

		JLabel lblTop = new JLabel("TOP DESTINATIONS");
		lblTop.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblTop.setBounds(78, 608, 131, 26);
		contentPane.add(lblTop);

		JButton btnChoose = new JButton("Select  residence");
		btnChoose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (id_residence == 0) {
					JOptionPane.showMessageDialog(null, "please narrow your search and select preferred residence ");
				} else {
					Residence residence = new Residence();

					try {
						spinnerRoom.commitEdit();
						spinnerAdults.commitEdit();
						spinnerChild.commitEdit();
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					int room_num = (Integer) spinnerRoom.getValue();
					int adults = (Integer) spinnerAdults.getValue();
					int children = (Integer) spinnerChild.getValue();

					DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
					setDates(date);

					numberOfNights(date);

					if (id_residence == 0) {
						JOptionPane.showMessageDialog(null,
								"please narrow your search and select preferred residence ");
					} else {

						ReservationForm reservation;
						try {

							reservation = new ReservationForm(destination, checkInDate, checkOutDate, room_num, adults,
									children, id_residence, id_usera, overnight_stay);
							residence.setNameOfResidence(destination);

							reservation.setVisible(true);

						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
				}
			}
		});
		btnChoose.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnChoose.setBounds(789, 403, 159, 23);
		contentPane.add(btnChoose);

		lblResidencePhotos = new JLabel("");
		lblResidencePhotos.setBackground(new Color(255, 255, 204));
		lblResidencePhotos.setBounds(10, 277, 211, 239);
		contentPane.add(lblResidencePhotos);
		
		JLabel profileAvatar = new JLabel("");
		profileAvatar.setBounds(84, 59, 57, 41);
		ImageIcon img11 = new ImageIcon(getClass().getResource("/register.png"));
		Image image2 = img11.getImage().getScaledInstance(profileAvatar.getWidth(), profileAvatar.getHeight(), Image.SCALE_SMOOTH);
		img11.setImage(image2);
		profileAvatar.setIcon(img11);
		contentPane.add(profileAvatar);
		
		JLabel lblNewLabel_4 = new JLabel("Bora Bora");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_4.setBounds(646, 690, 117, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Aitutaki, Cook Islands");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_4_1.setBounds(448, 690, 154, 14);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Val d'Isere");
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_4_1_1.setBounds(251, 690, 117, 14);
		contentPane.add(lblNewLabel_4_1_1);

		

	}


	private void numberOfNights(DateFormat date) {
	
		Period overnightStay = Period.between(checkInDate, checkOutDate);
		this.overnight_stay = overnightStay.getDays();

	}
	// metoda postavlja inicijalne datume kada nije odabran ni datun dolaska ni
	// datum odlaska
	// sam postavi kao danasnji datum dolazak, a odlazak +1 dan- nije potreban if
	// uslov jer su vec gore definisani datumi checkInDate = LocalDate.now();
	// checkOutDate = checkInDate.plusDays(1);

	private void setAutomaticDates(DateFormat date) {
		String chcIn = String.valueOf(checkInDate);
		String chcOut = String.valueOf(checkOutDate);

		try {
			dateChooserArrival.setDate(date.parse(chcIn));
			dateChooserDeparture.setDate(date.parse(chcOut));

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// metoda koja postavlja datume ali kada su odabrani termini
	// ovde ide if uslov jer ako se odabere isti datum dolaska i odlaska, svakako se
	// rezervise kao jedno nocenje 

	private void setDates(DateFormat date) {
		String checkIn = date.format(dateChooserArrival.getDate());
		String checkOut = date.format(dateChooserDeparture.getDate());
		checkInDate = LocalDate.parse(checkIn);
		checkOutDate = LocalDate.parse(checkOut);

		if (checkInDate.isEqual(checkOutDate)) {
			checkOutDate = checkInDate.plusDays(1);
		}

	}

	
	private void search_ByCountry_City_Residence(String name) {
		dtm.setRowCount(0);
		Object[] row = new Object[4];

		for (Destination destination1 : listDestination) {
			for (Residence residence : listResidence) {

				if ((destination1.getId_residence() == residence.getId_residence())

						&& (destination1.getCountry().contains(name)
								|| destination1.getCountry().equalsIgnoreCase(name))

						|| ((destination1.getId_residence() == residence.getId_residence()

								&& (destination1.getCity().contains(name)
										|| destination1.getCity().equalsIgnoreCase(name)))

								|| ((destination1.getId_residence() == residence.getId_residence())

										&& (residence.getNameOfResidence().contains(name)
												|| residence.getNameOfResidence().equalsIgnoreCase(name))))) {

					setResultInTable(destination1, residence, row);

				}

			}

		}

	}

	private void setResultInTable(Destination destination, Residence residence, Object[] row) {
		
		row[0] = destination.getCountry();
		row[1] = destination.getCity();
		row[2] = residence.getNameOfResidence();
		
		for (Review review : avgReviewList) {
			if (review.getId_residence() == residence.getId_residence()) {
				avg = residence.getAverage_rating();

				row[3] = df2.format(avg);

			} else {

				if (residence.getAverage_rating() == 0) {

					row[3] = ("no reviews yet");

				}
			}
		}

		

		dtm.addRow(row);

	}

	public ImageIcon ResizeImage(String path) {
		ImageIcon MyImage = new ImageIcon(path);
		Image img = MyImage.getImage().getScaledInstance(lblResidencePhotos.getWidth(), lblResidencePhotos.getHeight(),
				Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(img);
		return image;

	}
}



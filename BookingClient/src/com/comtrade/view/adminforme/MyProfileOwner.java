package com.comtrade.view.adminforme;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.comtrade.controlerUI.ControlerUI;
import com.comtrade.domen.Reservation;
import com.comtrade.domen.Residence;
import com.comtrade.domen.Review;
import com.comtrade.domen.Room;
import com.comtrade.domen.User;
import com.comtrade.transfer.TransferClass;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyProfileOwner extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextArea textAreaReviews;
	private int reservationUser,  roomId;
	private String userInfo, roomType;
	private int id_usera;
	private static DecimalFormat df2 = new DecimalFormat("#.##");
	private List<User>listUser;
	private List<Reservation>reservationList;
	private List<Residence> listResidence;
	private List<Room>roomList;
	private List<Review>reviewList;
	private String username;
	private JTextField tfFirstName;
	private JTextField tfUsername;
	private JTextField tfEmail;
	private JTextField tfPhoneNumber;
	private JTextField tfPassword;
	private JTextField tfPassConfirm;
	private JTextField tfLastName;
	private JTable table;
	private ImageIcon img;
	private JLabel lblEmail, lblPhoneNum, lblPassword, lblConfirmPass, lblUsername, lblLastName, lblFirstName;
	private DefaultTableModel dtm = new DefaultTableModel();
	private JLabel lblBruto;
	private JLabel lblSiteCommission;
	private JLabel lblSite;
	private JLabel lblTotalProfit;
	private JLabel lblNeto;
	private JLabel lblChat;
	
	public MyProfileOwner(int id_usera, String username) throws ClassNotFoundException, IOException {
		this.id_usera = id_usera;
		this.username = username;
		
		listUser = (List<User>) ControlerUI.getInstanca().getUserListBack().getServer_object_response();
		reservationList = (List<Reservation>) ControlerUI.getInstanca().getReservationBack().getServer_object_response();
		listResidence =  (List<Residence>) ControlerUI.getInstanca().putAllResidenceIntoTable().getServer_object_response();
		roomList = (List<Room>) ControlerUI.getInstanca().getAllRoomsBack().getServer_object_response();
		reviewList = (List<Review>) ControlerUI.getInstanca().getReviewBack().getServer_object_response();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 855, 538);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("Update personal info");
		button.addActionListener(new ActionListener() {
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
		button.setFont(new Font("Tahoma", Font.BOLD, 11));
		button.setBounds(10, 357, 155, 23);
		contentPane.add(button);
		
		JScrollPane scrollPaneReservations = new JScrollPane(table);
		scrollPaneReservations.setBounds(226, 27, 603, 180);
		contentPane.add(scrollPaneReservations);
		
		table = new JTable(dtm);
		scrollPaneReservations.setViewportView(table);
		
		Object[]column = new Object [11];  
		
		column[0] = "id_reservation";
		column[1] = "residence";
		column[2] = "user";
		column[3] = "room";
		column[4] = "check_in_date";
		column[5] = "check_out_date";
		column[6] = "number_of_rooms";
		column[7] = "adults";
		column[8] = "children";
		column[9] = "earning";
		column[10] = "commission fee";
		
		dtm.addColumn(column[0]);
		dtm.addColumn(column[1]);
		dtm.addColumn(column[2]);
		dtm.addColumn(column[3]);
		dtm.addColumn(column[4]);
		dtm.addColumn(column[5]);
		dtm.addColumn(column[6]);
		dtm.addColumn(column[7]);
		dtm.addColumn(column[8]);
		dtm.addColumn(column[9]);
		dtm.addColumn(column[10]);

		setDataInTable();
	
		
		JLabel lblReservations = new JLabel("Reservations");
		lblReservations.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblReservations.setBounds(226, 6, 217, 14);
		contentPane.add(lblReservations);
		
		JScrollPane scrollPaneReviews = new JScrollPane(textAreaReviews);
		scrollPaneReviews.setBounds(312, 328, 517, 128);
		contentPane.add(scrollPaneReviews);
		
		textAreaReviews = new JTextArea();
		textAreaReviews.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		scrollPaneReviews.setViewportView(textAreaReviews);
		textAreaReviews.setEditable(false);
		getReviews(textAreaReviews);
		
		
		tfFirstName = new JTextField();
		tfFirstName.setBounds(10, 25, 125, 20);
		tfFirstName.setEnabled(false);
		contentPane.add(tfFirstName);
		tfFirstName.setColumns(10);
		
		tfLastName = new JTextField();
		tfLastName.setEnabled(false);
		tfLastName.setColumns(10);
		tfLastName.setBounds(10, 72, 125, 20);
		contentPane.add(tfLastName);

		tfUsername = new JTextField();
		tfUsername.setEnabled(false);
		tfUsername.setColumns(10);
		tfUsername.setBounds(10, 118, 125, 20);
		contentPane.add(tfUsername);
		
		tfEmail = new JTextField();
		tfEmail.setEnabled(false);
		tfEmail.setColumns(10);
		tfEmail.setBounds(10, 255, 125, 20);
		contentPane.add(tfEmail);
		
		tfPassword = new JTextField();
		tfPassword.setEnabled(false);
		tfPassword.setColumns(10);
		tfPassword.setBounds(10, 163, 125, 20);
		contentPane.add(tfPassword);
		
		tfPassConfirm = new JTextField();
		tfPassConfirm.setEnabled(false);
		tfPassConfirm.setColumns(10);
		tfPassConfirm.setBounds(11, 210, 125, 20);
		contentPane.add(tfPassConfirm);
		
		tfPhoneNumber = new JTextField();
		tfPhoneNumber.setEnabled(false);
		tfPhoneNumber.setColumns(10);
		tfPhoneNumber.setBounds(10, 302, 125, 20);
		contentPane.add(tfPhoneNumber);
		
		setInfoinTextField();
		
		lblEmail = new JLabel("");
		lblEmail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfEmail.setEnabled(true);
			}
		});
		lblEmail.setBounds(139, 251, 38, 23);
		contentPane.add(lblEmail);
		
		lblPhoneNum = new JLabel("");
		lblPhoneNum.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfPhoneNumber.setEnabled(true);
			}
		});
		lblPhoneNum.setBounds(139, 299, 38, 23);
		contentPane.add(lblPhoneNum);
		
		lblPassword = new JLabel("");
		lblPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfPassword.setEnabled(true);
				tfPassConfirm.setEnabled(true);
			}
		});
		lblPassword.setBounds(138, 159, 38, 23);
		contentPane.add(lblPassword);
		
		lblConfirmPass = new JLabel("");
		lblConfirmPass.setBounds(138, 207, 38, 23);
		contentPane.add(lblConfirmPass);
		
		lblUsername = new JLabel("");
		lblUsername.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfUsername.setEnabled(true);
			}
		});
		lblUsername.setBounds(138, 117, 38, 23);
		contentPane.add(lblUsername);
		
		lblLastName = new JLabel("");
		lblLastName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfLastName.setEnabled(true);
			}
		});
		lblLastName.setBounds(138, 69, 38, 23);
		contentPane.add(lblLastName);
		
		lblFirstName = new JLabel("");
		lblFirstName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfFirstName.setEnabled(true);
			}
		});
		lblFirstName.setBounds(138, 21, 38, 23);
		contentPane.add(lblFirstName);
		
		setIconstoLabels();
		
		
		JLabel lblNewLabel_5 = new JLabel("First Name");
		lblNewLabel_5.setBounds(10, 11, 78, 13);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Last Name");
		lblNewLabel_6.setBounds(10, 56, 78, 13);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Username");
		lblNewLabel_7.setBounds(10, 103, 78, 13);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Password");
		lblNewLabel_8.setBounds(10, 149, 78, 13);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Email");
		lblNewLabel_9.setBounds(10, 241, 78, 13);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Confirm password");
		lblNewLabel_10.setBounds(10, 194, 125, 13);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Phone number");
		lblNewLabel_11.setBounds(10, 286, 125, 13);
		contentPane.add(lblNewLabel_11);
		
		JLabel lbltotalEarnings = new JLabel("bruto earnings");
		lbltotalEarnings.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lbltotalEarnings.setBounds(226, 240, 115, 23);
		contentPane.add(lbltotalEarnings);
		
		lblBruto = new JLabel("0.00");
		lblBruto.setForeground(new Color(50, 205, 50));
		lblBruto.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblBruto.setBounds(351, 240, 106, 23);
		contentPane.add(lblBruto);
		
		lblSiteCommission = new JLabel("site commission");
		lblSiteCommission.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblSiteCommission.setBounds(467, 240, 134, 23);
		contentPane.add(lblSiteCommission);
		
		lblSite = new JLabel("0.00");
		lblSite.setForeground(Color.RED);
		lblSite.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblSite.setBounds(605, 240, 106, 23);
		contentPane.add(lblSite);
		
		lblTotalProfit = new JLabel("total profit");
		lblTotalProfit.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblTotalProfit.setBounds(226, 274, 115, 23);
		contentPane.add(lblTotalProfit);
		
		lblNeto = new JLabel("0.00");
		lblNeto.setForeground(new Color(50, 205, 50));
		lblNeto.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNeto.setBounds(351, 274, 106, 23);
		contentPane.add(lblNeto);
		earningsSum();
		
		lblChat = new JLabel("");
		lblChat.addMouseListener(new MouseAdapter() {
			

			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				try {
					ChatMessageFrame messageFrame = new ChatMessageFrame(id_usera);
					messageFrame.setVisible(true);
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
		lblChat.setBounds(139, 414, 104, 74);
		contentPane.add(lblChat);

	}
	
	private void getReviews(JTextArea textAreaReviews2) {
		
		for (Review review : reviewList) {
			for (User user : listUser) {
				for (Residence residence : listResidence)
					if (residence.getId_residence() == review.getId_residence()
							&& review.getId_user() == user.getId_usera() && residence.getId_usera() == id_usera) {

						textAreaReviews2.append(user.getFirstName() + " " + ":" + "\n" + review.getComment() + "   "
								+ "   " + review.getRating() + "\n" + "\n");
					} else {

						if (reviewList.isEmpty()) {

							textAreaReviews2.setText(" no reviews yet for this destination ");
						}
					}
			}
		}

	}
	

	private void earningsSum() {
		double total = 0;
		double site = 0;
		
		for(int i = 0; i < table.getRowCount(); i++) {
			total += Double.parseDouble(table.getValueAt(i, 9).toString());
		    site +=  Double.parseDouble(table.getValueAt(i, 10).toString());
		}
		   lblBruto.setText(Double.toString(total));
		   lblSite.setText(Double.toString(site));
		   lblNeto.setText(df2.format(total-site));
	}

	private void setDataInTable() {
		dtm.setRowCount(0);
		Object[] row = new Object[11];
		
		for (Residence residence : listResidence) {
			for (Reservation reservation : reservationList) {

				if (residence.getId_residence() == reservation.getId_residence() && residence.getId_usera() == id_usera) {
					
					reservationUser = reservation.getId_usera();
					roomId = reservation.getId_room();

					for (User user : listUser) {
						if (user.getId_usera() == reservationUser) {
							userInfo = user.getFirstName() + " " + user.getLastName();
						}

						for (Room room : roomList) {
							if (room.getId_room() == roomId) {
								roomType = room.getRoom_type();
							}

						}
					}

					row[0] = reservation.getId_reservation();
					row[1] = residence.getNameOfResidence();
					row[2] = userInfo;
					row[3] = roomType;
					row[4] = reservation.getCheck_in_date();
					row[5] = reservation.getCheck_out_date();
					row[6] = reservation.getNumber_of_rooms();
					row[7] = reservation.getNumber_of_adults();
					row[8] = reservation.getNumber_of_children();
					row[9] = reservation.getTotal_price();
					row[10] = df2.format(reservation.getTotal_price() * 0.12);

					dtm.addRow(row);
					
				}
			}
		}

	}

	protected void setUpdate(TransferClass transferKlasa) {
		User user = (User) transferKlasa.getServer_object_response();
		int id = user.getId_usera();
		for(int i = 0; i < listUser.size(); i++ ) {
			if(listUser.get(i).getId_usera() == id) {
				listUser.set(i, user);
			}
		
		}
		
		
	}

	private void setIconstoLabels() {
		img = new ImageIcon(getClass().getResource("/TextEdit.png"));
		lblEmail.setIcon(img);
		lblPhoneNum.setIcon(img);
		lblPassword.setIcon(img);
		lblConfirmPass.setIcon(img);
		lblUsername.setIcon(img);
		lblLastName.setIcon(img);
		lblFirstName.setIcon(img);
		
		
	}
	
	public void setInfoinTextField() {
		for (User user : listUser) {
			
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


}


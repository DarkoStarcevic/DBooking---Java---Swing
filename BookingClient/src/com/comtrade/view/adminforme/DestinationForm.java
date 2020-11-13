package com.comtrade.view.adminforme;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import com.comtrade.controlerUI.ControlerUI;
import com.comtrade.domen.Destination;
import com.comtrade.domen.Residence;
import com.comtrade.transfer.TransferClass;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.util.List;
import java.util.Locale;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DestinationForm extends JFrame {

	private static final long serialVersionUID = 1L;
	
	 private ImageIcon[] images;
	 private JPanel contentPane; 
	 private JComboBox<Object> comboBoxCountry; 
	 private String [] locale;
	 private Integer[] intArray;
	 private JTextField tfCity;
	 private JTextField tfAddress;
	 private JTable table;
	 private DefaultTableModel dtm = new DefaultTableModel();
	 private JTextField tfPhoneNumber;
	 private JTextField tfEmail;
	 private int id_residence;
	 private int id_destination;
	 private List<Destination> listDestination;
	 private  JLabel lblGoogleMaps;
	 private JTextField tfZipcode;
	 private DefaultTableCellRenderer cellRenderer;
	

	 public DestinationForm(Residence residence) throws ClassNotFoundException, IOException { 
	 this.id_residence = residence.getId_residence();
	 listDestination =  (List<Destination>) ControlerUI.getInstanca().putDestinationIntoTable().getServer_object_response();
	 setTitle("Destination");
     setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	 setBounds(100, 100, 678, 618); contentPane = new JPanel();
	 contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	 setContentPane(contentPane); 
	 contentPane.setLayout(null);
	 
	 JLabel lblCity = new JLabel("City");
	 lblCity.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
	 lblCity.setBounds(10, 55, 96, 14);
	 contentPane.add(lblCity);
	 
	 tfCity = new JTextField();
	 tfCity.setBounds(95, 53, 212, 20);
	 contentPane.add(tfCity);
	 tfCity.setColumns(10);
	 
	 JLabel lblAddress = new JLabel("Address");
	 lblAddress.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
	 lblAddress.setBounds(10, 84, 96, 14);
	 contentPane.add(lblAddress);
	 
	 tfAddress = new JTextField();
	 tfAddress.setColumns(10);
	 tfAddress.setBounds(95, 80, 212, 20);
	 contentPane.add(tfAddress);
	 
	 JLabel lblNewLabel_1 = new JLabel("STEP 2");
	 lblNewLabel_1.setOpaque(true);
	 lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
 	 lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
	 lblNewLabel_1.setBounds(526, 26, 81, 23);
	 lblNewLabel_1.setForeground(Color.BLACK);
	 lblNewLabel_1.setBackground(new Color(0, 0, 0, 46));
	 contentPane.add(lblNewLabel_1);
	 
	 JButton btnInsertDestination = new JButton("Insert destination");
	 btnInsertDestination.addActionListener(new ActionListener() {
	 	
		public void actionPerformed(ActionEvent arg0) {
	 		
	 		String city = tfCity.getText();
	 		String address = tfAddress.getText();
	 		String zipcode = tfZipcode.getText();
	 		String email = tfEmail.getText();
	 		String phoneNumber = tfPhoneNumber.getText();

	 		Destination destination = new Destination();
	 		
	 		
	 		destination.setCountry(comboBoxCountry.getSelectedItem().toString());
	 		destination.setCity(city);
	 		destination.setAddress(address);
	 		destination.setZipcode(zipcode);
	 		destination.setEmail(email);
	 		destination.setPhone_number(phoneNumber);
			destination.setId_residence(id_residence);
			
			try {
				
				destination = (Destination) ControlerUI.getInstanca().insertDestination(destination).getServer_object_response();
				listDestination.add(destination);
				setDataInTable();
				ocistiFildove();
				
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
						
	 	}
		private void ocistiFildove() {
			tfCity.setText("");
			tfAddress.setText("");
			tfZipcode.setText("");
			tfEmail.setText("");
			tfPhoneNumber.setText("");
			
		}

		
	 });
	 btnInsertDestination.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
	 btnInsertDestination.setBounds(336, 123, 168, 23);
	 contentPane.add(btnInsertDestination);
	 
	 JScrollPane scrollPane = new JScrollPane(table);
	 scrollPane.setBounds(10, 203, 642, 104);
	 contentPane.add(scrollPane);
	 
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
		
		table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		table.setRowHeight(30);
		/*
		 * table.getColumnModel().getColumn(0).setPreferredWidth(2);
		 * table.getColumnModel().getColumn(1).setPreferredWidth(20);
		 * table.getColumnModel().getColumn(2).setPreferredWidth(20);
		 * table.getColumnModel().getColumn(3).setPreferredWidth(20);
		 * table.getColumnModel().getColumn(4).setPreferredWidth(20);
		 * table.getColumnModel().getColumn(5).setPreferredWidth(20);
		 * table.getColumnModel().getColumn(6).setPreferredWidth(20);
		 * table.getColumnModel().getColumn(7).setPreferredWidth(2);
		 */
	    cellRenderer = new DefaultTableCellRenderer();
	    //ako hocu prva kolona tj na indexu 0 da mi bude na sredini kolone onda ide kod - cellRenderer.setHorizontalAlignment(JLabel.CENTER);
	    cellRenderer.setHorizontalAlignment(JLabel.CENTER);
	   /* table.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
	    table.getColumnModel().getColumn(7).setCellRenderer(cellRenderer);*/
	 table.addMouseListener(new MouseAdapter() {
	 	@Override
	 	public void mouseClicked(MouseEvent e) {
	 		int red = table.getSelectedRow();
	 		String city = table.getModel().getValueAt(red, 2).toString();
	 		String address = table.getModel().getValueAt(red, 3).toString();
	 		String zipcode = table.getModel().getValueAt(red, 4).toString();
	 		String email = table.getModel().getValueAt(red, 6).toString();
	 		String phoneNumber = table.getModel().getValueAt(red, 5).toString();
	 		String country = table.getModel().getValueAt(red,1).toString();
	
	 		tfCity.setText(city);
	 		tfAddress.setText(address);
	 		tfZipcode.setText(zipcode);
	 		tfEmail.setText(email);
	 		tfPhoneNumber.setText(phoneNumber);
	 		comboBoxCountry.getModel().setSelectedItem(country);
	 		id_destination = Integer.parseInt(table.getModel().getValueAt(red, 0).toString());
	 		id_residence = Integer.parseInt(table.getModel().getValueAt(red, 7).toString());
	 		
	 	}
	 });
	 scrollPane.setViewportView(table);
	 Object[]kolone = new Object [8];
	 
	 	kolone[0] = "id_destination";
		kolone[1] = "Country";
		kolone[2] = "City";
		kolone[3] = "Address";
		kolone[4] = "zipcode";
		kolone[5] = "Phone num";
		kolone[6] = "email";
		kolone[7] = "id_residence";
		
		dtm.addColumn(kolone[0]);
		dtm.addColumn(kolone[1]);
		dtm.addColumn(kolone[2]);
		dtm.addColumn(kolone[3]);
		dtm.addColumn(kolone[4]);
		dtm.addColumn(kolone[5]);
		dtm.addColumn(kolone[6]);
		dtm.addColumn(kolone[7]);
		
		setDataInTable();
			 
	
	 comboBoxCountry = new JComboBox<>();
	 comboBoxCountry.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
	 comboBoxCountry.setBounds(10, 11, 282, 31);
	 contentPane.add(comboBoxCountry); 
	 comboBoxCountry.addItem( " -- choose country -- ");
	 setFlagAndCountriesToComboBox();
	 
	 JLabel lblPhoneNum = new JLabel("Phone num");
	 lblPhoneNum.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
	 lblPhoneNum.setBounds(10, 145, 96, 14);
	 contentPane.add(lblPhoneNum);
	 
	 tfPhoneNumber = new JTextField();
	 tfPhoneNumber.setColumns(10);
	 tfPhoneNumber.setBounds(95, 138, 212, 20);
	 contentPane.add(tfPhoneNumber);
	 
	 JLabel lblEmail = new JLabel("email");
	 lblEmail.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
	 lblEmail.setBounds(10, 178, 96, 14);
	 contentPane.add(lblEmail);
	 
	 tfEmail = new JTextField();
	 tfEmail.setColumns(10);
	 tfEmail.setBounds(95, 170, 212, 20);
	 contentPane.add(tfEmail);
	 
	 JButton btnNewButton = new JButton("Next ");
	 btnNewButton.addActionListener(new ActionListener() {
	 	public void actionPerformed(ActionEvent arg0) {
	 		
	 		Residence residence = new Residence();
			residence.setId_residence(id_residence);
			
			RoomForm roomForma;
			
				try {
					roomForma = new RoomForm(residence);
					residence.setId_residence(id_residence);
					roomForma.setVisible(true);		
				} catch (ClassNotFoundException | IOException e) {
					
					e.printStackTrace();
				}
				dispose();		
	 	}
	 });
	 btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
	 btnNewButton.setBounds(506, 516, 146, 23);
	 contentPane.add(btnNewButton);
	 
	 JButton btnUpdate = new JButton("Update destination");
	 btnUpdate.addActionListener(new ActionListener() {
	 	public void actionPerformed(ActionEvent arg0) {
	 	
	 		TransferClass transferKlasa = null;
	 		try {
	 			String city = tfCity.getText();
		 		String address = tfAddress.getText();
		 		String zipcode = tfZipcode.getText();
		 		String email = tfEmail.getText();
		 		String phoneNumber = tfPhoneNumber.getText();
		 		
		 		Destination destination = new Destination();
		 		
		 		destination.setCountry(comboBoxCountry.getSelectedItem().toString());
		 		destination.setCity(city);
		 		destination.setAddress(address);
		 		destination.setZipcode(zipcode);
		 		destination.setEmail(email);
		 		destination.setPhone_number(phoneNumber);
				destination.setId_residence(id_residence);
				destination.setId_destination(id_destination);
				transferKlasa = ControlerUI.getInstanca().updateDestination(destination);
				setUpdate(transferKlasa);
				setDataInTable();
			}catch (Exception e) {
				JOptionPane.showMessageDialog(null, transferKlasa.getMessage_response());
			
		
			}

	 	}
	 });
	 btnUpdate.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
	 btnUpdate.setBounds(336, 157, 168, 23);
	 contentPane.add(btnUpdate);
	 
	 JLabel lblClick = new JLabel("Click on map if you want to add gps coordinates");
	 lblClick.setFont(new Font("Tahoma", Font.BOLD, 11));
	 lblClick.setHorizontalAlignment(SwingConstants.RIGHT);
	 lblClick.setBounds(359, 332, 293, 54);
	 contentPane.add(lblClick);
	 
	 lblGoogleMaps = new JLabel("");
	 lblGoogleMaps.addMouseListener(new MouseAdapter() {
	 	@Override
	 	public void mouseClicked(MouseEvent e) {
	 		GPS_coordinates gps = new GPS_coordinates();
	 		gps.setVisible(true);
	 	}
	 });
	 lblGoogleMaps.setBounds(10, 332, 357, 236);
	 ImageIcon img = new ImageIcon(getClass().getResource("/googlemaps.png"));
	 lblGoogleMaps.setIcon(img);
	 contentPane.add(lblGoogleMaps);
	 
	 JLabel lblZipcode = new JLabel("zipcode");
	 lblZipcode.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
	 lblZipcode.setBounds(10, 113, 96, 14);
	 contentPane.add(lblZipcode);
	 
	 tfZipcode = new JTextField();
	 tfZipcode.setColumns(10);
	 tfZipcode.setBounds(95, 109, 212, 20);
	 contentPane.add(tfZipcode);
	 
	 	 
 }

	
	private void setFlagAndCountriesToComboBox() {
		
		locale = Locale.getISOCountries();
		images = new ImageIcon[locale.length];
		intArray = new Integer[locale.length];

		/*for (int i = 0; i < locale.length; i++) {
			intArray[i] = new Integer(i);
			images[i] = createImageIcon("/" + locale[i] + ".png");
			if (images[i] != null) {
				images[i].setDescription(locale[i]);
				comboBoxCountry.addItem(images[i]);
			}*/
			for (String countryCode : locale) {
				Locale loc = new Locale("", countryCode);
				String country = loc.getDisplayCountry();

				comboBoxCountry.addItem(country);

			}

			
	//	}

	}
	private ImageIcon createImageIcon(String path) {
		 java.net.URL imgURL =    comboBoxCountry.getClass().getResource(path);    
	        if (imgURL != null) {
	            return new ImageIcon(imgURL);
	        } else {
	            System.err.println("Couldn't find file: " + path);
	                return null;
	        }
	}
	
	public void setUpdate(TransferClass transferKlasa) {
		Destination destination = (Destination) transferKlasa.getServer_object_response();
		int id = destination.getId_destination();
		for(int i = 0; i < listDestination.size(); i++ ) {
			if(listDestination.get(i).getId_destination() == id) {
				listDestination.set(i, destination);
			}
		
		}
		
	}


	private void setDataInTable() {
		dtm.setRowCount(0);
		Object[] red = new Object[8];
		
		for(Destination destination : listDestination) {
			
			if(destination.getId_residence() == id_residence) {
							
				  red[0] = destination.getId_destination();
				  red[1] = destination.getCountry(); 
				  red[2] = destination.getCity();
				  red[3] = destination.getAddress();
				  red[4] = destination.getZipcode();
				  red[5] = destination.getPhone_number(); 
				  red[6] = destination.getEmail();
				  red[7] = destination.getId_residence();
				  
				  dtm.addRow(red);
				}  
		}
		
		
	}

}
package com.comtrade.view.adminforme;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import com.comtrade.controlerUI.ControlerUI;
import com.comtrade.domen.PhotoAlbum;
import com.comtrade.domen.Residence;
import com.comtrade.domen.Room;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class RoomForm extends JFrame {

	private JPanel contentPane;
	private JTextField tfNumberOfRooms;
	private JTextField tfNumberOfBeds;
	private JTextField tfPricePerNight;
	private JTextField tfRoomSize;
	private int id_residence;
	private JComboBox<String>cbRoomType;
	private int id_room;
	private String room_type;
	private List<Room>roomList;
	private JTable table;
	private DefaultTableModel dtm = new DefaultTableModel();
	private DefaultTableCellRenderer cellRenderer;
	
	public RoomForm(Residence residence) throws ClassNotFoundException, IOException {
		this.id_residence = residence.getId_residence();
		
		roomList = (List<Room>) ControlerUI.getInstanca().getAllRoomsBack().getServer_object_response();
		setTitle("Room selection");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 721, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPricePerNight = new JLabel("   Price per night");
		lblPricePerNight.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblPricePerNight.setBounds(287, 144, 162, 35);
		contentPane.add(lblPricePerNight);
		ImageIcon img9 = new ImageIcon(getClass().getResource("/price.png"));
		lblPricePerNight.setIcon(img9);

		JLabel lblNumberOfBeds = new JLabel("   Number of beds");
		lblNumberOfBeds.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNumberOfBeds.setBounds(287, 109, 162, 43);
		contentPane.add(lblNumberOfBeds);
		ImageIcon img8 = new ImageIcon(getClass().getResource("/bed.png"));
		lblNumberOfBeds.setIcon(img8);

		JLabel lblNumberOfAvailable = new JLabel("Number of available rooms");
		lblNumberOfAvailable.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNumberOfAvailable.setBounds(287, 92, 162, 14);
		contentPane.add(lblNumberOfAvailable);

		cbRoomType = new JComboBox<>();
		cbRoomType.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		cbRoomType.setModel(new DefaultComboBoxModel(new String[] { " -- Choose type of room --" }));
		cbRoomType.setToolTipText("");
		cbRoomType.setBounds(10, 30, 195, 20);
		contentPane.add(cbRoomType);
		cbRoomType.setEditable(isEnabled());
		// cbRoomType.addItem(" -- Choose type of room -- ");
		cbRoomType.addItem("Single room");
		cbRoomType.addItem("Double room");
		cbRoomType.addItem("Triple room");
		cbRoomType.addItem("Quad room");
		cbRoomType.addItem("King room");
		cbRoomType.addItem("Twin room");
		cbRoomType.addItem("Double-double room");
		cbRoomType.addItem("Studio");
		cbRoomType.addItem("Master Suite");
		cbRoomType.addItem("Junior Suite");
		
		JLabel lblNewLabel_1 = new JLabel("STEP 3");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_1.setBounds(571, 28, 81, 23);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBackground(new Color(0, 0, 0, 46));
		contentPane.add(lblNewLabel_1);

		tfNumberOfRooms = new JTextField();
		tfNumberOfRooms.setBounds(459, 89, 129, 20);
		contentPane.add(tfNumberOfRooms);
		tfNumberOfRooms.setColumns(10);

		tfNumberOfBeds = new JTextField();
		tfNumberOfBeds.setColumns(10);
		tfNumberOfBeds.setBounds(459, 120, 236, 20);
		contentPane.add(tfNumberOfBeds);

		tfPricePerNight = new JTextField();
		tfPricePerNight.setColumns(10);
		tfPricePerNight.setBounds(459, 151, 89, 20);
		contentPane.add(tfPricePerNight);

		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
			
			try {	
				int NumberOfRooms = Integer.parseInt(tfNumberOfRooms.getText());
				String NumberOfBeds = tfNumberOfBeds.getText();
				double PricePerNight = Double.parseDouble(tfPricePerNight.getText());
				int RoomSize = Integer.parseInt(tfRoomSize.getText());

				Room room = new Room();

				room.setRoom_type(cbRoomType.getSelectedItem().toString());
				room.setNumber_of_rooms(NumberOfRooms);
				room.setNumber_of_beds(NumberOfBeds);
				room.setPrice_per_night(PricePerNight);
				room.setRoom_size(RoomSize);
				room.setId_residence(id_residence);

				
					if(NumberOfBeds.trim().equals("") || RoomSize == 0 || cbRoomType.getSelectedItem().toString().trim().equals(" -- Choose type of room --")) {
						JOptionPane.showMessageDialog(null, "please fill up all fields");
					}else {

					room = (Room) ControlerUI.getInstanca().insertRoom(room).getServer_object_response();
					roomList.add(room);
					setDataInTable();					
					JOptionPane.showMessageDialog(null, "successfully saved ");
					ocistiFildove();
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "please fill up all fields");
				}

			}


			private void ocistiFildove() {
				tfNumberOfBeds.setText("");
				tfNumberOfRooms.setText("");
				tfPricePerNight.setText("");
				tfRoomSize.setText("");
				
			}
			
		});
		btnInsert.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnInsert.setBounds(459, 268, 89, 23);
		contentPane.add(btnInsert);
		
		JLabel lblSize = new JLabel("");
		lblSize.setHorizontalAlignment(SwingConstants.RIGHT);
		ImageIcon img10 = new ImageIcon(getClass().getResource("/m².png"));
		lblSize.setIcon(img10);
		lblSize.setBounds(407, 175, 46, 35);
		contentPane.add(lblSize);

		tfRoomSize = new JTextField();
		tfRoomSize.setBounds(459, 186, 35, 20);
		contentPane.add(tfRoomSize);
		tfRoomSize.setColumns(10);

		JLabel lblSquereMeter = new JLabel(" m\u00B2");
		lblSquereMeter.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSquereMeter.setBounds(493, 189, 46, 14);
		contentPane.add(lblSquereMeter);

		JLabel lblPriceInEuro = new JLabel("\u20AC");
		lblPriceInEuro.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPriceInEuro.setBounds(553, 154, 35, 14);
		contentPane.add(lblPriceInEuro);
		
		JButton btnNextToFinalStep = new JButton("Next to final step");
		btnNextToFinalStep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	
				Room room = new Room();
				room.setId_residence(id_residence);
				room.setId_room(id_room);
				room.setRoom_type(room_type);
				Room_InfoForm room_InfoForma;
					
					try {
						if(room.getId_room() == 0) {
							JOptionPane.showMessageDialog(null, "Please mark the room in the table");
						}else {
							
						
						room_InfoForma = new Room_InfoForm(room, residence);
						room.setId_room(id_room);
						room.setId_residence(id_residence);
						
						room_InfoForma.setVisible(true);
						}		
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}								
			
		});
		btnNextToFinalStep.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnNextToFinalStep.setBounds(537, 396, 142, 23);
		contentPane.add(btnNextToFinalStep);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 208, 387, 179);
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
		table.setRowHeight(20);
		
	    cellRenderer = new DefaultTableCellRenderer();
	    //ako hocu prva kolona tj na indexu 0 da mi bude na sredini kolone onda ide kod - cellRenderer.setHorizontalAlignment(JLabel.CENTER);
	    cellRenderer.setHorizontalAlignment(JLabel.CENTER);
	    
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = table.getSelectedRow();
				String type = table.getModel().getValueAt(row, 0).toString();
				String numberOfRooms = table.getModel().getValueAt(row, 1).toString();
				String numberOfBeds = table.getModel().getValueAt(row, 2).toString();
				String pricePerNight = table.getModel().getValueAt(row, 3).toString();
				String roomSize = table.getModel().getValueAt(row, 4).toString();
				
				cbRoomType.getModel().setSelectedItem(type);
				tfNumberOfRooms.setText(numberOfRooms);
				tfNumberOfBeds.setText(numberOfBeds);
				tfPricePerNight.setText(pricePerNight);
				tfRoomSize.setText(roomSize);
				id_room = Integer.parseInt(table.getModel().getValueAt(row, 5).toString());			
			}
		});
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setRowHeight(20);
		scrollPane.setViewportView(table);
		
		Object[]kolone = new Object [6];  
		kolone[0] = "room_type";
		kolone[1] = "number_of_rooms";
		kolone[2] = "number_of_beds";
		kolone[3] = "price_per_night";
		kolone[4] = "room_size";
		kolone[5] = "id_room";
	
		
		dtm.addColumn(kolone[0]);
		dtm.addColumn(kolone[1]);
		dtm.addColumn(kolone[2]);
		dtm.addColumn(kolone[3]);
		dtm.addColumn(kolone[4]);
		dtm.addColumn(kolone[5]);
		
		setDataInTable();
		
	}


	private void setDataInTable() {
		dtm.setRowCount(0);
		
		Object[] row = new Object[6];
		
		 for (Room room : roomList) {
			
			if (room.getId_residence() == id_residence) {
				
				row[0] = room.getRoom_type();
				row[1] = room.getNumber_of_rooms();
				row[2] = room.getNumber_of_beds();
				row[3] = room.getPrice_per_night();
				row[4] = room.getRoom_size();
				row[5] = room.getId_room();
				
				dtm.addRow(row);
			}
		}	
		
	}
	
	
}

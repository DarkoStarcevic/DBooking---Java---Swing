package com.comtrade.view.adminforme;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import com.comtrade.controlerUI.ControlerUI;
import com.comtrade.domen.Residence;
import com.comtrade.domen.Review;
import com.comtrade.domen.User;
import com.comtrade.transfer.TransferClass;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.SystemColor;


public class OwnerForm extends JFrame {

	private JPanel contentPane;
	private JTextField tfNameOfResidence;
	private JTable table;
	private JLabel lblNameOfResidence;
	private DefaultTableModel dtm = new DefaultTableModel();
	private JComboBox<String> cbTypeOfResidence;
	private List<Residence> listResidence;
	private int id_residence;
	private int id_usera;
	private String username;
	private List<Review>reviewList;
	private int id_review;
	private DefaultTableCellRenderer cellRenderer;

	
	public OwnerForm(User user2) throws ClassNotFoundException, IOException {
		this.id_usera = user2.getId_usera();
		this.username = user2.getUsername();
		listResidence =  (List<Residence>) ControlerUI.getInstanca().putAllResidenceIntoTable().getServer_object_response();
		reviewList = (List<Review>) ControlerUI.getInstanca().getReviewBack().getServer_object_response();
		setTitle("Your Residence");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 928, 491);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Logout");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
                JFrame frame = new JFrame();
				
				int answer = JOptionPane.showConfirmDialog(frame, "Are you sure you want to logout?");
				if(answer == JOptionPane.NO_OPTION) {
				   frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}else if(answer == JOptionPane.CANCEL_OPTION) {
					 frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}else {
				
				   dispose();
				   
				   try {
						ControlerUI.getInstanca().logout(user2).getServer_object_response();
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
		label.setIcon(img);
		label.setBackground(new Color(153, 255, 255));
		label.setForeground(new Color(0, 51, 153));
		label.setOpaque(true);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(0, 51, 153));
		label.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		label.setBackground(new Color(153, 255, 255));
		label.setBounds(698, 20, 89, 26);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("Welcome " + user2.getUsername());  
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(10, 11, 504, 38);
		contentPane.add(lblNewLabel);
			
		cbTypeOfResidence = new JComboBox<>();
		cbTypeOfResidence.setModel(new DefaultComboBoxModel(new String[] {" -- Choose type of residence  -- "}));
		cbTypeOfResidence.setBounds(257, 104, 202, 20);
		contentPane.add(cbTypeOfResidence);
		cbTypeOfResidence.setEditable(isEnabled());
		//cbTypeOfResidence.addItem(" -- Choose type of residence -- ");
		cbTypeOfResidence.addItem("Hotel");
		cbTypeOfResidence.addItem("Hostel");
		cbTypeOfResidence.addItem("Apartment");
		cbTypeOfResidence.addItem("Studio");
		cbTypeOfResidence.addItem("Resort");
		
		lblNameOfResidence = new JLabel("Name of residence");
		lblNameOfResidence.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNameOfResidence.setBounds(521, 79, 162, 14);
		contentPane.add(lblNameOfResidence);
		
		tfNameOfResidence = new JTextField();
		tfNameOfResidence.setBounds(521, 104, 231, 20);
		contentPane.add(tfNameOfResidence);
		tfNameOfResidence.setColumns(10);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String name = tfNameOfResidence.getText();
				Residence residence = new Residence();
				
				residence.setNameOfResidence(name);	
				residence.setTypeOfResidence(cbTypeOfResidence.getSelectedItem().toString());  	
				residence.setId_usera(id_usera);
				try {	
				
				residence =  (Residence) ControlerUI.getInstanca().insertResidence(residence).getServer_object_response();
			    listResidence.add(residence);
				setDataInTable();
				JOptionPane.showMessageDialog(null, "Cool... now, mark residence in table and go next ");

				} catch (ClassNotFoundException e) {
					
					e.printStackTrace();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				
			}
		});
			
		btnInsert.setBounds(499, 152, 89, 23);
		contentPane.add(btnInsert);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TransferClass transferKlasa = null;
				try {
				String name = tfNameOfResidence.getText();
				Residence residence = new Residence();
				residence.setNameOfResidence(name);
				residence.setTypeOfResidence(cbTypeOfResidence.getSelectedItem().toString());
				residence.setId_residence(id_residence);
				residence.setId_usera(id_usera);
				
				transferKlasa = ControlerUI.getInstanca().updateResidence(residence);
				setUpdate(transferKlasa);
				setDataInTable();
			}catch (Exception e) {
				JOptionPane.showMessageDialog(null, transferKlasa.getMessage_response());
			}
			}
		});
		btnUpdate.setBounds(598, 152, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Residence residence = new Residence();
				residence.setId_residence(id_residence);
				JFrame frame = new JFrame();
				
				int answer = JOptionPane.showConfirmDialog(frame, "Are you sure you want to delete residence?");
				if(answer == JOptionPane.NO_OPTION) {
				   frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}else if(answer == JOptionPane.CANCEL_OPTION) {
					 frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}else
					
				try {
					
				TransferClass transferKlasa = ControlerUI.getInstanca().deleteResidence(residence);
			    setDelete(residence);
			    setDataInTable(); 
				JOptionPane.showMessageDialog(null, transferKlasa.getMessage_response());
				setDataInTable();
				
				} catch (ClassNotFoundException | IOException e) {
					
					e.printStackTrace();
				}
			}
		});
		btnDelete.setBounds(698, 152, 89, 23);
		contentPane.add(btnDelete);		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(257, 216, 530, 225);
		contentPane.add(scrollPane);
		
		Object[]kolone = new Object [4];  
		kolone[0] = "id_residence";
		kolone[1] = "name";
		kolone[2] = "type";
		kolone[3] = "id_usera";
		
		
		dtm.addColumn(kolone[0]);
		dtm.addColumn(kolone[1]);
		dtm.addColumn(kolone[2]);
		dtm.addColumn(kolone[3]);
		
		
		setDataInTable();
		
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
		table.getColumnModel().getColumn(0).setPreferredWidth(2);
		table.getColumnModel().getColumn(1).setPreferredWidth(220);
	    table.getColumnModel().getColumn(2).setPreferredWidth(80);
	    table.getColumnModel().getColumn(3).setPreferredWidth(5);
	    cellRenderer = new DefaultTableCellRenderer();
	    //ako hocu prva kolona tj na indexu 0 da mi bude na sredini kolone onda ide kod - cellRenderer.setHorizontalAlignment(JLabel.CENTER);
	    cellRenderer.setHorizontalAlignment(JLabel.CENTER);
	    table.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
	    table.getColumnModel().getColumn(3).setCellRenderer(cellRenderer);
	    
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int red = table.getSelectedRow();
				String name = table.getModel().getValueAt(red, 1).toString();
				String typeOfResidence = table.getModel().getValueAt(red, 2).toString();
				tfNameOfResidence.setText(name);
				cbTypeOfResidence.getModel().setSelectedItem(typeOfResidence);                         
			    id_residence = Integer.parseInt(table.getModel().getValueAt(red, 0).toString());
				id_usera =  Integer.parseInt(table.getModel().getValueAt(red, 3).toString());
				
			}
		} );
		scrollPane.setViewportView(table);
		
		
		
		JButton btnNext = new JButton("Next");
		btnNext.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Residence residence = new Residence();
				residence.setId_residence(id_residence);
				DestinationForm destinationForma;
				try {
					destinationForma = new DestinationForm(residence);
					residence.setId_residence(id_residence);
					destinationForma.setVisible(true);
				} catch (ClassNotFoundException | IOException e1) {
					
					e1.printStackTrace();
				}
				
						
			}
		});
		btnNext.setBounds(813, 418, 89, 23);
		contentPane.add(btnNext);
		
		JLabel lblNewLabel_1 = new JLabel("STEP 1");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_1.setBounds(821, 11, 81, 23);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBackground(new Color(0, 0, 0, 46));
		contentPane.add(lblNewLabel_1);
				
		JLabel label_1 = new JLabel("My profile");
		label_1.addMouseListener(new MouseAdapter() {
			

			@Override
			public void mouseClicked(MouseEvent arg0) {
				User user = new User();
				
				MyProfileOwner profileOwner;
				try {
					profileOwner = new MyProfileOwner(id_usera,username);
					user.setUsername(username);
					user.setId_usera(id_usera);
					profileOwner.setVisible(true);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		label_1.setBounds(10, 52, 151, 41);
		contentPane.add(label_1);
		
		JLabel profileAvatar = new JLabel("");
		profileAvatar.setBounds(88, 52, 57, 41);
		ImageIcon img11 = new ImageIcon(getClass().getResource("/register.png"));
		Image image2 = img11.getImage().getScaledInstance(profileAvatar.getWidth(), profileAvatar.getHeight(), Image.SCALE_SMOOTH);
		img11.setImage(image2);
		profileAvatar.setIcon(img11);
		contentPane.add(profileAvatar);
		
		JLabel lblHotel = new JLabel("");
		lblHotel.setBounds(10, 138, 218, 303);
		ImageIcon img3 = new ImageIcon(getClass().getResource("/OwnerManagement.jpg"));
		Image image3 = img3.getImage().getScaledInstance(lblHotel.getWidth(), lblHotel.getHeight(), Image.SCALE_SMOOTH);
		img3.setImage(image3);
		lblHotel.setIcon(img3);
		contentPane.add(lblHotel);
	
	}


	private void setDataInTable() {
		dtm.setRowCount(0);
		Object[] red = new Object[4];
		
		
			 for (Residence residence : listResidence) {
				 
					
		
			 
			 if (residence.getId_usera() == id_usera ) {
					
					
					red[0] = residence.getId_residence();
					red[1] = residence.getNameOfResidence();
					red[2] = residence.getTypeOfResidence();
					red[3] = residence.getId_usera();
					
					
				dtm.addRow(red);
				
				
				}
				
			}	
			 		
		}	
			
	
	public void setUpdate(TransferClass transferKlasa) {
		Residence residence = (Residence) transferKlasa.getServer_object_response();
		int id = residence.getId_residence();
		for(int i = 0; i < listResidence.size(); i++ ) {
			if(listResidence.get(i).getId_residence() == id) {
				listResidence.set(i, residence);
			}
		
		}
		
	}
	
	public void setDelete(Residence residence) {
		for(int i = 0; i < listResidence.size(); i++ ) {
			if(listResidence.get(i).getId_residence() == residence.getId_residence()) {
				listResidence.remove(i);
			}
		}
		
	}
}



	






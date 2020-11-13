package com.comtrade.view.adminforme;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import com.comtrade.controlerUI.ControlerUI;
import com.comtrade.domen.PhotoAlbum;
import com.comtrade.domen.Residence;
import com.comtrade.domen.Room;
import com.comtrade.domen.Room_Info;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class Room_InfoForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int id_room;
	private String room_type;
	private List<Room> roomList;
	private List<Residence>residenceList;
	private String image; // = null;
	private JLabel lblPhotoUpload;
	private JCheckBox  chckbxAc,  chckbxKitchen, chckbxWifi, chckbxTv, chckbxPrivatebathroom, chckbxBalcony, chckbxParking, chckbxRestaurant;
	private int id_residence;
	//private List<JCheckBox> boxes = new ArrayList<>();
	//private String  services [] = { "AC", "WIFI", "balcony", "TV", "kitchen", "private_bathroom", "parking", "restaurant" };
	private LinkedList<PhotoAlbum>photoList;
	private IteratorLinkedList<PhotoAlbum> iter;
	private PhotoAlbum current;
	private JTextArea textAreaDescription;	
	private ArrayList<File> photos = new ArrayList<>();
	

	public Room_InfoForm(Room room, Residence residence) throws ClassNotFoundException, IOException  {
		this.id_room = room.getId_room();
		this.room_type = room.getRoom_type();
		this.id_residence = residence.getId_residence();
		roomList = (List<Room>) ControlerUI.getInstanca().getAllRoomsBack().getServer_object_response();
		residenceList = (List<Residence>) ControlerUI.getInstanca().putAllResidenceIntoTable().getServer_object_response();
		photoList =  (LinkedList<PhotoAlbum>) ControlerUI.getInstanca().returnPhoto().getServer_object_response();
		iter = new CircularLinkedListPhoto<PhotoAlbum>(photoList).iterator();
		
		setTitle("Room info");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 721, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Room_Info room_Info = new Room_Info();
				PhotoAlbum photoAlbum = new PhotoAlbum();
				String description = textAreaDescription.getText();
				room_Info.setDescription(description);
				room_Info.setId_room(id_room);
				photoAlbum.setPhoto_image(image);
				photoAlbum.setId_residence(id_residence);
				//getContentPane().add(lblPhotoUpload);
		     
				setSelectedCheckBoxes(room_Info);
				
				try {

					if (image != null) {
						room_Info = (Room_Info) ControlerUI.getInstanca().insertRoomServices(room_Info).getServer_object_response();
						photoAlbum = (PhotoAlbum) ControlerUI.getInstanca().insertPhoto(photoAlbum).getServer_object_response();
						photoList.add(photoAlbum);
						JOptionPane.showMessageDialog(null, "successfully saved ");
						cleanTxt();
						btnInsert.setEnabled(false);
					}else {
						JOptionPane.showMessageDialog(null, "please upload some photos");
					}
					
					
					
				} catch (ClassNotFoundException e) {
					
					e.printStackTrace();
				} catch (IOException e) {
					
					e.printStackTrace();
				}

			}
			
			private void cleanTxt() {
				textAreaDescription.setText("");
				
			}
				
			/*	List<JCheckBox>boxes = new ArrayList<>();
				String  services [] = { "AC", "WIFI", "balcony", "TV", "kitchen", "private_bathroom", "parking", "restaurant" };
				
				for (int i = 0; i < services.length; i++) {
				
				  JCheckBox box = new JCheckBox(services[i]);
				  boxes.add(box);
				   
				}
			
		     	// setSelectedCheckBoxes(boxes);
		     	*/

		});
		btnInsert.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnInsert.setBounds(552, 294, 89, 23);
		contentPane.add(btnInsert);
		

		chckbxAc = new JCheckBox("AC");
		chckbxAc.setBounds(369, 27, 46, 23);
		contentPane.add(chckbxAc);

	    chckbxKitchen = new JCheckBox("kitchen\t");
		chckbxKitchen.setBounds(369, 68, 76, 23);
		contentPane.add(chckbxKitchen);

		chckbxWifi = new JCheckBox("WiFi");
		chckbxWifi.setBounds(473, 27, 71, 23);
		contentPane.add(chckbxWifi);

		chckbxTv = new JCheckBox("TV");
		chckbxTv.setBounds(583, 27, 58, 23);
		contentPane.add(chckbxTv);

		chckbxPrivatebathroom = new JCheckBox("private_bathroom\t");
		chckbxPrivatebathroom.setBounds(369, 106, 137, 23);
		contentPane.add(chckbxPrivatebathroom);

		chckbxBalcony = new JCheckBox("balcony");
		chckbxBalcony.setBounds(583, 68, 76, 23);
		contentPane.add(chckbxBalcony);

		chckbxParking = new JCheckBox("parking");
		chckbxParking.setBounds(473, 68, 76, 23);
		contentPane.add(chckbxParking);

		chckbxRestaurant = new JCheckBox("restaurant");
		chckbxRestaurant.setBounds(543, 106, 116, 23);
		contentPane.add(chckbxRestaurant);

		JLabel lblAC = new JLabel("");
		lblAC.setHorizontalAlignment(SwingConstants.RIGHT);
		ImageIcon img = new ImageIcon(getClass().getResource("/ac.png"));
		lblAC.setIcon(img);
		lblAC.setBounds(305, 27, 58, 31);
		contentPane.add(lblAC);

		JLabel lblWiFi = new JLabel("");
		lblWiFi.setHorizontalAlignment(SwingConstants.RIGHT);
		ImageIcon img1 = new ImageIcon(getClass().getResource("/wifi.png"));
		lblWiFi.setIcon(img1);
		lblWiFi.setBounds(420, 27, 46, 31);
		contentPane.add(lblWiFi);

		JLabel lblTV = new JLabel("");
		lblTV.setHorizontalAlignment(SwingConstants.RIGHT);
		ImageIcon img2 = new ImageIcon(getClass().getResource("/tv1.png"));
		lblTV.setIcon(img2);
		lblTV.setBounds(521, 27, 56, 23);
		contentPane.add(lblTV);

		JLabel lblKitchen = new JLabel("");
		lblKitchen.setHorizontalAlignment(SwingConstants.RIGHT);
		ImageIcon img3 = new ImageIcon(getClass().getResource("/kitchen.png"));
		lblKitchen.setIcon(img3);
		lblKitchen.setBounds(317, 62, 46, 24);
		contentPane.add(lblKitchen);

		JLabel lblParking = new JLabel("");
		lblParking.setHorizontalAlignment(SwingConstants.RIGHT);
		ImageIcon img4 = new ImageIcon(getClass().getResource("/parking.png"));
		lblParking.setIcon(img4);
		lblParking.setBounds(421, 62, 46, 37);
		contentPane.add(lblParking);

		JLabel lblBalcony = new JLabel("");
		lblBalcony.setHorizontalAlignment(SwingConstants.RIGHT);
		ImageIcon img5 = new ImageIcon(getClass().getResource("/balcony.png"));
		lblBalcony.setIcon(img5);
		lblBalcony.setBounds(531, 62, 46, 29);
		contentPane.add(lblBalcony);

		JLabel lblBath = new JLabel("");
		lblBath.setHorizontalAlignment(SwingConstants.RIGHT);
		ImageIcon img6 = new ImageIcon(getClass().getResource("/bathtub.png"));
		lblBath.setIcon(img6);
		lblBath.setBounds(287, 98, 76, 31);
		contentPane.add(lblBath);

		JLabel lblJavaCup = new JLabel("");
		lblJavaCup.setHorizontalAlignment(SwingConstants.RIGHT);
		ImageIcon img7 = new ImageIcon(getClass().getResource("/Java.png"));
		lblJavaCup.setIcon(img7);
		lblJavaCup.setBounds(491, 98, 46, 31);
		contentPane.add(lblJavaCup);
		
		JLabel lblDescription = new JLabel("Add additional description");
		lblDescription.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblDescription.setBounds(342, 165, 254, 14);
		contentPane.add(lblDescription);
		
		lblPhotoUpload = new JLabel("");
		lblPhotoUpload.setOpaque(true);
		lblPhotoUpload.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhotoUpload.setForeground(Color.DARK_GRAY);
		lblPhotoUpload.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhotoUpload.setBackground(new Color(0, 0, 0, 24));
		lblPhotoUpload.setBounds(20, 58, 287, 320);
		
		for(PhotoAlbum album : photoList) {
			if(id_residence == album.getId_residence()) {                
				lblPhotoUpload.setIcon(ResizeImage(album.getPhoto_image()));
			}
		}

		contentPane.add(lblPhotoUpload);
		
		JButton btnPrevious = new JButton("<<");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
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
				
				lblPhotoUpload.setIcon(ResizeImage(image));
			}
		});
		btnPrevious.setBounds(20, 379, 66, 23);
		contentPane.add(btnPrevious);
		
		JButton btnNext = new JButton(">>");
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
				
				lblPhotoUpload.setIcon(ResizeImage(image));			
			}
		});
		btnNext.setBounds(241, 379, 66, 23);
		contentPane.add(btnNext);
		
		JButton btnUploadPhoto = new JButton("- upload photos -");
		btnUploadPhoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				selectPhotos();
				
			}
			
	
		});
		btnUploadPhoto.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnUploadPhoto.setBounds(20, 24, 149, 23);
		contentPane.add(btnUploadPhoto);
		
		JScrollPane scrollPane = new JScrollPane(textAreaDescription);
		scrollPane.setBounds(342, 190, 299, 93);
		contentPane.add(scrollPane);
		
		textAreaDescription = new JTextArea();
		scrollPane.setViewportView(textAreaDescription);
		
		JButton btnadditionalPhotos = new JButton("Add additional photos");
		btnadditionalPhotos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnInsert.setEnabled(false);
				selectPhotos();
			}
		});
		btnadditionalPhotos.setBounds(317, 294, 167, 23);
		contentPane.add(btnadditionalPhotos);
		
		JButton btnInsertPhotos = new JButton("Insert photos");
		btnInsertPhotos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				PhotoAlbum photoAlbum = new PhotoAlbum();	
				photoAlbum.setPhoto_image(image);
				photoAlbum.setId_residence(id_residence);
				try {
					photoAlbum = (PhotoAlbum) ControlerUI.getInstanca().insertPhoto(photoAlbum).getServer_object_response();
					photoList.add(photoAlbum);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(null, "successfully saved ");
			}
		});
		btnInsertPhotos.setBounds(317, 328, 167, 23);
		contentPane.add(btnInsertPhotos);	
		
	}
	
		protected void selectPhotos() {
			
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
			FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg", "gif", "png");
			fileChooser.addChoosableFileFilter(filter);
			fileChooser.setMultiSelectionEnabled(true);
			fileChooser.setAccessory(new ImagePreview(fileChooser));
			int result = fileChooser.showOpenDialog(null);
		
			if (result == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileChooser.getSelectedFile();
				File[] files = fileChooser.getSelectedFiles();
				  for(File file : files) {
					photos.add(file);
				}
				  
				
			
				String path = selectedFile.getAbsolutePath();
				lblPhotoUpload.setIcon(ResizeImage(path));
				image = path;
				
				
			} else if (result == JFileChooser.CANCEL_OPTION) {
				JOptionPane.showMessageDialog(null, "upload cancelled, please try again");
			}
				
			}


/*	private void setSelectedCheckBoxes(List<JCheckBox> boxes2) {
			
			 for (JCheckBox box : boxes ) {
				if(box.isSelected()) {
					
				box.setSelected(true);
				}
			}	
	}
	*/

	 protected void setSelectedCheckBoxes(Room_Info room_Info) {
		if(chckbxAc.isSelected()) {
			room_Info.setAC(true);
		}
		if(chckbxBalcony.isSelected()) {
			room_Info.setBalcony(true);
		}
		if(chckbxKitchen.isSelected()) {
			room_Info.setKitchen(true);
		}
		if(chckbxParking.isSelected()) {
			room_Info.setParking(true);
		}
		if(chckbxPrivatebathroom.isSelected()) {
			room_Info.setPrivate_bathroom(true);
		}
		if(chckbxRestaurant.isSelected()) {
			room_Info.setRestaurant(true);
		}
		if(chckbxTv.isSelected()) {
			room_Info.setTV(true);
		}
		if(chckbxWifi.isSelected()) {
			room_Info.setWiFi(true);
		}
	}
	

	 public ImageIcon ResizeImage(String path) {
			ImageIcon MyImage = new ImageIcon(path);
			Image img = MyImage.getImage().getScaledInstance(lblPhotoUpload.getWidth(), lblPhotoUpload.getHeight(),
					Image.SCALE_SMOOTH);
			ImageIcon image = new ImageIcon(img);
			return image;

		}
}



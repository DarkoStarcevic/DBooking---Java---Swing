package com.comtrade.registrationLogin.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import com.comtrade.controlerUI.ControlerUI;
import com.comtrade.domen.Residence;
import com.comtrade.domen.User;
import com.comtrade.transfer.TransferClass;

public class ResetPassword extends JFrame {

	private JPanel contentPane;
	private JLabel lblConfirmNewPassword;
	private JButton btnReset;
	private JPasswordField pfNewPassword;
	private JPasswordField pfNewPassConf;
	private String email;
	private List<User>userList;
	private String firstName,lastName,username, phoneNumber;
	private int id_usera;

	public ResetPassword(String email) throws ClassNotFoundException, IOException {
		this.email = email;
		userList = (List<User>) ControlerUI.getInstanca().getUserListBack().getServer_object_response();
		for(User u : userList) {
			if(u.getEmail().equals(email)) {
				this.username = u.getUsername();
				this.id_usera = u.getId_usera();
				this.firstName = u.getFirstName();
				this.lastName = u.getLastName();
				this.phoneNumber = u.getPhoneNum();
			}
		}
		
		setTitle("Password Reset");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 381, 204);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewPassword = new JLabel("New password");
		lblNewPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewPassword.setBounds(10, 57, 130, 14);
		contentPane.add(lblNewPassword);
		
		lblConfirmNewPassword = new JLabel("Confirm New password");
		lblConfirmNewPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblConfirmNewPassword.setBounds(10, 89, 130, 14);
		contentPane.add(lblConfirmNewPassword);
		
		pfNewPassword = new JPasswordField();
		pfNewPassword.setBackground(new Color(204, 255, 255));
		pfNewPassword.setBounds(150, 54, 146, 20);
		contentPane.add(pfNewPassword);
		
		pfNewPassConf = new JPasswordField();
		pfNewPassConf.setBackground(new Color(204, 255, 255));
		pfNewPassConf.setBounds(150, 86, 146, 20);
		contentPane.add(pfNewPassConf);
		
		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TransferClass transferKlasa = null;
				
				try {
				
				String newPassword = String.copyValueOf(pfNewPassword.getPassword());
				String newPassConf = String.copyValueOf(pfNewPassConf.getPassword());
				
				User user = new User();	
				
				if(newPassword.equals(newPassConf) && email != null) {   
					user.setPassword(newPassword);
					user.setEmail(email);  
				
						user =  (User) ControlerUI.getInstanca().sacuvajNoviPassword(user).getServer_object_response();
					
					    JOptionPane.showMessageDialog(null, "Password reset successfully");
					
						ocistiFildove();				
						
				}else {
							JOptionPane.showMessageDialog(null, "Something went wrong. Please try again");
						}
				
				}catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		
				}

			private void ocistiFildove() {
				pfNewPassword.setText("");
				pfNewPassConf.setText("");
				
			}

		});
		
		btnReset.setFont(new Font("Tahoma", Font.ITALIC, 12));
		btnReset.setBackground(new Color(51, 255, 255));
		btnReset.setBounds(141, 132, 89, 23);
		contentPane.add(btnReset);
		}

	
	}

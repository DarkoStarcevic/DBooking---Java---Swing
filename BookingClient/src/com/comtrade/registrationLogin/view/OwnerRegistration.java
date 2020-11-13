package com.comtrade.registrationLogin.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.comtrade.controlerUI.ControlerUI;
import com.comtrade.domen.User;
import com.comtrade.transfer.TransferClass;
import java.awt.Rectangle;

public class OwnerRegistration extends JFrame {

	private JPanel contentPane;
	private JTextField tfFirstName;
	private JTextField tfLastName;
	private JTextField tfPhoneNum;

	
	public OwnerRegistration() {
		setTitle("Owner registration");
		setBackground(new Color( 0,255, 255));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 100, 422, 643);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JTextField tfUsername1 = new JTextField();
		tfUsername1.setOpaque(false);
		tfUsername1.setForeground(Color.DARK_GRAY);
		tfUsername1.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfUsername1.setColumns(10);
		tfUsername1.setBounds(170, 35, 154, 20);
		contentPane.add(tfUsername1);
		
		JTextField tfEmail = new JTextField();
		tfEmail.setOpaque(false);
		tfEmail.setForeground(Color.DARK_GRAY);
		tfEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfEmail.setColumns(10);
		tfEmail.setBounds(170, 65, 154, 20);
		contentPane.add(tfEmail);
		
		JPasswordField pfPassword1 = new JPasswordField();
		pfPassword1.setForeground(Color.DARK_GRAY);
		pfPassword1.setOpaque(false);
		pfPassword1.setFont(new Font("Tahoma", Font.BOLD, 11));
		pfPassword1.setBounds(170, 96, 154, 20);
		contentPane.add(pfPassword1);
		
		JPasswordField pfConfirmPassword = new JPasswordField();
		pfConfirmPassword.setForeground(Color.DARK_GRAY);
		pfConfirmPassword.setOpaque(false);
		pfConfirmPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		pfConfirmPassword.setBounds(170, 127, 154, 20);
		contentPane.add(pfConfirmPassword);
		contentPane.setLayout(null);
		
		
		JLabel lblUsername1 = new JLabel("Username");
		lblUsername1.setBounds(10, 41, 114, 14);
		lblUsername1.setForeground(Color.DARK_GRAY);
		lblUsername1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsername1.setBackground(Color.BLACK);
		contentPane.add(lblUsername1);
		
		JLabel lblEmail = new JLabel("email");
		lblEmail.setBounds(10, 71, 114, 14);
		lblEmail.setForeground(Color.DARK_GRAY);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBackground(new Color(255, 255, 204));
		contentPane.add(lblEmail);
		
		JLabel lblPassword1 = new JLabel("Password");
		lblPassword1.setBounds(10, 102, 114, 14);
		lblPassword1.setForeground(Color.DARK_GRAY);
		lblPassword1.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblPassword1);
		
		JLabel lblConmfirmPassword = new JLabel("Confirm password");
		lblConmfirmPassword.setForeground(Color.DARK_GRAY);
		lblConmfirmPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConmfirmPassword.setBackground(Color.LIGHT_GRAY);
		lblConmfirmPassword.setBounds(10, 133, 139, 14);
		contentPane.add(lblConmfirmPassword);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(103, 271, 145, 28);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	
		        String username1 = tfUsername1.getText();
		        String email = tfEmail.getText();
			    String password1 = String.copyValueOf(pfPassword1.getPassword());
				String confirmPassword = String.copyValueOf(pfConfirmPassword.getPassword());
				String firstName = tfFirstName.getText();
				String lastName = tfLastName.getText();
				String phoneNum = tfPhoneNum.getText();
			
				  if(password1.equals(confirmPassword)) {
						User user = new User();
						user.setUsername(username1);
						user.setPassword(password1);
						user.setEmail(email);
						user.setFirstName(firstName);
						user.setLastName(lastName);
						user.setPhoneNum(phoneNum);
						user.setStatus("owner");
						try {
							if(username1.trim().equals("") || password1.trim().equals("") || email.trim().equals("")) {
							JOptionPane.showMessageDialog(null, "fields username, password and email are required");
							}else {
								TransferClass transferKlasa = ControlerUI.getInstanca().sacuvajUsera(user);						
								String message = transferKlasa.getMessage_response();
								ocistiFildove();
								JOptionPane.showMessageDialog(null,message);
							}
							
						
						} catch (ClassNotFoundException | IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						}else JOptionPane.showMessageDialog(null, "Sorry. Wrong password. Please try again");
						
					}

		private void ocistiFildove() {
			tfUsername1.setText("");
			pfPassword1.setText("");
			pfConfirmPassword.setText("");
			tfEmail.setText("");
			tfFirstName.setText("");
			tfLastName.setText("");
			tfPhoneNum.setText("");
				
			}
				});
		
		btnRegister.setOpaque(false);
		btnRegister.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		ImageIcon img2 = new ImageIcon(getClass().getResource("/ok.png"));
		btnRegister.setIcon(img2);
		contentPane.add(btnRegister);
		
		JLabel lblOwnerManagement = new JLabel("");
		lblOwnerManagement.setBounds(24, 321, 300, 253);
		contentPane.add(lblOwnerManagement);
		ImageIcon img = new ImageIcon(getClass().getResource("/OwnerManagement.jpg"));
		lblOwnerManagement.setIcon(img);
		
		JLabel lblFirstName = new JLabel("First name");
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFirstName.setForeground(Color.DARK_GRAY);
		lblFirstName.setBackground(Color.LIGHT_GRAY);
		lblFirstName.setBounds(10, 162, 139, 20);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last name");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLastName.setForeground(Color.DARK_GRAY);
		lblLastName.setBackground(Color.LIGHT_GRAY);
		lblLastName.setBounds(10, 193, 139, 14);
		contentPane.add(lblLastName);
		
		tfFirstName = new JTextField();
		tfFirstName.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfFirstName.setForeground(Color.DARK_GRAY);
		tfFirstName.setOpaque(false);
		tfFirstName.setBounds(170, 159, 154, 20);
		contentPane.add(tfFirstName);
		tfFirstName.setColumns(10);
		
		tfLastName = new JTextField();
		tfLastName.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfLastName.setForeground(Color.DARK_GRAY);
		tfLastName.setOpaque(false);
		tfLastName.setColumns(10);
		tfLastName.setBounds(170, 190, 154, 20);
		contentPane.add(tfLastName);
		
		JLabel lblPhoneNumber = new JLabel("Phone number");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPhoneNumber.setBackground(Color.LIGHT_GRAY);
		lblPhoneNumber.setForeground(Color.DARK_GRAY);
		lblPhoneNumber.setBounds(10, 218, 139, 23);
		contentPane.add(lblPhoneNumber);
		
		tfPhoneNum = new JTextField();
		tfPhoneNum.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfPhoneNum.setForeground(Color.DARK_GRAY);
		tfPhoneNum.setOpaque(false);
		tfPhoneNum.setColumns(10);
		tfPhoneNum.setBounds(170, 221, 154, 20);
		contentPane.add(tfPhoneNum);
		
	}
}

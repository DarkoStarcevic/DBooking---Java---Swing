package com.comtrade.registrationLogin.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.comtrade.controlerUI.ControlerUI;
import com.comtrade.domen.User;
import com.comtrade.proxy.login.IProxy;
import com.comtrade.proxy.login.ProxyLogin;
import com.comtrade.transfer.TransferClass;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RegistrationLogin extends JFrame {

	private JPanel contentPane;
	private JPasswordField pfPassword;
	private JLabel lblBackgroundBoraBora;
	private JTextField tfUsername1;
	private JPasswordField pfPassword1;
	private JPasswordField pfConfirmPassword;
	private JTextField tfEmail;
	private JTextField tfFirstName;
	private JTextField tfLastName;
	private JTextField tfPhoneNum;
	private JButton btnLogin;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrationLogin frame = new RegistrationLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegistrationLogin() {
		setTitle("Login page");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 915, 639);
		contentPane = new JPanel();
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(210, 22, 111, 14);
		lblUsername.setForeground(new Color(255, 255, 204));
		lblUsername.setBackground(new Color(0, 0, 0));
		lblUsername.setFont(lblUsername.getFont().deriveFont(lblUsername.getFont().getStyle() | Font.BOLD | Font.ITALIC, lblUsername.getFont().getSize() + 3f));
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(373, 22, 111, 14);
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setFont(lblPassword.getFont().deriveFont(lblPassword.getFont().getStyle() | Font.BOLD | Font.ITALIC, lblPassword.getFont().getSize() + 3f));
		contentPane.add(lblPassword);
		
		JTextField tfUsername = new JTextField();
		tfUsername.setBounds(210, 47, 153, 20);
		tfUsername.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfUsername.setOpaque(false);
		tfUsername.setForeground(new Color(255, 255, 204));
		contentPane.add(tfUsername);
		tfUsername.setColumns(10);

		pfPassword = new JPasswordField();
		pfPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					
					btnLogin.doClick();
				
				}
			}
		});
		pfPassword.setBounds(373, 47, 153, 20);
		pfPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		pfPassword.setBackground(new Color(0, 0, 0));
		pfPassword.setForeground(new Color(255, 255, 204));
		pfPassword.setOpaque(false);
		contentPane.add(pfPassword);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(536, 45, 98, 23);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = tfUsername.getText();
				String password = String.copyValueOf(pfPassword.getPassword());
				User user = new User();
				user.setUsername(username);
				user.setPassword(password);
				
				IProxy iProxy = new ProxyLogin();
				ocistiPolja();
				try {
					iProxy.login(user);
				} catch (ClassNotFoundException e) {
					
					e.printStackTrace();
				} catch (IOException e) {
					
					e.printStackTrace();
				}

			}
			private void ocistiPolja() {
				tfUsername.setText("");
				pfPassword.setText("");				
			}
			
		});
		btnLogin.setOpaque(false);
		btnLogin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		contentPane.add(btnLogin);
		
		tfUsername1 = new JTextField();
		tfUsername1.setBounds(657, 241, 154, 20);
		tfUsername1.setOpaque(false);
		tfUsername1.setForeground(new Color(255, 255, 204));
		tfUsername1.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfUsername1.setColumns(10);
		contentPane.add(tfUsername1);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(657, 268, 154, 20);
		tfEmail.setOpaque(false);
		tfEmail.setForeground(new Color(255, 255, 204));
		tfEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfEmail.setColumns(10);
		contentPane.add(tfEmail);
		
		tfFirstName = new JTextField();
		tfFirstName.setBounds(657, 364, 154, 20);
		tfFirstName.setOpaque(false);
		tfFirstName.setForeground(new Color(255, 255, 204));
		tfFirstName.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfFirstName.setColumns(10);
		contentPane.add(tfFirstName);
		
		tfLastName = new JTextField();
		tfLastName.setBounds(657, 389, 154, 20);
		tfLastName.setOpaque(false);
		tfLastName.setForeground(new Color(255, 255, 204));
		tfLastName.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfLastName.setColumns(10);
		contentPane.add(tfLastName);
		
		tfPhoneNum = new JTextField();
		tfPhoneNum.setBounds(657, 414, 154, 20);
		tfPhoneNum.setOpaque(false);
		tfPhoneNum.setForeground(new Color(255, 255, 204));
		tfPhoneNum.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfPhoneNum.setColumns(10);
		contentPane.add(tfPhoneNum);
		
		pfPassword1 = new JPasswordField();
		pfPassword1.setBounds(657, 299, 154, 20);
		pfPassword1.setForeground(new Color(255, 255, 204));
		pfPassword1.setOpaque(false);
		pfPassword1.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(pfPassword1);
		
		pfConfirmPassword = new JPasswordField();
		pfConfirmPassword.setBounds(657, 330, 154, 20);
		pfConfirmPassword.setForeground(new Color(255, 255, 204));
		pfConfirmPassword.setOpaque(false);
		pfConfirmPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(pfConfirmPassword);
		
		JLabel lblUsername1 = new JLabel("Username");
		lblUsername1.setBounds(498, 241, 114, 20);
		lblUsername1.setForeground(new Color(255, 255, 204));
		lblUsername1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsername1.setBackground(new Color(255, 255, 204));
		contentPane.add(lblUsername1);
		
		JLabel lblEmail = new JLabel("email");
		lblEmail.setBounds(498, 268, 114, 21);
		lblEmail.setForeground(new Color(255, 255, 204));
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBackground(new Color(255, 255, 204));
		contentPane.add(lblEmail);
		
		JLabel lblPassword1 = new JLabel("Password");
		lblPassword1.setBounds(498, 300, 114, 14);
		lblPassword1.setForeground(new Color(255, 255, 204));
		lblPassword1.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblPassword1);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(589, 456, 168, 33);
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
						user.setStatus("user");
						try {
							if(username1.trim().equals("") || password1.trim().equals("") || email.trim().equals("")) {
							JOptionPane.showMessageDialog(null, "fields username, password and email are required");
							}else{
								TransferClass transferKlasa = ControlerUI.getInstanca().sacuvajUsera(user);
								String message = transferKlasa.getMessage_response();
								ocistiFildove();
								JOptionPane.showMessageDialog(null,message);
							}
								
						
						} catch (ClassNotFoundException | IOException e) {
							
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
		
		JLabel lblForgot = new JLabel("Forgot account ?");
		lblForgot.setBounds(500, 74, 134, 14);
		lblForgot.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				ForgotAccount forgotAccount = new ForgotAccount();
				forgotAccount.setVisible(true);
				
			}
			
		});
		lblForgot.setHorizontalAlignment(SwingConstants.RIGHT);
		lblForgot.setForeground(new Color(255, 255, 204));
		lblForgot.setBackground(new Color(255, 255, 204));
		contentPane.add(lblForgot);
		
		
		JLabel lblConmfirmPassword = new JLabel("Confirm password");
		lblConmfirmPassword.setBounds(498, 331, 139, 14);
		lblConmfirmPassword.setForeground(new Color(255, 255, 204));
		lblConmfirmPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConmfirmPassword.setBackground(Color.LIGHT_GRAY);
		contentPane.add(lblConmfirmPassword);
		
		JLabel lblFirstName = new JLabel("First name");
		lblFirstName.setBounds(498, 365, 114, 14);
		lblFirstName.setForeground(new Color(255, 255, 204));
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFirstName.setBackground(new Color(255, 255, 204));
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last name");
		lblLastName.setBounds(498, 390, 114, 14);
		lblLastName.setForeground(new Color(255, 255, 204));
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLastName.setBackground(new Color(255, 255, 204));
		contentPane.add(lblLastName);
		
		JLabel lblPhoneNumber = new JLabel("Phone number");
		lblPhoneNumber.setBounds(498, 415, 114, 14);
		lblPhoneNumber.setForeground(new Color(255, 255, 204));
		lblPhoneNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPhoneNumber.setBackground(new Color(255, 255, 204));
		contentPane.add(lblPhoneNumber);
		
		
		JLabel lblSignUp = new JLabel("Sign up\r\n");
		lblSignUp.setBounds(643, 180, 114, 38);
		lblSignUp.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignUp.setForeground(new Color(255, 255, 204));
		lblSignUp.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		contentPane.add(lblSignUp);	
		
		JLabel lblHeader = new JLabel("@DBooking");
		lblHeader.setBounds(0, 0, 582, 88);
		lblHeader.setOpaque(true);
		lblHeader.setVerticalTextPosition(SwingConstants.TOP);
		lblHeader.setBackground(new Color(0,0,0,60));
		lblHeader.setHorizontalAlignment(SwingConstants.LEFT);
		lblHeader.setForeground(Color.CYAN);
		lblHeader.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		contentPane.add(lblHeader);
		
		JLabel lblFotkaSignUp = new JLabel("");
		lblFotkaSignUp.setBounds(484, 119, 168, 142);
		contentPane.add(lblFotkaSignUp);
		ImageIcon img = new ImageIcon(getClass().getResource("/register.png"));
		lblFotkaSignUp.setIcon(img);
		
		JLabel lblNewLabel = new JLabel("OR Register as Owner HERE");
		lblNewLabel.setBounds(635, 500, 166, 14);
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				OwnerRegistration ownerReg = new OwnerRegistration();
				ownerReg.setVisible(true);
			}
		});
		
		lblNewLabel.setForeground(new Color(255, 255, 204));
		contentPane.add(lblNewLabel);
		
		JLabel lblPozadina = new JLabel("");
		lblPozadina.setBounds(484, 130, 337, 391);
		lblPozadina.setOpaque(true);
		lblPozadina.setForeground(Color.CYAN);
		lblPozadina.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPozadina.setBackground(new Color(0,0,0,60));
		contentPane.add(lblPozadina);
		
		lblBackgroundBoraBora = new JLabel("");
		lblBackgroundBoraBora.setBounds(0, 0, 900, 600);
		contentPane.add(lblBackgroundBoraBora);
		lblBackgroundBoraBora.setBackground(new Color(0,0,0));
		lblBackgroundBoraBora.setBorder(new EmptyBorder(1, 1, 1, 1));
		lblBackgroundBoraBora.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon img3 = new ImageIcon(getClass().getResource("/bora.jpg"));
		lblBackgroundBoraBora.setIcon(img3);
	}
}

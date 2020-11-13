package com.comtrade.registrationLogin.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.comtrade.domen.User;

public class ForgotAccount extends JFrame {

	private JPanel contentPane;
	private JTextField tfEnterEmail;
	private JTextField tfVerifyCode;
	private String randomCode;
	private JLabel lblEnterEmail;
	//private User user;
	


	public ForgotAccount() {
		setTitle("Forgot Account");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 436, 349);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblForgotYourAccount = new JLabel("Forgot Your Account ?");
		lblForgotYourAccount.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblForgotYourAccount.setBounds(54, 61, 310, 23);
		contentPane.add(lblForgotYourAccount);

		lblEnterEmail = new JLabel("Please enter your email and we will find it for you ");
		lblEnterEmail.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblEnterEmail.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblEnterEmail.setHorizontalTextPosition(SwingConstants.LEFT);
		lblEnterEmail.setHorizontalAlignment(SwingConstants.LEFT);
		ImageIcon img = new ImageIcon(getClass().getResource("/Smiley1.jpg"));
		lblEnterEmail.setIcon(img);
		lblEnterEmail.setBounds(54, 95, 433, 42);
		contentPane.add(lblEnterEmail);

		tfEnterEmail = new JTextField();
		tfEnterEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfEnterEmail.setBackground(new Color(204, 255, 255));
		tfEnterEmail.setBounds(54, 136, 280, 23);
		contentPane.add(tfEnterEmail);
		tfEnterEmail.setColumns(10);

		JButton btnSend = new JButton("Send");
		btnSend.setFont(new Font("Tahoma", Font.ITALIC, 13));
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Random random = new Random();
				int low = 1001;
				int high = 10000;
				randomCode = String.valueOf(random.nextInt(high - low)+low);
				
				//System.out.println(randomCode);
				try {
					Properties props = new Properties();
					InputStream is = new FileInputStream(
							"C:\\eclipse\\workspace\\BookingSerever\\nazivBaze.properties");
					
					props.load(is);

					String from = props.getProperty("email");
					String pass = props.getProperty("emailpass");
					String to = tfEnterEmail.getText();
					String subject = "Reset Code";
					String msg = "Your code is " + randomCode;

					props.setProperty("mail.transport.protocol", "smtp");
					props.setProperty("mail.host", "smtp.gmail.com");
					props.put("mail.smtp.auth", "true");
					props.put("mail.smtp.port", "465");
					props.put("mail.debug", "true");
					props.put("mail.smtp.socketFactory.port", "465");
					props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
					props.put("mail.smtp.socketFactory.fallback", "false");
					Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(from, pass);
						}
					});

					// session.setDebug(true);

					Transport transport = session.getTransport();
					InternetAddress addressFrom = new InternetAddress(from);

					MimeMessage message = new MimeMessage(session);
					message.setSender(addressFrom);
					message.setSubject(subject);
					message.setContent(msg, "text/plain");
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

					transport.connect();
					Transport.send(message);
					transport.close();

				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});

		btnSend.setBackground(Color.CYAN);
		btnSend.setBounds(245, 182, 89, 23);
		contentPane.add(btnSend);

		JLabel lblVerifyCode = new JLabel("Verify code");
		lblVerifyCode.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblVerifyCode.setBounds(54, 228, 86, 14);
		contentPane.add(lblVerifyCode);

		tfVerifyCode = new JTextField();
		tfVerifyCode.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfVerifyCode.setBackground(new Color(204, 255, 255));
		tfVerifyCode.setBounds(54, 257, 86, 20);
		contentPane.add(tfVerifyCode);
		tfVerifyCode.setColumns(10);

		JButton btnVerify = new JButton("Verify");
		btnVerify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (String.valueOf(tfVerifyCode.getText()).equals(randomCode)) {
					
					String email = tfEnterEmail.getText();
				
					ResetPassword resetPassword;
					try {
						resetPassword = new ResetPassword(email);
						resetPassword.setVisible(true);
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				
				} else {
					JOptionPane.showMessageDialog(null, "“Wrong code, please try again”");
				}

			}

			
		});
		btnVerify.setFont(new Font("Tahoma", Font.ITALIC, 13));
		btnVerify.setBackground(new Color(0, 255, 255));
		btnVerify.setBounds(245, 256, 89, 23);
		contentPane.add(btnVerify);

	}

	

}


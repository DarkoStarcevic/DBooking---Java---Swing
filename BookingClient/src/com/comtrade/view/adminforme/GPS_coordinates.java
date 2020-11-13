package com.comtrade.view.adminforme;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GPS_coordinates extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblGps;

	
	public GPS_coordinates() {
		setTitle("GPS coordinates");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 263);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLongitude = new JLabel("Longitude");
		lblLongitude.setOpaque(true);
		//lblLongitude.setBackground(new Color(0,0,0,55));
		lblLongitude.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblLongitude.setBounds(36, 104, 91, 22);
		contentPane.add(lblLongitude);
		
		JLabel lblLatitude = new JLabel("Latitude");
		lblLatitude.setOpaque(true);
		//lblLatitude.setBackground(new Color(0,0,0,55));
		lblLatitude.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblLatitude.setBounds(36, 71, 91, 22);
		contentPane.add(lblLatitude);
		
		textField = new JTextField();
		textField.setBounds(137, 73, 210, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(137, 106, 210, 20);
		contentPane.add(textField_1);
		
		JButton btnNewButton = new JButton("Insert");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				JOptionPane.showMessageDialog(null, " GPS coordinates successfully added");
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnNewButton.setBounds(175, 156, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Please enter Decimal degrees (DD) : ( e.g.  41.40338, 2.17403 )");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(0, 0, 434, 22);
		contentPane.add(lblNewLabel);
		
		lblGps = new JLabel("");
		lblGps.setBounds(0, 0, 434, 230);
		lblGps.setOpaque(true);
		lblGps.setBackground(new Color(0,0,0,100));
		ImageIcon img = new ImageIcon(getClass().getResource("/Latitude+and+Longitude.jpg"));
		lblGps.setIcon(img);
		contentPane.add(lblGps);
	}
}

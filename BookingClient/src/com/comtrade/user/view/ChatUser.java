package com.comtrade.user.view;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.comtrade.controlerUI.ControlerUI;
import com.comtrade.domen.Message;
import com.comtrade.domen.Operations;
import com.comtrade.domen.Residence;
import com.comtrade.domen.User;
import com.comtrade.transfer.TransferClass;

import messageThreads.MessageReader;
import messageThreads.MessageWriter;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;
import java.awt.event.ActionEvent;

public class ChatUser extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField tfUsername;
	private JTextField tfPoruka;
	private JTextArea textArea;
	private Message message;
	private int idUser;
	private int idResidence;
	private List<User>userList;
	private String username;
	private PrintWriter printWriter;
	private BufferedReader bufferedReader;
	
	public ChatUser(int id_usera, int id_residence) throws ClassNotFoundException, IOException {
		this.idUser = id_usera;
		this.idResidence = id_residence;
		userList = (List<User>) ControlerUI.getInstanca().getUserListBack().getServer_object_response();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(62, 44, 93, 14);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 130, 376, 194);
		contentPane.add(scrollPane);
		
		 textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JLabel lblNewLabel_1 = new JLabel("Poruka");
		lblNewLabel_1.setBounds(29, 342, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		tfPoruka = new JTextField();
		tfPoruka.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					slanjePoruke();
				}
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		tfPoruka.setBounds(85, 339, 221, 20);
		contentPane.add(tfPoruka);
		tfPoruka.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Posalji");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(User user : userList) {
					if(user.getId_usera() == id_usera) {
						username = user.getUsername();
					}
				}
				
			
				
					
					bufferedReader = new BufferedReader(bufferedReader);
					try {
						printWriter = new PrintWriter(username) ;
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					printWriter.println(username);
					MessageWriter writer = new MessageWriter(printWriter, message);
					MessageReader reader = new MessageReader(bufferedReader, textArea);
				
				
				slanjePoruke();
			}
		});
		btnNewButton_1.setBounds(316, 338, 89, 23);
		contentPane.add(btnNewButton_1);
	}
	public void ocistiPolja() {
		tfPoruka.setText("");
	}
	
	public void slanjePoruke() {
		String porukaZaSlanje = tfPoruka.getText();
		textArea.append("\n Ja kazem :"+porukaZaSlanje+"\n");
		message.setMessage(porukaZaSlanje);
		ocistiPolja();
	}
}

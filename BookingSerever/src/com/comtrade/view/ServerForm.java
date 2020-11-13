package com.comtrade.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.comtrade.controlerBL.ControlerBL;
import com.comtrade.threads.ServerThread;

public class ServerForm extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblText;
	private JTextArea textArea;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerForm frame = new ServerForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	
	public ServerForm() {
		setTitle("Server");
		setBackground(Color.CYAN);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 505);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setForeground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnStart = new JButton("Start server");
		btnStart.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnStart.setForeground(Color.BLACK);
		btnStart.setBackground(SystemColor.activeCaption);
		btnStart.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnStart.setSelectedIcon(null);
		btnStart.setBounds(248, 31, 187, 23);
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ServerThread st= new ServerThread(textArea);
				st.start();
				lblText.setText("The server is up and running");
				btnStart.setEnabled(false);
			}
		});
		
		contentPane.setLayout(null);
		contentPane.add(btnStart);
		
	    lblNewLabel = new JLabel("");
	    lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		ImageIcon img = new ImageIcon(getClass().getResource("/server.jpg"));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(128, 99, 431, 142);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
		textArea.setEditable(false);
		textArea.setWrapStyleWord(true);
		scrollPane.setViewportView(textArea);
		ControlerBL.getInstanca().setFrame(this);
		
		lblText = new JLabel("");
		lblText.setForeground(Color.WHITE);
		lblText.setBackground(Color.WHITE);
		lblText.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblText.setHorizontalAlignment(SwingConstants.CENTER);
		lblText.setBounds(218, 65, 248, 23);
		contentPane.add(lblText);
		lblNewLabel.setBounds(0, 0, 671, 474);
		lblNewLabel.setIcon(img);
		contentPane.add(lblNewLabel);
		
		
		
	}

	public void setTextArea(String text) {
		textArea.append(text);
		
	}
}

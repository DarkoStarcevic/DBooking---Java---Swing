package com.comtrade.threads;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import com.comtrade.constants.Constants;
import com.comtrade.controlerBL.ControlerBL;



public class ServerThread extends Thread {
	
	private JTextArea textArea;
	
	
	public ServerThread(JTextArea textArea) {
		super();
		this.textArea = textArea;
	}
	

	public void run() {
		startServer();
	}

	private void startServer() {
		try {
			ServerSocket  serverSocket = new ServerSocket(Constants.PORT.getPort());
			ControlerBL.getInstanca().setUserInfoOnServer(textArea.getSelectedText());
			while(true) {
				Socket socket = serverSocket.accept();
				ClientThread klijentThread = new ClientThread();
				klijentThread.setSocket(socket);
				klijentThread.start();
			}
		} catch (IOException e) {
			
			JOptionPane.showMessageDialog(null, "Server already started");
			System.exit(0);
			e.printStackTrace();
		}
		
	}

}

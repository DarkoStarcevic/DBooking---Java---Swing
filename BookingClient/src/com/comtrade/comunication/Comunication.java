package com.comtrade.comunication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import com.comtrade.constants.Constants;
import com.comtrade.transfer.TransferClass;

public class Comunication {
	
	private static Comunication komunikacija;
	private Socket socket;
	
	private Comunication() {
		try {
			socket = new Socket(Constants.IP_ADRESA.getIpAdresa(), Constants.PORT.getPort());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public static Comunication getKomunikacija() {
		if(komunikacija == null) {
			komunikacija = new Comunication();
		}
		return komunikacija;
	}
	public void send(TransferClass transferKlasa) {
		ObjectOutputStream objectOutputStream;
		try {
			objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
			objectOutputStream.writeObject(transferKlasa);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public TransferClass read() throws IOException, ClassNotFoundException {
		
			ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
			return (TransferClass) objectInputStream.readObject();
		
	}

}

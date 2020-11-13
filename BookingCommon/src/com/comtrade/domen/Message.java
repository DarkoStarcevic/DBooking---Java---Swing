package com.comtrade.domen;

import java.io.Serializable;

public class Message implements Serializable {
	private static final long serialVersionUID = 1L;
	private String message;
	
	
	public synchronized String getMessage() {
		
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}

	public synchronized void setMessage(String message) {
		this.message = message;
		
		notify();
	}

	

	
}

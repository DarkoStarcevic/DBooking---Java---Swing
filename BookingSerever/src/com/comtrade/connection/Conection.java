package com.comtrade.connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conection {
	
	
	private static volatile Conection konekcija;
	private Connection connection;
	private Conection() {
		//ucitajDriver();
		
	}
	
	public Connection getConnection() {
		return connection;
	}

	/*private void ucitajDriver() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}*/
	public static Conection getKonekcija() {
		if(konekcija == null) {
			synchronized (Conection.class) {
				if(konekcija == null) {
					konekcija = new Conection();
				}
				
			}
		}
		return konekcija;
	}
	
	
	public void startTransakcije() {
		try {
			Properties prop = new Properties();
			InputStream is = new FileInputStream("/Users/darko/eclipse-workspace/BookingSerever/baseName.properties");
			prop.load(is);                     
				
			String url = prop.getProperty("url");
			String username = prop.getProperty("username");
			String password = prop.getProperty("password");
			
		    connection = DriverManager.getConnection(url,username,password);
			connection.setAutoCommit(false);
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
			
	
	public void potvrdiTransakciju() {
		try {
			connection.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void ponistiTransakciju() {
		try {
			connection.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void zatvoriKonekciju() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}

package com.comtrade.domen;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Payment implements GeneralDomen, Serializable {
	
	private int id_payment;
	private int id_usera;
	private int id_residence;
	private int id_reservation;
	private double price;
	private String type_of_payment;
	private String card_number;
	private String security_code;
	
	
	public Payment(int id_payment, int id_usera, int id_residence, int id_reservation, double price,
			String type_of_payment, String card_number, String security_code) {
		super();
		this.id_payment = id_payment;
		this.id_usera = id_usera;
		this.id_residence = id_residence;
		this.id_reservation = id_reservation;
		this.price = price;
		this.type_of_payment = type_of_payment;
		this.card_number = card_number;
		this.security_code = security_code;
	}

	public Payment() {
		super();
	}

	public int getId_payment() {
		return id_payment;
	}

	public void setId_payment(int id_payment) {
		this.id_payment = id_payment;
	}

	public int getId_usera() {
		return id_usera;
	}

	public void setId_usera(int id_usera) {
		this.id_usera = id_usera;
	}

	public int getId_residence() {
		return id_residence;
	}

	public void setId_residence(int id_residence) {
		this.id_residence = id_residence;
	}

	public int getId_reservation() {
		return id_reservation;
	}

	public void setId_reservation(int id_reservation) {
		this.id_reservation = id_reservation;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getType_of_payment() {
		return type_of_payment;
	}

	public void setType_of_payment(String type_of_payment) {
		this.type_of_payment = type_of_payment;
	}

	public String getCard_number() {
		return card_number;
	}

	public void setCard_number(String card_number) {
		this.card_number = card_number;
	}

	public String getSecurity_code() {
		return security_code;
	}

	public void setSecurity_code(String security_code) {
		this.security_code = security_code;
	}

	@Override
	public String vratiNazivTabele() {
		// TODO Auto-generated method stub
		return " payment ";
	}

	@Override
	public String vratiKolone() {
		// TODO Auto-generated method stub
		return "(id_usera, id_residence, id_reservation, price, type_of_payment, card_number, security_code )";
	}

	@Override
	public PreparedStatement vratiInsert(PreparedStatement ps) {
		try {
			ps.setInt(1, id_usera);
			ps.setInt(2, id_residence);
			ps.setInt(3, id_reservation);
			ps.setDouble(4, price);
			ps.setString(5, type_of_payment);
			ps.setString(6, card_number);
			ps.setString(7, security_code);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ps;
	}

	@Override
	public String vratiZnakove() {
		// TODO Auto-generated method stub
		return " values (?, ?, ?, ?, ?, ?, ?) ";
	}

	@Override
	public List<GeneralDomen> returnData(ResultSet resultSet) {
		List<GeneralDomen>list = new ArrayList<>(); 
		
		try {
			while(resultSet.next()) {
				Payment payment = new Payment();
				
				payment.setId_payment(resultSet.getInt("id_payment"));
				payment.setId_usera(resultSet.getInt("id_usera"));
				payment.setId_residence(resultSet.getInt("id_residence"));
				payment.setId_reservation(resultSet.getInt("id_reservation"));
				payment.setPrice(resultSet.getDouble("price"));
				payment.setType_of_payment(resultSet.getString("type_of_payment"));
				payment.setCard_number(resultSet.getString("card_number"));
				payment.setSecurity_code(resultSet.getString("security_code"));
				list.add(payment);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public String vratiKoloneUpdate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return "id_payment";
	}

	@Override
	public PreparedStatement preparedStatementUpdate(PreparedStatement preparedStatement) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public PreparedStatement preparedStatementDelete(PreparedStatement preparedStatement) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GeneralDomen vratiPoslednjiPodatak(ResultSet resultSet) {
		Payment payment = new Payment();
		
		try {
			if(resultSet.next()) {
				payment.setId_payment(resultSet.getInt("id_payment"));
				payment.setId_usera(resultSet.getInt("id_usera"));
				payment.setId_residence(resultSet.getInt("id_residence"));
				payment.setId_reservation(resultSet.getInt("id_reservation"));
				payment.setPrice(resultSet.getDouble("price"));
				payment.setType_of_payment(resultSet.getString("type_of_payment"));
				payment.setCard_number(resultSet.getString("card_number"));
				payment.setSecurity_code(resultSet.getString("security_code"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return payment;
		
	}

	@Override
	public String getForeignKeyId() {
		// TODO Auto-generated method stub
		return "id_reservation";
	}

	
}

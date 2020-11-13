package com.comtrade.domen;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Destination implements GeneralDomen, Serializable {
	
	private int id_destination;
	private int id_residence;
	private String country;
	private String city;
	private String address;
	private String zipcode;
	private String phone_number;
	private String email;
	public Destination(int id_destination, int id_residence, String country, String city, String address, String zipcode, String phone_number, String email) {
		super();
		this.id_destination = id_destination;
		this.id_residence = id_residence;
		this.country = country;
		this.city = city;
		this.address = address;
		this.zipcode = zipcode;
		this.phone_number = phone_number;
		this.email = email;
	}
	public Destination() {
		super();
		
	}
	

	public int getId_destination() {
		return id_destination;
	}
	public void setId_destination(int id_destination) {
		this.id_destination = id_destination;
	}
	public int getId_residence() {
		return id_residence;
	}
	public void setId_residence(int id_residence) {
		this.id_residence = id_residence;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phoneNumber) {
		this.phone_number = phoneNumber;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String vratiNazivTabele() {
		// TODO Auto-generated method stub
		return " destination ";
	}
	@Override
	public String vratiKolone() {
		// TODO Auto-generated method stub
		return " ( country, city, address, zipcode, phone_number, email, id_residence ) "; 
	}
	@Override
	public PreparedStatement vratiInsert(PreparedStatement ps) {
		try {
			ps.setString(1, country);
			ps.setString(2, city);
			ps.setString(3, address);
			ps.setString(4, zipcode);
			ps.setString(5, phone_number);
			ps.setString(6, email);
			ps.setInt(7, id_residence);
			
			
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
				Destination destination = new Destination();
				
				destination.setId_destination(resultSet.getInt("id_destination"));
				destination.setCountry(resultSet.getString("country"));
				destination.setCity(resultSet.getString("city"));
				destination.setAddress(resultSet.getString("address"));
				destination.setZipcode(resultSet.getString("zipcode"));
				destination.setPhone_number(resultSet.getString("phone_number"));
				destination.setEmail(resultSet.getString("email"));
				destination.setId_residence(resultSet.getInt("id_residence"));
				list.add(destination);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public String vratiKoloneUpdate() {
		
		return " country = ?, city = ?, address = ?, zipcode = ?, phone_number = ?, email = ?  " ;
				
	}
	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return "id_destination";
	}
	@Override
	public PreparedStatement preparedStatementUpdate(PreparedStatement preparedStatement) {
		try {
			preparedStatement.setString(1, country);
			preparedStatement.setString(2, city);
			preparedStatement.setString(3, address);
			preparedStatement.setString(4, zipcode);
			preparedStatement.setString(5, phone_number);
			preparedStatement.setString(6, email);
			preparedStatement.setInt(7, id_destination);
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return preparedStatement;
	}
	
	@Override
	public PreparedStatement preparedStatementDelete(PreparedStatement preparedStatement) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public GeneralDomen vratiPoslednjiPodatak(ResultSet resultSet) {
		Destination destination = new Destination();
		try {
			if(resultSet.next()) {
				
				destination.setId_destination(resultSet.getInt("id_destination"));
				destination.setCountry(resultSet.getString("country"));
				destination.setCity(resultSet.getString("city"));
				destination.setAddress(resultSet.getString("address"));
				destination.setZipcode(resultSet.getString("zipcode"));
				destination.setPhone_number(resultSet.getString("phone_number"));
				destination.setEmail(resultSet.getString("email"));
				destination.setId_residence(resultSet.getInt("id_residence"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return destination;
	}
	
	@Override
	public String getForeignKeyId() {
		// TODO Auto-generated method stub
		return " id_residence ";
	}
	

	
	
	
	
}

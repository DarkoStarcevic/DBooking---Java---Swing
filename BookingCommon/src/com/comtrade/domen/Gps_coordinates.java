package com.comtrade.domen;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Gps_coordinates implements Serializable, GeneralDomen {
	
	private int id_gps_coordinates;	
	private int id_destination;
	private String latitude;	
	private String longitude;
	
	

	public Gps_coordinates(int id_gps_coordinates, int id_destination, String latitude, String longitude) {
		super();
		this.id_gps_coordinates = id_gps_coordinates;
		this.id_destination = id_destination;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	

	public int getId_gps_coordinates() {
		return id_gps_coordinates;
	}



	public void setId_gps_coordinates(int id_gps_coordinates) {
		this.id_gps_coordinates = id_gps_coordinates;
	}



	public int getId_destination() {
		return id_destination;
	}



	public void setId_destination(int id_destination) {
		this.id_destination = id_destination;
	}



	public String getLatitude() {
		return latitude;
	}



	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}



	public String getLongitude() {
		return longitude;
	}



	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}



	@Override
	public String vratiNazivTabele() {
		// TODO Auto-generated method stub
		return " gps_coordinates ";
	}

	@Override
	public String vratiKolone() {
		// TODO Auto-generated method stub
		return " ( id_destination, latitude, longitude ) ";  
	}

	@Override
	public PreparedStatement vratiInsert(PreparedStatement ps) {
		try {
			ps.setInt(1, id_destination);
			ps.setString(2, latitude);
			ps.setString(3, longitude);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return ps;
	}

	@Override
	public String vratiZnakove() {
		// TODO Auto-generated method stub
		return " values (?, ?, ?) "; 
	}

	@Override
	public List<GeneralDomen> returnData(ResultSet resultSet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String vratiKoloneUpdate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return " id_gps_coordinates ";
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
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public String getForeignKeyId() {
		// TODO Auto-generated method stub
		return null;
	}


}

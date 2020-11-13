package com.comtrade.domen;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Room_Info implements GeneralDomen, Serializable {
	
	private int id_room_info;
	private int id_room;
	private boolean AC;				
	private boolean WiFi;
	private boolean balcony;
	private boolean TV;
	private boolean kitchen;
	private boolean private_bathroom;
	private boolean parking;
	private boolean restaurant;
	private String description;
	
	public Room_Info() {
		super();
	}

	public Room_Info(int id_room_info, int id_room, boolean aC, boolean wiFi, boolean balcony, boolean tV,
			boolean kitchen, boolean private_bathroom, boolean parking, boolean restaurant, String description) {
		super();
		this.id_room_info = id_room_info;
		this.id_room = id_room;
		this.AC = aC;
		this.WiFi = wiFi;
		this.balcony = balcony;
		this.TV = tV;
		this.kitchen = kitchen;
		this.private_bathroom = private_bathroom;
		this.parking = parking;
		this.restaurant = restaurant;
		this.description = description;
	}

	public int getId_room_info() {
		return id_room_info;
	}

	public void setId_room_info(int id_room_info) {
		this.id_room_info = id_room_info;
	}

	public int getId_room() {
		return id_room;
	}

	public void setId_room(int id_room) {
		this.id_room = id_room;
	}
	
	

	public boolean isAC() {
		return AC;
	}



	public void setAC(boolean aC) {
		AC = aC;
	}



	public boolean isWiFi() {
		return WiFi;
	}



	public void setWiFi(boolean wiFi) {
		WiFi = wiFi;
	}



	public boolean isBalcony() {
		return balcony;
	}



	public void setBalcony(boolean balcony) {
		this.balcony = balcony;
	}



	public boolean isTV() {
		return TV;
	}



	public void setTV(boolean tV) {
		TV = tV;
	}



	public boolean isKitchen() {
		return kitchen;
	}



	public void setKitchen(boolean kitchen) {
		this.kitchen = kitchen;
	}



	public boolean isPrivate_bathroom() {
		return private_bathroom;
	}



	public void setPrivate_bathroom(boolean private_bathroom) {
		this.private_bathroom = private_bathroom;
	}



	public boolean isParking() {
		return parking;
	}



	public void setParking(boolean parking) {
		this.parking = parking;
	}



	public boolean isRestaurant() {
		return restaurant;
	}



	public void setRestaurant(boolean restaurant) {
		this.restaurant = restaurant;
	}

	


	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	@Override
	public String vratiNazivTabele() {
		
		return " room_info ";
	}

	@Override
	public String vratiKolone() {
		
		return " ( AC, WIFI, balcony, TV, kitchen, private_bathroom, parking, restaurant, description, id_room ) ";   
		
	}

	@Override
	public PreparedStatement vratiInsert(PreparedStatement ps) {
		try {
			
			ps.setBoolean(1, AC);
			ps.setBoolean(2, WiFi);
			ps.setBoolean(3, balcony);
			ps.setBoolean(4, TV);
			ps.setBoolean(5, kitchen);
			ps.setBoolean(6, private_bathroom);
			ps.setBoolean(7, parking);
			ps.setBoolean(8, restaurant);
			ps.setString(9, description);
			ps.setInt(10, id_room);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return ps;
	}

	@Override
	public String vratiZnakove() {
		// TODO Auto-generated method stub
		return " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";       
	}

	@Override
	public List<GeneralDomen> returnData(ResultSet resultSet) {
		List<GeneralDomen>list = new ArrayList<>();
		try {
			while(resultSet.next()) {
				Room_Info room_Info = new Room_Info();
				
				room_Info.setId_room_info(resultSet.getInt("id_room_info"));
				room_Info.setAC(resultSet.getBoolean("AC"));
				room_Info.setWiFi(resultSet.getBoolean("WIFI"));
				room_Info.setBalcony(resultSet.getBoolean("balcony"));
				room_Info.setTV(resultSet.getBoolean("TV"));
				room_Info.setKitchen(resultSet.getBoolean("kitchen"));
				room_Info.setPrivate_bathroom(resultSet.getBoolean("private_bathroom"));
				room_Info.setParking(resultSet.getBoolean("parking"));
				room_Info.setRestaurant(resultSet.getBoolean("restaurant"));
				room_Info.setDescription(resultSet.getString("description"));
				room_Info.setId_room(resultSet.getInt("id_room"));
				list.add(room_Info);
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
		return "id_room_info";
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
		Room_Info room_Info= new Room_Info();
		try {
			if(resultSet.next()) {
				
				room_Info.setId_room_info(resultSet.getInt("id_room_info"));
				room_Info.setAC(resultSet.getBoolean("AC"));
				room_Info.setWiFi(resultSet.getBoolean("WIFI"));
				room_Info.setBalcony(resultSet.getBoolean("balcony"));
				room_Info.setTV(resultSet.getBoolean("TV"));
				room_Info.setKitchen(resultSet.getBoolean("kitchen"));
				room_Info.setPrivate_bathroom(resultSet.getBoolean("private_bathroom"));
				room_Info.setParking(resultSet.getBoolean("parking"));
				room_Info.setRestaurant(resultSet.getBoolean("restaurant"));
				room_Info.setDescription(resultSet.getString("description"));
				room_Info.setId_room(resultSet.getInt("id_room"));

			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return room_Info;
	}

	@Override
	public String getForeignKeyId() {
		// TODO Auto-generated method stub
		return null;
	}


}

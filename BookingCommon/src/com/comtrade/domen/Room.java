package com.comtrade.domen;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Room implements GeneralDomen, Serializable {
	
	private int id_room;
	private int id_residence;
	private String number_of_beds;
	private double price_per_night;
	private int room_size;
	private String room_type;
	private int number_of_rooms;

	
	public Room(int id_room, int id_residence,String number_of_beds, double price_per_night, int room_size, String room_type, int number_of_rooms) {
		super();
		this.id_room = id_room;
		this.id_residence = id_residence;
		this.number_of_beds = number_of_beds;
		this.price_per_night = price_per_night;
		this.room_size = room_size;
		this.room_type = room_type;
		this.number_of_rooms = number_of_rooms;
	}
	
/*
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((room_type == null) ? 0 : room_type.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		if (room_type == null) {
			if (other.room_type != null)
				return false;
		} else if (!room_type.equals(other.room_type))
			return false;
		return true;
	}
*/

	public Room() {
		super();
	}

	public int getId_room() {
		return id_room;
	}

	public void setId_room(int id_room) {
		this.id_room = id_room;
	}

	public int getId_residence() {
		return id_residence;
	}

	public void setId_residence(int id_residence) {
		this.id_residence = id_residence;
	}

	public String getNumber_of_beds() {
		return number_of_beds;
	}

	public void setNumber_of_beds(String number_of_beds) {
		this.number_of_beds = number_of_beds;
	}
	
	public int getNumber_of_rooms() {
		return number_of_rooms;
	}

	public void setNumber_of_rooms(int number_of_rooms) {
		this.number_of_rooms = number_of_rooms;
	}

	public double getPrice_per_night() {
		return price_per_night;
	}

	public void setPrice_per_night(double price_per_night) {
		this.price_per_night = price_per_night;
	}
	
	public int getRoom_size() {
		return room_size;
	}

	public void setRoom_size(int room_size) {
		this.room_size = room_size;
	}

	public String getRoom_type() {
		return room_type;
	}

	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}

	@Override
	public String vratiNazivTabele() {
		
		return " room ";
	}

	@Override
	public String vratiKolone() {
		// TODO Auto-generated method stub
		return " ( room_type, number_of_rooms, number_of_beds, price_per_night, room_size, id_residence ) "; 
			
	} 

	@Override
	public PreparedStatement vratiInsert(PreparedStatement ps) {
		try {
			
			ps.setString(1, room_type);
			ps.setInt(2, number_of_rooms);
			ps.setString(3, number_of_beds);
			ps.setDouble(4, price_per_night);
			ps.setInt(5, room_size);
			ps.setInt(6, id_residence);
			
	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return ps;
	}

	@Override
	public String vratiZnakove() {
		// TODO Auto-generated method stub
		return " values (?, ?, ?, ?, ?, ?) ";    
	}

	

	@Override
	public List<GeneralDomen> returnData(ResultSet resultSet) {
		List<GeneralDomen>list = new ArrayList<>();
		try {
			while(resultSet.next()) {
				Room room = new Room();
				
				room.setId_room(resultSet.getInt("id_room"));
				room.setRoom_type(resultSet.getString("room_type"));
				room.setNumber_of_rooms(resultSet.getInt("number_of_rooms"));
				room.setNumber_of_beds(resultSet.getString("number_of_beds"));
				room.setPrice_per_night(resultSet.getDouble("price_per_night"));
				room.setRoom_size(resultSet.getInt("room_size"));
				room.setId_residence(resultSet.getInt("id_residence"));
				list.add(room);

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
	public PreparedStatement preparedStatementUpdate(PreparedStatement preparedStatement) {
		return null;
		
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return "id_room";
	}

	@Override
	public PreparedStatement preparedStatementDelete(PreparedStatement preparedStatement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GeneralDomen vratiPoslednjiPodatak(ResultSet resultSet) {
		Room room = new Room();
		try {
			if(resultSet.next()) {
				
				room.setId_room(resultSet.getInt("id_room"));
				room.setRoom_type(resultSet.getString("room_type"));
				room.setNumber_of_rooms(resultSet.getInt("number_of_rooms"));
				room.setNumber_of_beds(resultSet.getString("number_of_beds"));
				room.setPrice_per_night(resultSet.getDouble("price_per_night"));
				room.setRoom_size(resultSet.getInt("room_size"));
				room.setId_residence(resultSet.getInt("id_residence"));
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return room;
	}

	@Override
	public String getForeignKeyId() {
		// TODO Auto-generated method stub
		return null;
	}
	

}

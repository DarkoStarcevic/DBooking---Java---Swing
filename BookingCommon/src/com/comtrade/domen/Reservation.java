package com.comtrade.domen;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Reservation implements GeneralDomen, Serializable{
	
	private int id_reservation;
	private int id_usera;
	private int id_residence;
	private int id_room;
	private LocalDate check_in_date;
	private LocalDate check_out_date;
	private int number_of_rooms;
	private int number_of_adults;
	private int number_of_children;
	private double total_price;
	
	
	
	
	public Reservation(int id_reservation, int id_usera, int id_residence, int id_room, LocalDate check_in_date,
			LocalDate check_out_date, int number_of_rooms, int number_of_adults, int number_of_children,
			double total_price) {
		super();
		this.id_reservation = id_reservation;
		this.id_usera = id_usera;
		this.id_residence = id_residence;
		this.id_room = id_room;
		this.check_in_date = check_in_date;
		this.check_out_date = check_out_date;
		this.number_of_rooms = number_of_rooms;
		this.number_of_adults = number_of_adults;
		this.number_of_children = number_of_children;
		this.total_price = total_price;
	}

	public Reservation() {
		super();
	}

	public int getId_reservation() {
		return id_reservation;
	}

	public void setId_reservation(int id_reservation) {
		this.id_reservation = id_reservation;
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

	public int getId_room() {
		return id_room;
	}

	public void setId_room(int id_room) {
		this.id_room = id_room;
	}

	public LocalDate getCheck_in_date() {
		return check_in_date;
	}

	public void setCheck_in_date(LocalDate check_in_date) {
		this.check_in_date = check_in_date;
	}

	public LocalDate getCheck_out_date() {
		return check_out_date;
	}

	public void setCheck_out_date(LocalDate check_out_date) {
		this.check_out_date = check_out_date;
	}

	public int getNumber_of_rooms() {
		return number_of_rooms;
	}

	public void setNumber_of_rooms(int number_of_rooms) {
		this.number_of_rooms = number_of_rooms;
	}

	public int getNumber_of_adults() {
		return number_of_adults;
	}

	public void setNumber_of_adults(int number_of_adults) {
		this.number_of_adults = number_of_adults;
	}

	public int getNumber_of_children() {
		return number_of_children;
	}

	public void setNumber_of_children(int number_of_children) {
		this.number_of_children = number_of_children;
	}
	
	public double getTotal_price() {
		return total_price;
	}

	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}

	@Override
	public String vratiNazivTabele() {
		
		return " reservation ";
	}

	@Override
	public String vratiKolone() {
		
		return "(id_usera, id_residence, id_room, check_in_date, check_out_date, number_of_rooms, number_of_adults, number_of_children, total_price)";
	}

	@Override
	public PreparedStatement vratiInsert(PreparedStatement ps) {
		
		try {
			ps.setInt(1, id_usera);
			ps.setInt(2, id_residence);
			ps.setInt(3, id_room);
			ps.setDate(4, java.sql.Date.valueOf(check_in_date));
			ps.setDate(5, java.sql.Date.valueOf(check_out_date));
			ps.setInt(6, number_of_rooms);
			ps.setInt(7, number_of_adults);
			ps.setInt(8, number_of_children);
			ps.setDouble(9, total_price);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return ps;
	
	}

	@Override
	public String vratiZnakove() {
		
		return " values (?, ?, ?, ?, ?, ?, ?, ?, ?) ";
	}

	@Override
	public List<GeneralDomen> returnData(ResultSet resultSet) {
		
		List<GeneralDomen> list = new ArrayList<>();
		try {
			while (resultSet.next()) {
				Reservation reservation = new Reservation();

				reservation.setId_reservation(resultSet.getInt("id_reservation"));
				reservation.setId_residence(resultSet.getInt("id_residence"));
				reservation.setId_usera(resultSet.getInt("id_usera"));
				reservation.setId_room(resultSet.getInt("id_room"));
				reservation.setCheck_in_date(resultSet.getDate("check_in_date").toLocalDate());
				reservation.setCheck_out_date(resultSet.getDate("check_out_date").toLocalDate());
				reservation.setNumber_of_rooms(resultSet.getInt("number_of_rooms"));
				reservation.setNumber_of_adults(resultSet.getInt("number_of_adults"));
				reservation.setNumber_of_children(resultSet.getInt("number_of_children"));
				reservation.setTotal_price(resultSet.getDouble("total_price"));
				list.add(reservation);

			}
		} catch (SQLException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}


	@Override
	public String vratiKoloneUpdate() {
		// TODO Auto-generated method stub
		return "  id_reservation " ;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return "id_reservation";
	}

	@Override
	public PreparedStatement preparedStatementUpdate(PreparedStatement preparedStatement) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public PreparedStatement preparedStatementDelete(PreparedStatement preparedStatement) throws SQLException {
	
		preparedStatement.setInt(1, id_reservation);
		return preparedStatement;
	}

	@Override
	public GeneralDomen vratiPoslednjiPodatak(ResultSet resultSet) {
		
		Reservation reservation = new Reservation();
		try {
			if(resultSet.next()) {
				
				reservation.setId_reservation(resultSet.getInt("id_reservation"));
				reservation.setId_residence(resultSet.getInt("id_residence"));
				reservation.setId_room(resultSet.getInt("id_usera"));
				reservation.setId_room(resultSet.getInt("id_room"));
				reservation.setCheck_in_date(resultSet.getDate("check_in_date").toLocalDate());
				reservation.setCheck_in_date(resultSet.getDate("check_out_date").toLocalDate());
				reservation.setId_room(resultSet.getInt("number_of_rooms"));
				reservation.setId_room(resultSet.getInt("number_of_adults"));
				reservation.setId_room(resultSet.getInt("number_of_children"));
				reservation.setTotal_price(resultSet.getDouble("total_price"));		
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reservation;
	}
	
	public List<Reservation>checkAvailability(ResultSet resultSet){
		List<Reservation>list = new ArrayList<>();
		try {
		while(resultSet.next()) {
			Reservation reservation1 = new Reservation();
			reservation1.setId_reservation(resultSet.getInt("id_reservation"));
			reservation1.setId_residence(resultSet.getInt("id_residence"));
			reservation1.setId_room(resultSet.getInt("id_usera"));
			reservation1.setId_room(resultSet.getInt("id_room"));
			reservation1.setCheck_in_date(resultSet.getDate("check_in_date").toLocalDate());
			reservation1.setCheck_in_date(resultSet.getDate("check_out_date").toLocalDate());
			reservation1.setId_room(resultSet.getInt("number_of_rooms"));
			reservation1.setId_room(resultSet.getInt("number_of_adults"));
			reservation1.setId_room(resultSet.getInt("number_of_children"));
			reservation1.setTotal_price(resultSet.getDouble("total_price"));
			
			list.add(reservation1);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return list;
	
		
	}

	@Override
	public String getForeignKeyId() {
		// TODO Auto-generated method stub
		return " id_reservation ";
	}

	

}

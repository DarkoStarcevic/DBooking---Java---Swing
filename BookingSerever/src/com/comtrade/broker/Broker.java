package com.comtrade.broker;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.comtrade.connection.Conection;
import com.comtrade.domen.GeneralDomen;
import com.comtrade.domen.Reservation;
import com.comtrade.domen.Residence;
import com.comtrade.domen.Review;
import com.comtrade.domen.User;

public class Broker implements IBroker {

	@Override
	public void sacuvaj(GeneralDomen opstiDomen) {
		String insert = "insert into " + opstiDomen.vratiNazivTabele() + " " + opstiDomen.vratiKolone() + " "
				+ opstiDomen.vratiZnakove();

		try {
			PreparedStatement preparedStatement = Conection.getKonekcija().getConnection().prepareStatement(insert);
			preparedStatement = opstiDomen.vratiInsert(preparedStatement);
			preparedStatement.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public User vrati(User opstiDomen) throws SQLException {
		String sql = "select * from  " + opstiDomen.vratiNazivTabele() + " where username =? and password =? ";
		User user = new User();
		try {
			PreparedStatement preparedStatement = Conection.getKonekcija().getConnection().prepareStatement(sql);
			preparedStatement.setString(1, opstiDomen.getUsername());
			preparedStatement.setString(2, opstiDomen.getPassword());

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				user.setStatus(resultSet.getString("status"));
				user.setEmail(resultSet.getString("email"));
				user.setId_usera(resultSet.getInt("id_usera"));
				user.setFirstName(resultSet.getString("first_name"));
				user.setLastName(resultSet.getString("last_name"));
				user.setPhoneNum(resultSet.getString("phone_number"));
			}
		} catch (SQLException e) {
			throw e;
		}
		return user;

	}

	

	public void updatePassword(User user) {

		String sql = "update user " + " set  password = ? " + " where email =? ";
		try {
			PreparedStatement preparedStatement = Conection.getKonekcija().getConnection().prepareStatement(sql);
			preparedStatement = user.preparedStatementUpdatePassword(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<GeneralDomen> list(GeneralDomen opstiDomen) {

		String sql = "select * from " +  opstiDomen.vratiNazivTabele(); // + " " + " WHERE " + " " + opstiDomen.getId();
		List<GeneralDomen> list = null;
		try {
			PreparedStatement preparedStatement = Conection.getKonekcija().getConnection().prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			list = opstiDomen.returnData(resultSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public void update(GeneralDomen opstiDomen) {

		String sql = "update " + opstiDomen.vratiNazivTabele() + " set " + opstiDomen.vratiKoloneUpdate() + " where "
				+ opstiDomen.getId() + " = ? ";

		try {
			PreparedStatement preparedStatement = Conection.getKonekcija().getConnection().prepareStatement(sql);
			preparedStatement = opstiDomen.preparedStatementUpdate(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void delete(GeneralDomen opstiDomen) {

		String sql = "delete  from " + opstiDomen.vratiNazivTabele() + " where " + opstiDomen.getId() + " = ? ";
		try {
			PreparedStatement preparedStatement = Conection.getKonekcija().getConnection().prepareStatement(sql);
			preparedStatement = opstiDomen.preparedStatementDelete(preparedStatement);
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Override
	public void deleteParenRow(GeneralDomen opstiDomen) {
		/*ALTER TABLE `room_info` DROP FOREIGN KEY `room_info_ibfk_1`; ALTER TABLE `room_info` ADD CONSTRAINT `room_info_ibfk_1` 
		FOREIGN KEY (`id_room`) REFERENCES `room`(`id_room`) ON DELETE CASCADE ON UPDATE RESTRICT;*/
		
	String sql = " delete from "+opstiDomen.vratiNazivTabele()+" where "+opstiDomen.getForeignKeyId()+ " = ?";
		
		PreparedStatement preparedStatement;	
		try {
			preparedStatement = Conection.getKonekcija().getConnection().prepareStatement(sql);
			preparedStatement = opstiDomen.preparedStatementDelete(preparedStatement);
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public GeneralDomen vratiPoslednjiUpisaniPodatak(GeneralDomen opstiDomen) {
		String sql = "select *  from " + opstiDomen.vratiNazivTabele() + "  ORDER BY " + opstiDomen.getId()
				+ " DESC LIMIT 1";
		PreparedStatement preparedStatement;
		GeneralDomen opstiDomen2 = null;
		try {

			preparedStatement = Conection.getKonekcija().getConnection().prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			opstiDomen2 = opstiDomen.vratiPoslednjiPodatak(resultSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return opstiDomen2;
	}

	
	public List<Review> totalRating() {

		List<Review> list = new ArrayList<>();

		// select id_review,id_user,reviews.id_residence,id_reservation, rating,
		// comment, AVG (reviews.rating) AS total FROM reviews INNER JOIN residence ON
		// reviews.id_residence = residence.id_residence GROUP BY reviews.id_residence
		String sql = " select id_review, id_user, reviews.id_residence, id_reservation, rating, comment, AVG(reviews.rating) "
				+ " AS average " + " FROM  reviews  INNER JOIN  residence "
				+ " ON reviews.id_residence = residence.id_residence " + " GROUP BY residence.id_residence ";

		PreparedStatement preparedStatement;
		try {
			preparedStatement = Conection.getKonekcija().getConnection().prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Review review = new Review();
				
				int id_review = resultSet.getInt("id_review");
				int id_user = resultSet.getInt("id_user");
				int id_residence = resultSet.getInt("id_residence");
				int id_reservation = resultSet.getInt("id_reservation");
				double average = resultSet.getDouble("average");
				String comment = resultSet.getString("comment");
				review.setId_review(id_review);
				review.setId_user(id_user);
				review.setId_residence(id_residence);
				review.setId_reservation(id_reservation);
				review.setRating(average);
				review.setComment(comment);
				
				list.add(review);
				
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			

		return list;
	}
	
	public void updateResidenceAvgRating(Residence residence) {
		//UPDATE `residence` SET `avg_rating`=[value-5] WHERE 1
		String sql = "update residence " + " set avg_rating =? " + " where id_residence =? " ;
		try {
			PreparedStatement preparedStatement = Conection.getKonekcija().getConnection().prepareStatement(sql);
			preparedStatement = residence.updateResidenceAvgRating(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public List<Reservation>availableRooms(){
		
		List<Reservation> list = new ArrayList<>();
		LocalDate check_in_date;
		LocalDate check_out_date;
		//SELECT reservation.id_room, room.room_type, (room.number_of_rooms - SUM(reservation.number_of_rooms)) as
		//availableRooms, reservation.check_in_date, reservation.check_out_date FROM
		//room INNER JOIN reservation ON room.id_room = reservation.id_room 
	    //GROUP BY reservation.id_reservation
		
		String sql = " select id_reservation, id_usera, reservation.id_residence, reservation.id_room, check_in_date, check_out_date, number_of_adults, number_of_children, total_price, (room.number_of_rooms - SUM(reservation.number_of_rooms)) "
				+ " AS availableRooms, reservation.check_in_date, reservation.check_out_date " 
				+  " FROM  room  INNER JOIN  reservation "
				+ " ON room.id_room = reservation.id_room " + " GROUP BY reservation.id_reservation ";
		
		PreparedStatement preparedStatement;
		try {
			preparedStatement = Conection.getKonekcija().getConnection().prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Reservation reservation = new Reservation();


				int id_reservation = resultSet.getInt("id_reservation");
				int id_user = resultSet.getInt("id_usera");
				int id_residence = resultSet.getInt("id_residence");
				int id_room = resultSet.getInt("id_room");
				check_in_date = resultSet.getDate("check_in_date").toLocalDate();
				check_out_date = resultSet.getDate("check_out_date").toLocalDate();
				int availableRooms = resultSet.getInt("availableRooms");
				int numberOfAdults = resultSet.getInt("number_of_adults");
				int numberOfChildren = resultSet.getInt("number_of_children");
				double total_price = resultSet.getDouble("total_price");
				
				reservation.setId_reservation(id_reservation);
				reservation.setId_usera(id_user);
				reservation.setId_residence(id_residence);
				reservation.setId_room(id_room);
				reservation.setCheck_in_date(check_in_date);
				reservation.setCheck_out_date(check_out_date);
				reservation.setNumber_of_rooms(availableRooms);
				reservation.setNumber_of_adults(numberOfAdults);
				reservation.setNumber_of_children(numberOfChildren);
				reservation.setTotal_price(total_price);
				list.add(reservation);

			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return list;
		
	}

	
	

}

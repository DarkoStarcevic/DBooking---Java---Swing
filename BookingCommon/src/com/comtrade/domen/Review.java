package com.comtrade.domen;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Review implements GeneralDomen, Serializable {
	
	 private static final long serialVersionUID = 1L;
	
	private int id_review;
	private int id_user;
	private int id_residence;
	private int id_reservation;
	private double rating;
	private String comment;
	
					
	public Review(int id_review, int id_user, int id_residence, int id_reservation, double rating, String comment) {
		super();
		this.id_review = id_review;
		this.id_user = id_user;
		this.id_residence = id_residence;
		this.id_reservation = id_reservation;
		this.rating = rating;
		this.comment = comment;
	}
	
	public Review() {
		super();
	}

	public int getId_review() {
		return id_review;
	}

	public void setId_review(int id_review) {
		this.id_review = id_review;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
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

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String vratiNazivTabele() {
		
		return " reviews " ;
	}

	@Override
	public String vratiKolone() {
		
		return " (id_user, id_residence, id_reservation, rating, comment) ";
	}

	@Override
	public PreparedStatement vratiInsert(PreparedStatement ps) {
		
		try {
			ps.setInt(1, id_user);
			ps.setInt(2, id_residence);
			ps.setInt(3, id_reservation);
			ps.setDouble(4, rating);
			ps.setString(5, comment);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ps;
	}

	@Override
	public String vratiZnakove() {
		
		return " values (?, ?, ?, ?, ?) ";
	}

	@Override
	public List<GeneralDomen> returnData(ResultSet resultSet) {
		List<GeneralDomen> list = new ArrayList<>();
		try {
			while (resultSet.next()) {
				Review review = new Review();
				
				review.setId_review(resultSet.getInt("id_review"));
				review.setId_user(resultSet.getInt("id_user"));
				review.setId_residence(resultSet.getInt("id_residence"));
				review.setId_reservation(resultSet.getInt("id_reservation"));
				review.setRating(resultSet.getDouble("rating"));
				review.setComment(resultSet.getString("comment"));
				list.add(review);

			}
		} catch (SQLException e) { 
			
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
		return "id_review";
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
		
		Review review = new Review();
		try {
			if(resultSet.next()) {
				
				review.setId_review(resultSet.getInt("id_review"));
				review.setId_user(resultSet.getInt("id_user"));
				review.setId_residence(resultSet.getInt("id_residence"));
				review.setId_reservation(resultSet.getInt("id_reservation"));
				review.setRating(resultSet.getDouble("rating"));
				review.setComment(resultSet.getString("comment"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return review;
	}

	@Override
	public String getForeignKeyId() {
		// TODO Auto-generated method stub
		return null;
	}

	

	

}

package com.comtrade.domen;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Residence implements GeneralDomen, Serializable {
	
	
	private int id_residence;
	private String NameOfResidence;
	private String TypeOfResidence;
	private int id_usera;
	private double average_rating;

	
	
	public Residence() {
		super();
	}
	
	

	public Residence(int id_residence) {
	
		this.id_residence = id_residence;
		
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

	public String getNameOfResidence() {
		return NameOfResidence;
	}

	public void setNameOfResidence(String nameOfResidence) {
		NameOfResidence = nameOfResidence;
	}

	public String getTypeOfResidence() {
		return TypeOfResidence;
	}

	public void setTypeOfResidence(String typeOfResidence) {
		TypeOfResidence = typeOfResidence;
	}
	
	public double getAverage_rating() {
		return average_rating;
	}

	public void setAverage_rating(double average_rating) {
		this.average_rating = average_rating;
	}



	@Override
	public String vratiNazivTabele() {
		// TODO Auto-generated method stub
		return " residence ";
	}

	@Override
	public String vratiKolone() {
		// TODO Auto-generated method stub
		return " (name_of_residence, type_of_residence, id_usera, avg_rating) ";   
	}

	@Override
	public PreparedStatement vratiInsert(PreparedStatement ps) {
		try {
		ps.setString(1, NameOfResidence);
		ps.setString(2, TypeOfResidence);
		ps.setInt(3, id_usera);
		ps.setDouble(4, average_rating);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ps;
	}

	@Override
	public String vratiZnakove() {
		// TODO Auto-generated method stub
		return " values (?, ?, ?, ?) ";   
	}

	
	@Override
	public List<GeneralDomen> returnData(ResultSet resultSet) {
	
		List<GeneralDomen> list = new ArrayList<>();
		try {
			while (resultSet.next()) {
				Residence residence = new Residence();

				residence.setId_residence(resultSet.getInt("id_residence"));
				residence.setNameOfResidence(resultSet.getString("name_of_residence"));
				residence.setTypeOfResidence(resultSet.getString("type_of_residence"));
				residence.setId_usera(resultSet.getInt("id_usera"));
				residence.setAverage_rating(resultSet.getDouble("avg_rating"));
				list.add(residence);

			}
		} catch (SQLException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public String vratiKoloneUpdate() {
		// TODO Auto-generated method stub
		return "  name_of_residence = ?, type_of_residence = ? " ;
	}

	

	@Override
	public PreparedStatement preparedStatementUpdate(PreparedStatement preparedStatement) {
		try {
			preparedStatement.setString(1, NameOfResidence);
			preparedStatement.setString(2, TypeOfResidence);
			preparedStatement.setInt(3, id_residence);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return preparedStatement;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return "id_residence";
	}


	@Override
	public PreparedStatement preparedStatementDelete(PreparedStatement preparedStatement) throws SQLException {
		
		preparedStatement.setInt(1, id_residence);
		return preparedStatement;
	}



	@Override
	public GeneralDomen vratiPoslednjiPodatak(ResultSet resultSet) {
		Residence residence= new Residence();
		try {
			if(resultSet.next()) {
				
				residence.setId_residence(resultSet.getInt("id_residence"));
				residence.setNameOfResidence(resultSet.getString("name_of_residence"));
				residence.setTypeOfResidence(resultSet.getString("type_of_residence"));
				residence.setId_usera(resultSet.getInt("id_usera"));
				residence.setAverage_rating(resultSet.getDouble("avg_rating"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return residence;
	}



	@Override
	public String getForeignKeyId() {
		// TODO Auto-generated method stub
		return "id_residence";
	}



	public PreparedStatement updateResidenceAvgRating(PreparedStatement preparedStatement) {
		
		try {
			preparedStatement.setDouble(1, average_rating);
			preparedStatement.setInt(2, id_residence);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return preparedStatement;
	}



}

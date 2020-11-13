package com.comtrade.domen;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class User implements GeneralDomen, Serializable{
	private int id_usera;
	private String username;
	private String password;
	private String email;
	private String status;
	private String firstName;
	private String lastName;
	private String phoneNum;
	
	
	public User(int id_usera, String username, String password, String email, String status, String firstName,
			String lastName, String phoneNum) {
		super();
		this.id_usera = id_usera;
		this.username = username;
		this.password = password;
		this.email = email;
		this.status = status;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNum = phoneNum;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public User() {
		super();
	}
	
	public int getId_usera() {
		return id_usera;
	}


	public void setId_usera(int id_usera) {
		this.id_usera = id_usera;
	}


	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;          
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}


	@Override
	public String vratiNazivTabele() {
		
		return "user";
	}
	@Override
	public String vratiKolone() {
		
		return " (username,  password, email, status, first_name, last_name, phone_number) ";      
	}
	@Override
	public PreparedStatement vratiInsert(PreparedStatement ps) {
		try {
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, email);
			ps.setString(4, status);
			ps.setString(5, firstName);
			ps.setString(6, lastName);
			ps.setString(7, phoneNum);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return ps;
	}
	@Override
	public String vratiZnakove() {
		
		return " values (?,?,?,?,?,?,?) ";
	}



	@Override
	public List<GeneralDomen> returnData(ResultSet resultSet) {
		
		
		
		List<GeneralDomen> list = new ArrayList<>();
		try {
			while (resultSet.next()) {
				User user = new User();
				user.setId_usera(resultSet.getInt("id_usera"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				user.setEmail(resultSet.getString("email"));
				user.setFirstName(resultSet.getString("first_name"));
				user.setLastName(resultSet.getString("last_name"));
				user.setPhoneNum(resultSet.getString("phone_number"));
				user.setStatus(resultSet.getString("status"));
				list.add(user);

			}
		} catch (SQLException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		 
	}


	@Override
	public String vratiKoloneUpdate() {
		// TODO Auto-generated method stub
		return " username =?, password = ?, email = ?, first_name =?, last_name =?, phone_number = ?  "; 
		
	}
	
	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return "id_usera";
	}


	@Override
	public PreparedStatement preparedStatementUpdate(PreparedStatement preparedStatement) {
		try {
			
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, email);
		    preparedStatement.setString(1, username);
		    preparedStatement.setString(4, firstName);
		    preparedStatement.setString(5, lastName);
		    preparedStatement.setString(6, phoneNum);
		    preparedStatement.setInt(7, id_usera);
		   
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return preparedStatement;
		
	}


	

	@Override
	public PreparedStatement preparedStatementDelete(PreparedStatement preparedStatement) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public GeneralDomen vratiPoslednjiPodatak(ResultSet resultSet) {
		// TODO Auto-generated method stub
		return null;
	}

	public PreparedStatement preparedStatementUpdatePassword(PreparedStatement preparedStatement) {
try {
			
			preparedStatement.setString(1, password);
			preparedStatement.setString(2, email);
		   
		   
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return preparedStatement;
	}


	@Override
	public String getForeignKeyId() {
		// TODO Auto-generated method stub
		return null;
	}


	



}

package com.comtrade.domen;


import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhotoAlbum implements GeneralDomen, Serializable {
	
	
	private int id_photo_album;
	private int id_residence;
	private String photo_image;
	
	

	public PhotoAlbum(int id_photo_album, int id_residence, String photo_image) {
		super();
		this.id_photo_album = id_photo_album;
		this.id_residence = id_residence;
		this.photo_image = photo_image;
		
	}
	
	public PhotoAlbum() {
		super();
	}

	public int getId_photo_album() {
		return id_photo_album;
	}

	public void setId_photo_album(int id_photo_album) {
		this.id_photo_album = id_photo_album;
	}

	public int getId_residence() {
		return id_residence;
	}

	public void setId_residence(int id_residence) {
		this.id_residence = id_residence;
	}

	public String getPhoto_image() {
		return photo_image;
	}

	public void setPhoto_image(String photo_image) {
		this.photo_image = photo_image;
	}
	
	

	@Override
	public String vratiNazivTabele() {
		// TODO Auto-generated method stub
		return " photo_album ";
	}

	@Override
	public String vratiKolone() {
		
		return " (id_residence, photo_image ) ";
	}

	@Override
	public PreparedStatement vratiInsert(PreparedStatement ps) {
		
		
			try {
				
			//	InputStream is = new FileInputStream(new File(image));
				ps.setInt(1, id_residence);
				ps.setString(2, photo_image);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
			return ps;
	}

	@Override
	public String vratiZnakove() {
		// TODO Auto-generated method stub
		return " values (?, ?) ";
	}

	@Override
	public List<GeneralDomen> returnData(ResultSet resultSet) {
		List<GeneralDomen> list = new ArrayList<>();
		try {
			while (resultSet.next()) {
				PhotoAlbum album = new PhotoAlbum();
	
				album.setId_photo_album(resultSet.getInt("id_photo_album"));
				album.setId_residence(resultSet.getInt("id_residence"));
				album.setPhoto_image(resultSet.getString("photo_image"));
				list.add(album);

			}
		} catch (SQLException e) { // TODO Auto-generated catch block
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
		return " id_photo_album ";
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
		PhotoAlbum album = new PhotoAlbum();
		try {
			if(resultSet.next()) {
				album.setId_photo_album(resultSet.getInt("id_photo_album"));
				album.setId_residence(resultSet.getInt("id_residence"));
				album.setPhoto_image(resultSet.getString("photo_image"));
				
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return album;
	}

	@Override
	public String getForeignKeyId() {
		// TODO Auto-generated method stub
		return null;
	}


}

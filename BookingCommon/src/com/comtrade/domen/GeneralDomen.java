package com.comtrade.domen;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface GeneralDomen {
	
	public String vratiNazivTabele();
	public String vratiKolone();
	public PreparedStatement vratiInsert(PreparedStatement ps);
	public String vratiZnakove();
	public List<GeneralDomen>returnData(ResultSet resultSet);
	public String vratiKoloneUpdate();
	public String getId();
	public PreparedStatement preparedStatementUpdate(PreparedStatement preparedStatement);
	public PreparedStatement preparedStatementDelete(PreparedStatement preparedStatement) throws SQLException;
	public GeneralDomen vratiPoslednjiPodatak(ResultSet resultSet);
	public String getForeignKeyId();
	
	
	

}

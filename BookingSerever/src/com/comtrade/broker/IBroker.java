package com.comtrade.broker;

import java.sql.SQLException;
import java.util.List;

import com.comtrade.domen.GeneralDomen;
import com.comtrade.domen.User;

public interface IBroker {
	
	public void sacuvaj(GeneralDomen opstiDomen);

	public User vrati(User user) throws SQLException;
	
	List<GeneralDomen>list(GeneralDomen opstiDomen);

	public void update(GeneralDomen opstiDomen);

	public void delete(GeneralDomen opstiDomen);

	public GeneralDomen vratiPoslednjiUpisaniPodatak(GeneralDomen opstiDomen);
	
	public void deleteParenRow(GeneralDomen opstiDomen);

	

	

	

	
	
	

	
}

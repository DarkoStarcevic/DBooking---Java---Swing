package com.comtrade.So.room;

import java.sql.SQLException;
import java.util.List;

import com.comtrade.So.OpstaSistemskaOperacija;
import com.comtrade.broker.Broker;
import com.comtrade.broker.IBroker;
import com.comtrade.domen.GeneralDomen;
import com.comtrade.domen.Room;


public class GetRoomsBackSo extends OpstaSistemskaOperacija {

	@Override
	protected void izvrsiKonkretnuOperaciju(Object object) throws SQLException {
		
		List<GeneralDomen>list = (List<GeneralDomen>) object;
		IBroker ib = new Broker();
		list.addAll(ib.list(new Room()));
		
		
	/*	Iterator iter= (Iterator) list.iterator();
		Room room = null;
		if(iter.hasNext()) {
			room =  (Room) iter.next();
		}
		list.addAll(ib.list(new Room()));	
		*/
	}

}


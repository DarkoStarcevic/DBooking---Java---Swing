package com.comtrade.So.room;

import java.sql.SQLException;
import java.util.List;

import com.comtrade.So.OpstaSistemskaOperacija;
import com.comtrade.broker.Broker;
import com.comtrade.broker.IBroker;
import com.comtrade.domen.Room;

public class InsertRoomSO extends OpstaSistemskaOperacija {

	@Override
	protected void izvrsiKonkretnuOperaciju(Object object) throws SQLException {
	/*	Room room = (Room) object;
		IBroker ib = new Broker();
		ib.sacuvaj(room);
		ib.vratiPoslednjiUpisaniPodatak(room);
*/
		
		List<Room> list = (List<Room>) object;
		IBroker ib = new Broker();
		ib.sacuvaj(list.get(0));
		list.add( (Room) ib.vratiPoslednjiUpisaniPodatak(list.get(0)));
		
	}

}

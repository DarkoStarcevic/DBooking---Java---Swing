package com.comtrade.So.RoomInfo;

import java.sql.SQLException;
import java.util.List;

import com.comtrade.So.OpstaSistemskaOperacija;
import com.comtrade.broker.Broker;
import com.comtrade.broker.IBroker;
import com.comtrade.domen.Room_Info;

public class RoomInfoSo extends OpstaSistemskaOperacija {

	@Override
	protected void izvrsiKonkretnuOperaciju(Object object) throws SQLException {
		/*Room_Info room_Info = (Room_Info) object;
		IBroker ib = new Broker();
		ib.sacuvaj(room_Info);
		//ib.vratiPoslednjiUpisaniPodatak(room_Info);
		
		*/
		
		List<Room_Info> list = (List<Room_Info>) object;
		IBroker ib = new Broker();
		ib.sacuvaj(list.get(0));
		list.add( (Room_Info) ib.vratiPoslednjiUpisaniPodatak(list.get(0)));
		
	}

}

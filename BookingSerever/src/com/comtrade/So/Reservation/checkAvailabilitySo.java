package com.comtrade.So.Reservation;

import java.sql.SQLException;
import java.util.List;

import com.comtrade.So.OpstaSistemskaOperacija;
import com.comtrade.broker.Broker;
import com.comtrade.domen.Reservation;

public class checkAvailabilitySo extends OpstaSistemskaOperacija {

	@Override
	protected void izvrsiKonkretnuOperaciju(Object object) throws SQLException {
		List<Reservation>list = (List<Reservation>) object;
		Broker broker = new Broker();
		list.addAll(broker.availableRooms());
		

	}

}

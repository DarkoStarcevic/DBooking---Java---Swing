package com.comtrade.So.Reservation;

import java.sql.SQLException;
import java.util.List;

import com.comtrade.So.OpstaSistemskaOperacija;
import com.comtrade.broker.Broker;
import com.comtrade.broker.IBroker;
import com.comtrade.domen.Reservation;

public class confirmReservationSo extends OpstaSistemskaOperacija {

	@Override
	protected void izvrsiKonkretnuOperaciju(Object object) throws SQLException {
		List<Reservation>list = (List<Reservation>) object;
		IBroker ib = new Broker();
		//list.add((Reservation) ib.checkAvailability(list.get(0)));
		ib.sacuvaj(list.get(0));
		list.add((Reservation) ib.vratiPoslednjiUpisaniPodatak(list.get(0)));
		

	}

}

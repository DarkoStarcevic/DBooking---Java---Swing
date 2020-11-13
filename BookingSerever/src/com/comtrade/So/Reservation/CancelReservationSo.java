package com.comtrade.So.Reservation;

import java.sql.SQLException;

import com.comtrade.So.OpstaSistemskaOperacija;
import com.comtrade.broker.Broker;
import com.comtrade.broker.IBroker;
import com.comtrade.domen.Reservation;

public class CancelReservationSo extends OpstaSistemskaOperacija {

	@Override
	protected void izvrsiKonkretnuOperaciju(Object object) throws SQLException {
		Reservation reservation = (Reservation) object;
		IBroker ib = new Broker();
		ib.delete(reservation);
	}

}

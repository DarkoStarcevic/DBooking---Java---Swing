package com.comtrade.So.destination;

import java.sql.SQLException;

import com.comtrade.So.OpstaSistemskaOperacija;
import com.comtrade.broker.Broker;
import com.comtrade.broker.IBroker;
import com.comtrade.domen.Destination;


public class UpdateDestinationSo extends OpstaSistemskaOperacija {

	@Override
	protected void izvrsiKonkretnuOperaciju(Object object) throws SQLException {
		Destination destination = (Destination) object;
		IBroker ib = new Broker();
		ib.update(destination);

	}

}

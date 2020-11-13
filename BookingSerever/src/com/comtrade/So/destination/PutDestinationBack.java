package com.comtrade.So.destination;

import java.sql.SQLException;
import java.util.List;

import com.comtrade.So.OpstaSistemskaOperacija;
import com.comtrade.broker.Broker;
import com.comtrade.broker.IBroker;
import com.comtrade.domen.Destination;
import com.comtrade.domen.GeneralDomen;


public class PutDestinationBack extends OpstaSistemskaOperacija {

	@Override
	protected void izvrsiKonkretnuOperaciju(Object object) throws SQLException {
		List<GeneralDomen>list = (List<GeneralDomen>) object;
		IBroker ib = new Broker();
		list.addAll(ib.list(new Destination()));
		
		

	}

}

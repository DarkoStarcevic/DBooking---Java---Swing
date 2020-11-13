package com.comtrade.So.residence;

import java.sql.SQLException;

import com.comtrade.So.OpstaSistemskaOperacija;
import com.comtrade.broker.Broker;
import com.comtrade.broker.IBroker;
import com.comtrade.domen.Residence;

public class DeleteResidenceSo extends OpstaSistemskaOperacija {

	@Override
	protected void izvrsiKonkretnuOperaciju(Object object) throws SQLException {
		Residence residence = (Residence) object;
		IBroker ib = new Broker();
		ib.deleteParenRow(residence);
		//ib.delete(residence);
	}

}

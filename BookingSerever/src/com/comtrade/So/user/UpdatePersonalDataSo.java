package com.comtrade.So.user;

import java.sql.SQLException;

import com.comtrade.So.OpstaSistemskaOperacija;
import com.comtrade.broker.Broker;
import com.comtrade.broker.IBroker;
import com.comtrade.domen.User;

public class UpdatePersonalDataSo extends OpstaSistemskaOperacija {

	@Override
	protected void izvrsiKonkretnuOperaciju(Object object) throws SQLException {
		User user = (User) object;
		IBroker ib = new Broker();
		ib.update(user);

	}

}

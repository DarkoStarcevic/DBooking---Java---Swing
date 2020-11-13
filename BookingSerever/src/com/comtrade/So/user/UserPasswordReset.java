package com.comtrade.So.user;

import java.sql.SQLException;

import com.comtrade.So.OpstaSistemskaOperacija;
import com.comtrade.broker.Broker;
import com.comtrade.domen.User;

public class UserPasswordReset extends OpstaSistemskaOperacija{

	@Override
	protected void izvrsiKonkretnuOperaciju(Object object) throws SQLException {
		User user = (User) object;
		Broker broker = new Broker();
		broker.updatePassword(user);
	}

}

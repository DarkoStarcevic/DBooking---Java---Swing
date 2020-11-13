package com.comtrade.So.user;

import com.comtrade.So.OpstaSistemskaOperacija;
import com.comtrade.broker.Broker;
import com.comtrade.broker.IBroker;
import com.comtrade.domen.User;

public class UserSo extends OpstaSistemskaOperacija {

	@Override
	protected void izvrsiKonkretnuOperaciju(Object object) {
		User user = (User) object;
		IBroker iBroker = new Broker();
		iBroker.sacuvaj(user);

	}

}

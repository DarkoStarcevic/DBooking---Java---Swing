package com.comtrade.So.user;

import java.sql.SQLException;
import java.util.List;

import com.comtrade.So.OpstaSistemskaOperacija;
import com.comtrade.broker.Broker;
import com.comtrade.broker.IBroker;
import com.comtrade.domen.User;

public class LoginUser extends OpstaSistemskaOperacija  {

	@Override
	protected void izvrsiKonkretnuOperaciju(Object object) throws SQLException {
		List<User>list = (List<User>) object;
		User user = list.get(0);
		IBroker iBroker = new Broker();
		User userBaza = iBroker.vrati(user);
		list.add(userBaza);
		
		
	}

}

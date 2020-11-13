package com.comtrade.So.Payment;

import java.sql.SQLException;

import com.comtrade.So.OpstaSistemskaOperacija;
import com.comtrade.broker.Broker;
import com.comtrade.broker.IBroker;
import com.comtrade.domen.Payment;


public class CancelPaymentSo extends OpstaSistemskaOperacija {

	@Override
	protected void izvrsiKonkretnuOperaciju(Object object) throws SQLException {
		Payment payment = (Payment) object;
		IBroker ib = new Broker();
		ib.deleteParenRow(payment);
		

	}

}

package com.comtrade.So.Payment;

import java.sql.SQLException;
import java.util.List;

import com.comtrade.So.OpstaSistemskaOperacija;
import com.comtrade.broker.Broker;
import com.comtrade.broker.IBroker;
import com.comtrade.domen.Payment;

public class ConfirmPaymentSo extends OpstaSistemskaOperacija {

	@Override
	protected void izvrsiKonkretnuOperaciju(Object object) throws SQLException {
		/*Payment payment = (Payment) object;
		IBroker ib = new Broker();
		ib.sacuvaj(payment);
		ib.vratiPoslednjiUpisaniPodatak(payment);
		*/
		
		
		List<Payment>list = (List<Payment>) object;
		IBroker ib = new Broker();
		ib.sacuvaj(list.get(0));
		list.add((Payment) ib.vratiPoslednjiUpisaniPodatak(list.get(0)));

	}

}

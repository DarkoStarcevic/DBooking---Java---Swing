package com.comtrade.So.Review;

import java.sql.SQLException;
import java.util.List;

import com.comtrade.So.OpstaSistemskaOperacija;
import com.comtrade.broker.Broker;
import com.comtrade.broker.IBroker;
import com.comtrade.domen.GeneralDomen;
import com.comtrade.domen.Review;


public class getReviewBackSo extends OpstaSistemskaOperacija {

	@Override
	protected void izvrsiKonkretnuOperaciju(Object object) throws SQLException {
		List<GeneralDomen>list  = (List<GeneralDomen>) object;
		IBroker ib = new Broker();
		list.addAll(ib.list(new Review()));


	}

}

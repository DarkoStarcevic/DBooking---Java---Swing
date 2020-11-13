package com.comtrade.So.Review;

import java.sql.SQLException;
import java.util.List;

import com.comtrade.So.OpstaSistemskaOperacija;
import com.comtrade.broker.Broker;
import com.comtrade.broker.IBroker;
import com.comtrade.domen.Review;

public class insertReviewSo extends OpstaSistemskaOperacija {

	@Override
	protected void izvrsiKonkretnuOperaciju(Object object) throws SQLException {
	
		List<Review> reviewList = (List<Review>) object;
		IBroker ib = new Broker();
		ib.sacuvaj(reviewList.get(0));
		reviewList.add( (Review) ib.vratiPoslednjiUpisaniPodatak(reviewList.get(0)));
	
	}

}

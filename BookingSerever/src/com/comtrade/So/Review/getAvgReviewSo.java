package com.comtrade.So.Review;

import java.sql.SQLException;
import java.util.List;

import com.comtrade.So.OpstaSistemskaOperacija;
import com.comtrade.broker.Broker;
import com.comtrade.broker.IBroker;
import com.comtrade.domen.Residence;
import com.comtrade.domen.Review;

public class getAvgReviewSo extends OpstaSistemskaOperacija {

	@Override
	protected void izvrsiKonkretnuOperaciju(Object object) throws SQLException {
		List<Review>list = (List<Review>) object;
		Broker br = new Broker();
		list.addAll(br.totalRating());
		
	//	System.out.println("aaa");

	}

}

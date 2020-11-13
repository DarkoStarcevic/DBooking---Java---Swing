package com.comtrade.So.Review;

import java.sql.SQLException;
import java.util.List;

import com.comtrade.So.OpstaSistemskaOperacija;
import com.comtrade.broker.Broker;
import com.comtrade.broker.IBroker;
import com.comtrade.domen.Residence;

public class UpdateResidenceAvgRatingSo extends OpstaSistemskaOperacija {

	@Override
	protected void izvrsiKonkretnuOperaciju(Object object) throws SQLException {
		Residence residence = (Residence) object;
		Broker broker = new Broker();
		broker.updateResidenceAvgRating(residence);
		
		
	}

}

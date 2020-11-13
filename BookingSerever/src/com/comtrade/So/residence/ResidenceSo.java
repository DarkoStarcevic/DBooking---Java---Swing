package com.comtrade.So.residence;

import java.sql.SQLException;
import java.util.List;

import com.comtrade.So.OpstaSistemskaOperacija;
import com.comtrade.broker.Broker;
import com.comtrade.broker.IBroker;
import com.comtrade.domen.Residence;

public class ResidenceSo extends OpstaSistemskaOperacija {

	@Override
	protected void izvrsiKonkretnuOperaciju(Object object) throws SQLException {
		List<Residence> residenceList = (List<Residence>) object;
		IBroker ib = new Broker();
		ib.sacuvaj(residenceList.get(0));
		residenceList.add( (Residence) ib.vratiPoslednjiUpisaniPodatak(residenceList.get(0)));
		
	}
	 
}

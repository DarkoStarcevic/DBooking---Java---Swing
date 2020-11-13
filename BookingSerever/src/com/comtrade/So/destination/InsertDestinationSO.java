package com.comtrade.So.destination;

import java.sql.SQLException;
import java.util.List;

import com.comtrade.So.OpstaSistemskaOperacija;
import com.comtrade.broker.Broker;
import com.comtrade.broker.IBroker;
import com.comtrade.domen.Destination;



public class InsertDestinationSO extends OpstaSistemskaOperacija {

	@Override
	protected void izvrsiKonkretnuOperaciju(Object object) throws SQLException {
		List<Destination> destinationList =  (List<Destination>) object;
		IBroker ib = new Broker();
		ib.sacuvaj(destinationList.get(0));
		destinationList.add( (Destination) ib.vratiPoslednjiUpisaniPodatak(destinationList.get(0)));
		
	}
	
	/*Set<OpstiDomen>destinationList = (HashSet<OpstiDomen>) object;
	IBroker ib = new Broker();
	Iterator iter= (Iterator) destinationList.iterator();
	Destination destination = null;
	if(iter.hasNext()) {
		destination = (Destination) iter.next();
	}
	
	ib.sacuvaj(destination);
	//destinationList.clear();
	//destinationList.addAll(ib.list(new Destination()));
	//destinationList.add( (Destination) ib.vratiPoslednjiUpisaniPodatak(new Destination()));
	destinationList.add(destination);*/
	
	
}

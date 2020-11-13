package com.comtrade.photoAlbumSo;

import java.sql.SQLException;
import java.util.List;

import com.comtrade.So.OpstaSistemskaOperacija;
import com.comtrade.broker.Broker;
import com.comtrade.broker.IBroker;
import com.comtrade.domen.PhotoAlbum;


public class InsertPhotoSo extends OpstaSistemskaOperacija {

	@Override
	protected void izvrsiKonkretnuOperaciju(Object object) throws SQLException {
		/*PhotoAlbum photoAlbum = (PhotoAlbum) object;
		IBroker ib = new Broker();
		ib.sacuvaj(photoAlbum);*/
		
		List<PhotoAlbum>list = (List<PhotoAlbum>) object;
		IBroker ib = new Broker();
		ib.sacuvaj(list.get(0));
		list.add((PhotoAlbum) ib.vratiPoslednjiUpisaniPodatak(new PhotoAlbum()));

	}
	
	
}


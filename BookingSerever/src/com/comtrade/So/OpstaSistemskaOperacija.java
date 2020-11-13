package com.comtrade.So;

import java.sql.SQLException;

import com.comtrade.connection.Conection;

public abstract class OpstaSistemskaOperacija {
	
	public void izvrsiSistemskuOperaciju(Object object) {
		try {
			pokreniTransakciju();
			izvrsiKonkretnuOperaciju(object);
			potvrdiTransakciju();
		} catch (Exception e) {
			ponistiTransakciju();			
		}finally {
			zatvoriKonekciju();
			
		}
	}

	private void pokreniTransakciju(){
		Conection.getKonekcija().startTransakcije();
		
	}

	protected abstract void izvrsiKonkretnuOperaciju(Object object) throws SQLException;

	private void potvrdiTransakciju() {
		Conection.getKonekcija().potvrdiTransakciju();
		
	}

	private void ponistiTransakciju() {
		Conection.getKonekcija().ponistiTransakciju();
		
	}

	private void zatvoriKonekciju() {
		Conection.getKonekcija().zatvoriKonekciju();
		
	}

}

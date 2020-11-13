package com.comtrade.constants;

public enum Constants {
	
	IP_ADRESA("127.0.0.1"), PORT(9000);
	
	private String ipAdresa;
	private int port;
	private Constants(String ipAdresa) {
		this.ipAdresa = ipAdresa;
	}
	private Constants(int port) {
		this.port = port;
	}
	public String getIpAdresa() {
		return ipAdresa;
	}
	public int getPort() {
		return port;
	}
	
	

}

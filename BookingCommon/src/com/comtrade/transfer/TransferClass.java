package com.comtrade.transfer;

import java.io.Serializable;

public class TransferClass implements Serializable {

	private static final long serialVersionUID = 1L;
	private int operation;
	private Object client_object_request;
	private Object server_object_response;
	private String message_response;
	
	public int getOperation() {
		return operation;
	}
	public void setOperation(int operation) {
		this.operation = operation;
	}
	public Object getClient_object_request() {
		return client_object_request;
	}
	public void setClient_object_request(Object client_object_request) {
		this.client_object_request = client_object_request;
	}
	public Object getServer_object_response() {
		return server_object_response;
	}
	public void setServer_object_response(Object server_object_response) {
		this.server_object_response = server_object_response;
	}
	public String getMessage_response() {
		return message_response;
	}
	public void setMessage_response(String message_response) {
		this.message_response = message_response;
	}

	
	

}

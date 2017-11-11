package com.niit.backend.model;

import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Component
public class BaseDomain {
	
	@Transient
	private String Errorcode;
	
	@Transient
	private String Errormessage;

	public String getErrorcode() {
		return Errorcode;
	}

	public void setErrorcode(String errorcode) {
		Errorcode = errorcode;
	}

	public String getErrormessage() {
		return Errormessage;
	}

	public void setErrormessage(String errormessage) {
		Errormessage = errormessage;
	}
	

}

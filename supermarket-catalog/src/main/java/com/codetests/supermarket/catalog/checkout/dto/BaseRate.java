package com.codetests.supermarket.catalog.checkout.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BaseRate {
	
	public BaseRate() {
		super();
	}
	
	public BaseRate(Float baseInterestRate) {
		super();
		this.baseInterestRate = baseInterestRate;
	}

	private Float baseInterestRate;

	public Float getBaseInterestRate() {
		return baseInterestRate;
	}

	public void setBaseInterestRate(Float baseInterestRate) {
		this.baseInterestRate = baseInterestRate;
	}
	
}

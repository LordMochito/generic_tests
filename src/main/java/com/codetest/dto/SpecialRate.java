package com.codetest.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SpecialRate {
	private Float overriddenSpecialRate;
	
	public SpecialRate() {
		super();
	}
	
	public SpecialRate(Float overriddenSpecialRate) {
		super();
		this.overriddenSpecialRate = overriddenSpecialRate;
	}

	public Float getOverriddenSpecialRate() {
		return overriddenSpecialRate;
	}

	public void setOverriddenSpecialRate(Float overriddenSpecialRate) {
		this.overriddenSpecialRate = overriddenSpecialRate;
	}
}

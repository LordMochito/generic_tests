package com.codetest.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class InterestRate {
	
	
	private Float rate;

	
	public InterestRate() {
		super();
	}
	
	public InterestRate(Float rate) {
		super();
		this.rate = rate;
	}

	public Float getRate() {
		return rate;
	}

	public void setRate(Float rate) {
		this.rate = rate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rate == null) ? 0 : rate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InterestRate other = (InterestRate) obj;
		if (rate == null) {
			if (other.rate != null)
				return false;
		} else if (!rate.equals(other.rate))
			return false;
		return true;
	}
	
	
}

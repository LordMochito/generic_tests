package com.codetest.pojos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BaseInterestRate")
/**
 * BaseInterestRate domain object.
 * 
 * It's in itself a snapshot. the last value is the current Value
 * 
 * @author pablogutierrez
 *
 */
public class BaseInterestRate{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "BASE_INT_RATE")
	private Float baseInterestRate;
	
	@Column(name = "STANDAR_INT_RATE")
	private Float standarInterestRate;
	
	@Column(name = "PRIVILIGED_INT_RATE")
	private Float privilegeInterestRate;
	
	@Column(name = "SPECIAL_INT_RATE")
	private Float specialInterestRate;
	
	@Column(name = "CREATION_DATE")
	private Date creationDate;

	public BaseInterestRate() {
		super();
	}
	
	public BaseInterestRate(Float baseInterestRate) {
		super();
		this.baseInterestRate = baseInterestRate;
		calculateRates();
		this.creationDate = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getBaseInterestRate() {
		return baseInterestRate;
	}

	public void setBaseInterestRate(Float baseInterestRate) {
		this.baseInterestRate = baseInterestRate;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	

	public Float getStandarInterestRate() {
		return standarInterestRate;
	}

	public void setStandarInterestRate(Float standarInterestRate) {
		this.standarInterestRate = standarInterestRate;
	}

	public Float getPrivilegeInterestRate() {
		return privilegeInterestRate;
	}

	public void setPrivilegeInterestRate(Float privilegeInterestRate) {
		this.privilegeInterestRate = privilegeInterestRate;
	}

	public Float getSpecialInterestRate() {
		return specialInterestRate;
	}

	public void setSpecialInterestRate(Float specialInterestRate) {
		this.specialInterestRate = specialInterestRate;
	}

	/**
	 * To do this, I prefer DDD. The logic is focus in the same entity 
	 * 
	 * Calculate rates by default
	 */
	public void calculateRates() {
		    setPrivilegeInterestRate((float) ((baseInterestRate + baseInterestRate * 1.05) / 2));
			setSpecialInterestRate((float) ((baseInterestRate + baseInterestRate * 1.05) / 2));
			setStandarInterestRate((float) (baseInterestRate * 1.05));
	}
	
	/**
	 * 
	 * To do this, I prefer DDD. The logic is focus in the same entity
	 * 
	 * Establish a overridden special rate
	 * @param overridden
	 */
	public void overrideSpecialRate(Float overridden) {
		if (overridden > (getBaseInterestRate() * 1.01)){
			setSpecialInterestRate(overridden);
		}else{
			setSpecialInterestRate((float) (getBaseInterestRate() * 1.01));
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((baseInterestRate == null) ? 0 : baseInterestRate.hashCode());
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
		BaseInterestRate other = (BaseInterestRate) obj;
		if (baseInterestRate == null) {
			if (other.baseInterestRate != null)
				return false;
		} else if (!baseInterestRate.equals(other.baseInterestRate))
			return false;
		return true;
	}
	
}

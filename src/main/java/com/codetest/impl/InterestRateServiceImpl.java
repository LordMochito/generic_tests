package com.codetest.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.codetest.CurrentRates;
import com.codetest.InterestRateService;
import com.codetest.dto.BaseRate;
import com.codetest.dto.SpecialRate;
import com.codetest.enums.ClientType;
import com.codetest.pojos.BaseInterestRate;
import com.codetest.repositories.BaseInterestRateRepository;

@Named
public class InterestRateServiceImpl implements InterestRateService {

	@Inject
	private BaseInterestRateRepository baseInterestRateRepository;
	
	@Inject
	private CurrentRates currentRates;
	
	
	@Override
	public Float calculateRateByClienType(ClientType clientType) {
		BaseInterestRate baseInterestRate = currentRates.getCurrentRates();
		return calculateRate(clientType, baseInterestRate);
	}

	@Override
	public void setNewBaseRate(BaseRate baseRate) {
		baseInterestRateRepository.save(new BaseInterestRate(baseRate.getBaseInterestRate()));
	}

	private Float calculateRate(ClientType clientType, BaseInterestRate baseRate) {
		switch (clientType) {
		case SPECIAL:
			return baseRate.getSpecialInterestRate();
		case PRIVILIGED:
			return baseRate.getPrivilegeInterestRate();
		default:
			return baseRate.getStandarInterestRate();
		}
	}

	@Override
	public void setNewSpecialRate(SpecialRate specialRate) {
		BaseInterestRate currentRates = this.currentRates.getCurrentRates();
		currentRates.overrideSpecialRate(specialRate.getOverriddenSpecialRate());
		baseInterestRateRepository.save(currentRates);
		
	}
	
}

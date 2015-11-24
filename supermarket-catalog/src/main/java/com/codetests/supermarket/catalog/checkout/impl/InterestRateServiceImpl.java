package com.codetests.supermarket.catalog.checkout.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.codetests.supermarket.catalog.checkout.CurrentRates;
import com.codetests.supermarket.catalog.checkout.InterestRateService;
import com.codetests.supermarket.catalog.checkout.dto.BaseRate;
import com.codetests.supermarket.catalog.checkout.dto.SpecialRate;
import com.codetests.supermarket.catalog.checkout.enums.ClientType;
import com.codetests.supermarket.catalog.checkout.repositories.BaseInterestRateRepository;
import com.codetests.supermarket.catalog.domain.BaseInterestRate;

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

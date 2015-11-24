package com.codetests.supermarket.catalog.checkout.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

import com.codetests.supermarket.catalog.checkout.CurrentRates;
import com.codetests.supermarket.catalog.checkout.repositories.BaseInterestRateRepository;
import com.codetests.supermarket.catalog.domain.BaseInterestRate;

@Named
public class CurrentRatesImpl implements CurrentRates{

	@Inject
	private BaseInterestRateRepository baseInterestRateRepository;
	
	@Override
	public BaseInterestRate getCurrentRates() {
		Order order = new Order(Direction.DESC, "creationDate");
		Pageable pageable = new PageRequest(0, 1, new Sort(order)); //it's only searched the last element ordered by timestamp desc
		Page<BaseInterestRate> lastElement = baseInterestRateRepository.findAll(pageable);
		BaseInterestRate baseInterestRate = lastElement.getContent().get(0);
		return baseInterestRate;
	}
}

package com.codetests.supermarket.catalog.checkout;

import com.codetests.supermarket.catalog.checkout.dto.BaseRate;
import com.codetests.supermarket.catalog.checkout.dto.SpecialRate;
import com.codetests.supermarket.catalog.checkout.enums.ClientType;

public interface InterestRateService {

	Float calculateRateByClienType(ClientType clientType);

	void setNewBaseRate(BaseRate baseRate);

	void setNewSpecialRate(SpecialRate specialRate);
	
}

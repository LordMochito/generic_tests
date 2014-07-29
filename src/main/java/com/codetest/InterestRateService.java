package com.codetest;

import com.codetest.dto.BaseRate;
import com.codetest.dto.SpecialRate;
import com.codetest.enums.ClientType;

public interface InterestRateService {

	Float calculateRateByClienType(ClientType clientType);

	void setNewBaseRate(BaseRate baseRate);

	void setNewSpecialRate(SpecialRate specialRate);
	
}

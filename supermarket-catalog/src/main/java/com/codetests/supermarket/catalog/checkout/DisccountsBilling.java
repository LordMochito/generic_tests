package com.codetests.supermarket.catalog.checkout;

import java.util.List;
import java.util.TreeSet;

import com.codetests.supermarket.catalog.checkout.rules.CheckoutRule;
import com.codetests.supermarket.catalog.domain.Receipt;
import com.codetests.supermarket.catalog.domain.ReceiptItem;

public interface DisccountsBilling {
	Receipt calculate(TreeSet<ReceiptItem> aggrupatedItems); 
	
	void addNewRule(CheckoutRule newRule);
	
	void resetRules();
	
	List<CheckoutRule> getRules();
}

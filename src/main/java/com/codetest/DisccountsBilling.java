package com.codetest;

import java.util.List;
import java.util.TreeSet;

import com.codetest.checkout.rules.CheckoutRule;
import com.codetest.pojos.Receipt;
import com.codetest.pojos.ReceiptItem;

public interface DisccountsBilling {
	Receipt calculate(TreeSet<ReceiptItem> aggrupatedItems); 
	
	void addNewRule(CheckoutRule newRule);
	
	void resetRules();
	
	List<CheckoutRule> getRules();
}

package com.codetest;

import java.util.List;
import java.util.TreeSet;

import com.codetest.checkout.rules.CheckoutRule;
import com.codetest.pojos.CatalogItem;
import com.codetest.pojos.Receipt;
import com.codetest.pojos.ReceiptItem;

public interface ReceiptCalculations {

	Receipt getCalculatedReceipt(List<CatalogItem> articleItemCustomerList);
	
	void addNewRule(CheckoutRule newRule);
	
	void resetRules();
	
	TreeSet<ReceiptItem> aggrupateItems(List<CatalogItem> articleItemCustomerList);
}

package com.codetests.supermarket.catalog.checkout;

import java.util.List;
import java.util.TreeSet;

import com.codetests.supermarket.catalog.checkout.rules.CheckoutRule;
import com.codetests.supermarket.catalog.domain.CatalogItem;
import com.codetests.supermarket.catalog.domain.Receipt;
import com.codetests.supermarket.catalog.domain.ReceiptItem;

public interface ReceiptCalculations {

	Receipt getCalculatedReceipt(List<CatalogItem> articleItemCustomerList);
	
	void addNewRule(CheckoutRule newRule);
	
	void resetRules();
	
	TreeSet<ReceiptItem> aggrupateItems(List<CatalogItem> articleItemCustomerList);
}

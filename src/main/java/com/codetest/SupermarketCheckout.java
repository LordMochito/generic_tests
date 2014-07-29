package com.codetest;

import java.util.List;

import com.codetest.checkout.rules.CheckoutRule;
import com.codetest.exceptions.ItemNotFoundException;
import com.codetest.pojos.CatalogItem;
import com.codetest.pojos.Receipt;

/**
 * Check out service interface
 * 
 * @author pablogutierrez
 *
 */

public interface SupermarketCheckout {

	void addItem(Long itemId, String itemSet) throws ItemNotFoundException;

	Receipt getReceipt();
	
	List<CatalogItem> getArticles();
	
	void addNewRule(CheckoutRule newRule);
	
	void resetRules();

}

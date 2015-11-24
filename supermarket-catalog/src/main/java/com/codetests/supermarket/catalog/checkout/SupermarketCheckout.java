package com.codetests.supermarket.catalog.checkout;

import java.util.List;

import com.codetests.supermarket.catalog.checkout.exceptions.ItemNotFoundException;
import com.codetests.supermarket.catalog.checkout.rules.CheckoutRule;
import com.codetests.supermarket.catalog.domain.CatalogItem;
import com.codetests.supermarket.catalog.domain.Receipt;

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

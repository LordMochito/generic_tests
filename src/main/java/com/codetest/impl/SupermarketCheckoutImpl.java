/**
 * 
 */
package com.codetest.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.codetest.ReceiptCalculations;
import com.codetest.SupermarketCatalog;
import com.codetest.SupermarketCheckout;
import com.codetest.checkout.rules.CheckoutRule;
import com.codetest.exceptions.ItemNotFoundException;
import com.codetest.pojos.CatalogItem;
import com.codetest.pojos.Receipt;

/**
 * Supermarket checkout
 * 
 * @author pablogutierrez
 *
 */
@Named
public class SupermarketCheckoutImpl implements SupermarketCheckout {
	
	private List<CatalogItem> articleItemCustomerList = new ArrayList<>();
	
	@Inject
	private SupermarketCatalog supermarketCatalog;
	
	@Inject
	private ReceiptCalculations receiptCalculations;
	
	@Override
	/**
	 * Add Item Id
	 * 
	 * @throws ItemNotFoundException
	 */
	public void addItem(Long itemId, String itemSet) throws ItemNotFoundException {
		CatalogItem catalogItem = supermarketCatalog.getItem(itemSet, itemId);
		add2CustomerItems(catalogItem);
	}
	
	private synchronized void add2CustomerItems(CatalogItem catalogItem) {
		articleItemCustomerList.add(catalogItem);
	}

	@Override
	/**
	 * Get the receipt
	 */
	public Receipt getReceipt() {
		return receiptCalculations.getCalculatedReceipt(articleItemCustomerList);
	}
	/**
	 * List all the articles
	 */
	public List<CatalogItem> getArticles() {
		return articleItemCustomerList;
	}

	@Override
	public void addNewRule(CheckoutRule newRule) {
		receiptCalculations.addNewRule(newRule);
	}

	@Override
	public void resetRules() {
		receiptCalculations.resetRules();
	}
}

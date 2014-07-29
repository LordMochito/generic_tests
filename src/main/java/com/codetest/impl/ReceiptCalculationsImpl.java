package com.codetest.impl;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

import javax.inject.Inject;
import javax.inject.Named;

import com.codetest.DisccountsBilling;
import com.codetest.ReceiptCalculations;
import com.codetest.checkout.rules.CheckoutRule;
import com.codetest.pojos.CatalogItem;
import com.codetest.pojos.Receipt;
import com.codetest.pojos.ReceiptItem;

@Named
/**
 * 
 * Service to make checkout calculations
 * 
 * @author pablogutierrez
 *
 */
public class ReceiptCalculationsImpl implements ReceiptCalculations {

	@Inject
	DisccountsBilling disccountsBilling;
	
	@Override
	public Receipt getCalculatedReceipt(List<CatalogItem> articleItemCustomerList) {
		TreeSet<ReceiptItem> aggrupatedItems = aggrupateItems(articleItemCustomerList);
		return disccountsBilling.calculate(aggrupatedItems);
	}
	
	public TreeSet<ReceiptItem> aggrupateItems(List<CatalogItem> articleItemCustomerList) {
		LinkedList<ReceiptItem> receiptList = new LinkedList<>();
		Collections.sort(articleItemCustomerList);
		CatalogItem beforeItem = new CatalogItem(); 
		for (CatalogItem catalogItem : articleItemCustomerList) {
			if (! catalogItem.equals(beforeItem)){
				receiptList.add(map2ReceiptItem(catalogItem));
			}else{
				receiptList.getLast().setQuantity(receiptList.getLast().getQuantity() + 1);
			}
			beforeItem = catalogItem;
		}
		return new TreeSet<ReceiptItem>(receiptList);
	}
	
	private ReceiptItem map2ReceiptItem(CatalogItem catalogItem) {
		ReceiptItem receiptItem = new ReceiptItem();
		receiptItem.setId(catalogItem.getId());
		receiptItem.setName(catalogItem.getName());
		receiptItem.setItemPrice(catalogItem.getPrice());
		receiptItem.setDescription(catalogItem.getDescription());
		receiptItem.setQuantity(1);
		return receiptItem;
	}

	@Override
	public void addNewRule(CheckoutRule newRule) {
		disccountsBilling.addNewRule(newRule);
	}

	@Override
	public void resetRules() {
		disccountsBilling.resetRules();
	}
}

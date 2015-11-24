package com.codetests.supermarket.catalog.checkout.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import javax.inject.Named;

import com.codetests.supermarket.catalog.checkout.DisccountsBilling;
import com.codetests.supermarket.catalog.checkout.rules.CheckoutRule;
import com.codetests.supermarket.catalog.domain.Receipt;
import com.codetests.supermarket.catalog.domain.ReceiptItem;

@Named
public class DisccountsBillingImpl implements DisccountsBilling{
	
	private List<CheckoutRule> checkoutRuleList = new ArrayList<>(); 
	
	public Receipt calculate(TreeSet<ReceiptItem> aggrupatedItems) {
		Receipt receipt = new Receipt();
		BigDecimal totalAmount = new BigDecimal(0);
		for (ReceiptItem receiptItem : aggrupatedItems) {
			BigDecimal totalItemsPrice = new BigDecimal(receiptItem.getItemPrice()).multiply(new BigDecimal(receiptItem.getQuantity()));
			receiptItem.setTotalItemsPrice(totalItemsPrice.doubleValue());
			applyRules(receiptItem);
			totalAmount = totalAmount.add(new BigDecimal(receiptItem.getTotalItemsPrice()));
		}
		receipt.setTotalAmount(totalAmount.doubleValue());	
		return receipt;
	}
	
	public void addNewRule(CheckoutRule newRule) {
		checkoutRuleList.add(newRule);
	}
	
	public void resetRules() {
		checkoutRuleList = new ArrayList<>();
	}

	private void applyRules(ReceiptItem receiptItem) {
		for (CheckoutRule checkoutRule : checkoutRuleList) {
			checkoutRule.apply(receiptItem);
		}

	}
	public List<CheckoutRule> getRules() {
		return checkoutRuleList;
	}
}

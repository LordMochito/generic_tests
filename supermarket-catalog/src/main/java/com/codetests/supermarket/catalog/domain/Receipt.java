package com.codetests.supermarket.catalog.domain;

import java.util.TreeSet;

/**
 * Receipt Data transfer object
 * 
 * @author pablogutierrez
 *
 */
public class Receipt {
	private Double totalAmount = null;
	
	private TreeSet<ReceiptItem> aggrupatedItems;
	
	public Receipt(){
		aggrupatedItems = new TreeSet<>();
	}
	
	//GETTERS & SETTERS
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public TreeSet<ReceiptItem> getAggrupatedItems() {
		return aggrupatedItems;
	}

	public void setAggrupatedItems(TreeSet<ReceiptItem> aggrupatedItems) {
		this.aggrupatedItems = aggrupatedItems;
	}
}
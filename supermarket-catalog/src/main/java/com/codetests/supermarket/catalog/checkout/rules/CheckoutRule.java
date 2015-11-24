package com.codetests.supermarket.catalog.checkout.rules;

import com.codetests.supermarket.catalog.domain.ReceiptItem;

/**
 * Abstract class to define new rules
 * 
 * @author pablogutierrez
 *
 */
public abstract class CheckoutRule {
	protected Long itemId;

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	
	public abstract void apply(ReceiptItem receiptItem);
}

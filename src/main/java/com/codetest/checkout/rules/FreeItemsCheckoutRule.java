package com.codetest.checkout.rules;

import java.math.BigDecimal;

import com.codetest.pojos.ReceiptItem;

/**
 * for each N (equals) items X, you get K items Y for free
 * 
 * I'm assuming that X and K are the same - it's odd if they are different. 
 * 
 * @author pablogutierrez
 *
 */
public class FreeItemsCheckoutRule extends CheckoutRule{
	
	private Integer itemNumberEquals;
	private Integer itemNumberFree;
	
	public FreeItemsCheckoutRule(Long itemId, Integer itemNumberEquals, Integer itemNumberFree) {
		super();
		super.itemId = itemId;
		this.itemNumberEquals = itemNumberEquals;
		this.itemNumberFree = itemNumberFree;
	}
	
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public Integer getItemNumberEquals() {
		return itemNumberEquals;
	}
	public void setItemNumberEquals(Integer itemNumberEquals) {
		this.itemNumberEquals = itemNumberEquals;
	}
	public Integer getItemNumberFree() {
		return itemNumberFree;
	}
	public void setItemNumberFree(Integer itemNumberFree) {
		this.itemNumberFree = itemNumberFree;
	}
	
	public void apply(ReceiptItem receiptItem) {
		Integer quantity = receiptItem.getQuantity();
		if (receiptItem.getId() ==	getItemId()
			&& quantity == getItemNumberEquals()){
			quantity = quantity - itemNumberFree;
		}
		BigDecimal totalItemsPrice = new BigDecimal(receiptItem.getItemPrice()).multiply(new BigDecimal(quantity));
		receiptItem.setTotalItemsPrice(totalItemsPrice.doubleValue());
	}
	
}

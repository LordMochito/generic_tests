package com.codetests.supermarket.catalog.checkout.rules;

import java.math.BigDecimal;

import com.codetests.supermarket.catalog.domain.ReceiptItem;

/**
 * for each N (equals) items X, you get K items Y for free
 * 
 * I'm assuming that X and K are the same - it's odd if they are different. 
 * 
 * @author pablogutierrez
 *
 */
public class ThreePerTwoCheckoutRule extends CheckoutRule{
	
	public void apply(ReceiptItem receiptItem) {
		Integer quantity = receiptItem.getQuantity();
		if (quantity % 3 == 0){
			quantity = quantity - quantity / 3;
			BigDecimal totalItemsPrice = new BigDecimal(receiptItem.getItemPrice()).multiply(new BigDecimal(quantity));
			receiptItem.setTotalItemsPrice(totalItemsPrice.doubleValue());
		}
	}
	
}

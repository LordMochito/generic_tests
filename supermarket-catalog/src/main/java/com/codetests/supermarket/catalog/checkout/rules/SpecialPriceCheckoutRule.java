package com.codetests.supermarket.catalog.checkout.rules;

import java.math.BigDecimal;

import com.codetests.supermarket.catalog.domain.ReceiptItem;

/**
 * for special prices rule
 * 
 * @author pablogutierrez
 *
 */
public class SpecialPriceCheckoutRule extends CheckoutRule{
	
	private Integer itemNumberEquals;
	private Double specialPrice;
	
	public SpecialPriceCheckoutRule(Integer itemNumberEquals, Double specialPrice) {
		super();
		this.itemNumberEquals = itemNumberEquals;
		this.specialPrice = specialPrice;
	}



	public void apply(ReceiptItem receiptItem) {
		Integer quantity = receiptItem.getQuantity();
		if (quantity == itemNumberEquals){
			receiptItem.setItemPrice(specialPrice);
			BigDecimal totalItemsPrice = new BigDecimal(receiptItem.getItemPrice()).multiply(new BigDecimal(quantity));
			receiptItem.setTotalItemsPrice(totalItemsPrice.doubleValue());
		}
	}
	
}

package com.codetest.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.TreeSet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.codetest.checkout.rules.ThreePerTwoCheckoutRule;
import com.codetest.impl.DisccountsBillingImpl;
import com.codetest.pojos.Receipt;
import com.codetest.pojos.ReceiptItem;

@RunWith(MockitoJUnitRunner.class)
public class DisccountsBillingTest {

	@InjectMocks
	DisccountsBillingImpl disccountsBilling;
	
	@Test
	public void shouldCalculateTotal() {
		
		// Fixture
		TreeSet<ReceiptItem> items = new TreeSet<>();
		ReceiptItem receiptItem = new ReceiptItem();
		receiptItem.setId(1L);
		receiptItem.setItemPrice(1.0);
		receiptItem.setName("Test1");
		receiptItem.setQuantity(1);
		items.add(receiptItem);
		ReceiptItem receiptItem2 = new ReceiptItem();
		receiptItem2.setId(2L);
		receiptItem2.setItemPrice(2.0);
		receiptItem2.setName("Test2");
		receiptItem2.setQuantity(1);
		items.add(receiptItem2);
		
		//Experimentation
		Receipt receipt = disccountsBilling.calculate(items);		
		//Expectations
		assertNotNull(receipt);
		assertEquals(new Double(3.0) , receipt.getTotalAmount());
	}

	@Test
	public void shouldAddNewRule() {
		// Fixture
		disccountsBilling.resetRules();
		//Experimentation
		disccountsBilling.addNewRule(new ThreePerTwoCheckoutRule());		
		//Expectations
		assertEquals(1, disccountsBilling.getRules().size());
	}

	@Test
	public void shouldResetRules() {
		// Fixture
		disccountsBilling.addNewRule(new ThreePerTwoCheckoutRule());
		//Experimentation
		disccountsBilling.resetRules();			
		//Expectations
		assertEquals(0, disccountsBilling.getRules().size());
	}

}

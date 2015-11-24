package com.codetests.supermarket.catalog.checkout.tests;

import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.codetests.supermarket.catalog.checkout.DisccountsBilling;
import com.codetests.supermarket.catalog.checkout.impl.ReceiptCalculationsImpl;
import com.codetests.supermarket.catalog.checkout.rules.CheckoutRule;
import com.codetests.supermarket.catalog.domain.CatalogItem;
import com.codetests.supermarket.catalog.domain.Receipt;

@RunWith(MockitoJUnitRunner.class)
public class ReceiptCalculationsTest {
	
	@InjectMocks
	ReceiptCalculationsImpl receiptCalculations;
	
	private List<CatalogItem> articleItemCustomerList = new ArrayList<>();

	@Mock
	DisccountsBilling disccountsBilling;

	@Mock
	private CheckoutRule newRule;
	
	@Test
	public void testGetCalculatedReceipt() {
		// Fixture
		CatalogItem catalogItem = new CatalogItem();
		catalogItem.setId(1L);
		catalogItem.setName("name1");
		catalogItem.setPrice(1.0);
		articleItemCustomerList.add(catalogItem);
		CatalogItem catalogItem2 = new CatalogItem();
		catalogItem2.setId(2L);
		catalogItem2.setName("name1");
		catalogItem2.setPrice(1.0);
		articleItemCustomerList.add(catalogItem);
		//Experimentation
		Receipt calculatedReceipt = receiptCalculations.getCalculatedReceipt(articleItemCustomerList);		
		//Expectations
		verify(disccountsBilling).calculate(receiptCalculations.aggrupateItems(articleItemCustomerList));
	}

	@Test
	public void testAddNewRule() {
		//Experimentation
		receiptCalculations.addNewRule(newRule);		
		//Expectations
		verify(disccountsBilling).addNewRule(newRule);
	}

	@Test
	public void testResetRules() {
		//Experimentation
		receiptCalculations.resetRules();		
		//Expectations
		verify(disccountsBilling).resetRules();
	}

}

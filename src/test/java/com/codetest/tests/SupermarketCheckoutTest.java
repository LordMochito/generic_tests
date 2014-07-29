package com.codetest.tests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.codetest.exceptions.ItemNotFoundException;
import com.codetest.impl.SupermarketCatalogImpl;
import com.codetest.impl.SupermarketCheckoutImpl;
import com.codetest.pojos.CatalogItem;

@RunWith(MockitoJUnitRunner.class)
public class SupermarketCheckoutTest {

	@InjectMocks
    private SupermarketCheckoutImpl supermarketCheckout;
	
	@Mock
	SupermarketCatalogImpl supermarketCatalog;
	
	@Mock
	CatalogItem articleItem;
	
	Long rightIdentifier = 1L;
	
	Long wrongIdentifier = 7L;
	
	@Test
	public void shouldAddItem() throws ItemNotFoundException {
		// Fixture
		when(supermarketCatalog.getItem("Vegetables", rightIdentifier)).thenReturn(articleItem);
		int previousSize = supermarketCheckout.getArticles().size();
		//Experimentation
		supermarketCheckout.addItem(rightIdentifier, "Vegetables");
		
		//Expectations
		assertEquals(previousSize +1, supermarketCheckout.getArticles().size());
	}
	
	@SuppressWarnings("unchecked")
	@Test(expected=ItemNotFoundException.class)
	public void shouldNotFoundFound() throws ItemNotFoundException {
		// Fixture
		when(supermarketCatalog.getItem("Vegetables", wrongIdentifier)).thenThrow(ItemNotFoundException.class);
		//Experimentation
		supermarketCheckout.addItem(wrongIdentifier, "Vegetables");
		//Expectations
	}

}

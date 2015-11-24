package com.codetests.supermarket.catalog.checkout.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.codetests.supermarket.catalog.checkout.exceptions.ItemNotFoundException;
import com.codetests.supermarket.catalog.checkout.impl.SupermarketCatalogImpl;
import com.codetests.supermarket.catalog.checkout.repositories.SupermarketCatalogRepository;
import com.codetests.supermarket.catalog.domain.CatalogItem;

@RunWith(MockitoJUnitRunner.class)
public class SupermarketCatalogTest {
	
	@InjectMocks
    private SupermarketCatalogImpl supermarketCatalog;
	
	@Mock
	SupermarketCatalogRepository supermarketCatalogRepository;
	
	Long rightIdentifier = 1L;
	
	Long wrongIdentifier = 7L;
	
	@Mock
	CatalogItem articleItem;
			
	@Test
	public void shouldFindArticle() throws ItemNotFoundException {
		// Fixture
		when(supermarketCatalogRepository.findOne(rightIdentifier)).thenReturn(articleItem);
		//Experimentation
		CatalogItem catalogArticleItem = supermarketCatalog.getItem("Vegetables", rightIdentifier);		
		//Expectations
		assertNotNull(catalogArticleItem);
		assertEquals(catalogArticleItem.getId(), articleItem.getId());
	}

	@Test(expected=ItemNotFoundException.class)
	public void shouldNotFindArticle() throws ItemNotFoundException {
		// Fixture
		//Experimentation
		supermarketCatalog.getItem("Vegetables", wrongIdentifier);
		//Expectations
	}
}


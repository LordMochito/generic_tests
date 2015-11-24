package com.codetests.supermarket.catalog.checkout;

import com.codetests.supermarket.catalog.checkout.exceptions.ItemNotFoundException;
import com.codetests.supermarket.catalog.domain.CatalogItem;

/**
 * Catalog service interface
 * 
 *
 */
public interface SupermarketCatalog {

	public CatalogItem getItem(String itemSet, Long itemId) throws ItemNotFoundException;

}

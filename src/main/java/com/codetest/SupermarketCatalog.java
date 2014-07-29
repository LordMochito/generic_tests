package com.codetest;

import com.codetest.exceptions.ItemNotFoundException;
import com.codetest.pojos.CatalogItem;

/**
 * Catalog service interface
 * 
 * @author pablogutierrez
 *
 */
public interface SupermarketCatalog {

	public CatalogItem getItem(String itemSet, Long itemId) throws ItemNotFoundException;

}

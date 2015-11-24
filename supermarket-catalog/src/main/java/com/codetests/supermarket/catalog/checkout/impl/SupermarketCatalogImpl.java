/**
 * 
 */
package com.codetests.supermarket.catalog.checkout.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.codetests.supermarket.catalog.checkout.SupermarketCatalog;
import com.codetests.supermarket.catalog.checkout.exceptions.ItemNotFoundException;
import com.codetests.supermarket.catalog.checkout.repositories.SupermarketCatalogRepository;
import com.codetests.supermarket.catalog.domain.CatalogItem;

/**
 * 
 * Supermarket catalog service 
 * 
 * @author pablogutierrez
 *
 */
@Named
public class SupermarketCatalogImpl implements SupermarketCatalog {

	@Inject
	SupermarketCatalogRepository supermarketCatalogRepository;
	
	/* (non-Javadoc)
	 * @see com.codetest.SupermarketCatalog#getItem(java.lang.String, java.lang.Long)
	 */
	@Override
	/**
	 * Get Item by Id
	 */
	public CatalogItem getItem(String itemSet, Long itemId) throws ItemNotFoundException {
		CatalogItem item = supermarketCatalogRepository.findOne(itemId);
		if (item == null){
			throw new ItemNotFoundException();
		}else{
			return item;
		}
	}

}

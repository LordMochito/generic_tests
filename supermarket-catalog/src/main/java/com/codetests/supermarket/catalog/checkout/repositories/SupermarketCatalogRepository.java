package com.codetests.supermarket.catalog.checkout.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.codetests.supermarket.catalog.domain.CatalogItem;

/**
 * Catalog Items Repository
 *  
 * @author pablogutierrez
 *
 */
public interface SupermarketCatalogRepository extends PagingAndSortingRepository<CatalogItem, Long>{
}

package com.codetest.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.codetest.pojos.CatalogItem;

/**
 * Catalog Items Repository
 *  
 * @author pablogutierrez
 *
 */
public interface SupermarketCatalogRepository extends PagingAndSortingRepository<CatalogItem, Long>{
}

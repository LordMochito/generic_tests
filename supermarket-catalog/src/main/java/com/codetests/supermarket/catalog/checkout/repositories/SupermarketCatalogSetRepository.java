package com.codetests.supermarket.catalog.checkout.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.codetests.supermarket.catalog.domain.CatalogSet;

public interface SupermarketCatalogSetRepository extends PagingAndSortingRepository<CatalogSet, Long>{

	CatalogSet findByName(String name);
}

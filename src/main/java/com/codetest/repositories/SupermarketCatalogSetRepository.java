package com.codetest.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.codetest.pojos.CatalogSet;

public interface SupermarketCatalogSetRepository extends PagingAndSortingRepository<CatalogSet, Long>{

	CatalogSet findByName(String name);
}

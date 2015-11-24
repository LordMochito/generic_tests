package com.codetests.supermarket.catalog.checkout.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.codetests.supermarket.catalog.domain.BaseInterestRate;

/**
 * Base Interest Rate Repository
 *  
 * @author pablogutierrez
 *
 */
public interface BaseInterestRateRepository extends PagingAndSortingRepository<BaseInterestRate, Long>{
}

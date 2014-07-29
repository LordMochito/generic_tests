package com.codetest.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.codetest.pojos.BaseInterestRate;

/**
 * Base Interest Rate Repository
 *  
 * @author pablogutierrez
 *
 */
public interface BaseInterestRateRepository extends PagingAndSortingRepository<BaseInterestRate, Long>{
}

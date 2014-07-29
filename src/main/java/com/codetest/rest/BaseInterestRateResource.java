package com.codetest.rest;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.codetest.InterestRateService;
import com.codetest.dto.BaseRate;

@Named
@Path("/base_interests_rate")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
/**
 * Set a new  base rate.
 * 
 * This service should be protected and only used by administrators.
 * 
 * At this moment, I need it to make white box style test, to avoid access to the databse from the acceptance tests
 * 
 * @author pablogutierrez
 *
 */
public class BaseInterestRateResource {

	@Inject
	private InterestRateService interestRateService;
	
	
	@PUT
	public Response setNewBaseRate(BaseRate baseRate) {
		interestRateService.setNewBaseRate(baseRate);
		return Response.ok().build();
	}
	
}

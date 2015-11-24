package com.codetests.supermarket.catalog.checkout.rest;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.codetests.supermarket.catalog.checkout.InterestRateService;
import com.codetests.supermarket.catalog.checkout.dto.InterestRate;
import com.codetests.supermarket.catalog.checkout.dto.SpecialRate;
import com.codetests.supermarket.catalog.checkout.enums.ClientType;

@Named
@Path("/interests_rate/{clientType}")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
/**
 * Interest rate calculator based on type of client 
 * 
 * @author pablogutierrez
 *
 */
public class InterestRateResource {

	@Inject
	InterestRateService interestRateService;
	
	@GET
	public Response calculateInterestRate(@PathParam("clientType") String clientTypeString) {
		ClientType clientType = getClientType(clientTypeString);
		Float calculatedRate = interestRateService.calculateRateByClienType(clientType); 
		return Response.ok(new InterestRate(calculatedRate)).build();
	}
	
	@PUT
	public Response setNewBaseRate(@PathParam("clientType") String clientTypeString, SpecialRate specialRate) {
		validateClientType(clientTypeString);
		interestRateService.setNewSpecialRate(specialRate);
		return Response.ok().build();
	}
	
	private void validateClientType(String clientTypeString) {
		ClientType clientType = getClientType(clientTypeString);
		if (! clientType.isSpecial()){
			throw new WebApplicationException(
			        Response
			          .status(Status.BAD_REQUEST)
			          .entity("Client type should be special, and it's: " + clientTypeString)
			          .build()
			      );
		}
			
	}

	private ClientType getClientType(String clientTypeString) {
		try {
			return ClientType.valueOf(clientTypeString);
		} catch (IllegalArgumentException e) {
			throw new WebApplicationException(
			        Response
			          .status(Status.BAD_REQUEST)
			          .entity("Invalid client type: " + clientTypeString + "; Should be one of these (" + ClientType.allNames() + ")")
			          .build()
			      );
		}
	}
}

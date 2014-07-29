package com.codetest.acceptance.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.core.Response.Status;

import com.codetest.acceptance.tests.rest.communications.ClientResponse;
import com.codetest.acceptance.tests.rest.communications.RestMethod;
import com.codetest.acceptance.tests.rest.communications.RestRequestSender;
import com.codetest.acceptance.tests.rest.communications.SimpleClientResponse;
import com.codetest.dto.BaseRate;
import com.codetest.dto.InterestRate;
import com.codetest.starter.Starter;

import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class CalculateInterestRateTest {
	
	@Inject
	RestRequestSender restRequestSender;
	
	private String clientType;
	private ClientResponse<InterestRate> response; 
	private ClientResponse<String>  errorResponse;
	
	@Given("^a valid client type \"([^\"]*)\"$")
	public void a_valid_client_type(String clientType) throws Throwable {
	    this.clientType = clientType;
	}
	
	@Given("^a base interest rate \"([^\"]*)\"$")
	public void a_base_interest_rate(Float baseInterestRate) throws Throwable {
	   SimpleClientResponse invokedRest = restRequestSender.invoke(RestMethod.PUT, "/base_interests_rate",  new BaseRate(baseInterestRate));
	   assertEquals(Status.OK, invokedRest.getStatus()); // base rate established
	}		

	@When("^I request to interest rate service$")
	public void I_request_to_interest_rate_service() throws Throwable {
		response = restRequestSender.invoke(RestMethod.GET, "/interests_rate/" +clientType, InterestRate.class);
	}

	@Then("^I receive the interest rate \"([^\"]*)\"$")
	public void I_receive_the_interest_rate(Float interestRate) throws Throwable {
		assertEquals(Status.OK, response.getStatus());
		assertEquals(new InterestRate(interestRate) , response.getEntity());
	}

	@Given("^an  invalid client type:$")
	public void an_invalid_client_type(DataTable dataTable) throws Throwable {
		List<String> wrongClientTypes = dataTable.asList(String.class);
		for (String wrongClientType : wrongClientTypes) {
			errorResponse = restRequestSender.invoke(RestMethod.GET, "/interests_rate/" + wrongClientType , String.class);
		}
	}

	@Then("^I receive the an \"([^\"]*)\" error$")
	public void I_receive_the_an_error(String arg1) throws Throwable {
		assertEquals(Status.BAD_REQUEST, response.getStatus());
		assertTrue(errorResponse.getEntity().startsWith("Invalid client type"));
	}
	
	@Before(value="@Feature")
    public void initialize() throws Exception {
		if (! Starter.isRunning())
			Starter.startIt();
	}

	public void setClientType(String clientType) {
		this.clientType = clientType;
	}
}
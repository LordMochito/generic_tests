package com.codetest.acceptance.tests;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.core.Response.Status;

import com.codetest.acceptance.tests.rest.communications.RestMethod;
import com.codetest.acceptance.tests.rest.communications.RestRequestSender;
import com.codetest.acceptance.tests.rest.communications.SimpleClientResponse;
import com.codetest.dto.SpecialRate;
import com.codetest.enums.ClientType;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OverrideSpecialRateTest {

	@Inject
	private RestRequestSender restRequestSender;
	
	@Inject
	private CalculateInterestRateTest calculateInterestRateTest;
	
	private SimpleClientResponse invokedRest;
	private String clientType;
	
	@Given("^a valid client special type$")
	public void a_valid_client_special_type() throws Throwable {
		clientType = ClientType.SPECIAL.name();
	}

	@Given("^I request to override a special price \"([^\"]*)\"$")
	public void I_request_to_override_a_special_price(Float overridenRate) throws Throwable {
		invokedRest = restRequestSender.invoke(RestMethod.PUT, "/interests_rate/" + clientType,  new SpecialRate(overridenRate));
		assertEquals(Status.OK, invokedRest.getStatus()); // special rate established
		calculateInterestRateTest.setClientType(clientType);
	}

	@Given("^not SPECIAL client type:$")
	public void not_SPECIAL_client_type(DataTable dataTable) throws Throwable {
		List<String> notSpecialList = dataTable.asList(String.class);
		for (String clientTypes : notSpecialList) {
			clientType = clientTypes;
		}
	}
	
	@When("^I request to override a  not special price \"([^\"]*)\"$")
	public void I_request_to_override_a_not_special_price(Float overridenRate) throws Throwable {
		invokedRest = restRequestSender.invoke(RestMethod.PUT, "/interests_rate/" + clientType,  new SpecialRate(overridenRate));
	}

	@Then("^I receive the a not special client error$")
	public void I_receive_the_a_not_special_client_error() throws Throwable {
		assertEquals(Status.BAD_REQUEST, invokedRest.getStatus()); 
	}


}

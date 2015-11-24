package com.codetests.supermarket.checkout.acceptance.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.TreeSet;

import javax.inject.Inject;

import com.codetests.supermarket.catalog.checkout.SupermarketCheckout;
import com.codetests.supermarket.catalog.checkout.rules.SpecialPriceCheckoutRule;
import com.codetests.supermarket.catalog.checkout.rules.ThreePerTwoCheckoutRule;
import com.codetests.supermarket.catalog.domain.Receipt;
import com.codetests.supermarket.catalog.domain.ReceiptItem;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SupermarketCheckoutAcceptanceTest {

	@Inject
	SupermarketCheckout supermarketCheckout;
	
	Receipt receipt = null;
	
	@Given("^a list of \"([^\"]*)\" with a single identifier \"([^\"]*)\" in a group of \"([^\"]*)\" items with \"([^\"]*)\" of which one$")
	public void a_list_of_with_a_single_identifier_in_a_group_of_items_with_of_which_one(String itemName, Long itemId, String itemSet, Long quantity) throws Throwable {
		//Fixtures
		for (int i = 0; i < quantity; i++) {
			supermarketCheckout.addItem(itemId, itemSet);	
		}
	}

	@Given("^the (\\d+) rules stablished$")
	public void the_rules_stablished(int arg1) throws Throwable {
		supermarketCheckout.addNewRule(new ThreePerTwoCheckoutRule());
		supermarketCheckout.addNewRule(new SpecialPriceCheckoutRule(2, 1.0)); //Every two elements at 1 pound
	}
	
	@When("^I ask for the receipt$")
	public void I_ask_for_the_receipt() throws Throwable {
		//Experimentation
		receipt = supermarketCheckout.getReceipt();
	}

	@Then("^I get an list of the items with their prices$")
	public void I_get_an_list_of_the_items_with_their_prices() throws Throwable {
		TreeSet<ReceiptItem> aggrupatedItems = receipt.getAggrupatedItems();
		assertNotNull(aggrupatedItems);
	}
	
	@Then("^I get a total number with the sum of all of them  \"([^\"]*)\"$")
	public void I_get_a_total_number_with_the_sum_of_all_of_them(Double expectedTotalAmount) throws Throwable {
		assertEquals(expectedTotalAmount, receipt.getTotalAmount());
	}
}

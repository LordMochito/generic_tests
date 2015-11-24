package com.codetest.acceptance.tests;


import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class)

@Cucumber.Options(format = {"pretty", "html:target/cucumber-html-report"}
)


public class RunCukesTest {
	
}
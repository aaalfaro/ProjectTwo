package com.revature.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = {"src/test/java/InsertingWithDb.feature"},
		glue = {"com.revature.StepImplementation"}
		)
public class TestNGRunner extends AbstractTestNGCucumberTests{

}

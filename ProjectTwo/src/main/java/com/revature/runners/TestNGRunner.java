package com.revature.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = {"C:/Users/Administrator/.jenkins/workspace/ProjectTwo/src/test/java/Delete.feature"},
		glue = {"com.revature.StepImplementation"}
		)
public class TestNGRunner extends AbstractTestNGCucumberTests{
	
}

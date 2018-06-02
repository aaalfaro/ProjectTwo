package com.revature.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		//"C:/Users/Administrator/.jenkins/workspace/ProjectTwo/src/test/java/Update.feature"
		features = {"C:/Users/Administrator/.jenkins/workspace/ProjectTwo/ProjectTwo/src/test/java/Caliber.feature"},
		glue = {"com.revature.StepImplementation"}
		)
public class TestNGRunner extends AbstractTestNGCucumberTests{
	
}

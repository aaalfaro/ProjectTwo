package com.revature.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		//"C:/Users/Administrator/.jenkins/workspace/ProjectTwo/ProjectTwo/src/test/java/Update.feature"
		features = {"C:/Users/Administrator/.jenkins/workspace/ProjectTwo/ProjectTwo/src/test/java/Popup.feature","C:/Users/Administrator/.jenkins/workspace/ProjectTwo/ProjectTwo/src/test/java/Close.feature","C:/Users/Administrator/.jenkins/workspace/ProjectTwo/ProjectTwo/src/test/java/DropDown.feature","C:/Users/Administrator/.jenkins/workspace/ProjectTwo/ProjectTwo/src/test/java/Report.feature","C:/Users/Administrator/.jenkins/workspace/ProjectTwo/ProjectTwo/src/test/java/Create.feature","C:/Users/Administrator/.jenkins/workspace/ProjectTwo/ProjectTwo/src/test/java/Update.feature","C:/Users/Administrator/.jenkins/workspace/ProjectTwo/ProjectTwo/src/test/java/Delete.feature"},
		glue = {"com.revature.StepImplementation"}
		)
public class TestNGRunner extends AbstractTestNGCucumberTests{
	
}


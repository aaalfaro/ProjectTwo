package com.revature.StepImplementation;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.revature.Driver.DriverFactory;
import com.revature.pom.AssessBatchPage;
import com.revature.pom.HomePage;
import com.revature.pom.ManageBatchPage;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AssessmentUpdateStepImpl {
	WebDriver driver;
	WebDriverWait wait;
	HomePage home;
	ManageBatchPage manage;
	AssessBatchPage assess;
	
	
	@Given("^a user connects to a web browser$")
	public void a_user_connects_to_a_web_browser() throws Throwable {
		driver = DriverFactory.getDriver("chrome");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 20);
	}

	@Given("^goes to caliber$")
	public void goes_to_caliber() throws Throwable {
		 home = new HomePage(driver);
		 assertEquals("Welcome to Caliber!", home.getId());
	}

	

	@Given("^selects a row title$")
	public void selects_a_row_title() throws Throwable {
	    assess.getUpdateAssessButton().click();
	}

	@When("^picks Assessment Category$")
	public void picks_Assessment_Category() throws Throwable {
	   System.out.println("here");
	}

	@Then("^user will be greeted with all titles$")
	public void user_will_be_greeted_with_all_titles() throws Throwable {
	  assertEquals(assess.getCategories().get(0),"Servlet Verbal");
	}
	
	
}

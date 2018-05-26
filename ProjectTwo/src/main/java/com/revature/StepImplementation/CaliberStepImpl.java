package com.revature.StepImplementation;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.revature.Driver.DriverFactory;
import com.revature.pom.AssessBatchPage;
import com.revature.pom.HomePage;
import com.revature.pom.ManageBatchPage;
import com.revature.pom.POM;
import com.revature.pom.ReportPage;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CaliberStepImpl {

	WebDriver driver;
	WebDriverWait wait;
	HomePage home;
	ManageBatchPage manage;
	AssessBatchPage assess;
	ReportPage report;
	POM cur;

	@Given("^a user opens a webbrowser$")
	public void a_user_opens_a_webbrowser() throws Throwable {
		driver = DriverFactory.getDriver("chrome");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 5);
	}

	@Given("^navigates to caliber$")
	public void navigates_to_caliber() throws Throwable {
		home = new HomePage(driver);
		assertEquals("Welcome to Caliber!", home.getId());
	}

	@Given("^choose to assessBatch$")
	public void choose_to_assessBatch() throws Throwable {
		home.getAssessAnchor().click();
		assess = new AssessBatchPage(driver);
	}

	@When("^user arrives at \"([^\"]*)\"$")
	public void user_arrives_at(String arg1) throws Throwable {
		switch (arg1) {
		case "home":
			home = new HomePage(driver);
			cur = home;
			break;
		case "manage":
			manage = new ManageBatchPage(driver);
			cur = manage;
			break;
		case "assess":
			assess = new AssessBatchPage(driver);
			cur = assess;
			break;
		case "report":
			report = new ReportPage(driver);
			cur = report;
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	@When("^user clicks \"([^\"]*)\"$")
	public void user_clicks(String arg1) throws Throwable {
		switch (arg1) {
		case "home":
			cur.getHomeAnchor().click();
			break;
		case "manage":
			cur.getManageAnchor().click();
			break;
		case "assess":
			cur.getAssessAnchor().click();
			break;
		case "report":
			cur.getReportAnchor().click();
			break;
		case "importBatch":
			home.getManageAnchor().click();
			manage = new ManageBatchPage(driver);
			manage.getImportBatchButton().click();
			break;
		case "viewTrainees":
			home.getManageAnchor().click();
			manage = new ManageBatchPage(driver);
			manage.getViewBatchButton().click();
			break;
		case "updateBatch":
			home.getManageAnchor().click();
			manage = new ManageBatchPage(driver);
			manage.getUpdateBatchButton().click();
			break;
		case "deleteBatch":
			home.getManageAnchor().click();
			manage = new ManageBatchPage(driver);
			manage.getDeleteBatchButton().click();
			break;
		case "addTrainee":
			home.getManageAnchor().click();
			manage = new ManageBatchPage(driver);
			manage.getViewBatchButton().click();
			break;
		case "createAssess":
			home.getAssessAnchor().click();
			assess = new AssessBatchPage(driver);
			assess.getCreateAssessButton().click();
			break;
		case "createWeek":
			home.getAssessAnchor().click();
			assess = new AssessBatchPage(driver);
			assess.getCreateWeekButton().click();
			break;
		case "updateAssess":
			home.getAssessAnchor().click();
			assess = new AssessBatchPage(driver);
			assess.getUpdateAssessButton().click();
			break;
		case "createBatch":
			manage = new ManageBatchPage(driver);
			manage.getCreateBatchButton().click();
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	@Then("^user should be at \"([^\"]*)\"$")
	public void user_should_be_at(String arg1) throws Throwable {
		String test = "";
		switch (arg1) {
		case "home":
			test = "Welcome to Caliber!";
			cur = new HomePage(driver);
			break;
		case "manage":
			test = "Training Name";
			cur = new ManageBatchPage(driver);
			break;
		case "assess":
			test = "Notes";
			cur = new AssessBatchPage(driver);
			break;
		case "report":
			test = "Cumulative Scores";
			cur = new ReportPage(driver);
			break;
		default:
			throw new IllegalArgumentException();
		}
		assertEquals(cur.getId(), test);
	}

	@Then("^user should see \"([^\"]*)\"$")
	public void user_should_see(String arg1) throws Throwable {
		switch (arg1) {
		case "createBatch":
			assertEquals(manage.getCreateBatchId(), "test");
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	@Then("^the \"([^\"]*)\" should occur$")
	public void the_should_occur(String arg1) throws Throwable {
		switch (arg1) {
		case "createBatch":
			assertEquals(manage.getCreateBatchId(), "h4");
			break;
		case "importBatch":
			assertEquals(manage.getImportBatchId(), "a");
			break;
		case "viewTrainees":
			assertEquals(manage.getViewBatchId(), "h3");
			break;
		case "updateBatch":
			assertEquals(manage.getUpdateBatchId(), "label");
			break;
		case "deleteBatch":
			assertEquals(manage.getDeleteBatchId(), "span");
			break;
		case "addTrainee":
			assertEquals(manage.getAddTraineeId(), "h3");
			break;
		case "createAssess":
			assertEquals(assess.getCreateAssessId(), "h4");
			break;
		case "createWeek":
			assertEquals(assess.getCreateWeekId(), "h4");
			break;
		case "updateAssess":
			assertEquals(assess.getUpdateAssessId(), "label");
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	@After
	public void shutDownDrivers() {
		if (driver != null)
			driver.close();
	}

}

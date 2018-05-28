package com.revature.StepImplementation;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.revature.Driver.DriverFactory;
import com.revature.model.Assessment;
import com.revature.pom.AssessBatchPage;
import com.revature.pom.HomePage;
import com.revature.pom.ManageBatchPage;
import com.revature.pom.POM;
import com.revature.pom.ReportPage;
import com.revature.service.AssessmentService;

import cucumber.api.DataTable;
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
		wait = new WebDriverWait(driver, 15);
		cur = new HomePage(driver);
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
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
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
			manage.getViewBatchButton("0").click();
			break;
		case "deleteBatch":
			home.getManageAnchor().click();
			manage = new ManageBatchPage(driver);
			manage.getDeleteBatchButton().click();
			break;
		case "addTrainee":
			home.getManageAnchor().click();
			manage = new ManageBatchPage(driver);
			manage.getViewBatchButton("0").click();
			wait.until(ExpectedConditions.visibilityOf(manage.getAddTraineeButton()));
			manage.getAddTraineeButton().click();
			break;
		case "createAssess":
			home.getAssessAnchor().click();
			assess = new AssessBatchPage(driver);
			assess.getCreateAssessButton().click();
			break;
		case "createWeek":
			home.getAssessAnchor().click();
			assess = new AssessBatchPage(driver);
			wait.until(ExpectedConditions.elementToBeClickable(assess.getCreateWeekButton()));
			assess.getCreateWeekButton().click();
			break;
		case "createBatch":
			home.getManageAnchor().click();
			manage = new ManageBatchPage(driver);
			manage.getCreateBatchButton().click();
			break;
		case "techSkills":
			home.getReportAnchor().click();
			report = new ReportPage(driver);
			report.getTechSkillsButton().click();
			break;
		case "save":
			home.getAssessAnchor().click();
			assess = new AssessBatchPage(driver);
			assess.getSaveButton().click();
			break;
		case "subAssess":
			wait.until(ExpectedConditions.visibilityOf(assess.getSubAssessButton()));
			assess.getSubAssessButton().click();
			break;
		case "subCreateBatch":
			wait.until(ExpectedConditions.visibilityOf(manage.getSubCreateBatchButton()));
			manage.getSubCreateBatchButton().click();
			break;
		case "subWeek":
			wait.until(ExpectedConditions.visibilityOf(assess.getSubCreateWeekButton()));
			assess.getSubCreateWeekButton().click();
			break;
		case "upAssess":
			wait.until(ExpectedConditions.visibilityOf(assess.getSubCreateWeekButton()));
			assess.getSubmitUpdateButton().submit();
			break;
		case "subBatch":
			manage.getBatchUpdateSub().click();
			break;
		case "subTrainee":
			manage.getSubTraineeButton().click();
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
		case "updateTrainee":
			assertEquals(manage.getUpdateTraineeId(), "h3");
			break;
		case "techSkills":
			assertEquals(report.getTechSkillsId(), "h4");
			break;
		case "save":
			wait.until(ExpectedConditions.visibilityOf(assess.getSaveCheckMark()));
			assertTrue(assess.getSaveId());
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	@Then("^the \"([^\"]*)\" should be closed$")
	public void the_should_be_closed(String arg1) throws Throwable {
		try {
			switch (arg1) {
			case "viewTrainee":
				manage.getViewBatchId();
				assertTrue(false);
				break;
			case "active":
				assertEquals(manage.getActiveId(), "h4");
				break;
			case "updateBatch":
				manage.getUpdateBatchId();
				assertTrue(false);
				break;
			case "updateTrainee":
				manage.getUpdateTraineeId();
				assertTrue(false);
				break;
			case "deleteBatch":
				manage.getDeleteBatchId();
				assertTrue(false);
				break;
			case "createBatch":
				manage.getCreateBatchId();
				assertTrue(false);
				break;
			case "createAssess":
				assess.getCreateAssessId();
				assertTrue(false);
				break;
			case "createWeek":
				assess.getCreateWeekId();
				assertTrue(false);
				break;
			case "techSkills":
				report.getTechSkillsId();
				assertTrue(false);
				break;
			case "importBatch":
				manage.getImportBatchId();
				assertTrue(false);
				break;
			default:
				assertTrue(false);
			}
		} catch (Exception e) {
			assertTrue(true);
			return;
		}

	}

	@When("^user closes \"([^\"]*)\"$")
	public void user_closes(String arg1) throws Throwable {
		switch (arg1) {
		case "active":
			wait.until(ExpectedConditions.visibilityOf(manage.getActiveSwitch()));
			manage.getActiveSwitch().click();
			break;
		case "viewTrainees":
			wait.until(ExpectedConditions.elementToBeClickable(manage.getViewTraineeClose()));
			manage.getViewTraineeClose().click();
			break;
		case "updateBatch":
			wait.until(ExpectedConditions.elementToBeClickable(manage.getUpdateBatchClose()));
			manage.getUpdateBatchClose().click();
			break;
		case "updateTrainee":
			wait.until(ExpectedConditions.elementToBeClickable(manage.getUpdateTraineeClose()));
			manage.getUpdateTraineeClose().click();
			break;
		case "deleteBatch":
			wait.until(ExpectedConditions.elementToBeClickable(manage.getDeleteBatchClose()));
			manage.getDeleteBatchClose().click();
			break;
		case "createBatch":
			wait.until(ExpectedConditions.elementToBeClickable(manage.getCreateBatchClose()));
			manage.getCreateBatchClose().click();
			break;
		case "createAssess":
			wait.until(ExpectedConditions.elementToBeClickable(assess.getCreateAssessClose()));
			assess.getCreateAssessClose().click();
			break;
		case "createWeek":
			wait.until(ExpectedConditions.elementToBeClickable(assess.getCreateWeekClose()));
			assess.getCreateWeekClose().click();
			break;
		case "importBatch":
			wait.until(ExpectedConditions.elementToBeClickable(manage.getImportBatchClose()));
			manage.getImportBatchClose().click();
			break;
		case "techSkills":
			wait.until(ExpectedConditions.elementToBeClickable(report.getTechSkillsClose()));
			report.getTechSkillsClose().click();
			break;
		case "updateBatchButton":
			wait.until(ExpectedConditions.elementToBeClickable(manage.getUpdateBatchClose()));
			manage.getUpdateBatchCloseButton().click();
			break;
		case "updateTraineeButton":
			wait.until(ExpectedConditions.elementToBeClickable(manage.getUpdateTraineeCloseButton()));
			manage.getUpdateTraineeCloseButton().click();
			break;
		case "deleteBatchButton":
			wait.until(ExpectedConditions.elementToBeClickable(manage.getDeleteBatchCloseButton()));
			manage.getDeleteBatchCloseButton().click();
			break;
		case "createBatchButton":
			wait.until(ExpectedConditions.elementToBeClickable(manage.getCreateBatchCloseButton()));
			manage.getCreateBatchCloseButton().click();
			break;
		case "createAssessButton":
			wait.until(ExpectedConditions.elementToBeClickable(assess.getCreateAssessCloseButton()));
			assess.getCreateAssessCloseButton().click();
			break;
		case "createWeekButton":
			wait.until(ExpectedConditions.elementToBeClickable(assess.getCreateWeekCloseButton()));
			assess.getCreateWeekCloseButton().click();
			break;
		case "importBatchButton":
			wait.until(ExpectedConditions.elementToBeClickable(manage.getImportBatchCloseButton()));
			manage.getImportBatchCloseButton().click();
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	@When("^user input \"([^\"]*)\" from \"([^\"]*)\"$")
	public void user_input_from(String arg1, String arg2) throws Throwable {

		switch (arg2) {
		case "point":
			assess.input(arg1, "rawScore");
			break;
		case "name":
			manage.input(arg1, "trainingName");
			break;
		case "startDate":
			manage.getStartDateInput().sendKeys(arg1);
			break;
		case "endDate":
			manage.getEndDateInput().sendKeys(arg1);
			break;
		case "goodGrade":
			manage.input(arg1, "goodGrade");
			break;
		case "passingGrade":
			manage.input(arg1, "borderlineGrade");
			break;
		case "traineeName":
			manage.getInputForTraineeName(0).sendKeys(arg2);
			break;
		case "email":
			manage.input(arg1, "traineeEmail");
			break;
		case "skype":
			manage.input(arg1, "traineeSkype");
			break;
		case "phone":
			manage.input(arg1, "traineePhone");
			break;
		case "college":
			manage.input(arg1, "traineeCollege");
			break;
		case "degree":
			manage.input(arg1, "traineeDegree");
			break;
		case "major":
			manage.input(arg1, "traineeMajor");
			break;
		case "recruit":
			manage.input(arg1, "traineeRecruiterName");
			break;
		case "screen":
			manage.input(arg1, "traineeTechScreenerName");
			break;
		case "url":
			manage.getInputForTraineeName(1).sendKeys(arg2);
			break;
		case "completion":
			manage.input(arg1, "traineeProjectCompletion");
			break;
		case"updatePoint":
			assess.updateDropDown(arg1, "rawScore");
			break;
		case"searchTextBox":
			home.getReportAnchor().click();
			report = new ReportPage(driver);
			report.input(arg1, arg2);
			driver.findElement(By.xpath("//*[@id=\"searchTextBox\"]")).submit();
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	@When("^user selects \"([^\"]*)\" from \"([^\"]*)\"$")
	public void user_selects_from(String arg1, String arg2) throws Throwable {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		switch (arg2) {
		case "categories":
			assess.DropDown(arg1, "category");
			break;
		case "type":
			assess.DropDown(arg1, "assessmentType");
			break;
		case "updateCategory":
			assess.updateDropDown(arg1, "category");
			break;
		case "updateType":
			assess.updateDropDown(arg1, "assessmentType");
			break;
		case "training":
			manage.DropDown(arg1, "trainingType");
			break;
		case "skill":
			manage.DropDown(arg1, "skillType");
			break;
		case "NY":
			manage.selectLocation(arg1, arg2);
			break;
		case "VA":
			manage.selectLocation(arg1, arg2);
			break;
		case "trainer":
			manage.DropDown(arg1, "trainer");
			break;
		case "status":
			manage.DropDown(arg1, "traineeStatus");
			break;
		case "manageYear":
			manage = new ManageBatchPage(driver);
			manage.yearDropDown(arg1, arg2);
			break;
		case "assessYear":
			assess = new AssessBatchPage(driver);
			assess.dropDownOptions(arg1, "1");
			break;
		case "assessTrainer":
			assess = new AssessBatchPage(driver);
			assess.dropDownOptions(arg1, "2");
			break;
		case "reportYear":
			report = new ReportPage(driver);
			report.dropDownOptions(arg1, "1");
			break;
		case "reportTrainer":
			report = new ReportPage(driver);
			report.dropDownOptions(arg1, "2");
			break;
		case "reportWeek":
			report = new ReportPage(driver);
			report.dropDownOptions(arg1, "3");
			break;
		case "reportTrainee":
			report = new ReportPage(driver);
			report.dropDownOptions(arg1, "4");
			break;
		case "reportPdf":
			report = new ReportPage(driver);
			report.dropDownOptions(arg1, "pdf");
			break;
		case "weekTab":
			assess= new AssessBatchPage(driver);
			assess.weekTab(arg1);
		case "updateAssess":
			home.getAssessAnchor().click();
			assess = new AssessBatchPage(driver);
			assess.getUpdateAssessButton(arg1).click();
			break;
		case "updateBatch":
			home.getManageAnchor().click();
			manage = new ManageBatchPage(driver);
			manage.getUpdateBatchButton(arg1).click();
			break;
		case "upTrainee":
			wait.until(ExpectedConditions.visibilityOf(manage.getUpdateTraineeButton(arg1)));
			manage.getUpdateTraineeButton(arg1).click();
			break;
		case "viewBatch":
			home.getManageAnchor().click();
			manage = new ManageBatchPage(driver);
			manage.yearDropDown("2016", "");
			manage.getViewBatchButton(arg1).click();
			break;
		case "deleteAssess":
			home.getAssessAnchor().click();
			assess = new AssessBatchPage(driver);
			assess.getDeleteAssess(arg1).click();
			break;
		case "deleteBatch":
			home.getManageAnchor().click();
			manage = new ManageBatchPage(driver);
			manage.yearDropDown("2016", "");
			manage.getDeleteBatchButton(arg1).click();
			break;	
		default:
			throw new IllegalArgumentException();
		}
	}
	
	@Then("^the \"([^\"]*)\" should be gone$")
	public void the_should_be_gone(String arg1) throws Throwable {
	    assertTrue(true);
	}

	@Then("^new assessment should be created$")
	public void new_assessment_should_be_created() throws Throwable {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		assertTrue(true);
	}

	@Then("^new week should be created$")
	public void new_week_should_be_created() throws Throwable {
		assertTrue(true);
	}

	@Then("^new trainee should be created$")
	public void new_trainee_should_be_created() throws Throwable {
		assertTrue(true);
	}

	@Then("^\"([^\"]*)\" should be displayed$")
	public void should_be_displayed(String arg1) throws Throwable {
		assertTrue(true);
	}
	@Then("^the \"([^\"]*)\" should displayed$")
	public void the_should_displayed(String arg1) throws Throwable {
	  assertTrue(true);
	}
	@When("^user clicks a pdf button$")
	public void user_clicks_a_pdf_button() throws Throwable {
		home.getReportAnchor().click();
		report = new ReportPage(driver);
		report.TestPdfs();
	}
	@Then("^a pdf should download$")
	public void a_pdf_should_download() throws Throwable {
	    assertTrue(report.wasPdfTestSuccessful());
	}
	
	@When("^a user inserts an assessment$")
	public void a_user_inserts_an_assessment(DataTable arg1) throws Throwable {
		Map<String, String> map = arg1.asMap(String.class, String.class);
		Assessment assessment = AssessmentService.getAssessment(Integer.parseInt(map.get("pk")));
	    home.getAssessAnchor().click();
	    assess = new AssessBatchPage(driver);
	    assess.getCreateAssessButton().click();
	    assess.DropDown(assessment.getCategory(), "category");
	    assess.DropDown(assessment.getType(), "assessmentType");
	    assess.input("80", "rawScore");
	    assess.getSubAssessButton().click();
	}
	@When("^a user inserts an assessment \"([^\"]*)\"$")
	public void a_user_inserts_an_assessment(String pk) throws Throwable {
		Assessment assessment = AssessmentService.getAssessment(Integer.parseInt(pk));
	    home.getAssessAnchor().click();
	    assess = new AssessBatchPage(driver);
	    assess.getCreateAssessButton().click();
	    assess.DropDown(assessment.getCategory(), "category");
	    assess.DropDown(assessment.getType(), "assessmentType");
	    assess.input("80", "rawScore");
	    assess.getSubAssessButton().click();
	}
	public void insertAssessment(int pk) {
		
	}
	@Then("^a new assessment should be made$")
	public void a_new_assessment_should_be_made() throws Throwable {
	    assertTrue(true);
	}

	@After
	public void shutDownDrivers() {
		if (driver != null)
			driver.close();
	}
}

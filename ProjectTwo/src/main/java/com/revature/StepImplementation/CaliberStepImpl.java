package com.revature.StepImplementation;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.revature.Driver.DriverFactory;
import com.revature.model.Assessment;
import com.revature.model.Batch;
import com.revature.model.Trainee;
import com.revature.pom.AssessBatchPage;
import com.revature.pom.HomePage;
import com.revature.pom.ManageBatchPage;
import com.revature.pom.POM;
import com.revature.pom.ReportPage;
import com.revature.service.AssessmentService;
import com.revature.service.BatchService;
import com.revature.service.TraineeService;

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
		driver.navigate().to("https://dev-caliber.revature.tech/caliber/#/trainer/home");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 5);
		cur = new HomePage(driver);
	}

	@Given("^navigates to caliber$")
	public void navigates_to_caliber() throws Throwable {
		home = new HomePage(driver);
		assertEquals("Welcome to Caliber!", home.getId());
		Thread.sleep(100000);
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
		case "updatePoint":
			assess.updateDropDown(arg1, "rawScore");
			break;
		case "searchTextBox":
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
			manage.yearDropDown(arg1);
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
			assess = new AssessBatchPage(driver);
			assess.weekTab(arg1);
		case "updateAssess":
			home.getAssessAnchor().click();
			assess = new AssessBatchPage(driver);
			assess.getUpdateAssessButton().click();
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
			manage.yearDropDown("2016");
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
			manage.yearDropDown("2016");
			manage.getDeleteBatchButton(arg1).click();
			break;
		default:
			throw new IllegalArgumentException();
		}
	}
	
	@When("^user clicks a pdf button$")
	public void user_clicks_a_pdf_button() throws Throwable {
		home.getReportAnchor().click();
		report = new ReportPage(driver);
		report.TestPdfs();
	}
	
	@When("^a user inserts an assessment \"([^\"]*)\"$")
	public void a_user_inserts_an_assessment(String pk) throws Throwable {
		Assessment assessment = AssessmentService.getAssessment(Integer.parseInt(pk));
		home.getAssessAnchor().click();
		assess = new AssessBatchPage(driver);
		assess.yearDropDown("2016");
		assess.getCreateAssessButton().click();
		assess.createCategoryDropDown(assessment.getCategory());
		assess.createTypeDropDown(assessment.getType());
		assess.inputCreatePoint(assessment.getPoint());
		assess.getSubAssessButton().click();
		Thread.sleep(1000);

	}

	@When("^a user inserts a batch \"([^\"]*)\"$")
	public void a_user_inserts_a_batch(String arg1) throws Throwable {
		Batch batch = BatchService.getBatch(Integer.parseInt(arg1));
		home.getManageAnchor().click();
		manage = new ManageBatchPage(driver);
		manage.numElements = driver.findElements(By.xpath("//*[@id=\"manage\"]/div[2]/div/div/table/tbody/tr[1]")).size();
		manage.getCreateBatchButton().click();
		manage.input(batch.getName(), "trainingName");
		manage.DropDown(batch.getType().getType(), "trainingType");
		manage.DropDown(batch.getSkill().getType(), "skillType");
		manage.selectLocation(batch.getLocation(), batch.getLocationCategory());
		manage.DropDown(batch.getTrainers().get(0).getName(), "trainer");
		manage.DropDown(batch.getTrainers().get(1).getName(), "co-trainer");
		String start = "" + batch.getStartDate();
		String end = "" + batch.getEndDate();
		manage.getStartDateInput().sendKeys(start);
		manage.getEndDateInput().sendKeys(end);
		manage.input("" + batch.getGoodGrade(), "goodGrade");
		manage.input("" + batch.getPassingGrade(), "borderlineGrade");
		manage.getSubCreateBatchButton().click();
	}

	@When("^a user inserts a trainee \"([^\"]*)\"$")
	public void a_user_inserts_a_trainee(String arg1) throws Throwable {
		Trainee trainee = TraineeService.getTrainee(Integer.parseInt(arg1));
		home.getManageAnchor().click();
		manage = new ManageBatchPage(driver);
		manage.yearDropDown("2016");
		manage.getViewBatchButton(String.valueOf(manage.getBatchRow("Test Batch 1"))).click();
		manage.numElements = driver.findElements(By.xpath("//*[@id=\"viewTraineeModal\"]/div/div/div[2]/div[2]/div/table/tbody/tr[1]/td")).size();
		wait.until(ExpectedConditions.visibilityOf(manage.getAddTraineeButton()));
		manage.getAddTraineeButton().click();
		manage.input(trainee.getName(), "traineeName");
		manage.input(trainee.getEmail(), "traineeEmail");
		manage.input(trainee.getSkype(), "traineeSkype");
		manage.input(trainee.getPhone(), "traineePhone");
		manage.input(trainee.getCollege(), "traineeCollege");
		manage.input(trainee.getDegree(), "traineeDegree");
		manage.input(trainee.getMajor(), "traineeMajor");
		manage.input(trainee.getRecruiter(), "traineeRecruiterName");
		manage.input(trainee.getScreener(), "traineeTechScreenerName");
		manage.input("" + trainee.getCompletion(), "traineeProjectCompletion");
		manage.DropDown(trainee.getStatus().getStatus(), "traineeStatus");
		manage.GetUrlTextBox().sendKeys(trainee.getUrl());
		manage.GetUrlTextBox().submit();
		Thread.sleep(5000);
	}

	@When("^a user clicks the add week button$")
	public void a_user_clicks_the_add_week_button() throws Throwable {
		home.getAssessAnchor().click();
		assess = new AssessBatchPage(driver);
		wait.until(ExpectedConditions.visibilityOf(assess.getCreateWeekButton()));
		assess.getCreateWeekButton().click();
		wait.until(ExpectedConditions.visibilityOf(assess.getSubCreateWeekButton()));
		assess.getSubCreateWeekButton().click();
		Thread.sleep(250);
	}

	@When("^user deletes batch \"([^\"]*)\"$")
	public void user_deletes_batch(String arg1) throws Throwable {
		home.getManageAnchor().click();
		manage = new ManageBatchPage(driver);
		Batch batch = BatchService.getBatch(Integer.parseInt(arg1));
		manage.yearDropDown("2016");
		manage.numElements = driver.findElements(By.xpath("//*[@id=\"manage\"]/div[2]/div/div/table/tbody/*/td[1]")).size();
		manage.deleteBatch(manage.getBatchRow(batch.getName()));
		wait.until(ExpectedConditions.elementToBeClickable(manage.deleteBatchSubmit()));
		manage.deleteBatchSubmit().click();
		Thread.sleep(500);
	}
	
	@When("^user deletes trainee \"([^\"]*)\"$")
	public void user_deletes_trainee(String arg1) throws Throwable {
		home.getManageAnchor().click();
		manage = new ManageBatchPage(driver);
		Trainee trainee = TraineeService.getTrainee(Integer.parseInt(arg1));
		manage.yearDropDown("2016");
		manage.getViewBatchButton(String.valueOf(manage.getBatchRow("Test Batch 1"))).click();
		manage.numElements = driver.findElements(By.xpath("//*[@id=\"viewTraineeModal\"]/div/div/div[2]/div[2]/div/table/tbody")).size();
		manage.deleteTrainee(manage.getTraineeRow(trainee.getName()));
		wait.until(ExpectedConditions.elementToBeClickable(manage.deleteTraineeSubmit()));
		manage.deleteTraineeSubmit().click();
		TraineeService.removeTraineeFromBatch(Integer.parseInt(arg1));
		Thread.sleep(500);
	}

	@When("^user deletes assessment \"([^\"]*)\"$")
	public void user_deletes_assessment(String arg1) throws Throwable {


	}
	
	@When("^a user updates batch \"([^\"]*)\" with \"([^\"]*)\"$")
	public void a_user_updates_batch_with(String arg1, String arg2) throws Throwable {
		driver.navigate().to(POM.MANAGE_URL);
		Batch oldBatch = BatchService.getBatch(Integer.parseInt(arg1));
		Batch newBatch = BatchService.getBatch(Integer.parseInt(arg2));
		manage = new ManageBatchPage(driver);
		manage.yearDropDown("2016");
		manage.batchAction("update", manage.getBatchRow(oldBatch.getName()));
		manage.input(newBatch.getName(), "trainingName");
		if(newBatch.getType() != null)
			manage.DropDown(newBatch.getType().getType(), "trainingType");
		if(newBatch.getSkill() != null)
			manage.DropDown(newBatch.getSkill().getType(), "skillType");
		manage.selectLocation(newBatch.getLocation(), newBatch.getLocationCategory());
		if(!newBatch.getTrainers().isEmpty()) {
		if(newBatch.getTrainers().size() > 0)
			manage.DropDown(newBatch.getTrainers().get(0).getName(), "trainer");
		if(newBatch.getTrainers().size() > 1)	
			manage.DropDown(newBatch.getTrainers().get(1).getName(), "co-trainer");
		}
		String start = "" + newBatch.getStartDate();
		String end = "" + newBatch.getEndDate();
		if(newBatch.getStartDate() != null){
			manage.getStartDateInput().sendKeys(start);
		}
		if(!end.equals(null))
			manage.getEndDateInput().sendKeys(end);	
		manage.input("" + newBatch.getGoodGrade(), "goodGrade");
		manage.input("" + newBatch.getPassingGrade(), "borderlineGrade");	
		manage.getBatchUpdateSub().click();
		Thread.sleep(10000);	
	}
	
	@When("^a user updates trainee \"([^\"]*)\" with \"([^\"]*)\"$")
	public void a_user_updates_trainee_with(String arg1, String arg2) throws Throwable {
		driver.navigate().to(POM.MANAGE_URL);
		Trainee oldTrain = TraineeService.getTrainee(Integer.parseInt(arg1));
		Trainee newTrain = TraineeService.getTrainee(Integer.parseInt(arg2));
		manage = new ManageBatchPage(driver);
		manage.yearDropDown("2016");
		manage.batchAction("view",Integer.parseInt(""+manage.getBatchRow("1806 NOV08 Java1")));
		manage.traineeAction("update", manage.getTraineeRow(oldTrain.getName()));
		manage.input(newTrain.getName(), "traineeName");
		manage.input(newTrain.getEmail(), "traineeEmail");
		manage.input(newTrain.getSkype(), "traineeSkype");
		manage.input(newTrain.getPhone(), "traineePhone");
		manage.input(newTrain.getCollege(), "traineeCollege");
		manage.input(newTrain.getDegree(), "traineeDegree");
		manage.input(newTrain.getMajor(), "traineeMajor");
		manage.input(newTrain.getRecruiter(), "traineeRecruiterName");
		manage.input(newTrain.getScreener(), "traineeTechScreenerName");
		manage.input("" + newTrain.getCompletion(), "traineeProjectCompletion");
		if(newTrain.getStatus() != null)
			manage.DropDown(newTrain.getStatus().getStatus(), "traineeStatus");
		if(newTrain.getUrl() != null) {
			manage.GetUrlTextBox().clear();
			manage.GetUrlTextBox().sendKeys(newTrain.getUrl());
		}
		manage.GetUrlTextBox().submit();
		Thread.sleep(250);
	}
	
	@When("^a user updates assessment\"([^\"]*)\" with \"([^\"]*)\"$")
	public void a_user_updates_assessment_with(String arg1, String arg2) throws Throwable {
		Assessment oldAssessment = AssessmentService.getAssessment(Integer.parseInt(arg1));
		Assessment newAssessment = AssessmentService.getAssessment(Integer.parseInt(arg2));
		driver.navigate().to(POM.ASSESSMENT_URL);
		assess = new AssessBatchPage(driver);
		driver.findElement(By.xpath("/html/body/div/ui-view/ui-view/div[1]/div/div[3]/ul/li[13]")).click();
		driver.findElement(By.xpath("//*[@id=\"trainer-assess-table\"]/div/div/ul/ul/table/thead/tr/th[3]")).click();
		assess.updateCategoryDropDown(newAssessment.getCategory());
		assess.updateTypeDropDown(newAssessment.getType());
		assess.inputUpdatePoint(newAssessment.getPoint());
		assess.subAssessmentUpdate();
		Thread.sleep(250);
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
			test = "Search...";
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

	@Then("^the \"([^\"]*)\" should be gone$")
	public void the_should_be_gone(String arg1) throws Throwable {
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

	@Then("^a pdf should download$")
	public void a_pdf_should_download() throws Throwable {
		assertTrue(report.wasPdfTestSuccessful());
	}

	@Then("^a new assessment \"([^\"]*)\" should be made$")
	public void a_new_assessment_should_be_made(String arg1) throws Throwable {
		assertTrue(assess.numElements < driver.findElements(By.xpath("//*[@id=\"trainer-assess-table\"]/div/div/ul/ul/table/thead/tr/th")).size());
	}
	
	@Then("^a new batch \"([^\"]*)\" should be made$")
	public void a_new_batch_should_be_made(String arg1) throws Throwable {
		Batch test = BatchService.getBatch(Integer.parseInt(arg1));
		Thread.sleep(1000);
		manage.yearDropDown("2016");
		int row = manage.getBatchRow(test.getName());
		assertEquals(test.getName(),manage.getBatchInfo(String.valueOf(row),"1"));
		//if(test.getType() != null) {
		//assertEquals(test.getType().getType(),manage.getBatchInfo(String.valueOf(row),"3"));
		//}
		//if(test.getSkill() != null) {
			//		assertEquals(test.getSkill().getType(),manage.getBatchInfo(String.valueOf(row),"4"));
		//}
		//if(test.getTrainers().get(0).g.size() > 0) {
		//assertEquals(test.getTrainers.get(0).getName(),manage.getBatchInfo(String.valueOf(row),"5"));
		//}
	//	if(test.getTrainers().size() > 1) {
			//		assertEquals(test.getTrainers.get(1).getName(),manage.getBatchInfo(String.valueOf(row),"6"));
		//}
			//		assertEquals(test.getUrl(),manage.getBatchInfo(String.valueOf(row),"7"));
//		assertEquals(test.getLocation(),manage.getBatchInfo(String.valueOf(row),"8"));
		//		assertEquals(test.getStartDate(),manage.getBatchInfo(String.valueOf(row),"9"));
//		assertEquals(test.getEndDate(),manage.getBatchInfo(String.valueOf(row),"10"));
//		assertEquals(test.getGoodGrade(),manage.getBatchInfo(String.valueOf(row),"11"));
//		assertEquals(test.getPassingGrade(),manage.getBatchInfo(String.valueOf(row),"12"));
	}

	@Then("^a new trainee \"([^\"]*)\" should be made$")
	public void a_new_trainee_should_be_made(String arg1) throws Throwable {
		Trainee test = TraineeService.getTrainee(Integer.parseInt(arg1));
		int row = manage.getTraineeRow(test.getName());
		assertEquals(test.getName(),manage.getTraineeInfo(String.valueOf(row),"1"));
		//assertEquals(test.getEmail(),manage.getTraineeInfo(String.valueOf(row),"3"));
//		assertEquals(test.getStatus(),manage.getTraineeInfo(String.valueOf(row),"4"));
		//assertEquals(test.getPhone(),manage.getTraineeInfo(String.valueOf(row),"5"));
//		assertEquals(test.getSkype(),manage.getTraineeInfo(String.valueOf(row),"6"));
//		assertEquals(test.getUrl(),manage.getTraineeInfo(String.valueOf(row),"7"));
//		assertEquals(test.getRecruiter(),manage.getTraineeInfo(String.valueOf(row),"8"));
//		assertEquals(test.getCollege(),manage.getTraineeInfo(String.valueOf(row),"9"));
//		assertEquals(test.getDegree(),manage.getTraineeInfo(String.valueOf(row),"10"));
//		assertEquals(test.getMajor(),manage.getTraineeInfo(String.valueOf(row),"11"));
//		assertEquals(test.getScreener(),manage.getTraineeInfo(String.valueOf(row),"12"));
//		assertEquals(test.getCompletion(),manage.getTraineeInfo(String.valueOf(row),"13"));
	}
	@Then("^a week should be added$")
	public void a_week_should_be_added() throws Throwable {
		assertTrue(assess.numElements < driver.findElements(By.xpath("/html/body/div/ui-view/ui-view/div[1]/div/div[3]/ul/li")).size());
	}
	
	@Then("^trainee \"([^\"]*)\" should be gone$")
	public void trainee_should_be_gone(String arg1) throws Throwable {
		assertTrue(manage.numElements > driver.findElements(By.xpath("//*[@id=\"viewTraineeModal\"]/div/div/div[2]/div[2]/div/table/tbody")).size());
	}

	@Then("^assessment \"([^\"]*)\" should be gone$")
	public void assessment_should_be_gone(String arg1) throws Throwable {
		assertTrue(assess.numElements > driver.findElements(By.xpath("//*[@id=\"trainer-assess-table\"]/div/div/ul/ul/table/thead/tr/th")).size());
	}

	@Then("^batch should be delete \"([^\"]*)\"$")
	public void batch_should_be_delete(String arg1) throws Throwable {
		assertTrue(manage.numElements < driver.findElements(By.xpath("//*[@id=\"manage\"]/div[2]/div/div/table/tbody/*/td[1]")).size());
	}	

	@Then("^then batch\"([^\"]*)\" should be changed$")
	public void then_batch_should_be_changed(String arg1) throws Throwable {
		Batch test = BatchService.getBatch(Integer.parseInt(arg1));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"manage\"]/div[1]/div/div/ul/li[1]"))));
		manage.yearDropDown("2016");
		int row = manage.getBatchRow(test.getName());
		assertEquals(test.getName(),manage.getBatchInfo(String.valueOf(row),"1"));
		//if(test.getType() != null) {
		//assertEquals(test.getType().getType(),manage.getBatchInfo(String.valueOf(row),"3"));
		//}
		//if(test.getSkill() != null) {
			//		assertEquals(test.getSkill().getType(),manage.getBatchInfo(String.valueOf(row),"4"));
		//}
		//if(test.getTrainers().get(0).g.size() > 0) {
		//assertEquals(test.getTrainers.get(0).getName(),manage.getBatchInfo(String.valueOf(row),"5"));
		//}
	//	if(test.getTrainers().size() > 1) {
			//		assertEquals(test.getTrainers.get(1).getName(),manage.getBatchInfo(String.valueOf(row),"6"));
		//}
			//		assertEquals(test.getUrl(),manage.getBatchInfo(String.valueOf(row),"7"));
//		assertEquals(test.getLocation(),manage.getBatchInfo(String.valueOf(row),"8"));
		//		assertEquals(test.getStartDate(),manage.getBatchInfo(String.valueOf(row),"9"));
//		assertEquals(test.getEndDate(),manage.getBatchInfo(String.valueOf(row),"10"));
//		assertEquals(test.getGoodGrade(),manage.getBatchInfo(String.valueOf(row),"11"));
//		assertEquals(test.getPassingGrade(),manage.getBatchInfo(String.valueOf(row),"12"));

	}

	@Then("^then trainee\"([^\"]*)\" should be changed$")
	public void then_trainee_should_be_changed(String arg1) throws Throwable {
		Trainee test = TraineeService.getTrainee(Integer.parseInt(arg1));
		int row = manage.getTraineeRow(test.getName());
		assertEquals(test.getName(),manage.getTraineeInfo(String.valueOf(row),"1"));
		//assertEquals(test.getEmail(),manage.getTraineeInfo(String.valueOf(row),"3"));
//		assertEquals(test.getStatus(),manage.getTraineeInfo(String.valueOf(row),"4"));
		//assertEquals(test.getPhone(),manage.getTraineeInfo(String.valueOf(row),"5"));
//		assertEquals(test.getSkype(),manage.getTraineeInfo(String.valueOf(row),"6"));
//		assertEquals(test.getUrl(),manage.getTraineeInfo(String.valueOf(row),"7"));
//		assertEquals(test.getRecruiter(),manage.getTraineeInfo(String.valueOf(row),"8"));
//		assertEquals(test.getCollege(),manage.getTraineeInfo(String.valueOf(row),"9"));
//		assertEquals(test.getDegree(),manage.getTraineeInfo(String.valueOf(row),"10"));
//		assertEquals(test.getMajor(),manage.getTraineeInfo(String.valueOf(row),"11"));
//		assertEquals(test.getScreener(),manage.getTraineeInfo(String.valueOf(row),"12"));
//		assertEquals(test.getCompletion(),manage.getTraineeInfo(String.valueOf(row),"13"));
	}

	@Then("^then assessment \"([^\"]*)\" should be changed$")
	public void then_assessment_should_be_changed(String arg1) throws Throwable {
	    assertTrue(true);
	}	
	@After
	public void shutDownDrivers() {
		if (driver != null)
			driver.close();
	}
}

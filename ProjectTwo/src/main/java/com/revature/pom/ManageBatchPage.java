package com.revature.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManageBatchPage extends POM{
	
	@Override
	public String getId() {
		return driver.findElement(By.cssSelector("#manage > div:nth-child(2) > div > div > table > thead > tr > th:nth-child(1)")).getText();
	}

	public ManageBatchPage(WebDriver driver) {
		super(driver);
	}
	public WebElement getCreateBatchButton() {
		return driver.findElement(By.cssSelector("#manage > div:nth-child(1) > div > div > ul > li:nth-child(3) > a > span"));
	}
	public WebElement getImportBatchButton() {
		return driver.findElement(By.cssSelector("#manage > div:nth-child(1) > div > div > ul > li:nth-child(2) > a"));
	}
	public WebElement getViewBatchButton(String locator) {
		if(locator.equals("0")) {			
			return driver.findElement(By.xpath("//*[@id=\"manage\"]/div[2]/div/div/table/tbody/tr[1]/td[11]/a/span"));
			}
			return driver.findElement(By.xpath("//*[@id=\"manage\"]/div[2]/div/div/table/tbody/tr["+locator+"]/td[11]/a/span"));
			}
	
	public WebElement getUpdateBatchButton(String locator) {
		if(locator.equals("0")) {
			return driver.findElement(By.cssSelector("#manage > div:nth-child(2) > div > div > table > tbody > tr > td:nth-child(12) > a"));
		}
		return driver.findElement(By.cssSelector("#manage > div:nth-child(2) > div > div > table > tbody > tr:nth-child("+locator +") > td:nth-child(12) > a > span"));
	}
	public WebElement getDeleteBatchButton() {
		return driver.findElement(By.cssSelector("#manage > div:nth-child(2) > div > div > table > tbody > tr:nth-child(1) > td:nth-child(13) > a > span"));
	}
	public WebElement getAddTraineeButton() {		
		return driver.findElement(By.cssSelector("#viewTraineeModal > div > div > div.modal-body.only-top-padding > div.col-md-12.col-lg-12 > div > div > a"));
	}
	public WebElement getUpdateTraineeButton(String locator) {
		if(locator.equals("0")) {			
			return driver.findElement(By.xpath("//*[@id=\"viewTraineeModal\"]/div/div/div[2]/div[2]/div/table/tbody/tr/td[14]/a"));
			}
			return driver.findElement(By.xpath("//*[@id=\"viewTraineeModal\"]/div/div/div[2]/div[2]/div/table/tbody/tr["+locator+"]/td[14]/a"));
			}
	public String getCreateBatchId() {
		return driver.findElement(By.xpath("//*[@id=\"batchModalLabel\"]")).getTagName();
	}
	public String getImportBatchId(){
		return driver.findElement(By.xpath("//*[@id=\"manage\"]/div[1]/div/div/ul/li[2]/a")).getTagName();
	}
	public String getViewBatchId(){
		return driver.findElement(By.xpath("//*[@id=\"viewTraineeModal\"]/div/div/div[2]/div[1]/h3")).getTagName();
	}
	public String getUpdateBatchId(){
		return driver.findElement(By.xpath("//*[@id=\"createBatchModal\"]/div/div/div[2]/div[1]/div[1]/label")).getTagName();
	}
	public String getDeleteBatchId(){
		return driver.findElement(By.xpath("//*[@id=\"deleteBatchModal\"]/div/div/div[2]/span")).getTagName();
	}
	public String getAddTraineeId() {
		return driver.findElement(By.xpath("//*[@id=\"addTraineeModal\"]/div/div/div[2]/h3")).getTagName();
	}
	public String getUpdateTraineeId() {
		return driver.findElement(By.xpath("//*[@id=\"viewTraineeModal\"]/div/div/div[2]/div[1]/h3")).getTagName();
	}

	public WebElement getViewTraineeClose() {
		return driver.findElement(By.xpath("//*[@id=\"viewTraineeModal\"]/div/div/div[1]/button"));
	}
	public WebElement getActiveSwitch() {
		return driver.findElement(By.cssSelector("#viewTraineeModal > div > div > div.modal-body.only-top-padding > div.container.modal-widest > div > a:nth-child(2) > span"));
	}
	public WebElement getActiveId() {
		return driver.findElement(By.xpath("//*[@id=\"viewTraineeModal\"]/div/div/div[2]/div[2]/div/table/tbody/tr[1]/td[2]/span"));
	}

	public WebElement getUpdateBatchClose() {
		return driver.findElement(By.xpath("//*[@id=\"createBatchModal\"]/div/div/div[1]/button/span"));	}

	public WebElement getUpdateTraineeClose() {
		return driver.findElement(By.xpath("//*[@id=\"addTraineeModal\"]/div/div/div[1]/button/span"));
	}

	public WebElement getDeleteBatchClose() {
		return driver.findElement(By.xpath("//*[@id=\"deleteBatchModal\"]/div/div/div[1]/button/span"));
	}

	public WebElement getCreateBatchClose() {
		return driver.findElement(By.xpath("//*[@id=\"createBatchModal\"]/div/div/div[1]/button/span"));
	}
	public WebElement getImportBatchClose() {
		return driver.findElement(By.xpath("//*[@id=\"importBatchModal\"]/div/div/div[1]/button/span"));
	}
	
	public WebElement getUpdateBatchCloseButton() {
		return driver.findElement(By.xpath("//*[@id=\"createBatchModal\"]/div/div/div[3]/button"));	}

	public WebElement getUpdateTraineeCloseButton() {
		return driver.findElement(By.xpath("//*[@id=\"addTraineeModal\"]/div/div/div[1]/button/span"));
	}

	public WebElement getDeleteBatchCloseButton() {
		return driver.findElement(By.xpath("//*[@id=\"deleteBatchModal\"]/div/div/div[3]/button"));
	}

	public WebElement getCreateBatchCloseButton() {
		return driver.findElement(By.xpath("//*[@id=\"createBatchModal\"]/div/div/div[3]/button"));
	}
	public WebElement getImportBatchCloseButton() {
		return driver.findElement(By.xpath("//*[@id=\"importBatchModal\"]/div/div/div[3]/button"));
	}

	public WebElement getSubCreateBatchButton() {
		return driver.findElement(By.cssSelector("#createBatchModal > div > div > div.modal-footer > input"));
	}

	public WebElement getStartDateInput() {
		return driver.findElement(By.xpath("//*[@id=\"start-date\"]/input"));
	}

	public WebElement getEndDateInput() {
		return driver.findElement(By.xpath("//*[@id=\"end-date\"]/input"));
	}

	public WebElement getInputForTraineeName(int index) {
		return driver.findElements(By.cssSelector("#traineeName")).get(index);
	}
	public void yearDropDown(String input) {					
		WebElement list = driver.findElement(By.xpath("//*[@id=\"manage\"]/div[1]/div/div/ul/li[1]"));
		list.click();
		List<WebElement> listOfElements = list.findElements(By.tagName("a"));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"manage\"]/div[1]/div/div/ul/li[1]"))));
		for(WebElement el : listOfElements) {
			if(el.getText().equals(input)) {
			wait.until(ExpectedConditions.visibilityOf(el));
				el.click();
				return;
			}
			
		}
		throw new IllegalArgumentException("Not a valid month");
		}
	public void selectLocation(String input, String locator) {
		String path;
		switch(locator) {
		case"NY": path = "//*[@id=\"location\"]/optgroup[1]/option";break;
		case"VA": path = "//*[@id=\"location\"]/optgroup[2]/option";break;
		default:throw new IllegalArgumentException();
		}
		List<WebElement> listOfElements = driver.findElements(By.xpath(path));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#location"))));
		Select select = new Select(driver.findElement(By.cssSelector("#location")));
		for(WebElement el : listOfElements) {
			if(el.getText().equals(input)) {
			wait.until(ExpectedConditions.visibilityOf(el));
			select.selectByVisibleText(el.getText());
				return;
			}
			
		}
		throw new IllegalArgumentException("Not a valid month");
		}

	public WebElement getBatchUpdateSub() {
		return driver.findElement(By.xpath("//*[@id=\"createBatchModal\"]/div/div/div[3]/input"));
	}

	public WebElement getSubTraineeButton() {
		return driver.findElement(By.xpath("//*[@id=\"addTraineeModal\"]/div/div/div[2]/div[2]/input[1]"));
	}
	public WebElement getSubTraineeUpdateButton() {
		// TODO Auto-generated method stub
		return null;
	}

	public WebElement getDeleteBatchButton(String locator) {
		return driver.findElement(By.xpath("//*[@id=\"manage\"]/div[2]/div/div/table/tbody/tr["+locator+"]/td[13]/a"));
	}

	public WebElement GetUrlTextBox() {
		return driver.findElements(By.xpath("//*[@id=\"traineeName\"]")).get(1);
	}

	public int getTraineeRow(String name) {
		wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//*[@id=\"viewTraineeModal\"]/div/div/div[2]/div[2]/div/table/tbody/tr[1]/td"))));
		List<WebElement> names = driver.findElements(By.xpath("//*[@id=\"viewTraineeModal\"]/div/div/div[2]/div[2]/div/table/tbody/tr[1]/td"));
		for(int i = 0; i < names.size();i++) {
			if(names.get(i).getText().equals(name)) {
				return i+1;
			}
		}
		return -1;
	}

	public void deleteTrainee(int traineeRow) {
		driver.findElement(By.xpath("//*[@id=\"viewTraineeModal\"]/div/div/div[2]/div[2]/div/table/tbody/tr["+traineeRow+"]/td[15]/a/span")).click();
	}
	public WebElement deleteTraineeSubmit() {
		return driver.findElement(By.xpath("//*[@id=\"deleteTraineeModal\"]/div/div/div[3]/input"));
	}

	public void deleteBatch(int traineeRow) {
		driver.findElement(By.xpath("//*[@id=\"viewTraineeModal\"]/div/div/div[2]/div[2]/div/table/tbody/tr["+traineeRow+"]/td[15]/a/span")).click();
	}

	public WebElement deleteBatchSubmit() {
		return driver.findElement(By.xpath("//*[@id=\"deleteBatchModal\"]/div/div/div[3]/input"));
	}

	public int getBatchRow(String name) {
		wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//*[@id=\"manage\"]/div[2]/div/div/table/tbody/tr[1]"))));
		List<WebElement> names = driver.findElements(By.xpath("//*[@id=\"manage\"]/div[2]/div/div/table/tbody/*/td[1]"));
		//*[@id="manage"]/div[2]/div/div/table/tbody/tr[1]/td[1]
		//*[@id="manage"]/div[2]/div/div/table/tbody/tr[2]/td[1]
		for(int i = 0; i < names.size();i++) {
			System.out.println(names.get(i).getText());
			if(names.get(i).getText().equals(name)) {
				return i+1;
			}
		}
		return -1;
	}
	}



package com.revature.pom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class AssessBatchPage extends POM{

	public AssessBatchPage(WebDriver driver) {
		super(driver);
	}
	@Override
	public String getId() {
		return driver.findElement(By.cssSelector("#trainer-assess-table > div > div > ul > ul > table > thead > tr > th.col-sm-9.col-md-9.col-lg-9")).getText();
	}
	public WebElement getCreateAssessButton() {
		return driver.findElement(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li.pull-right > a"));
	}
	public WebElement getCreateWeekButton() {
		return driver.findElements(By.className("glyphicon-plus")).get(2);
	}
	public String getCreateWeekId() {
		return driver.findElement(By.xpath("//*[@id=\"myModalLabel\"]")).getTagName();
	}
	public String getCreateAssessId() {
		return driver.findElement(By.cssSelector("#confirmingweeks > div > div > div.modal-body > div > h4:nth-child(1)")).getTagName();	}
	public String getUpdateAssessId() {		
		return driver.findElement(By.xpath("//*[@id=\"editAssessmentModal_155021\"]/div/div/div[2]/div/div[1]/label")).getTagName();
	}
	public WebElement getUpdateAssessButton(String locator) {
		return driver.findElement(By.xpath("//*[@id=\"trainer-assess-table\"]/div/div/ul/ul/table/thead/tr/th["+locator+"]"));
	}
	public List<String> getCategories(){
		List<WebElement> webList = driver.findElements(By.xpath("//*[@id=\"category\"]"));
		List<String> wordList = new ArrayList<>();
		for(WebElement web : webList) {
			wordList.add(web.getText());
		}
		return wordList;
	}
	public WebElement getSaveButton() {
		return driver.findElement(By.xpath("//*[@id=\"trainer-assess-table\"]/div/div/ul/ul/div[3]/div/a"));
	}
	public boolean getSaveId() {
		return driver.findElement(By.xpath("//*[@id=\"checkMark\"]")).isDisplayed();
	}
	public WebElement getSaveCheckMark() {
		return driver.findElement(By.xpath("//*[@id=\"checkMark\"]"));
	}
	public WebElement getCreateAssessClose() {
		return driver.findElement(By.xpath("//*[@id=\"createAssessmentModal\"]/div/div/div/button/span"));
	}
	public WebElement getCreateWeekClose() {
		return driver.findElement(By.xpath("//*[@id=\"confirmingweeks\"]/div/div/div[1]/button"));
	}
	public WebElement getCreateAssessCloseButton() {
		return driver.findElement(By.xpath("//*[@id=\"createAssessmentModal\"]/div/div/form/div[2]/button"));
	}
	public WebElement getCreateWeekCloseButton() {
		return driver.findElement(By.xpath("//*[@id=\"confirmingweeks\"]/div/div/div[2]/button[2]"));
	}
	public WebElement getSubAssessButton() {
		return driver.findElement(By.xpath("//*[@id=\"createAssessmentModal\"]/div/div/form/div[2]/input"));
	}

	public WebElement getSubCreateWeekButton() {
		return driver.findElement(By.xpath("//*[@id=\"yesBtn\"]"));
	}
	public void weekTab(String input) {
		WebElement list = driver.findElement(By.xpath("/html/body/div/ui-view/ui-view/div[1]/div/div[3]/ul"));									
		List<WebElement> listOfElements = list.findElements(By.tagName("li"));
		System.out.println(listOfElements.get(0).toString());
		wait.until(ExpectedConditions.visibilityOf(list));
		for(WebElement el : listOfElements) {
			if(el.getText().equals(input)) {
			wait.until(ExpectedConditions.visibilityOf(el));
				el.click();
				return;
			}
			
		}
		throw new IllegalArgumentException("Not a valid month");
		}
	
	public void dropDownOptions(String input,String locator) {	
		WebElement list = driver.findElement(By.xpath("/html/body/div/ui-view/ui-view/div[1]/div/div[2]/ul[1]/li["+locator+"]"));	
		list.click();								
		List<WebElement> listOfElements = list.findElements(By.tagName("a"));
		wait.until(ExpectedConditions.visibilityOf(list));
		for(WebElement el : listOfElements) {
			if(el.getText().equals(input)) {
			wait.until(ExpectedConditions.visibilityOf(el));
				el.click();
				return;
			}
			
		}
		throw new IllegalArgumentException("Not a valid month");
		}
	public void updateDropDown(String input,String locator) {
		WebElement list = driver.findElements(By.xpath("//*[@id=\""+locator+"\"]")).get(0);
		List<WebElement> listOfElements = list.findElements(By.className("option"));
		wait.until(ExpectedConditions.visibilityOf(list));
		Select select = new Select(driver.findElements(By.cssSelector("#"+locator)).get(0));
		for(WebElement el : listOfElements) {
			if(el.getText().equals(input)) {
			wait.until(ExpectedConditions.visibilityOf(el));
			select.selectByVisibleText(el.getText());
				return;
			}
			
		}
		throw new IllegalArgumentException("Not a valid month");
		}
	public WebElement getSubmitUpdateButton() {
		return driver.findElement(By.xpath("//*[@id=\"editAssessmentModal_155027\"]/div/div/div[3]/div[2]/input"));
	}
	public WebElement getDeleteAssess(String arg1) {
		return null;
	}
}

package com.revature.pom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.revature.model.Assessment;

public class AssessBatchPage extends POM{

	public int numElements;
	
	public AssessBatchPage(WebDriver driver) {
		super(driver);
	}
	@Override
	public String getId() {
		return driver.findElement(By.xpath("//*[@id=\"trainer-assess-table\"]/div/div/ul/ul/table/thead/tr/th[1]")).getText();
	}
	public WebElement getCreateAssessButton() {
		return driver.findElement(By.xpath("/html/body/div/ui-view/ui-view/div[1]/div/div[2]/ul[1]/li[3]"));
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
	public WebElement getUpdateAssessButton() {
		return driver.findElement(By.xpath("//*[@id=\"trainer-assess-table\"]/div/div/ul/ul/table/thead/tr/th[3]"));
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
		numElements = listOfElements.size();
		wait.until(ExpectedConditions.visibilityOf(list));
		for(WebElement el : listOfElements) {
			if(el.getText().equals(input)) {
			wait.until(ExpectedConditions.visibilityOf(el));
				el.click();
				return;
			}
			
		}
		throw new IllegalArgumentException("Not a valid week");
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
	public void createCategoryDropDown(String input) {
		List<WebElement> listOfElements = driver.findElements(By.xpath("//*[@id=\"createAssessmentModal\"]/div/div/form/div[1]/div[1]/div/select/option"));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"createAssessmentModal\"]/div/div/form/div[1]/div[1]/div/select"))));
		Select select = new Select(driver.findElement(By.xpath("//*[@id=\"createAssessmentModal\"]/div/div/form/div[1]/div[1]/div/select")));
		for(WebElement el : listOfElements) {
			if(el.getText().equals(input)) {
			wait.until(ExpectedConditions.visibilityOf(el));
				select.selectByVisibleText(el.getText());
				return;
			}
			
		}
		throw new IllegalArgumentException("Not a valid category");
	} 
	public void updateCategoryDropDown(String input) throws InterruptedException {
		List<WebElement> listOfElements = driver.findElements(By.xpath("//*[@id=\"category\"]"));
		WebElement selection = null;
		for(WebElement el : listOfElements) {
			try {
			wait.until(ExpectedConditions.visibilityOf(el));
			selection = el;
			}catch(TimeoutException te) {
			}
		}
		Select select = new Select(selection);
		listOfElements = selection.findElements(By.tagName("option"));
		for(WebElement el : listOfElements) {
			if(el.getText().equals(input)) {
			wait.until(ExpectedConditions.visibilityOf(el));
				select.selectByVisibleText(el.getText());
				return;
			}
			
		}
		throw new IllegalArgumentException("Not a valid category");
	} 
	public void inputCreatePoint(String input) {
		driver.findElement(By.xpath("//*[@id=\"createAssessmentModal\"]/div/div/form/div[1]/div[2]/div[1]/input")).clear();
		driver.findElement(By.xpath("//*[@id=\"createAssessmentModal\"]/div/div/form/div[1]/div[2]/div[1]/input")).sendKeys(input);
	}
	public void createTypeDropDown(String input) {
		List<WebElement> listOfElements = driver.findElements(By.xpath("//*[@id=\"createAssessmentModal\"]/div/div/form/div[1]/div[2]/div[2]/select/option"));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"createAssessmentModal\"]/div/div/form/div[1]/div[2]/div[2]/select"))));
		Select select = new Select(driver.findElement(By.xpath("//*[@id=\"createAssessmentModal\"]/div/div/form/div[1]/div[2]/div[2]/select")));
		for(WebElement el : listOfElements) {
			if(el.getText().equals(input)) {
			wait.until(ExpectedConditions.visibilityOf(el));
				select.selectByVisibleText(el.getText());
				return;
			}
			
		}
		throw new IllegalArgumentException("Not a valid category");
	}
	public String getAssessmentRow(Assessment assessment) throws InterruptedException {
		List<WebElement> elements =driver.findElements(By.xpath("//*[@id=\"trainer-assess-table\"]/div/div/ul/ul/table/thead/tr/th"));
		Thread.sleep(1000);
		for(int i = 0; i < elements.size(); i++){
			WebElement el = elements.get(i);
			Thread.sleep(1000);
			if(el.getText().contains(assessment.getType()+" "+assessment.getCategory())){
				return ""+(i+3);
			}
		}
	return "";
	}
	public void inputUpdatePoint(String point) {
		List<WebElement> list = driver.findElements(By.tagName("input"));
		for(WebElement el :list) {
			try {
				wait.until(ExpectedConditions.visibilityOf(el));
				el.clear();
				el.sendKeys(point);
				return;
			} 
			catch(TimeoutException te) {
				
			}
		}
		
	}
	public void updateTypeDropDown(String type) {
		List<WebElement> listOfElements = driver.findElements(By.xpath("//*[@id=\"assessmentType\"]"));
		WebElement selection = null;
		for(WebElement el : listOfElements) {
			try {
			wait.until(ExpectedConditions.visibilityOf(el));
			selection = el;
			}catch(TimeoutException te) {
			}
		}
		Select select = new Select(selection);
		listOfElements = selection.findElements(By.tagName("option"));
		for(WebElement el : listOfElements) {
			if(el.getText().equals(type)) {
			wait.until(ExpectedConditions.visibilityOf(el));
				select.selectByVisibleText(el.getText());
				return;
			}
			
		}
		throw new IllegalArgumentException("Not a valid category");
		
	}
	public void subAssessmentUpdate() {
	List<WebElement> listOfButtons = driver.findElements(By.className("btn-primary"));
	for(WebElement button :listOfButtons) {
		try {
		wait.until(ExpectedConditions.elementToBeClickable(button));
		button.click();
		return;
		}
		catch(TimeoutException te) {
		}
	}
	
}
	public void yearDropDown(String input){					
		WebElement list = driver.findElement(By.xpath("/html/body/div/ui-view/ui-view/div[1]/div/div[2]/ul[1]/li[1]"));
		list.click();
		List<WebElement> listOfElements = list.findElements(By.tagName("a"));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("/html/body/div/ui-view/ui-view/div[1]/div/div[2]/ul[1]/li[1]"))));
		for(WebElement el : listOfElements) {
			if(el.getText().equals(input)) {
			wait.until(ExpectedConditions.visibilityOf(el));
				el.click();
				return;
			}
			
		}
		throw new IllegalArgumentException("Not a valid month");
		}
	}

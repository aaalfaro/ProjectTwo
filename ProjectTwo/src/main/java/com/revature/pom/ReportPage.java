package com.revature.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ReportPage extends POM{
	
	boolean pdfSuccess = true;
	
	public ReportPage(WebDriver driver) {
		super(driver);
	}
	public WebElement getTechSkillsButton() {
		return driver.findElement(By.xpath("//*[@id=\"caliber-container\"]/div/div/div[2]/div[1]/div/div[1]/div/i"));
	}
	public String getTechSkillsId() {
		return driver.findElement(By.xpath("//*[@id=\"insert-trainee\"]/div/div/div[1]/h4")).getTagName();
	}
	@Override
	public String getId() {
		return driver.findElement(By.xpath("//*[@id=\"searchTextBox\"]")).getText();
	}
	public WebElement getTechSkillsClose() {
		return driver.findElement(By.xpath("//*[@id=\"insert-trainee\"]/div/div/div[1]/button/span"));
	}
	public void dropDownOptions(String input,String locator) {
		WebElement list;
		if(locator.equals("pdf")) {
			list = driver.findElement(By.xpath("//*[@id=\"dropdownMenu1\"]"));
			list.click();
			list = driver.findElement(By.xpath("/html/body/div/ui-view/ui-view/div[1]/div/div/div[2]/ul"));
		}
		else {
			list = driver.findElement(By.xpath("/html/body/div/ui-view/ui-view/div[1]/div/div/ul/li["+ locator +"]"));	
			list.click();
		}
										
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
	public void TestPdfs() {
	List<WebElement> pdfButtons =	driver.findElements(By.className("glyphicon-save"));
	for(WebElement button : pdfButtons) {	
		button.click();
		if(!pdfSuccess) {
			pdfSuccess = false;
		}
	}
	}
	public boolean wasPdfTestSuccessful() {
		return pdfSuccess;
	}
	
}

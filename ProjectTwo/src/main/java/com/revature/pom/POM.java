package com.revature.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class POM {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	public static final String ASSESSMENT_URL = "https://dev-caliber.revature.tech/caliber/#/vp/assess";
	public static final String HOME_URL = "https://dev-caliber.revature.tech/caliber/#/vp/home";
	public static final String MANAGE_URL = "https://dev-caliber.revature.tech/caliber/#/vp/manage";
	public static final String REPORT_URL = "https://dev-caliber.revature.tech/caliber/#/vp/reports";		
	public POM(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 5);
	}
	
	public abstract String getId();
	
	public WebElement getHomeAnchor() {     
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/ui-view/nav/div/ul[2]/li[1]/a")));
		return driver.findElement(By.xpath("/html/body/div/ui-view/nav/div/ul[2]/li[1]/a"));
	}
	public WebElement getManageAnchor() {
		return driver.findElement(By.xpath("/html/body/div/ui-view/nav/div/ul[2]/li[2]/a"));
	}
	public WebElement getAssessAnchor() {
		return driver.findElement(By.xpath("/html/body/div/ui-view/nav/div/ul[2]/li[3]/a"));
	}
	public WebElement getReportAnchor() {
		return driver.findElement(By.xpath("/html/body/div/ui-view/nav/div/ul[2]/li[6]/a"));
	}
	public void DropDown(String input,String locator) {					

		if(input != null && !input.equals("0")) {
		List<WebElement> listOfElements = driver.findElements(By.xpath("//*[@id=\""+locator+"\"]/option"));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#"+locator))));
		Select select = new Select(driver.findElement(By.cssSelector("#"+locator)));
		for(WebElement el : listOfElements) {
			if(el.getText().equals(input)) {
			wait.until(ExpectedConditions.visibilityOf(el));
				select.selectByVisibleText(el.getText());
				return;
			}
		}
		}
		throw new IllegalArgumentException("Not a valid month");
		}
	public void input(String input,String locator) throws InterruptedException {		
		if(input != null && !input.equals("-1")) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\""+ locator +"\"]")));
		driver.findElement(By.xpath("//*[@id=\""+ locator +"\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\""+ locator +"\"]")).sendKeys(input);
		Thread.sleep(250);
	}
}
}

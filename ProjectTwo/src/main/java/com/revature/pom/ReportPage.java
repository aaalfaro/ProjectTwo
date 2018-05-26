package com.revature.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReportPage extends POM{

	public ReportPage(WebDriver driver) {
		super(driver);
	}
	@Override
	public String getId() {
		return driver.findElement(By.cssSelector("#caliber-container > div > div > div.col-sm-12.col-md-12.col-lg-12 > div:nth-child(1) > div > div > div.panel-heading")).getText();
	}
}

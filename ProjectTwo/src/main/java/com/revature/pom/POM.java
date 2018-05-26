package com.revature.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class POM {
	
	protected WebDriver driver;
	
	public POM(WebDriver driver) {
		this.driver = driver;
	}
	
	public abstract String getId();
	
	public WebElement getHomeAnchor() {     
		return driver.findElement(By.xpath("/html/body/div/ui-view/nav/div/ul[2]/li[1]/a"));
	}
	public WebElement getManageAnchor() {
		return driver.findElement(By.xpath("/html/body/div/ui-view/nav/div/ul[2]/li[2]/a"));
	}
	public WebElement getAssessAnchor() {
		return driver.findElement(By.xpath("/html/body/div/ui-view/nav/div/ul[2]/li[3]/a"));
	}
	public WebElement getReportAnchor() {
		return driver.findElement(By.xpath("/html/body/div/ui-view/nav/div/ul[2]/li[4]/a"));
	}
	
}

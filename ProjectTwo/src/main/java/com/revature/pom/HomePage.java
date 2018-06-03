package com.revature.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends POM{
private static final String URL = "https://dev-caliber.revature.tech/caliber/#/trainer/home";
	

	public HomePage(WebDriver driver) {
		super(driver);
		driver.get(URL);
	}
	@Override						
	public String getId() {					
		return driver.findElement(By.xpath("//*[@id=\"home\"]/div[1]/h1")).getText();
	}
}

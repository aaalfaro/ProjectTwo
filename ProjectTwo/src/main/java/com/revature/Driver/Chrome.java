package com.revature.Driver;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome implements MyDriver{

	@Override
	public WebDriver getDriver() {
		//C:/Users/Administrator/.jenkins/workspace/ProjectTwo/ProjectTwo/src/main/resources/chromedriver.exe
		File file = new File("C:/Users/Administrator/.jenkins/workspace/ProjectTwo/ProjectTwo/src/main/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
		return new ChromeDriver();
	}
	
}

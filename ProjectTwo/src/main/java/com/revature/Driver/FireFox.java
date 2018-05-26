package com.revature.Driver;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFox implements MyDriver{

	@Override
	public WebDriver getDriver() {
		File file = new File("scr/main/resources/geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
		return new FirefoxDriver();
	}

}

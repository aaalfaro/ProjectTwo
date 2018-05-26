package com.revature.Driver;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
	private DriverFactory() {}
	public static WebDriver getDriver(String driverType) {
		MyDriver driver = null;
		String type = driverType.toLowerCase();
		switch(type) {
		case "chrome":driver = 
						new Chrome();
						return driver.getDriver();
		case "firefox": driver=
						new FireFox();
						return driver.getDriver();
		default: throw new DriverNotFoundException("Could not find the specified type of driver");	
		}
	}
}

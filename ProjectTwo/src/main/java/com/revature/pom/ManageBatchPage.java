package com.revature.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ManageBatchPage extends POM{

	public ManageBatchPage(WebDriver driver) {
		super(driver);
	}
	public WebElement getCreateBatchButton() {
		return driver.findElement(By.cssSelector("#manage > div:nth-child(1) > div > div > ul > li:nth-child(3) > a > span"));
	}
	public WebElement getImportBatchButton() {
		return driver.findElement(By.cssSelector("#manage > div:nth-child(1) > div > div > ul > li:nth-child(2) > a"));
	}
	public WebElement getViewBatchButton() {
		return driver.findElement(By.xpath("//*[@id=\"manage\"]/div[2]/div/div/table/tbody/tr[1]/td[11]/a/span/p"));
	}
	public WebElement getUpdateBatchButton() {
		return driver.findElement(By.cssSelector("#manage > div:nth-child(2) > div > div > table > tbody > tr:nth-child(1) > td:nth-child(12) > a > span"));
	}
	public WebElement getDeleteBatchButton() {
		return driver.findElement(By.cssSelector("#manage > div:nth-child(2) > div > div > table > tbody > tr:nth-child(1) > td:nth-child(13) > a > span"));
	}
	public WebElement getAddTraineeButton() {
		return driver.findElement(By.cssSelector("#viewTraineeModal > div > div > div.modal-body.only-top-padding > div.col-md-12.col-lg-12 > div > div > a"));
	}
	public String getCreateBatchId() {
		return driver.findElement(By.xpath("//*[@id=\"batchModalLabel\"]")).getTagName();
	}
	public String getImportBatchId(){
		return driver.findElement(By.xpath("//*[@id=\"manage\"]/div[1]/div/div/ul/li[2]/a")).getTagName();
	}
	public String getViewBatchId(){
		return driver.findElement(By.xpath("//*[@id=\"viewTraineeModal\"]/div/div/div[2]/div[1]/h3")).getTagName();
	}
	public String getUpdateBatchId(){
		return driver.findElement(By.xpath("//*[@id=\"createBatchModal\"]/div/div/div[2]/div[1]/div[1]/label")).getTagName();
	}
	public String getDeleteBatchId(){
		return driver.findElement(By.xpath("//*[@id=\"deleteBatchModal\"]/div/div/div[2]/span")).getTagName();
	}
	public String getAddTraineeId() {
		return driver.findElement(By.xpath("//*[@id=\"addTraineeModal\"]/div/div/div[2]/h3")).getTagName();
	}
	
	@Override
	public String getId() {
		return driver.findElement(By.cssSelector("#manage > div:nth-child(2) > div > div > table > thead > tr > th:nth-child(1)")).getText();
	}
	

}

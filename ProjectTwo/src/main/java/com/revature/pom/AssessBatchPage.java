package com.revature.pom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AssessBatchPage extends POM{

	public AssessBatchPage(WebDriver driver) {
		super(driver);
	}
	@Override
	public String getId() {
		return driver.findElement(By.cssSelector("#trainer-assess-table > div > div > ul > ul > table > thead > tr > th.col-sm-9.col-md-9.col-lg-9")).getText();
	}
	public WebElement getCreateAssessButton() {
		return driver.findElement(By.cssSelector("body > div > ui-view > ui-view > div:nth-child(1) > div > div.col-md-12.col-lg-12.top10 > ul:nth-child(1) > li.pull-right > a"));
	}
	public WebElement getCreateWeekButton() {
		return driver.findElement(By.xpath("/html/body/div/ui-view/ui-view/div[1]/div/div[3]/ul/li[9]/a/span"));
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
}

package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import foundation.BasePage;

public class SubmissionPage extends BasePage {
	public SubmissionPage(WebDriver driver) {
		super(driver);
	}
	
	public String getInformationSentMessage() {
		return driver.findElement(By.cssSelector("h1.ddm-form-name")).getText();
	}
	
	public String getSuccessfulyMessage() {
		return driver.findElement(By.cssSelector("h5.ddm-form-description")).getText();
	}
}

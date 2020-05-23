package pageObjects;

import foundation.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormPage extends BasePage {
	public FormPage(WebDriver driver) {
		super(driver);
	}
	
	public String getFormPageTitle() {
		return driver.getTitle();
	}
	
	public String getPartyRockText() {
		return driver.findElement(By.cssSelector("div.ddm-form-page h4")).getText();
	}
	
	public FormPage inputTextNameField(String name) {
		driver.findElement(By.cssSelector("div.form-group input.ddm-field-text")).sendKeys(name);;
		return this;
	}
	
	public WebElement getDateOfBirthFieldElement() {
		return driver.findElement(By.cssSelector("div.input-group-item input"));
	}
	
	public FormPage inputTextTextField(String text) {
		driver.findElement(By.cssSelector("div.form-group textarea")).sendKeys(text);
		return this;
	}
	
	public SubmissionPage clickOnSubmitBtn() {
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		return new SubmissionPage(driver);
	}
	
	
}

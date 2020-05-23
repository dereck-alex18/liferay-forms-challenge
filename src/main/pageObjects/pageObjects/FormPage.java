package pageObjects;

import foundation.BasePage;

import java.util.List;

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
	
	public WebElement getTextNameFieldElement() {
		return driver.findElement(By.cssSelector("div.form-group input.ddm-field-text"));
	}
	
	public WebElement getDateOfBirthFieldElement() {
		return driver.findElement(By.cssSelector("div.input-group-item input"));
	}
	
	public WebElement getTextFieldElement() {
		return driver.findElement(By.cssSelector("div.form-group textarea"));
	}
	
	public WebElement clickOnSubmitBtn() {
		return driver.findElement(By.cssSelector("button[type='submit']"));
	}
	
	public List<WebElement> getAllFeedBackMessages(){
		
		return driver.findElements(By.cssSelector("div.form-feedback-item"));
	}
 	
	public SubmissionPage fillAllFields(String name, String dateOfBirth, String text) {
		getTextNameFieldElement().sendKeys(name);
		getDateOfBirthFieldElement().sendKeys(dateOfBirth);
		getTextFieldElement().sendKeys(text);
		clickOnSubmitBtn();
		return new SubmissionPage(driver);
	}
	
	
}

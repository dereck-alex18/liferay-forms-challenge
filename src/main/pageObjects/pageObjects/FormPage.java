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
	
	public SubmissionPage clickOnSubmitBtn() {
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		return new SubmissionPage(driver);
	}
	
	public WebElement getMonthDropDown() {
		return driver.findElement(By.cssSelector("select[name='month']"));
	}
	
	public WebElement getYearDropDown() {
		return driver.findElement(By.cssSelector("select[name='year']"));
	}
	
	public WebElement getDayOnCalendar(String day) {
		String formatedCssSelector = String.format("div.day[arialabel='%s']", day);
		return driver.findElement(By.cssSelector(formatedCssSelector));
	}
	
	public List<WebElement> getAllFeedBackMessages(){
		//Make sure to get the dynamic div
		try {
			return driver.findElements(By.cssSelector("div.form-feedback-item"));
		}
		catch (org.openqa.selenium.StaleElementReferenceException e) {
			return driver.findElements(By.cssSelector("div.form-feedback-item"));
		}
	}
	
	public List<WebElement> getAllYears(){
		return driver.findElements(By.cssSelector("select[name='year'] option"));
	}
	
	public WebElement getGoToCurrentDateBtn() {
		return driver.findElement(By.cssSelector("button.btn-monospaced[aria-label='live']"));
	}
	
	public WebElement getCurrentDayDiv() {
		return driver.findElement(By.cssSelector("div.day.active"));
	}
	
	public WebElement getLanguageBtn() {
		return driver.findElement(By.cssSelector("div.dropdown button"));
	}
	
	public WebElement getLanguageDiv() {
		return driver.findElement(By.cssSelector("ul.dropdown-menu li"));
	}
		
}

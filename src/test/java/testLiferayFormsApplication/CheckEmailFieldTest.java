package testLiferayFormsApplication;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import foundation.InitProcess;
import pageObjects.FormPage;
import pageObjects.SubmissionPage;

public class CheckEmailFieldTest {
	private WebDriver driver;
	private FormPage formPageObj;
	private SubmissionPage submissionPage;
	
	@Before
	public void setUp() {
		driver = InitProcess.createBrowser();
		formPageObj = new FormPage(driver);
		submissionPage = new SubmissionPage(driver);
	}
	
	@Test
	public void checkNameTypedIsInNameField() {
		formPageObj.getTextNameFieldElement().sendKeys("Dereck Portela");
		assertEquals(formPageObj.getTextNameFieldElement().getAttribute("value"), "Dereck Portela");
	}
	
	@Test
	public void checkNotDisplayErrorMessageWhenNameIsTypedTest() {
		formPageObj.getTextNameFieldElement().sendKeys("Dereck Portela");
		formPageObj.getDateOfBirthFieldElement().click();
		
		if(formPageObj.getAllFeedBackMessages().size() > 0) {
			assertFalse(formPageObj.getAllFeedBackMessages().get(0).isDisplayed());
		}
		
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}

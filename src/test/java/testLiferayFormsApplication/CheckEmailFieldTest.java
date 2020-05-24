package testLiferayFormsApplication;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import foundation.InitProcess;
import pageObjects.FormPage;


public class CheckEmailFieldTest {
	private WebDriver driver;
	private FormPage formPageObj;

	
	@Before
	public void setUp() {
		driver = InitProcess.createBrowser();
		formPageObj = new FormPage(driver);
	}
	
	@Test
	public void checkNameTypedIsInNameFieldTest() {
		//Check when user types something in the name, the name will be exact how the user typed
		formPageObj.getTextNameFieldElement().sendKeys("Dereck Portela");
		assertEquals("Dereck Portela", formPageObj.getTextNameFieldElement().getAttribute("value"));
	}
	
	@Test
	public void checkNotDisplayErrorMessageWhenNameIsTypedTest() {
		//Check if no error message is displayed after the user type something in the
		//email field and click on another field
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

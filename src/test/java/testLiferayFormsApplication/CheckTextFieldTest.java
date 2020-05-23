package testLiferayFormsApplication;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import foundation.InitProcess;
import pageObjects.FormPage;

public class CheckTextFieldTest {
	private WebDriver driver;
	private FormPage formPageObj;
	
	@Before
	public void setUp() {
		driver = InitProcess.createBrowser();
		formPageObj = new FormPage(driver);
	
	}
	
	@Test
	public void checkTextTypedInTextField() {
		//Check when user types something in the text field, the text will be exact what the user types
		String text = "I joined test because testing may save your life";
		formPageObj.getTextFieldElement().sendKeys(text);
		assertEquals(text,formPageObj.getTextFieldElement().getAttribute("value"));
	}
	
	@Test
	public void checkNotDisplayErrorMessageWhenTextIsTyped() {
		//Check if no error message is displayed after the user type something in the
		//text field and click on another field
		String text = "I joined test because testing may save your life";
		formPageObj.getTextFieldElement().sendKeys(text);
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

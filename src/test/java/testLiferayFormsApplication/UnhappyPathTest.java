package testLiferayFormsApplication;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import foundation.InitProcess;
import pageObjects.FormPage;

public class UnhappyPathTest {
	private WebDriver driver;
	private FormPage formPageObj;
	
	@Before
	public void setUp() {
		driver = InitProcess.createBrowser();
		formPageObj = new FormPage(driver);
	}
	
	@Test
	public void checkIfAllErrorMesagesIsDisplayedSubmitEmptyForm() {
		formPageObj.clickOnSubmitBtn();
		if(formPageObj.getAllFeedBackMessages().size() == 3) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	
}

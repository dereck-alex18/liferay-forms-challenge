package testLiferayFormsApplication;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import foundation.InitProcess;
import pageObjects.FormPage;

public class IternationalizationTest {
	private WebDriver driver;
	private FormPage formPageObj;
	
	@Before
	public void setUp() {
		driver = InitProcess.createBrowser();
		formPageObj = new FormPage(driver);
	}
	
	@Test
	public void checkIfPartyRockIsOnFormWhenLanguageIsChangedTest() {
		formPageObj.getLanguageBtn().click();
		formPageObj.getLanguageDiv().click();
		assertTrue(formPageObj.getPartyRockText().contains("party rock"));
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}

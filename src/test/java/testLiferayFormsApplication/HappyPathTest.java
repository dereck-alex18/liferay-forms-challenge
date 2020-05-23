package testLiferayFormsApplication;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import foundation.InitProcess;
import pageObjects.FormPage;

public class HappyPathTest {
	private WebDriver driver;
	private FormPage formPageObj;
	
	@Before
	public void setUp() {
		driver =  InitProcess.createBrowser();
		formPageObj = new FormPage(driver);
	}
	
	@Test
	public void checkPageTitle() {
		assertTrue(formPageObj.getFormPageTitle().contains("This is a Liferay Forms"));
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}

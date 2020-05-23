package testLiferayFormsApplication;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import foundation.InitProcess;
import pageObjects.FormPage;
import pageObjects.SubmissionPage;

public class HappyPathTest {
	private WebDriver driver;
	private FormPage formPageObj;
	private SubmissionPage submissionPage;
	
	@Before
	public void setUp() {
		driver =  InitProcess.createBrowser();
		formPageObj = new FormPage(driver);
		submissionPage = new SubmissionPage(driver);
	}
	
	@Test
	public void checkPageTitleTest() {
		assertTrue(formPageObj.getFormPageTitle().contains("This is a Liferay Forms"));
	}
	
	@Test
	public void checkIfPartyRockIsOnTheFormTest() {
		assertEquals(formPageObj.getPartyRockText(), "party rock");
	}
	
	@Test
	public void fillAllFieldsAndSubmitTest() {
		formPageObj.inputTextNameField("Dereck Portela");
		formPageObj.getDateOfBirthFieldElement().sendKeys("01181994");
		formPageObj.inputTextTextField("I joined test area because test may save your life!");
		formPageObj.clickOnSubmitBtn();
		assertEquals(submissionPage.getInformationSentMessage(), "Information sent");
		assertEquals(submissionPage.getSuccessfulyMessage(), "Information sent successfully!");
	}
	
//	@After
//	public void tearDown() {
//		driver.quit();
//	}
}

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
		//Expected result: party rock text must be on the page
		assertTrue(formPageObj.getPartyRockText().contains("party rock"));
	}
	
	@Test
	public void fillAllFieldsAndSubmitTest() {
		//Expected result: The form should be sent
		String text = "I joined test because testing may save your life";
		formPageObj.fillAllFields("Dereck Portela", "01181994", text);
		assertEquals(submissionPage.getInformationSentMessage(), "Information sent");
		assertEquals(submissionPage.getSuccessfulyMessage(), "Information sent successfully!");
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}

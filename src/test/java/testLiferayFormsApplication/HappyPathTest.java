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
		//Check if the page title is being displayed
		assertTrue(formPageObj.getFormPageTitle().contains("This is a Liferay Forms"));
	}
	
	@Test
	public void checkIfPartyRockIsOnTheFormTest() {
		//Check if the text "party rock" is in the form
		assertTrue(formPageObj.getPartyRockText().contains("party rock"));
	}
	
	@Test
	public void fillAllFieldsAndSubmitTest() {
		//Check if filling all fields and click submit button. the form is sent
		String text = "I joined test because testing may save your life";
		formPageObj.getTextNameFieldElement().sendKeys("Dereck Portela");
		formPageObj.getDateOfBirthFieldElement().sendKeys("01181994");
		formPageObj.getTextFieldElement().sendKeys(text);
		formPageObj.clickOnSubmitBtn();
		assertEquals("Information sent", submissionPage.getInformationSentMessage());
		assertEquals("Information sent successfully!", submissionPage.getSuccessfulyMessage());
	}
	
	@Test
	public void fillNameAndTextFieldsSelectDateThroughCalendarAndSubmitTest(){
		//Check if filling email and text form and selecting data through the calendar, the form is sent
		String text = "I joined test because testing may save your life";
		formPageObj.getTextNameFieldElement().sendKeys("Dereck Portela");
		formPageObj.getDateOfBirthFieldElement().click();
		formPageObj.getGoToCurrentDateBtn().click();
		formPageObj.getCurrentDayDiv().click();
		formPageObj.getTextFieldElement().sendKeys(text);
		formPageObj.clickOnSubmitBtn();
		System.out.println(formPageObj.getAllFeedBackMessages().size());
		assertEquals("Information sent", submissionPage.getInformationSentMessage());
		assertEquals("Information sent successfully!", submissionPage.getSuccessfulyMessage());
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}

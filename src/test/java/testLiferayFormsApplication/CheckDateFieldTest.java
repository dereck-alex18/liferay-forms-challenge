package testLiferayFormsApplication;

import static org.junit.Assert.*;
import java.time.Month;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import foundation.InitProcess;
import pageObjects.FormPage;

public class CheckDateFieldTest {
	private WebDriver driver;
	private FormPage formPageObj;
	
	@Before
	public void setUp() {
		driver = InitProcess.createBrowser();
		formPageObj = new FormPage(driver);
	}
	
	@Test
	public void typeDateInDateFieldTest() {
		//Check if the typed date is displayed in the field
		formPageObj.getDateOfBirthFieldElement().sendKeys("01181994");
		assertEquals("01/18/1994", formPageObj.getDateOfBirthFieldElement().getAttribute("value"));
	}
	
	@Test
	public void selectDateOnCalendar() {
		//Try to select a date, in this case 01/18/1994, through the calendar
		Select monthDropDown = new Select(formPageObj.getMonthDropDown());
		Select yearDropDown = new Select(formPageObj.getYearDropDown());
		String year = "1994";
		String day = "1994 0 18";
		
		formPageObj.getDateOfBirthFieldElement().click();
		monthDropDown.selectByVisibleText("January");
		for(int i = 0; i < formPageObj.getAllYears().size(); i++) {
			if(formPageObj.getAllYears().get(i).getAttribute("value").contains(year)) {
				yearDropDown.selectByVisibleText(year);
				formPageObj.getDayOnCalendar(day).click();
				break;
			}
		}
		assertEquals("01/18/1994", formPageObj.getDateOfBirthFieldElement().getAttribute("value"));
	}
	
	@Test
	public void selectTheCurrentDate() {
		//Select the current date through calendar
		Select monthDropDown = new Select(formPageObj.getMonthDropDown());
		Select yearDropDown = new Select(formPageObj.getYearDropDown());
		formPageObj.getDateOfBirthFieldElement().click();
		formPageObj.getGoToCurrentDateBtn().click();
		String currentMonth = "0" + Integer.toString((Integer.parseInt(monthDropDown.getFirstSelectedOption().getAttribute("value") ) + 1));
		String currentYear = yearDropDown.getFirstSelectedOption().getAttribute("value");
		formPageObj.getCurrentDayDiv().click();
		String currentDay = formPageObj.getCurrentDayDiv().getAttribute("innerHTML");
		String currentDate = String.format("%s/%s/%s", currentMonth, currentDay, currentYear);
		
		assertEquals(currentDate, formPageObj.getDateOfBirthFieldElement().getAttribute("value"));
	}
	
	@Test
	public void typeSpecialCharactersInField() {
		formPageObj.getDateOfBirthFieldElement().sendKeys("%%##****");
		formPageObj.getTextFieldElement().click();
		if(formPageObj.getAllFeedBackMessages().size() > 0) {
			assertTrue(formPageObj.getAllFeedBackMessages().get(0).isDisplayed());
		}
		
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}

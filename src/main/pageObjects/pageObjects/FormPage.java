package pageObjects;

import foundation.BasePage;
import org.openqa.selenium.WebDriver;

public class FormPage extends BasePage {
	public FormPage(WebDriver driver) {
		super(driver);
	}
	
	public String getFormPageTitle() {
		return driver.getTitle();
	}
}

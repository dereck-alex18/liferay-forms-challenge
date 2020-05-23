package foundation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InitProcess {
	public static WebDriver createBrowser() {
		String liferayFormsUrl = "https://forms.liferay.com/web/forms/shared/-/form/122548?p_p_state=pop_up&p_p_auth=4VCVmD11&_com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormPortlet_languageId=en_US";
		System.setProperty("webdriver.chrome.driver", "/home/dereck/Documents/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(liferayFormsUrl);
		return driver;
	}
}

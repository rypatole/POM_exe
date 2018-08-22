package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends HeaderPage {
	private WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;

	}

	By activity = By.xpath("//td[contains(text(),'My Upcoming and Pending Activities')]");

	public int checkActivity() {

		return driver.findElements(activity).size();

	}

}

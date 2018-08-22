package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	By Username = By.name("user_name");
	By Pwd = By.name("user_password");
	By theme = By.name("login_theme");
	By btnLogin = By.name("Login");
	By logo = By.xpath("//img[@src='include/images/vtiger-crm.gif']");
	By errormsg = By.xpath("//td[contains(text(),'You must specify a valid username and password')]");

	public boolean validateTitle(String expected) {

		if (expected.equals(driver.getTitle())) {
			return true;
		} else {
			return false;
		}

	}

	public boolean validatelogo() {
		if (driver.findElement(logo).isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public void Login(String user, String pwd) {
		driver.findElement(Username).clear();
		driver.findElement(Username).sendKeys(user);
		driver.findElement(Pwd).clear();
		driver.findElement(Pwd).sendKeys(pwd);
		driver.findElement(btnLogin).click();
	}

	public boolean validateErrorMessage() {
		if (driver.findElement(errormsg).isDisplayed()) {

			return true;
		}

		else {
			return false;
		}
	}
}

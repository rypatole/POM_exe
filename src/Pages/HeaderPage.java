package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage {

	private WebDriver driver;

	public HeaderPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this); // PageFactory is used to
												// optimize the code
	}

	@FindBy(linkText = "Logout") // One way we can declare an element
     WebElement Logout;
  // By Logout = By.linkText("Logout");
	
//	@FindBy(how=How.LINK_TEXT,using="New Lead") // Other way we can declare an element
	@FindBy(linkText = "New Lead")
	WebElement Newlead;
  // By Newlead=By.linkText("New Lead");	
	
	public void clickonLogout(){
		Logout.click();
	}
	
	public void clickOnHyperLink(String link){
		
		driver.findElement(By.linkText(link)).click();
	}

}

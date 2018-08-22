package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewLeadPage extends HeaderPage{
	
	public WebDriver driver;
	
	public NewLeadPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}

	
	By lastname=By.name("lastname");
	By company = By.name("company");
	By savebutton=By.name("button");
	By displayedLnameValue= By.xpath("//td[contains(text(),'Last Name:')]/following::td[1]");
	By displayedCnameValue=By.xpath("//td[contains(text(),'Company:')]/following::td[1]");
	
	public boolean checkMandatoryField(){
		
		driver.findElement(savebutton).click();
		Alert alt=driver.switchTo().alert();
		String ltext=alt.getText();
		alt.accept();
		driver.findElement(lastname).clear();
		driver.findElement(lastname).sendKeys("lname");
		driver.findElement(savebutton).click();
		Alert alt1=driver.switchTo().alert();
		String ctext=alt1.getText();
		alt1.accept();
		if(ltext.equals("Last Name cannot be empty") && ctext.equals("Company cannot be empty")){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void CreateLeadWithMandatoryfield(String Lname,String comp)
	{
		driver.findElement(lastname).clear();
		driver.findElement(lastname).sendKeys(Lname);
		driver.findElement(company).clear();
		driver.findElement(company).sendKeys(comp);
		driver.findElement(savebutton).click();		
	}
	
	
	public void CreateLeadWithAllfields(String Lname,String comp)
	{
		driver.findElement(lastname).clear();
		driver.findElement(lastname).sendKeys(Lname);
		driver.findElement(company).clear();
		driver.findElement(company).sendKeys(comp);
		driver.findElement(savebutton).click();		
	}
	
	public boolean verifyLeadCreation(String Lname,String comp)
	{
		String lnametxt=driver.findElement(displayedLnameValue).getText();
		String comptxt=driver.findElement(displayedCnameValue).getText();
		if(Lname.equals(lnametxt.trim()) && comp.equals(comptxt.trim()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
		
	


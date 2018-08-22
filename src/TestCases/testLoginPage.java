package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Common.Commonfunctions;
import Pages.HomePage;
import Pages.LoginPage;

public class testLoginPage extends BaseTest{
		
	@BeforeClass
	public void luanchapp()
	{
		if(report==null)
		{
			createTestReport();
		}
		LaunchApp();
	}
	
	@Test(priority=1)
	public void verifyApplicationURL() throws Exception
	{
		logger=report.startTest("verifyApplicationURL");
		logger.log(LogStatus.INFO, "Application launched successfully");
		LoginPage lp=new LoginPage(driver);
		boolean flag=lp.validateTitle("vtiger CRM - Commercial Open Source CRM");
		if(flag)
		{
		logger.log(LogStatus.PASS, "Title matched successfully");
		}
		else
		{
		logger.log(LogStatus.FAIL, "Title did not match");	
		}
		Commonfunctions.getscreenshot("verifyApplicationURL", driver);
		Assert.assertTrue(flag);
		report.endTest(logger);
		report.flush();
	}
	
	@Test(priority=2)
	public void verifyApplicationLogo() throws Exception
	{
		logger=report.startTest("verifyApplicationLogo");
		LoginPage lp=new LoginPage(driver);
		boolean flag=lp.validatelogo();
		if(flag)
		{
		logger.log(LogStatus.PASS, "Logo displayed successfully");
		}
		else
		{
		logger.log(LogStatus.FAIL, "Logo not found");	
		}
		Commonfunctions.getscreenshot("verifyApplicationLogo", driver);
		Assert.assertTrue(flag);
		report.endTest(logger);
		report.flush();
	}
	
	@Test(priority=3)
	public void verifyInvalidLogin() throws Exception
	{
		logger=report.startTest("verifyInvalidLogin");
		LoginPage lp=new LoginPage(driver);
		lp.Login("sfasf", "asdada");
		boolean flag=lp.validateErrorMessage();		
		if(flag)
		{
		logger.log(LogStatus.PASS, "Invalid login validated");
		}
		else
		{
		logger.log(LogStatus.FAIL, "Invalid login not working");	
		}
		Commonfunctions.getscreenshot("verifyInvalidLogin", driver);
		Assert.assertTrue(flag);
		report.endTest(logger);
		report.flush();
	}
	
	@Test(priority=4)
	public void validateValidLogin() throws Exception
	{
		logger=report.startTest("validateValidLogin");
		LoginPage lp=new LoginPage(driver);
		lp.Login("admin", "admin");
		HomePage hp=new HomePage(driver);
		int cnt=hp.checkActivity();
		Assert.assertEquals(cnt, 1);
		
		if(cnt==2)
		{
		logger.log(LogStatus.PASS, "valid login validated");
		}
		else
		{
		logger.log(LogStatus.FAIL, "valid login not working");	
		}
		
		report.endTest(logger);
		report.flush();
		Commonfunctions.getscreenshot("validateValidLogin", driver);
		
	}
	
	
	@AfterClass(alwaysRun = true)
	public void closeApp()
	{
		driver.close();
		driver.quit();
	}
	
	

}

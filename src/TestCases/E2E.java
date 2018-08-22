package TestCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Common.Commonfunctions;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.NewLeadPage;

public class E2E extends BaseTest {

	@BeforeClass
	public void launchapp() {

		if (report == null) {
			createTestReport();

		}

		LaunchApp();
	}

	@Test

	public void E2E_Test() throws Exception {

		logger = report.startTest("E2E_Test");
		logger.log(LogStatus.PASS, "Application launched successfully");
		Commonfunctions.getscreenshot("E2E_Test", driver);
		LoginPage lp = new LoginPage(driver);
		lp.Login("admin", "admin");
		logger.log(LogStatus.PASS, "Login successfully");
		Commonfunctions.getscreenshot("E2E_Test", driver);
		HomePage hp = new HomePage(driver);
		hp.clickOnHyperLink("New Lead");
		logger.log(LogStatus.PASS, "Clicked on New Lead");
		Commonfunctions.getscreenshot("E2E_Test", driver);
		NewLeadPage nlp = new NewLeadPage(driver);
		boolean flag = nlp.checkMandatoryField();
		if (flag) {
			logger.log(LogStatus.PASS, "Manadatory field validated successfully");
		} else {
			logger.log(LogStatus.FAIL, "Manadatory fields not working");
		}
		Commonfunctions.getscreenshot("E2E_Test", driver);
		nlp.CreateLeadWithMandatoryfield("Narendra", "Modi");
		boolean flag1 = nlp.verifyLeadCreation("Narendra", "Modi");
		if (flag1) {
			logger.log(LogStatus.PASS, "Lead created successfully");

		} else {
			logger.log(LogStatus.FAIL, "Lead creation Failed");
		}
		nlp.clickOnHyperLink("Logout");
		Commonfunctions.getscreenshot("E2E_Test", driver);
		logger.log(LogStatus.PASS, "Logout Successful");
		report.endTest(logger);
		report.flush();
	}

	@AfterClass(alwaysRun = true)
	public void closeApp() {
		driver.close();
		driver.quit();
	}
}

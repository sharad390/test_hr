package hrms.testcases;

import java.awt.AWTException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import hrms.testbase.TestBase;
import hrms.utilities.LoggerManager;

public class DashboardPageTest extends TestBase
{

	@Test(priority = 1, description = "Verify dashboard Page UI", groups = { "Smoke" })
	public void verifydashboardPageTitle() throws AWTException {

		LoggerManager.info("Verifying dashboard");

		TestBase.test = TestBase.extent.createTest("Dashboard Page Test");
		TestBase.test.assignCategory("Smoke Test");
		TestBase.test = TestBase.test.createNode("Verify Dashboard Page Title");

		TestBase.test.log(Status.INFO, "Verifying DashboardPage Title");

		//assertTrue(driver.getTitle().contains("Welcome to SKF"));

		dashboardPage.verifydashboard();
		

	}
	
	@Test(priority = 0, description = "Verify dashboard Page UI", groups = { "UI" })
	public void verifyUI() throws AWTException 
	{
		LoggerManager.info("Verifying UI");

		TestBase.test = TestBase.extent.createTest("UI");
		TestBase.test.assignCategory("UI Test");
		TestBase.test = TestBase.test.createNode("Verify UI");

		TestBase.test.log(Status.INFO, "Verifying UI");

		//assertTrue(driver.getTitle().contains("Welcome to SKF"));

		dashboardPage.verifyElementClickable();
		


	
	}


}

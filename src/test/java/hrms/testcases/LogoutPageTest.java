package hrms.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import hrms.testbase.TestBase;
import hrms.utilities.EnvironmentConfig;
import hrms.utilities.LoggerManager;

public class LogoutPageTest extends TestBase {

	@Test(priority = 0, description = "Verify LoginPage UI", groups = { "Smoke" })
	public void verifylogoutPage() {

		LoggerManager.info("Verifying logout Page");

		TestBase.test = TestBase.extent.createTest("logoutPage Test");
		TestBase.test.assignCategory("Smoke Test");
		TestBase.test = TestBase.test.createNode("Verify logout Page");

		TestBase.test.log(Status.INFO, "Verifying logoutPage");
		
		// getTitle() to obtain page title
	    System.out.println("Page title is : " + driver.getTitle());

		assertTrue(driver.getTitle().contains("Welcome to SKF"));
		
		
	}
}

package hrms.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import hrms.pages.DashboardPage;
import hrms.testbase.TestBase;
import hrms.utilities.EnvironmentConfig;
import hrms.utilities.LoggerManager;

public class UploadExcelPageTest extends TestBase 
{

	@Test(priority = 0, description = "Verify Upload excel Page", groups = {"Regression"})
	public void verifyuploadexcelpage()  throws InterruptedException, AWTException
	{

		LoggerManager.info("Verifying Upload excel page");

		TestBase.test = TestBase.extent.createTest("Upload excel Page Test");
		TestBase.test.assignCategory("Smoke Test");
		TestBase.test = TestBase.test.createNode("Verify Upload excelPage Title");

		TestBase.test.log(Status.INFO, "Verifying Upload excel page Title");

		//assertTrue(driver.getTitle().contains("Welcome to SKF"));

		uploadexcelPage.uploadexcelpage();
		uploadexcelPage.Upload_Images();

	}
}

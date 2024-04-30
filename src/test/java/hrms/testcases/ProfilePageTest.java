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

public class ProfilePageTest extends TestBase {

	@Test(priority = 0, description = "Verify profile Page Landing", groups = { "Smoke" })
	public void verifyLoginPageTitle() {

		LoggerManager.info("Verifying Profile Page Title");

		TestBase.test = TestBase.extent.createTest("Profile Page Test");
		TestBase.test.assignCategory("Smoke Test");
		TestBase.test = TestBase.test.createNode("Verify Profile Page Title");

		TestBase.test.log(Status.INFO, "Verifying Profile Page Title");

		// assertTrue(driver.getTitle().contains("Personal Details"));

		ProfilePage.profile_pagePageLanding();

	}

	@Test(priority = 1, description = "Verify profile_page clear textbox", groups = { "Smoke" })
	public void verifyprofile_pagecleartextbox() 
	{

		LoggerManager.info("Verifying profile_page");

		TestBase.test = TestBase.extent.createTest("profile_page clear textboxes");
		TestBase.test.assignCategory("Smoke Test");
		TestBase.test = TestBase.test.createNode("profile_page clear textboxes");

		TestBase.test.log(Status.INFO, "Verifying profile_page clear");

		// assertTrue(profile_pagecleartextbox(), "loaded Profile Page components");
		ProfilePage.profile_pagecleartextbox();

	}

	@Test(priority = 2, description = "Verify profile_page mobile field", groups = { "Smoke" })
	public void verifyprofile_page_mobilefield() 
	{
		LoggerManager.info("Verify profile_page mobile field");

		TestBase.test = TestBase.extent.createTest("Verify profile_page mobile field");
		TestBase.test.assignCategory("Smoke Test");
		TestBase.test = TestBase.test.createNode("Verify Login Page Components");

		TestBase.test.log(Status.INFO, "Verifying LoginPage Components");

		// assertTrue(profile_page_mobilefield(), "loaded Profile Page components");

		ProfilePage.profile_page_mobilefield();

	}

	@Test(priority = 3, description = "Verify profile_page_Street_1field", groups = { "Smoke" })
	public void verifyprofile_page_Street_1field() {

		LoggerManager.info("Verifying LoginPage Components");

		TestBase.test = TestBase.extent.createTest("Login Page Components Test");
		TestBase.test.assignCategory("Smoke Test");
		TestBase.test = TestBase.test.createNode("Verify Login Page Components");

		TestBase.test.log(Status.INFO, "Verifying LoginPage Components");

		// assertTrue(profile_page_Street_1field(), "loaded Profile Page components");
		ProfilePage.profile_page_Street_1field();

	}

	@Test(priority = 4, description = "Verify profile_page_statevalidation", groups = { "Smoke" })
	public void verifyprofile_page_statevalidation() {

		LoggerManager.info("Verifying LoginPage Components");

		TestBase.test = TestBase.extent.createTest("Login Page Components Test");
		TestBase.test.assignCategory("Smoke Test");
		TestBase.test = TestBase.test.createNode("Verify Login Page Components");

		TestBase.test.log(Status.INFO, "Verifying LoginPage Components");

		// assertTrue(verifyprofile_page_statevalidation(), "loaded Profile Page
		// components");
		ProfilePage.profile_page_statevalidation();

	}

}

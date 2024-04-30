package hrms.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import hrms.testbase.TestBase;
import hrms.utilities.EnvironmentConfig;
import hrms.utilities.LoggerManager;

public class HomePageTest extends TestBase {

	String username = EnvironmentConfig.environmentSetup().get("USERNAME");
	String password = EnvironmentConfig.environmentSetup().get("PASSWORD");
	
	@Test(priority = 0, description = "Verify Who We Are", groups = { "Functional" })
	public void verifyWhoweare() throws InterruptedException 
	{
		
		
		homePage.Whoweare();

		//TestBase.test.log(Status.INFO, "Verifying HomePage who we are");
		
		//assertTrue(driver.getTitle().contains("Who We Are"));

	}
	
	
	@Test(priority = 1, description = "Verify What we do", groups = { "Functional" })
	public void verifyWhatwedo() throws InterruptedException 
	{
		
		
		homePage.Whatwedo();

		//TestBase.test.log(Status.INFO, "Verifying HomePage Waht we do");

	}
	
	@Test(priority = 2, description = "Verify Why support us", groups = { "Functional" })
	public void verifyWhysupportus() throws InterruptedException 
	{
		
		
		homePage.Whysupportus();

		//TestBase.test.log(Status.INFO, "Verifying HomePage Why support us");

	}
	
	@Test(priority = 3, description = "Verify how to associate", groups = { "Functional" })
	public void verifyhowToAsso() throws InterruptedException 
	{
		
		
		homePage.howToAsso();

		//TestBase.test.log(Status.INFO, "Verifying HomePage  how to associate");

	}
	
	@Test(priority = 4, description = "Verify where are we", groups = { "Functional" })
	public void verifywhereArewe() throws InterruptedException 
	{
		
		
		homePage.whereArewe();

		//TestBase.test.log(Status.INFO, "Verifying HomePage  where are we");

	}
	
	@Test(priority = 5, description = "Verify Write To Us", groups = { "Functional" })
	public void verifywritetous() throws InterruptedException 
	{
		
		
		homePage.writetous();

		//TestBase.test.log(Status.INFO, "Verifying HomePage Write To Us");

	}
	
}

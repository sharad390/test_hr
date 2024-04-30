package hrms.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import hrms.testbase.TestBase;
import hrms.utilities.EnvironmentConfig;
import hrms.utilities.LoggerManager;

public class LogoutPage {

	public WebDriver driver;

	public Boolean blnLogin = false;

	WebDriverWait wait;

	// Initializing the Page Objects:
	public LogoutPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		LoggerManager.debug("======== Initializing Login Page Objects ======== ");

	}

	@FindBy(xpath = "//img[@class='rounded-circle']")
	public WebElement user_profile;
	
	@FindBy(xpath = "//a[@class='dropdown-item'][normalize-space()='Logout']")
	public WebElement logout;
	
	

	public void verifylogout() 
	{
		LoggerManager.info("======== into verifylogout() ========");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			
			user_profile.click();
			
			logout.click();
			Thread.sleep(2000);
			
			String t = driver.getTitle();
			
			// getTitle() to obtain page title
		    System.out.println("Page title is : " + driver.getTitle());
		    
			
		} catch (Exception e) {

			LoggerManager.error("+++++++++ Exception in verifylogout() +++++++++ " + e.getMessage()); // e.printStackTrace();
		}

	}
}
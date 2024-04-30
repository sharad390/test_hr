package hrms.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import hrms.utilities.LoggerManager;

public class DashboardPage 
{

	public static WebDriver driver;

	public Boolean blnLogin = false;

	WebDriverWait wait;

	JavascriptExecutor js ;

	// Initializing the Page Objects:
	public DashboardPage(WebDriver driver) 
	{

		this.driver = driver;

		js = (JavascriptExecutor)driver;

		PageFactory.initElements(driver, this);
		LoggerManager.debug("======== Initializing Login Page Objects ======== ");

	}


	@FindBy(xpath = "//span[normalize-space()='On-Boarding Process']")
	public WebElement onboarding;

	@FindBy(xpath = "//a[normalize-space()='On Boarding Process']")
	public WebElement onboarding_process;

	@FindBy(xpath = "//span[@id='select2-locId-container']")
	public WebElement searchfiler;

	@FindBy(xpath = "//input[@role='textbox']")
	public WebElement search_text;

	@FindBy(xpath = "//button[@id='submtbtn']")
	public WebElement search_btn;

	@FindBy(xpath = "//button[normalize-space()='Candidate Registration']")
	public WebElement candidate_registrations;


	@FindBy(xpath = "//input[@id='firstName']")
	public WebElement FirstName;

	@FindBy(xpath = "//input[@id='middleName']")
	public WebElement MiddleName;

	@FindBy(xpath = "//input[@id='lastName']")
	public WebElement LastName;

	@FindBy(xpath = "//span[contains(text(),'Select Company')]")
	public WebElement CompanyName;

	@FindBy(xpath = "//form[@id='submitInsertLocaion']")
	public WebElement CompanyName_dropdown;

	@FindBy(xpath = "//span[contains(text(),'Select Designation')]")
	public WebElement Designation;

	@FindBy(xpath = "//form[@id='submitInsertLocaion']")
	public WebElement Designation_dropdown;

	@FindBy(xpath = "//span[@id='select2-location-container']")
	public WebElement Location;

	@FindBy(xpath = "//input[@id='responseEmail']")
	public WebElement Location_dropdown;

	@FindBy(xpath = "//input[@id='email']")
	public WebElement Email;

	@FindBy(xpath = "//input[@id='contactNo']")
	public WebElement ContactNo;

	@FindBy(xpath = "//input[@id='address']")
	public WebElement Address;

	@FindBy(xpath = "//input[@id='responseEmail']")
	public WebElement ResponseEmail;

	@FindBy(xpath = "//span[@class='select2-selection__placeholder']")
	public WebElement Department;

	@FindBy(xpath = "//form[@id='submitInsertLocaion']")
	public WebElement Department_dropdown;

	//	Candidate Allowance Details
	@FindBy(xpath = "//input[@id='basic']")
	public WebElement Basic_Rs;

	@FindBy(xpath = "//button[@id='submtbtn']")
	public WebElement submit_btn;

	@FindBy(xpath = "//div[@class='alert bg-success text-white alert-styled-left alert-dismissible']")
	public WebElement message;
	
	public boolean verifyElementClickable()
	{
		boolean str = false;
		if (onboarding_process.isDisplayed())
			str = true;
			System.out.println("UI test case Passed");
			return str;
		
		
	}

	public void verifydashboard() throws AWTException 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		Robot robot = new Robot();  // Robot class throws AWT Exception

		try {

			//onboarding.click();

			Thread.sleep(1000);
			onboarding.click();

			onboarding_process.click();

			searchfiler.click();

			//search_text.sendKeys("All");
			//pressing enter
			robot.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(1000);

			//releasing enter
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(1000);

			search_btn.click();
			Thread.sleep(1000);

			candidate_registrations.click();
			Thread.sleep(1000);

			//========================= form fields ==================================
			FirstName.sendKeys("test");

			MiddleName.sendKeys("test");

			LastName.sendKeys("test");

			CompanyName.click();

			//CompanyName_dropdown.sendKeys("krios- Pune");
			//pressing enter
			robot.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(1000);

			//releasing enter
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(1000);


			Designation.click();
			//Designation_dropdown.sendKeys("Quality Analyst1");
			robot.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(1000);

			//releasing enter
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(1000);


			Location.click();
			//Location_dropdown.sendKeys("Pune");
			robot.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(1000);

			//releasing enter
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(1000);


			Email.click();
			Email.sendKeys("test@gmail.com");

			ContactNo.sendKeys("8010018899");

			Address.sendKeys("baner Pune");

			ResponseEmail.sendKeys("test_1@gmail.com");

			Department.click();
			//Department_dropdown.sendKeys("Quality Assurance");
			robot.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(1000);

			//releasing enter
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(1000);

			//	Candidate Allowance Details
			Basic_Rs.clear();
			Basic_Rs.click();
			Basic_Rs.sendKeys("30000.00");
			Thread.sleep(1000);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,250)", "");
			Thread.sleep(1000);

			submit_btn.click();
			System.out.println("submit button clicked");
			Thread.sleep(1000);

			robot.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(1000);

			//releasing enter
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(1000);


			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert bg-success text-white alert-styled-left alert-dismissible']")));


			// Check whether the Check box is toggled on 		
			if (message.isDisplayed()) 
			{
				System.out.println("Well done! Candidate Registered Successfully");
			}
			else
			{
				System.out.println("Candidate is not registered");
			}
			
			
			
			
			//Path of the excel file
			//FileInputStream fs = new FileInputStream("D:\\Sharad\\Python\\HRMS\\hrms\\Resource\\DownloadEmployeeExcellFormat.xlsx");
			
			
			
			
			
			

		} 

		catch (Exception e) 
		{

			LoggerManager.error("+++++++++ Exception in verifydashboard() +++++++++ " + e.getMessage()); 
			e.printStackTrace();

		}

	}

}


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
import org.testng.Assert;

import hrms.testbase.TestBase;
import hrms.utilities.EnvironmentConfig;
import hrms.utilities.LoggerManager;

public class ProfilePage {

	public WebDriver driver;	

	public Boolean blnLogin=false;

	WebDriverWait wait;

	// Initializing the Page Objects:
	public ProfilePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		LoggerManager.debug("======== Initializing Profile Page Objects ======== ");

	}
	
	@FindBy(xpath = "//button[@class='btn webform-button--submit button button--primary js-form-submit form-submit']")
	public WebElement login_btn;
	
	@FindBy(xpath = "//a[normalize-space()='Profile']")
	public WebElement profile_page;
	
	public String profile_page_URL = "https://hariyali-dev.m-devsecops.com/user/update";
	
	@FindBy(xpath = "//h5[normalize-space()='Personal Details']")
	public WebElement Personal_Details;
	
	@FindBy(xpath = "//input[@placeholder='Mobile Number']")
	public WebElement mobile_number;
	
	@FindBy(xpath = "//input[@placeholder=' Street 1']")
	public WebElement Street_1;
	
	@FindBy(xpath = "//input[@placeholder='Street 2']")
	public WebElement Street_2;
	
	@FindBy(xpath = "//input[@placeholder='Street 3']")
	public WebElement Street_3;
	
	@FindBy(xpath = "//input[@placeholder='state']")
	public WebElement state;
	
	@FindBy(xpath = "//input[@placeholder='City']")
	public WebElement city;
	
	@FindBy(xpath = "//input[@placeholder='Postal Code']")
	public WebElement Postal_Code;
	
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement updatebtn;
		
	@FindBy(xpath = "//div[contains(text(),'Mobile No. is required')]")
	public WebElement mobile_validation;
	
	
	@FindBy(xpath = "//div[contains(text(),'Street 1 is required')]")
	public WebElement Street_1_validation;
	
	@FindBy(xpath = "//div[contains(text(),'State is required')]")
	public WebElement state_validation;
	
	@FindBy(xpath = "//div[contains(text(),'postalCode is required')]")
	public WebElement Postal_Code_validation;
	
	
	/**
	* Locating and Clicking CheckBox By using xpath
	 */
	@FindBy(xpath = "//li[contains(text(),'By checking this box, I confirm that I have read a')]//input[@name='Condition']")
	public WebElement checkbox_1;
	
	@FindBy(xpath = "//li[contains(text(),'I understand that I am free to withdraw my consent')]//input[@name='Condition']")
	public WebElement checkbox_2;
	
	// Store message in variable
	String mnumber = "08010418397";	
	
	// Store message in variable
	String s1 = "Teerth Technospace";
	
	// Store message in variable
	String s2 = "Office No. 206 B Wing";
	
	// Store message in variable
	String s3 = "Bengaluru - Mumbai Hwy";
	
	// Store message in variable
	String st = "MAHARASHTRA";
	
	// Store message in variable
	String c1 = "Pune";
	
	// Store message in variable
	String pc1 = "411045";
	
	// method declaration
	public void profile_pagePageLanding() 
	{
		//login_icon.click();
		
		profile_page.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		// statement which prints the argument passed to it
		System.out.println("======== Navigating to Profile page ========");

		// Get current URL
		String actualURL = driver.getCurrentUrl();

		// statement which prints the argument passed to it
		System.out.println("Current Page is : " + driver.getTitle());

		// method used to compare the actual and expected results
		 Assert.assertEquals(actualURL, profile_page_URL);
		 
		 String actualTitle = driver.getTitle();
		 
		 String expectedTitle = "PERSONAL DETAILS";
		 
		 if(actualTitle.equalsIgnoreCase(expectedTitle))
			 System.out.println("PERSONAL DETAILS Title Matched");
		 
		 else
			 System.out.println("PERSONAL DETAILS Title didn't match");
		 
	}
	
	// method declaration
	public void profile_pagecleartextbox() 
	{
		// delete default value with clear()
		 mobile_number.clear();
		 
		// delete default value with clear()
		 Street_1.clear();
		 
		// delete default value with clear()
		 Street_2.clear();		 
		 
		// delete default value with clear()
		 Street_3.clear();
		 
		// delete default value with clear()
		 state.clear();
		 
		// delete default value with clear()
		 city.clear();
		 
		// delete default value with clear()
		 Postal_Code.clear();
		 
		 
	}
	
	// method declaration
	public void profile_page_mobilefield() 
	{
		 
		// click on update button
		 updatebtn.click();
		 
		// This will capture error message
		String actual_msg= mobile_validation.getText();
			    
		// Store message in variable
		String expect="Mobile No. is required";
			                
		// Here Assert is a class and assertEquals is a method which will compare two values if// both matches it will run fine but in case if does not match then if will throw an 
		//exception and fail testcases

		// Verify mobile number validation message
		Assert.assertEquals(actual_msg, expect);
		
		 if(actual_msg.equalsIgnoreCase(expect))
			 System.out.println("Verified validation message Mobile No. is required");
		 
		 else
			 System.out.println("Didn't match validation message Mobile No. is required");
		
	}
	
	// method declaration
	public void profile_page_Street_1field() 
	{
		 
		// This will capture error message
		String actual_msg= Street_1_validation.getText();
			    
		// Store message in variable
		String expect="Street 1 is required";
			                
		// Here Assert is a class and assertEquals is a method which will compare two values if// both matches it will run fine but in case if does not match then if will throw an 
		//exception and fail testcases

		// Verify mobile number validation message
		Assert.assertEquals(actual_msg, expect);
		
		 if(actual_msg.equalsIgnoreCase(expect))
			 System.out.println("Verified validation Street 1 is required");
		 
		 else
			 System.out.println("Didn't match validation message Street 1 is required");

	}

	
	// method declaration
	public void profile_page_statevalidation() 
	{
		 
		// This will capture error message
		String actual_msg= state_validation.getText();
			    
		// Store message in variable
		String expect="State is required";
			                
		// Here Assert is a class and assertEquals is a method which will compare two values if// both matches it will run fine but in case if does not match then if will throw an 
		//exception and fail testcases

		// Verify mobile number validation message
		Assert.assertEquals(actual_msg, expect);
		
		 if(actual_msg.equalsIgnoreCase(expect))
			 System.out.println("Verified validation State is required");
		 
		 else
			 System.out.println("Didn't match validation message State is required");

	}

	
	// method declaration
	public void profile_page_Postal_Codevalidation() 
	{
		 
		// This will capture error message
		String actual_msg= Postal_Code_validation.getText();
			    
		// Store message in variable
		String expect="postalCode is required";
			                
		// Here Assert is a class and assertEquals is a method which will compare two values if// both matches it will run fine but in case if does not match then if will throw an 
		//exception and fail testcases

		// Verify mobile number validation message
		Assert.assertEquals(actual_msg, expect);
		
		 if(actual_msg.equalsIgnoreCase(expect))
			 System.out.println("Verified validation postalCode is required");
		 
		 else
			 System.out.println("Didn't match validation message postalCode is required");

	}
	
	// method declaration
	public boolean profile_pageAcionForMultipleSelection() 
	{
		
		String mnumber = "08010418397";	
		
		// Store message in variable
		String s1 = "Teerth Technospace";
		
		// Store message in variable
		String s2 = "Office No. 206 B Wing";
		
		// Store message in variable
		String s3 = "Bengaluru - Mumbai Hwy";
		
		// Store message in variable
		String st = "MAHARASHTRA";
		
		// Store message in variable
		String c1 = "Pune";
		
		// Store message in variable
		String pc1 = "411045";
		
		mobile_number.sendKeys(mnumber);
		
		Street_1.sendKeys(s1);

		Street_2.sendKeys(s2);

		Street_3.sendKeys(s3);

		state.sendKeys(st);
		
		city.sendKeys(c1);
				
		Postal_Code.sendKeys(pc1);
		
		//Selecting the first checkbox using XPath
		try 
		{
			checkbox_1.click();
			Thread.sleep(2);

			//Selecting the second checkbox using Xpath
			checkbox_2.click();
			
			//click on update button
			updatebtn.click();
			 
			return true;
		}

		catch(Exception e)
		{
			return false;
		}


	}
		 
}

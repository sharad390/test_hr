package hrms.pages;

import java.time.Duration;


import java.util.ArrayList;
import com.paulhammant.ngwebdriver.*;
import com.paulhammant.ngwebdriver.ByAngularModel;

import hrms.utilities.LoggerManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage 
{


	protected WebDriver driver;

	public Boolean blnLogin = false;

	WebDriverWait wait;

	
	public HomePage(WebDriver driver) 
	{

		this.driver = driver;
		PageFactory.initElements(driver, this);
		LoggerManager.debug("======== Initializing the Home Page Objects ======== ");

	}
	
	@FindBy(xpath="(//a[@class='nav-link'])[1]")
	WebElement wwa;
	
	@FindBy(xpath="//a[@data-rr-ui-event-key='/WhatWeDo']")
	WebElement wwd;
	
	@FindBy(xpath="(//a[@class='nav-link'])[2]")
	WebElement ysupport;
	
	
	@FindBy(xpath="(//a[@class='nav-link'])[3]")
	WebElement howta;
	
	@FindBy(xpath="(//a[@class='nav-link'])[4]")
	WebElement wew;
	
	@FindBy(xpath="(//a[@class='nav-link'])[5]")
	WebElement wtu;
	
	@FindBy(xpath="(//div[@class='feature-description feature-description-other'])[1]")
	WebElement whoimage;
	
	
	public void Whoweare() throws InterruptedException 
	{
		
		Thread.sleep(2000);
		wwa.click();
		Thread.sleep(2000);
		System.out.println("Clicked on Who We Are");
		
		
        if (whoimage.isDisplayed()) {
            System.out.println("Who we are page is visible. Return: " + whoimage.isDisplayed());
        } else {
            System.out.println("Who we are page is not visible. Return: " + whoimage.isDisplayed());
        }
		
		//driver.close();
		//driver.switchTo().window((String) communitytabs.get(0));
		//driver.close();
	
	
	}
	
	public void Whatwedo() throws InterruptedException 
	{
		
		Thread.sleep(2000);
		wwd.click();
		Thread.sleep(2000);
		System.out.println("Clicked on What We do");
		
		//driver.close();
		//driver.switchTo().window((String) communitytabs.get(0));
		//driver.close();
	
	}
	
	public void Whysupportus() throws InterruptedException 
	{
		
		Thread.sleep(2000);
		ysupport.click();
		Thread.sleep(2000);
		System.out.println("Clicked on y support us");
		
		//driver.close();
		//driver.switchTo().window((String) communitytabs.get(0));
		//driver.close();
	
	}
	
	public void howToAsso() throws InterruptedException 
	{
		
		Thread.sleep(2000);
		howta.click();
		Thread.sleep(2000);
		System.out.println("Clicked on how to associate");
		
		//driver.close();
		//driver.switchTo().window((String) communitytabs.get(0));
		//driver.close();
	
	}
	
	public void whereArewe() throws InterruptedException 
	{
		
		Thread.sleep(2000);
		wew.click();
		Thread.sleep(2000);
		System.out.println("Clicked on where are we");
		
		//driver.close();
		//driver.switchTo().window((String) communitytabs.get(0));
		//driver.close();
	
	}
	
	public void writetous() throws InterruptedException 
	{
		
		Thread.sleep(2000);
		wtu.click();
		Thread.sleep(2000);
		System.out.println("Clicked on write to us");
		
		//driver.close();
		//driver.switchTo().window((String) communitytabs.get(0));
		//driver.close();
	
	}
}
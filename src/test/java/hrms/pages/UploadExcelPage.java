package hrms.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
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

public class UploadExcelPage {

	public static WebDriver driver;

	public Boolean blnLogin = false;

	WebDriverWait wait;

	JavascriptExecutor js ;

	// Initializing the Page Objects:
	public UploadExcelPage(WebDriver driver) 
	{

		this.driver = driver;

		js = (JavascriptExecutor)driver;



		PageFactory.initElements(driver, this);
		LoggerManager.debug("======== Initializing Login Page Objects ======== ");

	}

	@FindBy(xpath = "//i[@class='icon-Box-Full']")
	public WebElement uploadexcelpage;

	@FindBy(xpath = "//input[@id='rdoexcel']")
	public WebElement Upload_Excelradio;

	@FindBy(xpath = "//input[@id='rdoimage']")
	public WebElement Upload_Excelradio1;

	@FindBy(xpath = "//button[@onclick='uploadFile(event)']")
	public static WebElement uploadbtn;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[2]/div[4]/table[1]/tbody[1]/tr[1]/td[1]/input[1]")
	public static WebElement chkoption1;

	@FindBy(xpath = "//button[@id='SaveEmployee']")
	public static WebElement submitbtn;

	@FindBy(xpath = "//button[@id='UpdateEmployee']")
	public static WebElement OldEmployeesListUpdatebtn;

	@FindBy(xpath = "//a[normalize-space()='Download Excel Format']")
	public static WebElement Download_Excel_btn;
	
	
	@FindBy(xpath = "//button[@onclick='uploadAllImages(event)']")
	public static WebElement Upload_Profile_Imagebtn;

	public void uploadexcelpage() throws InterruptedException, AWTException 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		uploadexcelpage.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@onclick='uploadFile(event)']")));

		// Check whether the Check box is toggled on 		
		if (uploadexcelpage.isDisplayed()) 
		{
			Robot robot = new Robot();  // Robot class throws AWT Exception

			System.out.println("Upload Excel page is displayed");

			// Check whether the Check box is toggled on 		
			if (Upload_Excelradio.isSelected()) 
			{					
				System.out.println("UploadExcel Radio option 1 Selected");					

				//Radio Button1 is selected		
				Upload_Excelradio.click();			

				robot.keyPress(KeyEvent.VK_TAB);	
				Thread.sleep(2000);

				robot.keyPress(KeyEvent.VK_ENTER);	
				// press enter key of keyboard to perform above selected action
				Thread.sleep(2000);

				System.out.println("choose file button is clickabled");

				//StringSelection s = new StringSelection("C:\\Users\\Admin\\Desktop\\tt.png");

				StringSelection s = new StringSelection("D:\\Sharad\\Python\\SKFIdCardApplication\\SKFIdCardApplication\\Resource\\DownloadEmployeeExcellFormat.xlsx");

				// Clipboard copy
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s,null);

				//pressing enter
				robot.keyPress(KeyEvent.VK_ENTER);
				Thread.sleep(2000);

				//releasing enter
				robot.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(2000);

				//pressing ctrl+v
				robot.keyPress(KeyEvent.VK_CONTROL);
				Thread.sleep(2000);

				robot.keyPress(KeyEvent.VK_V);
				Thread.sleep(2000);

				//releasing ctrl+v
				robot.keyRelease(KeyEvent.VK_CONTROL);
				Thread.sleep(2000);

				robot.keyRelease(KeyEvent.VK_V);
				Thread.sleep(2000);

				//pressing enter
				robot.keyPress(KeyEvent.VK_ENTER);
				Thread.sleep(2000);

				//releasing enter
				robot.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(2000);

				uploadbtn.click();
				Thread.sleep(1000);

				System.out.println("Employee Excel Format uploaded successfully");
				System.out.println("Update button clicked");

				Thread.sleep(3000);

				// This will Toggle the Check box 		
				chkoption1.click();			

				// Check whether the Check box is toggled on 		
				if (chkoption1.isSelected()) 
				{					
					System.out.println("Checkbox is Toggled On");

					//Robot robot = new Robot();  // Robot class throws AWT Exception

					robot.keyPress(KeyEvent.VK_TAB);	
					Thread.sleep(2000);

					robot.keyPress(KeyEvent.VK_TAB);	
					Thread.sleep(2000);

					robot.keyPress(KeyEvent.VK_ENTER);	
					// press enter key of keyboard to perform above selected action
					Thread.sleep(2000);

					System.out.println("choose file button is clickabled");

					//StringSelection s = new StringSelection("C:\\Users\\Admin\\Desktop\\tt.png");

					StringSelection s1 = new StringSelection("D:\\Sharad\\Python\\SKFIdCardApplication\\SKFIdCardApplication\\Resource\\tt.png");

					// Clipboard copy
					Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s1,null);


					//pressing enter
					robot.keyPress(KeyEvent.VK_ENTER);
					Thread.sleep(2000);

					//releasing enter
					robot.keyRelease(KeyEvent.VK_ENTER);
					Thread.sleep(2000);

					//pressing ctrl+v
					robot.keyPress(KeyEvent.VK_CONTROL);
					Thread.sleep(2000);

					robot.keyPress(KeyEvent.VK_V);
					Thread.sleep(2000);

					//releasing ctrl+v
					robot.keyRelease(KeyEvent.VK_CONTROL);
					Thread.sleep(2000);

					robot.keyRelease(KeyEvent.VK_V);
					Thread.sleep(2000);

					//pressing enter
					robot.keyPress(KeyEvent.VK_ENTER);
					Thread.sleep(2000);

					//releasing enter
					robot.keyRelease(KeyEvent.VK_ENTER);
					Thread.sleep(2000);

					System.out.println("User Profile Image uploaded successfully");

					Download_Excel_btn.click();

					//pressing enter
					robot.keyPress(KeyEvent.VK_ENTER);
					Thread.sleep(2000);

					//releasing enter
					robot.keyRelease(KeyEvent.VK_ENTER);
					Thread.sleep(2000);

					//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[2]/div[4]/table[1]/tbody[1]/tr[1]/td[10]/input[1]")));

					// This  will scroll down the page by  1000 pixel vertical		
					//js.executeScript("window.scrollBy(0,1000)");
					submitbtn.click();
					Thread.sleep(2000);


				}



				else 
				{			
					System.out.println("Checkbox is Toggled Off");					
				}		



			}


			else 
			{			
				System.out.println("UploadExcel Radio option 1 is not Selected");					
			}

		}

		else 
		{			
			System.out.println("Upload Excel page is displayed");
		}
	}

	public void Upload_Images() throws InterruptedException, AWTException 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		
		uploadexcelpage.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@onclick='uploadFile(event)']")));

		//Upload_Excelradio1.click();
		Robot robot = new Robot();  // Robot class throws AWT Exception
		
		Upload_Excelradio1.click();
		Thread.sleep(2000);


		// Check whether the Check box is toggled on 		
		if (Upload_Excelradio1.isSelected()) 
		{
			//Upload_Excelradio1.click();
			Thread.sleep(2000);
			
			System.out.println("UploadExcel Radio option 2 Selected");
			
			robot.keyPress(KeyEvent.VK_TAB);	
			Thread.sleep(2000);

			robot.keyPress(KeyEvent.VK_ENTER);	
			// press enter key of keyboard to perform above selected action
			Thread.sleep(2000);

			System.out.println("choose file button is clickabled");

			//StringSelection s = new StringSelection("C:\\Users\\Admin\\Desktop\\tt.png");

			StringSelection s = new StringSelection("D:\\Sharad\\Python\\SKFIdCardApplication\\SKFIdCardApplication\\Resource\\tt.png");

			// Clipboard copy
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s,null);


			//pressing enter
			robot.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(2000);

			//releasing enter
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);

			//pressing ctrl+v
			robot.keyPress(KeyEvent.VK_CONTROL);
			Thread.sleep(2000);

			robot.keyPress(KeyEvent.VK_V);
			Thread.sleep(2000);

			//releasing ctrl+v
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(2000);

			robot.keyRelease(KeyEvent.VK_V);
			Thread.sleep(2000);

			//pressing enter
			robot.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(2000);

			//releasing enter
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);

			System.out.println("User Profile Image uploaded successfully");
			Thread.sleep(2000);
			
			Upload_Profile_Imagebtn.click();
			Thread.sleep(2000);




		}
	}

}
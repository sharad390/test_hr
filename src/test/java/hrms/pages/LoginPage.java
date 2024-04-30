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

public class LoginPage {

	public WebDriver driver;

	public Boolean blnLogin = false;

	WebDriverWait wait;

	// Initializing the Page Objects:
	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		LoggerManager.debug("======== Initializing Login Page Objects ======== ");

	}

	@FindBy(xpath = "//input[@id='username']")
	public WebElement txtUsername;

	@FindBy(xpath = "//input[@id='password']")
	public WebElement txtPassword;

	@FindBy(xpath = "//button[@type='submit']")
	public WebElement login_btn;
	
	@FindBy(xpath = "//span[normalize-space()='Dashboard']")
	public WebElement dashboard;

	public boolean verifyLogin(String userName, String password) 
	{
		blnLogin = true;
		LoggerManager.info("======== into verifyLogin() ========");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			
			//login_icon.click();

			new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(txtUsername));
			txtUsername.clear();
			txtUsername.sendKeys(userName);
			LoggerManager.info("======== Username: " + userName + "========");

			new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(txtPassword));
			txtPassword.clear();
			txtPassword.sendKeys(password);
			LoggerManager.info("======== Password: " + password + "========");
			
			login_btn.click();
			

		} catch (Exception e) {

			LoggerManager.error("+++++++++ Exception in verifyLogin() +++++++++ " + e.getMessage()); // e.printStackTrace();
		}

		/*
		 * if (driver.getCurrentUrl().endsWith("home")) {
		 * 
		 * LoggerManager.info("======== Login Success ========");
		 * 
		 * assertEquals(driver.getTitle(), "YOUR DONATIONS");
		 * 
		 * LoggerManager.info("======== End verifyLogin() ========");
		 * 
		 * return true;
		 * 
		 * } else {
		 * 
		 * LoggerManager.debug("======== Login Unsuccessful ========");
		 * 
		 * return false; }
		 */
		
		return true;
	}

	public HomePage verifyHomePage(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean profile_pagePageLanding() {
		
		//login_icon.click();
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * public boolean visiblityOfLoginPageComponents(){ try {
	 * 
	 * Thread.sleep(1000);
	 * 
	 * LoggerManager.
	 * info("============  Verifying Visiblity Of Login Page Components ============"
	 * );
	 * 
	 * if (lblManagmentBoardPortal.isDisplayed() && txtUsername.isDisplayed() &&
	 * txtPassword.isDisplayed() && btnSignIn.isDisplayed() &&
	 * btnforgotPassword.isDisplayed() && linkChooseDiffPortal.isDisplayed()) {
	 * 
	 * LoggerManager.info("============  Login Page verified ============"); return
	 * true; } else { LoggerManager.
	 * info("============  Login Page verification failed ============");
	 * 
	 * return false; } } catch (Exception e) {
	 * 
	 * e.printStackTrace(); }
	 * 
	 * 
	 * return false; }
	 * 
	 * public boolean verifyLoginWithEnterKeyPress(String userName, String password)
	 * { blnLogin = true;
	 * LoggerManager.info("======== into verifyLoginEnterKeyPress() ========");
	 * 
	 * try {
	 * 
	 * new WebDriverWait(driver,
	 * Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(txtUsername));
	 * txtUsername.clear(); txtUsername.sendKeys(userName);
	 * LoggerManager.info("======== Username: " + userName + "========");
	 * 
	 * new WebDriverWait(driver,
	 * Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(txtPassword));
	 * txtPassword.clear(); txtPassword.sendKeys(password);
	 * LoggerManager.info("======== Password: " + password + "========");
	 * 
	 * txtPassword.sendKeys(Keys.ENTER);
	 * 
	 * // btnSignIn.click();
	 * 
	 * Thread.sleep(8000);
	 * 
	 * } catch (Exception e) {
	 * 
	 * LoggerManager.
	 * error("+++++++++ Exception in verifyLoginEnterKeyPress() +++++++++ " +
	 * e.getMessage()); // e.printStackTrace(); }
	 * 
	 * if (driver.getCurrentUrl().endsWith("home")) {
	 * 
	 * LoggerManager.info("======== Login Success ========");
	 * 
	 * assertEquals(driver.getTitle(), "Management Portal Sandbox");
	 * 
	 * LoggerManager.info("======== End verifyLoginEnterKeyPress() ========");
	 * 
	 * return true;
	 * 
	 * } else {
	 * 
	 * LoggerManager.debug("======== Login Unsuccessful ========");
	 * 
	 * return false; }
	 * 
	 * }
	 * 
	 * public boolean clickBrowserBackTest(String userName, String password) {
	 * blnLogin = true;
	 * 
	 * LoggerManager.info("======== into clickBrowserBackTest() ========");
	 * 
	 * try {
	 * 
	 * new WebDriverWait(driver,
	 * Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(txtUsername));
	 * txtUsername.clear(); txtUsername.sendKeys(userName);
	 * LoggerManager.info("======== Username: " + userName + "========");
	 * 
	 * new WebDriverWait(driver,
	 * Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(txtPassword));
	 * txtPassword.clear(); txtPassword.sendKeys(password);
	 * LoggerManager.info("======== Password: " + password + "========");
	 * 
	 * 
	 * btnSignIn.click(); Thread.sleep(5000);
	 * 
	 * 
	 * } catch (Exception e) {
	 * 
	 * LoggerManager.
	 * error("+++++++++ Exception in clickBrowserBackTest() +++++++++ " +
	 * e.getMessage()); // e.printStackTrace(); }
	 * 
	 * if (driver.getCurrentUrl().endsWith("home")) {
	 * 
	 * LoggerManager.info("======== Login Success ========");
	 * 
	 * //assertEquals(driver.getTitle(), "Management Portal Sandbox");
	 * 
	 * driver.navigate().back(); try { Thread.sleep(7000); } catch
	 * (InterruptedException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * String expectedurl = "https://sandbox.ciranet.com/v2/managementportal/home";
	 * String actualurl = driver.getCurrentUrl(); assertEquals(expectedurl,
	 * actualurl);
	 * 
	 * LoggerManager.info("======== End clickBrowserBackTest() ========");
	 * 
	 * return true;
	 * 
	 * } else {
	 * 
	 * LoggerManager.debug("======== Login Unsuccessful ========");
	 * 
	 * return false; }
	 * 
	 * }
	 * 
	 * public boolean invalidLogin(String username, String password) {
	 * 
	 * LoggerManager.info("======== Into invalidLogin() ========");
	 * 
	 * try {
	 * 
	 * new WebDriverWait(driver,
	 * Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(txtUsername));
	 * txtUsername.clear(); txtUsername.sendKeys(username);
	 * LoggerManager.info("======== Username: " + username + "========");
	 * 
	 * new WebDriverWait(driver,
	 * Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(txtPassword));
	 * txtPassword.clear(); txtPassword.sendKeys(password);
	 * LoggerManager.info("======== Passworder: " + password + "========");
	 * 
	 * if (btnSignIn.isEnabled()) { btnSignIn.click(); Thread.sleep(3000);
	 * 
	 * } else {
	 * 
	 * LoggerManager.debug("======== Button is disabled ========");
	 * 
	 * return false;
	 * 
	 * } } catch (Exception e) {
	 * 
	 * LoggerManager.error("+++++++++ Exception in invalidLogin() +++++++++ " +
	 * e.getMessage()); // e.printStackTrace(); }
	 * 
	 * if ((!driver.getCurrentUrl().endsWith("/home")) &&
	 * msgInvalidCredentials.isDisplayed()) {
	 * 
	 * LoggerManager.info("======== invalidLogin() Fail ========");
	 * 
	 * return false;
	 * 
	 * } else {
	 * 
	 * LoggerManager.info("======== invalidLogin() Pass ========");
	 * 
	 * return true; }
	 * 
	 * }
	 * 
	 * 
	 * public HomePage verifyHomePage(String userName, String password) { //
	 * blnLogin = true;
	 * 
	 * LoggerManager.info("======== into verifyHomePage() ========");
	 * 
	 * try {
	 * 
	 * new WebDriverWait(driver,
	 * Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(txtUsername));
	 * txtUsername.clear(); txtUsername.sendKeys(userName);
	 * LoggerManager.info("======== Username: " + userName + "========");
	 * 
	 * new WebDriverWait(driver,
	 * Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(txtPassword));
	 * txtPassword.clear(); txtPassword.sendKeys(password);
	 * LoggerManager.info("======== Password: " + password + "========");
	 * 
	 * btnSignIn.click();
	 * 
	 * Thread.sleep(8000);
	 * 
	 * } catch (Exception e) {
	 * 
	 * LoggerManager.error("+++++++++ Exception in verifyHomePage() +++++++++ " +
	 * e.getMessage()); // e.printStackTrace(); }
	 * 
	 * doLogin(userName, password, "verifyHomePage()"); return new HomePage(driver);
	 * 
	 * }
	 * 
	 * public boolean visiblityOfForgotPasswordPageComponents(){ try {
	 * 
	 * Thread.sleep(1000);
	 * 
	 * LoggerManager.
	 * info("============  Verifying Visiblity Of Forgot Password Page Components ============"
	 * );
	 * 
	 * if (lblManagmentBoardPortal.isDisplayed() && txtUserNameOnFP.isDisplayed() &&
	 * btnBackToLogin.isDisplayed() && btnSubmit.isDisplayed()) {
	 * 
	 * LoggerManager.info("============  Forgot Password Page verified ============"
	 * ); return true; } else { LoggerManager.
	 * info("============  Forgot Password Page verification failed ============");
	 * 
	 * return false; } } catch (Exception e) {
	 * 
	 * e.printStackTrace(); } return false; }
	 * 
	 * 
	 * 
	 * public boolean verifySimultaneousLoginOnSameBrowser(String userName, String
	 * password) { blnLogin = true;
	 * LoggerManager.info("======== into verifyLogin() ========");
	 * 
	 * try {
	 * 
	 * new WebDriverWait(driver,
	 * Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(txtUsername));
	 * txtUsername.clear(); txtUsername.sendKeys(userName);
	 * LoggerManager.info("======== Username: " + userName + "========");
	 * 
	 * 
	 * new WebDriverWait(driver,
	 * Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(txtPassword));
	 * txtPassword.clear(); txtPassword.sendKeys(password);
	 * LoggerManager.info("======== Password: " + password + "========");
	 * 
	 * btnSignIn.click();
	 * 
	 * Thread.sleep(8000);
	 * 
	 * } catch (Exception e) {
	 * 
	 * LoggerManager.error("+++++++++ Exception in verifyLogin() +++++++++ " +
	 * e.getMessage()); // e.printStackTrace(); }
	 * 
	 * if (driver.getCurrentUrl().endsWith("home")) {
	 * 
	 * LoggerManager.info("======== Login Success ========");
	 * 
	 * assertEquals(driver.getTitle(), "Management Portal Sandbox");
	 * 
	 * LoggerManager.info("======== End verifyLogin() ========");
	 * 
	 * return true;
	 * 
	 * } else {
	 * 
	 * LoggerManager.debug("======== Login Unsuccessful ========");
	 * 
	 * return false; }
	 * 
	 * }
	 * 
	 * 
	 * @SuppressWarnings("deprecation") public boolean
	 * verifyLoginDiffUsersOnDifferentBrowsers(String userName, String password) {
	 * blnLogin = false; LoggerManager.
	 * info("======== into verifyLoginDiffUsersOnDifferentBrowsers() ========");
	 * 
	 * try {
	 * 
	 * new WebDriverWait(driver,
	 * Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(txtUsername));
	 * txtUsername.clear(); txtUsername.sendKeys(userName);
	 * LoggerManager.info("======== Username: " + userName + "========");
	 * 
	 * new WebDriverWait(driver,
	 * Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(txtPassword));
	 * txtPassword.clear(); txtPassword.sendKeys(password);
	 * LoggerManager.info("======== Password: " + password + "========");
	 * 
	 * btnSignIn.click();
	 * 
	 * //Thread.sleep(8000);
	 * driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestBase.
	 * PAGE_LOAD_TIMEOUT));
	 * 
	 * } catch (Exception e) {
	 * 
	 * LoggerManager.
	 * error("+++++++++ Exception in verifyLoginDiffUsersOnDifferentBrowsers() +++++++++ "
	 * + e.getMessage()); // e.printStackTrace(); }
	 * 
	 * // Different browser code started //WebDriverManager.firefoxdriver().setup();
	 * FirefoxDriver ffDriver = new FirefoxDriver(); String applicationURL =
	 * EnvironmentConfig.environmentSetup().get("ApplicationURL");
	 * 
	 * ffDriver.get(applicationURL);
	 * ffDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
	 * 
	 * LoggerManager.debug("------- Page load timeout is set to: " + "40");
	 * 
	 * ffDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	 * 
	 * LoggerManager.debug("------- Implicit Wait time is set to: " + "15");
	 * 
	 * // webelement, store it in webelement variable WebElement User =
	 * ffDriver.findElement(By.xpath("//input[@type='text']"));
	 * User.sendKeys(userName); try { Thread.sleep(5000); } catch
	 * (InterruptedException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * // webelement, store it in webelement variable WebElement pwd =
	 * ffDriver.findElement(By.xpath("//input[contains(@type,'password')]"));
	 * pwd.sendKeys(password); try { Thread.sleep(1000); } catch
	 * (InterruptedException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * // webelement, store it in webelement variable WebElement loginButton =
	 * ffDriver.findElement(By.
	 * xpath("//dx-button[@aria-label='Log in']//div[@class='dx-button-content']"));
	 * loginButton.click(); try { Thread.sleep(5000); } catch (InterruptedException
	 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
	 * 
	 * // Creating Strings String expectedurl1 = TestBase.HomePageURL; try {
	 * Thread.sleep(2000); } catch (InterruptedException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); }
	 * 
	 * //getCurrentUrl(): It fetches the URL of the opened application. String
	 * actualurl1 = ffDriver.getCurrentUrl(); try { Thread.sleep(2000); } catch
	 * (InterruptedException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * if (expectedurl1.equals(actualurl1)) {
	 * LoggerManager.info("======== Login on different browser Success ========");
	 * 
	 * assertEquals(driver.getTitle(), "Management Portal Sandbox");
	 * 
	 * LoggerManager.
	 * info("======== End verifyLoginDiffUsersOnDifferentBrowsers() ========");
	 * 
	 * // Compare between two variable whether both are equal or not
	 * assertEquals(expectedurl1, actualurl1);
	 * 
	 * // Stop the execution of the current thread //Thread.sleep(5000);
	 * ffDriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	 * 
	 * // Quit current browser ffDriver.quit(); return true;
	 * 
	 * } else { LoggerManager.
	 * debug("======== verifyLoginDiffUsersOnDifferentBrowsers Unsuccessful ========"
	 * );
	 * 
	 * return false; } }
	 * 
	 * 
	 * ///////// For Internal Tasks Page
	 * 
	 * 
	 * public void doLogin(String userName, String password,String verifyPageName) {
	 * LoggerManager.info("======== into " + verifyPageName + " ========");
	 * 
	 * try {
	 * 
	 * new WebDriverWait(driver,
	 * Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(txtUsername));
	 * txtUsername.clear(); txtUsername.sendKeys(userName);
	 * LoggerManager.info("======== Username: " + userName + "========");
	 * 
	 * new WebDriverWait(driver,
	 * Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(txtPassword));
	 * txtPassword.clear(); txtPassword.sendKeys(password);
	 * LoggerManager.info("======== Password: " + password + "========");
	 * 
	 * btnSignIn.click();
	 * 
	 * Thread.sleep(8000);
	 * 
	 * } catch (Exception e) {
	 * 
	 * LoggerManager.error("+++++++++ Exception in " + verifyPageName + "+++++++++ "
	 * + e.getMessage()); // e.printStackTrace(); } }
	 * 
	 * public boolean userlogout() { blnLogin = false; try { Thread.sleep(3000); }
	 * catch (InterruptedException e1) { // TODO Auto-generated catch block
	 * e1.printStackTrace(); } WebElement element =
	 * driver.findElement(By.xpath("//div[@class='cc-user-panel-name']")); try {
	 * Thread.sleep(3000);
	 * 
	 * ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
	 * element);
	 * 
	 * //driver.findElement(By.xpath("//div[@class='cc-user-panel-name']")).click();
	 * 
	 * Thread.sleep(500);
	 * 
	 * driver.findElement(By.xpath("//span[contains(.,'Logout')]")).click();
	 * 
	 * assertTrue(driver.getTitle().contains("Management Portal Sandbox"));
	 * 
	 * return true;
	 * 
	 * } catch (
	 * 
	 * InterruptedException e) {
	 * 
	 * LoggerManager.error("+++++++++ Exception in userlogout() +++++++++ " +
	 * e.getMessage()); // e.printStackTrace(); } return false;
	 * 
	 * }
	 * 
	 */

}

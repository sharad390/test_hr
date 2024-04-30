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

public class LoginPageTest extends TestBase {

	@Test(priority = 0, description = "Verify LoginPage UI", groups = { "Regression" })
	public void verifyLoginPageTitle() {

		LoggerManager.info("Verifying LoginPage Title");

		TestBase.test = TestBase.extent.createTest("Login Page Test");
		//TestBase.test.assignCategory("Smoke Test");
		TestBase.test.assignCategory("Regression Test");
		TestBase.test = TestBase.test.createNode("Verify Login Page Title");

		TestBase.test.log(Status.INFO, "Verifying LoginPage Title");

		//assertTrue(driver.getTitle().contains("Management Portal Sandbox"));
		
		
	}

	
	  @Test(priority = 1, description = "Verify LoginPage Components", groups = {
	  "Smoke" }) public void verifyLoginPageComponents() {
	  
	  LoggerManager.info("Verifying LoginPage Components");
	  
	  TestBase.test = TestBase.extent.createTest("Login Page Components Test");
	  TestBase.test.assignCategory("Smoke Test"); TestBase.test =
	  TestBase.test.createNode("Verify Login Page Components");
	  
	  TestBase.test.log(Status.INFO, "Verifying LoginPage Components");
	  
	  assertTrue(loginPage.verifyLogin("00001","Byte@123"), "Fail to load login components");
	  
	  }
		/*
		 * 
		 * @Test(priority = 2, description = "Verify valid login functionality", groups
		 * = { "Functional" }) public void verifyValidLogin() throws Exception {
		 * 
		 * LoggerManager.info("----- Verify Valid Login Start -----");
		 * 
		 * String username = EnvironmentConfig.environmentSetup().get("USERNAME");
		 * String password = EnvironmentConfig.environmentSetup().get("PASSWORD");
		 * 
		 * LoggerManager.info("Verifying LoginPage Title");
		 * 
		 * LoggerManager.info("Username: " + username + " Password: " + password);
		 * 
		 * TestBase.test = TestBase.extent.createTest("Verify Valid Login");
		 * TestBase.test.assignCategory("Funtional Test");
		 * 
		 * TestBase.test.log(Status.INFO, "Username : " + username);
		 * TestBase.test.log(Status.INFO, "Password : " + password);
		 * 
		 * assertTrue(loginPage.verifyLogin(username, password),
		 * "Login functionality failed with valid credentials");
		 * 
		 * LoggerManager.info("----- Verify Valid Login End -----"); Thread.sleep(1000);
		 * loginPage.userlogout();
		 * 
		 * }
		 * 
		 * @Test(priority = 3, description =
		 * "Verify valid login functionality after Enter key Press", groups = {
		 * "Functional" }) public void verifyValidLoginEnterKeyPress() throws Exception
		 * {
		 * 
		 * LoggerManager.
		 * info("----- Verify Valid Login Start  after Enter Key Press -----");
		 * 
		 * String username = EnvironmentConfig.environmentSetup().get("USERNAME");
		 * String password = EnvironmentConfig.environmentSetup().get("PASSWORD");
		 * 
		 * LoggerManager.info("Verifying LoginPage After Enter Key Press");
		 * 
		 * LoggerManager.info("Username: " + username + " Password: " + password);
		 * 
		 * TestBase.test =
		 * TestBase.extent.createTest("Verify Valid Login after Enter Key Press");
		 * TestBase.test.assignCategory("Funtional Test");
		 * 
		 * TestBase.test.log(Status.INFO, "Username : " + username);
		 * TestBase.test.log(Status.INFO, "Password : " + password);
		 * 
		 * assertTrue(loginPage.verifyLoginWithEnterKeyPress(username, password),
		 * "Login functionality failed with valid credentials");
		 * 
		 * LoggerManager.info("----- Verify Valid Login with Enter Key Press End -----"
		 * );
		 * 
		 * Thread.sleep(1000); loginPage.userlogout(); }
		 * 
		 * @Test(priority = 4, description =
		 * "Verify Browser back functionality after Login", groups = { "Functional" })
		 * public void clickBrowserBackTest() throws Exception {
		 * 
		 * LoggerManager.info("----- Verify Browser Back after user logs in -----");
		 * 
		 * String username = EnvironmentConfig.environmentSetup().get("USERNAME");
		 * String password = EnvironmentConfig.environmentSetup().get("PASSWORD");
		 * 
		 * LoggerManager.info("Verifying Homepage after Browser back");
		 * 
		 * LoggerManager.info("Username: " + username + " Password: " + password);
		 * 
		 * TestBase.test = TestBase.extent.createTest("Verify Valid Login");
		 * TestBase.test.assignCategory("Funtional Test");
		 * 
		 * TestBase.test.log(Status.INFO, "Username : " + username);
		 * TestBase.test.log(Status.INFO, "Password : " + password);
		 * 
		 * assertTrue(loginPage.clickBrowserBackTest(username, password),
		 * "Login functionality failed with valid credentials");
		 * 
		 * LoggerManager.info("----- Verify Browser Back after user logs in End -----");
		 * Thread.sleep(5000); loginPage.userlogout(); }
		 * 
		 * @Test(priority = 5, description =
		 * "Verify Invalid Username Valid Password on Login", groups = { "Functional" })
		 * public void InvalidUserValidPassword() throws Exception { Thread.sleep(1000);
		 * LoggerManager.info("----- Verify Invalid Username Valid Password -----");
		 * 
		 * String username = "abh.ranade" ;//
		 * EnvironmentConfig.environmentSetup().get("INUSERNAME"); String password =
		 * "YELLO#12" ;//EnvironmentConfig.environmentSetup().get("PASSWORD");
		 * 
		 * LoggerManager.info("Verifying Invalid Username Valid Password on Login");
		 * 
		 * LoggerManager.info("Username: " + username + " Password: " + password);
		 * 
		 * TestBase.test =
		 * TestBase.extent.createTest("Verify Login for Invalid UserName Valid Password"
		 * ); TestBase.test.assignCategory("Funtional Test");
		 * 
		 * TestBase.test.log(Status.INFO, "Username : " + username);
		 * TestBase.test.log(Status.INFO, "Password : " + password);
		 * 
		 * loginPage.txtUsername.clear(); loginPage.txtPassword.clear();
		 * 
		 * loginPage.txtUsername.sendKeys(username);
		 * loginPage.txtPassword.sendKeys(password); Thread.sleep(1000);
		 * loginPage.btnSignIn.click();
		 * 
		 * String expectedurl1 = "https://sandbox.ciranet.com/v2/managementportal/home";
		 * 
		 * //getCurrentUrl(): It fetches the URL of the opened application. String
		 * actualurl1 = driver.getCurrentUrl();
		 * 
		 * // Compare between two variable whether both are equal or not
		 * assertNotEquals(expectedurl1, actualurl1);
		 * 
		 * 
		 * //new WebDriverWait(driver,
		 * Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOf(loginPage.
		 * msgInvalidCredentials));
		 * //assertTrue(loginPage.msgInvalidCredentials.isDisplayed());
		 * 
		 * LoggerManager.
		 * info("----- Verify Invalid Username Valid Password on Login End -----");
		 * Thread.sleep(1000);
		 * 
		 * }
		 * 
		 * @Test(priority = 6, description =
		 * "Verify valid Username Invalid Password on Login", groups = { "Functional" })
		 * public void validUserInvalidPassword() throws Exception { Thread.sleep(1000);
		 * LoggerManager.info("----- Verify valid Username Invalid Password -----");
		 * 
		 * String username = "abhayranade" ;//
		 * EnvironmentConfig.environmentSetup().get("INUSERNAME"); String password =
		 * "WHITE#12" ;//EnvironmentConfig.environmentSetup().get("PASSWORD");
		 * 
		 * LoggerManager.info("Verifying valid Username Invalid Password on Login");
		 * 
		 * LoggerManager.info("Username: " + username + " Password: " + password);
		 * 
		 * TestBase.test =
		 * TestBase.extent.createTest("Verify Login for valid Username Invalid Password"
		 * ); TestBase.test.assignCategory("Funtional Test");
		 * 
		 * TestBase.test.log(Status.INFO, "Username : " + username);
		 * TestBase.test.log(Status.INFO, "Password : " + password);
		 * 
		 * loginPage.txtUsername.clear(); loginPage.txtPassword.clear();
		 * 
		 * loginPage.txtUsername.sendKeys(username);
		 * loginPage.txtPassword.sendKeys(password);
		 * 
		 * 
		 * loginPage.btnSignIn.click();
		 * 
		 * String expectedurl1 = "https://sandbox.ciranet.com/v2/managementportal/home";
		 * 
		 * //getCurrentUrl(): It fetches the URL of the opened application. String
		 * actualurl1 = driver.getCurrentUrl();
		 * 
		 * // Compare between two variable whether both are equal or not
		 * assertNotEquals(expectedurl1, actualurl1);
		 * 
		 * LoggerManager.
		 * info("----- Verify valid Username Invalid Password on Login End -----");
		 * 
		 * }
		 * 
		 * @Test(priority = 7, description =
		 * "Verify Invalid Username Invalid Password on Login", groups = { "Functional"
		 * }) public void InvalidUserInvalidPassword() throws Exception {
		 * Thread.sleep(1000);
		 * LoggerManager.info("----- Verify Invalid Username Invalid Password -----");
		 * 
		 * String username = "abh.ranade1" ;//
		 * EnvironmentConfig.environmentSetup().get("INUSERNAME"); String password =
		 * "WHITE#12" ;//EnvironmentConfig.environmentSetup().get("PASSWORD");
		 * 
		 * LoggerManager.info("Verifying Invalid Username Invalid Password on Login");
		 * 
		 * LoggerManager.info("Username: " + username + " Password: " + password);
		 * 
		 * TestBase.test = TestBase.extent.
		 * createTest("Verify Login for Invalid Username Invalid Password");
		 * TestBase.test.assignCategory("Funtional Test");
		 * 
		 * TestBase.test.log(Status.INFO, "Username : " + username);
		 * TestBase.test.log(Status.INFO, "Password : " + password);
		 * 
		 * loginPage.txtUsername.clear(); loginPage.txtPassword.clear();
		 * loginPage.txtUsername.sendKeys(username);
		 * loginPage.txtPassword.sendKeys(password);
		 * 
		 * loginPage.btnSignIn.click();
		 * 
		 * String expectedurl1 = "https://sandbox.ciranet.com/v2/managementportal/home";
		 * 
		 * //getCurrentUrl(): It fetches the URL of the opened application. String
		 * actualurl1 = driver.getCurrentUrl();
		 * 
		 * // Compare between two variable whether both are equal or not
		 * assertNotEquals(expectedurl1, actualurl1); LoggerManager.
		 * info("----- Verify Invalid Username Invalid Password on Login End -----");
		 * 
		 * Thread.sleep(2000); }
		 * 
		 * @Test(priority = 8, description =
		 * "Verify Show Password functionality on Login", groups = { "Functional" })
		 * public void showPasswordFunctionality() throws Exception {
		 * Thread.sleep(1000);
		 * LoggerManager.info("----- Verify Show Password functionality -----");
		 * 
		 * String username = "" ;//
		 * EnvironmentConfig.environmentSetup().get("INUSERNAME"); String password =
		 * "WHITE#12" ;//EnvironmentConfig.environmentSetup().get("PASSWORD");
		 * 
		 * LoggerManager.info("Verifying Show Password functionality on Login");
		 * 
		 * LoggerManager.info("Username: " + username + " Password: " + password);
		 * 
		 * TestBase.test =
		 * TestBase.extent.createTest("Verify Show Password functionality");
		 * TestBase.test.assignCategory("Funtional Test");
		 * 
		 * TestBase.test.log(Status.INFO, "Username : " + username);
		 * TestBase.test.log(Status.INFO, "Password : " + password);
		 * 
		 * loginPage.txtUsername.clear(); loginPage.txtPassword.clear();
		 * loginPage.txtUsername.sendKeys(username);
		 * loginPage.txtPassword.sendKeys(password);
		 * 
		 * //WebElement showIcon =
		 * driver.findElement(By.xpath("//i[contains(@class,'dx-icon fas fa-eye')]"));
		 * loginPage.showEyeIconPassword.click(); Thread.sleep(3000);
		 * 
		 * //assertTrue(loginPage.txtPassword.ge)); boolean passwordDisplayed=
		 * driver.findElement(By.xpath("(//input[@role='textbox'])[2]")).isDisplayed();
		 * assertTrue(passwordDisplayed);
		 * 
		 * loginPage.hideEyeIconPassword.click();
		 * 
		 * LoggerManager.info("----- Verify Show Password on Login End -----");
		 * 
		 * Thread.sleep(2000); }
		 * 
		 * 
		 * @Test(priority = 9, description =
		 * "Verify Empty Username Empty Password on Login", groups = { "Functional" })
		 * public void emptyUserEmptyPassword() throws Exception { Thread.sleep(1000);
		 * LoggerManager.
		 * info("----- Verify Empty Username Empty Password on Login -----");
		 * 
		 * String username = "" ;//
		 * EnvironmentConfig.environmentSetup().get("INUSERNAME"); String password = ""
		 * ;//EnvironmentConfig.environmentSetup().get("PASSWORD");
		 * 
		 * LoggerManager.info("Verify Empty Username Empty Password on Login");
		 * 
		 * LoggerManager.info("Username: " + username + " Password: " + password);
		 * 
		 * TestBase.test = TestBase.extent.
		 * createTest("Verify Login for Invalid Username Invalid Password");
		 * TestBase.test.assignCategory("Funtional Test");
		 * 
		 * TestBase.test.log(Status.INFO, "Username : " + username);
		 * TestBase.test.log(Status.INFO, "Password : " + password);
		 * 
		 * loginPage.txtUsername.clear(); loginPage.txtPassword.clear();
		 * loginPage.txtUsername.sendKeys(username);
		 * loginPage.txtPassword.sendKeys(password);
		 * 
		 * loginPage.btnSignIn.click(); Thread.sleep(2000);
		 * 
		 * String expectedurl1 = "https://sandbox.ciranet.com/v2/managementportal/home";
		 * 
		 * //getCurrentUrl(): It fetches the URL of the opened application. String
		 * actualurl1 = driver.getCurrentUrl();
		 * 
		 * // Compare between two variable whether both are equal or not
		 * assertNotEquals(expectedurl1, actualurl1); LoggerManager.
		 * info("----- Verify Invalid Username Invalid Password on Login End -----");
		 * 
		 * Thread.sleep(2000); }
		 * 
		 * @Test(priority = 10, description =
		 * "Verify Choose Different Portal Link Click", groups = { "Functional" })
		 * public void VerifyChooseDifferentPortal() throws Exception {
		 * 
		 * LoggerManager.info("Verifying Choose Different Portal Link Click");
		 * 
		 * TestBase.test =
		 * TestBase.extent.createTest("Verify Choose Different Portal Link Click Test");
		 * TestBase.test.assignCategory("Functional"); TestBase.test =
		 * TestBase.test.createNode("Verify Choose Different Portal Link Click");
		 * 
		 * loginPage.linkChooseDiffPortal.click();
		 * 
		 * Thread.sleep(3000); String expectedURL =
		 * "https://sandbox.ciranet.com/v2/portalselection";
		 * 
		 * //getCurrentUrl(): It fetches the URL of the opened application. String
		 * actualURL = driver.getCurrentUrl();
		 * 
		 * // Compare between two variable whether both are equal or not
		 * assertEquals(expectedURL, actualURL);
		 * 
		 * driver.navigate().back(); Thread.sleep(3000); TestBase.test.log(Status.INFO,
		 * "Verifying Choose Different Portal Link Click End");
		 * 
		 * 
		 * 
		 * 
		 * }
		 * 
		 * 
		 * @Test(priority = 11, description = "Verify Forgot Password Button Click",
		 * groups = { "Functional" }) public void VerifyForgotPasswordButtonClick()
		 * throws Exception { Thread.sleep(1000);
		 * LoggerManager.info("----- Verify Forgot Password Password Button Click -----"
		 * ); loginPage.btnforgotPassword.click();
		 * 
		 * Thread.sleep(2000); String expectedURL =
		 * "https://sandbox.ciranet.com/v2/managementportal/user/forgotpassword";
		 * 
		 * //getCurrentUrl(): It fetches the URL of the opened application. String
		 * actualURL = driver.getCurrentUrl();
		 * 
		 * // Compare between two variable whether both are equal or not
		 * assertEquals(expectedURL, actualURL);
		 * 
		 * Thread.sleep(1000); loginPage.btnBackToLogin.click(); Thread.sleep(2000);
		 * 
		 * LoggerManager.
		 * info("----- Verify Forgot Password Password Button Click on Login End -----"
		 * );
		 * 
		 * }
		 * 
		 * @Test(priority = 12, description = "Forgot Password Page Components", groups
		 * = { "Smoke" }) public void VerifyForgotPasswordPageComponents() throws
		 * Exception {
		 * 
		 * LoggerManager.info("Verifying Forgot Password Page Components");
		 * 
		 * loginPage.btnforgotPassword.click(); Thread.sleep(2000); TestBase.test =
		 * TestBase.extent.createTest("Forgot Password Page Components Test");
		 * TestBase.test.assignCategory("Smoke Test"); TestBase.test =
		 * TestBase.test.createNode("Verify Forgot Password Page Components");
		 * 
		 * TestBase.test.log(Status.INFO, "Verifying Forgot Password Page Components");
		 * 
		 * assertTrue(loginPage.visiblityOfForgotPasswordPageComponents(),
		 * "Fail to load Forgot Password Page components");
		 * loginPage.btnBackToLogin.click(); Thread.sleep(2000); }
		 * 
		 * @SuppressWarnings("deprecation")
		 * 
		 * @Test(priority = 13, description = "Simultaneous Login On Same Browser",
		 * groups = { "Smoke" }) public void verifySimultaneousLoginOnSameBrowser()
		 * throws Exception {
		 * 
		 * //Creating Strings // Configuration implementation that reads the platform
		 * specific environment variables String username =
		 * EnvironmentConfig.environmentSetup().get("USERNAME"); String password =
		 * EnvironmentConfig.environmentSetup().get("PASSWORD");
		 * 
		 * System.out.println(username); System.out.println(password);
		 * 
		 * // used to forward logs to all the registered output Handler objects. //INFO
		 * message: Info is for the use of administrators or advanced users
		 * LoggerManager.info("Verifying LoginPage Title");
		 * 
		 * LoggerManager.info("Username: " + username + " Password: " + password);
		 * 
		 * //To Generate Extent Reports in Selenium TestBase.test =
		 * TestBase.extent.createTest("Simultaneous Login On Same Browser");
		 * 
		 * //Extent Reporting Framework is widely adopted and used in many test
		 * frameworks TestBase.test.assignCategory("Funtional Test");
		 * 
		 * //Java-based logging utility TestBase.test.log(Status.INFO, "Username : " +
		 * username); TestBase.test.log(Status.INFO, "Password : " + password);
		 * 
		 * // assert that a condition is true, you still have to code such condition for
		 * it to be evaluated at runtime assertTrue(loginPage.verifyLogin(username,
		 * password), "Login functionality failed with valid credentials");
		 * 
		 * // Manages a hierarchical namespace of Logger objects. All named Loggers are
		 * stored in this namespace
		 * LoggerManager.info("----- Verify Simultaneous Login On Same Browser -----");
		 * //Thread.sleep(5000);
		 * 
		 * //set the amount of time to wait for a page load to complete before throwing
		 * an error driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		 * 
		 * // Opens a new window and switches to new window
		 * driver.switchTo().newWindow(WindowType.TAB);
		 * 
		 * // Opens LambdaTest homepage in the newly opened tab
		 * driver.navigate().to(TestBase.applicationURL);
		 * 
		 * // Creating Strings String expectedurl1 = TestBase.HomePageURL;
		 * 
		 * //getCurrentUrl(): It fetches the URL of the opened application. String
		 * actualurl1 = driver.getCurrentUrl();
		 * 
		 * // Prints the argument passed to it System.out.print("actualurl1  " +
		 * actualurl1);
		 * 
		 * // Compare between two variable whether both are equal or not
		 * assertEquals(expectedurl1, actualurl1);
		 * 
		 * // Stop the execution of the current thread //Thread.sleep(5000);
		 * driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		 * 
		 * loginPage.userlogout();
		 * 
		 * // Stop the execution of the current thread //Thread.sleep(2000);
		 * driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		 * 
		 * }
		 * 
		 * 
		 * 
		 * @SuppressWarnings("deprecation")
		 * 
		 * @Test(priority = 14, description =
		 * "Verify user is able to login on different browsers with different credentials"
		 * , groups = { "Functional" }) public void
		 * verifyLoginDiffUsersOnDifferentBrowsers() throws Exception {
		 * 
		 * LoggerManager.
		 * info("----- Verify user is able to login on different browsers with different credentials -----"
		 * );
		 * 
		 * String username = EnvironmentConfig.environmentSetup().get("USERNAME");
		 * String password = EnvironmentConfig.environmentSetup().get("PASSWORD");
		 * 
		 * LoggerManager.
		 * info("Verify user is able to login on different browsers with different credentials"
		 * );
		 * 
		 * LoggerManager.info("Username: " + username + " Password: " + password);
		 * 
		 * TestBase.test = TestBase.extent.createTest("Verify Valid Login");
		 * TestBase.test.assignCategory("Funtional Test");
		 * 
		 * TestBase.test.log(Status.INFO, "Username : " + username);
		 * TestBase.test.log(Status.INFO, "Password : " + password);
		 * 
		 * assertTrue(loginPage.verifyLoginDiffUsersOnDifferentBrowsers(username,
		 * password),
		 * "Login functionality failed with different credentials different browser");
		 * driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		 * 
		 * LoggerManager.
		 * info("----- Verify verifyLoginDiffUsersOnDifferentBrowsers End -----");
		 * //Thread.sleep(1000); //loginPage.userlogout();
		 * 
		 * }
		 * 
		 * 
		 */	 }

package hrms.testbase;

import java.awt.AWTException;
import java.io.File;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import hrms.pages.DashboardPage;
import hrms.pages.HomePage;
import hrms.pages.LoginPage;
import hrms.pages.LogoutPage;
import hrms.pages.ProfilePage;
import hrms.pages.UploadExcelPage;
import hrms.utilities.CommonUtilities;
import hrms.utilities.EnvironmentConfig;
import hrms.utilities.LoggerManager;
//import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class TestBase 
{

	public static WebDriver driver;

	public static ExtentHtmlReporter htmlReporter;

	public static ExtentReports extent;

	public static ExtentTest test; // helps to generate the logs in the test report.

	String browserName = EnvironmentConfig.environmentSetup().get("BrowserType");

	public static String applicationURL = EnvironmentConfig.environmentSetup().get("ApplicationURL");

	public static String HomePageURL = EnvironmentConfig.environmentSetup().get("HomePageURL");

	public static int PAGE_LOAD_TIMEOUT = Integer
			.parseInt(EnvironmentConfig.environmentSetup().get("PAGE_LOAD_TIMEOUT"));

	public static int IMPLICIT_WAIT = Integer.parseInt(EnvironmentConfig.environmentSetup().get("IMPLICIT_WAIT"));

	public static final String AUTOMATE_USERNAME = EnvironmentConfig.environmentSetup()
			.get("BROWSER_STACK_AUTOMATE_USERNAME");

	public static final String AUTOMATE_ACCESS_KEY = EnvironmentConfig.environmentSetup()
			.get("BROWSER_STACK_AUTOMATE_ACCESS_KEY");

	public LoginPage loginPage = new LoginPage(driver);

	public HomePage homePage = new HomePage(driver);

	public ProfilePage ProfilePage = new ProfilePage(driver);

	public DashboardPage dashboardPage = new DashboardPage(driver);

	public UploadExcelPage uploadexcelPage = new UploadExcelPage(driver);

	public LogoutPage logoutPage = new LogoutPage(driver);


	public static String rept_loc;

	DesiredCapabilities dc = new DesiredCapabilities();

	// Initializing pages here
	@BeforeMethod(alwaysRun = true)
	public void pageSetup() throws AWTException 
	{

		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);

		ProfilePage = new ProfilePage(driver);
		dashboardPage = new DashboardPage(driver);

		uploadexcelPage = new UploadExcelPage(driver);

		logoutPage = new LogoutPage(driver);
	}

	@BeforeSuite(alwaysRun=true)
	public WebDriver setup() throws MalformedURLException, UnknownHostException {

		//htmlReporter = new ExtentHtmlReporter(EnvironmentConfig.environmentSetup().get("REPORT_LOCATION")	+ "AutomationExtentReport_" + CommonUtilities.getCurrentDateTime() + ".html");

		//htmlReporter = new ExtentHtmlReporter(EnvironmentConfig.environmentSetup().get("REPORT_LOCATION") 
		//		+ "AutomationExtentReport_" + CommonUtilities.getCurrentDateTime() + ".html");

		htmlReporter = new ExtentHtmlReporter(EnvironmentConfig.environmentSetup().get("REPORT_LOCATION")
				+ "AutomationExtentReport_" + CommonUtilities.getCurrentDateTime() + ".html");

		extent = new ExtentReports();

		extent.attachReporter(htmlReporter);

		extent.setSystemInfo("HostName : ", InetAddress.getLocalHost().getHostName());

		extent.setSystemInfo("ProjectName : ", "HRMS Test Automation");

		extent.setSystemInfo("Test Environment: ", System.getProperty("env").toUpperCase());

		extent.setSystemInfo("Operating System : ", System.getProperty("os.name"));

		extent.setSystemInfo("QA Name : ", System.getProperty("user.name"));

		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setDocumentTitle("HRMS Test Automation Report");
		htmlReporter.config().setReportName("HRMS Automation Test Execution Report ");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setChartVisibilityOnOpen(true);


		String str = ""; 
		str = EnvironmentConfig.environmentSetup().get("REPORT_LOCATION");

		str = str.substring(1, str.length()); // EnvironmentConfig.environmentSetup().get("REPORT_LOCATION");

		/*
		 * rept_loc = System.getProperty("user.dir") +
		 * EnvironmentConfig.environmentSetup().get("REPORT_LOCATION") +
		 * "AutomationExtentReport_" + CommonUtilities.getCurrentDateTime() + ".html";
		 */

		str = str.replaceAll("\\/", "//");

		////System.out.println("STR is changd to " + str);


		rept_loc = System.getProperty("user.dir") + str + 
				"AutomationExtentReport_" + CommonUtilities.getCurrentDateTime() + ".html";


		//rept_loc = System.getProperty("user.dir") + str + "AutomationExtentReport_" +
		//CommonUtilities.getCurrentDateTime() + ".html";



		////System.out.println("From TEST BASE ==> " + rept_loc);

		rept_loc=rept_loc.replaceAll("\\//", "\\\\");

		rept_loc=rept_loc.replaceAll("\\\\", "\\\\\\\\");

		//System.out.println("Changed rept_loc is ..... >>>>> " + rept_loc);

		if (browserName.equalsIgnoreCase("Chrome")) 
		{
			// To Load Chrome driver Instance.

			//WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();

			LoggerManager.debug("------- Chrome browser loaded -------");

			// et.log(LogStatus.INFO, "Chrome browser loaded");
		}
		else if (browserName.equalsIgnoreCase("FireFox")) {
			// To Load FireFox driver Instance.

			//WebDriverManager.firefoxdriver().setup();

			driver = new FirefoxDriver();

			LoggerManager.debug("------- FireFox browser loaded -------");

			// et.log(LogStatus.INFO, "FireFox browser loaded");
		} else if (browserName.equalsIgnoreCase("Edge")) {
			// To Load Edge driver Instance.
			//WebDriverManager.edgedriver().setup();

			driver = new EdgeDriver();

			LoggerManager.debug("------- Edge browser loaded -------");


		}
		else if (browserName.equalsIgnoreCase("Safari")) 
		{

			// To Load Safari driver Instance.

			driver = new SafariDriver();

			LoggerManager.debug("------- Safari browser loaded -------");

			// et.log(LogStatus.INFO, "Safari browser loaded");
		} else if (browserName.equalsIgnoreCase("bs_chrome")) {

			LoggerManager.debug("Browser Stack Chrome browser loaded");

			dc.setCapability("os_version", "Catalina");
			dc.setCapability("resolution", "1920x1080");
			dc.setCapability("browser", "Chrome");
			dc.setCapability("browser_version", "latest");
			dc.setCapability("os", "OS X");
			dc.setCapability("name", "BStack-[Java] Sample Test"); // test name
			// dc.setCapability("build", buildName); // CI/CD job or build name
			// dc.setCapability("browserstack.local", browserstackLocal);
			// dc.setCapability("browserstack.localIdentifier",
			// browserstackLocalIdentifier);

			// driver = new RemoteWebDriver(new URL(URL), dc);
			driver = new RemoteWebDriver(new URL(
					"https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub.browserstack.com/wd/hub"), dc);

			driver.manage().window().maximize();

		} else if (browserName.equalsIgnoreCase("bs_iphone")) {

			LoggerManager.debug("Browser Stack iPhone Safari browser loaded");

			dc.setCapability("browserName", "iPhone");
			dc.setCapability("device", "iPhone 11 Pro");
			dc.setCapability("realMobile", "true");
			dc.setCapability("os_version", "13");
			dc.setCapability("name", "BStack-[Java] Sample Test"); // test name
			dc.setCapability("build", "BStack Build Number 2"); // CI/CD job or build name
			// driver = new RemoteWebDriver(new URL(URL), dc);
			driver = new RemoteWebDriver(new URL(
					"https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub.browserstack.com/wd/hub"), dc);

		} else {

			// Default browser set to Chrome driver Instance.

			//WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();

			LoggerManager.debug("------- Chrome browser loaded as default browser -------");

			// et.log(LogStatus.INFO, "Chrome browser loaded");

		}

		if (driver != null) {

			driver.manage().deleteAllCookies();

			driver.manage().window().maximize();

			driver.get(applicationURL);

			LoggerManager.debug("------- Application URL set to: " + applicationURL);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT));

			LoggerManager.debug("------- Page load timeout is set to: " + PAGE_LOAD_TIMEOUT);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));

			LoggerManager.debug("------- Implicit Wait time is set to: " + IMPLICIT_WAIT);

		} else {

			driver.close();

			LoggerManager.debug("------- Browser closed");

			// Null browser Instance when close.

			driver = null;

			LoggerManager.debug("------- Browser set as NULL");
		}



		return driver;

	}

	//@BeforeSuite(alwaysRun=true)
	public void extentSetUp() throws UnknownHostException {

		htmlReporter = new ExtentHtmlReporter(EnvironmentConfig.environmentSetup().get("REPORT_LOCATION")
				+ "AutomationExtentReport_" + CommonUtilities.getCurrentDateTime() + ".html");

		extent = new ExtentReports();

		extent.attachReporter(htmlReporter);

		extent.setSystemInfo("HostName : ", InetAddress.getLocalHost().getHostName());

		extent.setSystemInfo("ProjectName : ", "HRMS Test Automation ");

		extent.setSystemInfo("Test Environment: ", System.getProperty("env").toUpperCase());

		extent.setSystemInfo("Operating System : ", System.getProperty("os.name"));

		extent.setSystemInfo("QA Name : ", System.getProperty("user.name"));

		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setDocumentTitle("HRMS Test Automation Report");
		htmlReporter.config().setReportName("Automation Test Execution Report ");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setChartVisibilityOnOpen(true);

	}


	/*
	 * public void userLogout() {
	 * 
	 * LoggerManager.info("----- Verify Logout Start -----");
	 * 
	 * TestBase.test = TestBase.extent.createTest("Logout Test");
	 * //TestBase.test.assignCategory("Smoke Test"); TestBase.test =
	 * TestBase.test.createNode("Verify Logout");
	 * 
	 * TestBase.test.log(Status.INFO, "Verifying Logout");
	 * 
	 * assertTrue(loginPage.userlogout(), "User still logged in");
	 * 
	 * TestBase.test.log(Status.INFO, "User logged out.");
	 * 
	 * LoggerManager.info("----- Verify Valid Logout End -----"); }
	 */

	public static String captureScreenshot(WebDriver driver, String screenShotName) throws Exception {

		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
				.takeScreenshot(driver);
		// 
		String dest =  System.getProperty("user.dir") + EnvironmentConfig.environmentSetup().get("SCREEN_SHOT_PATH")  
				+ screenShotName + System.currentTimeMillis() + ".png";

		//System.out.println("Screenshot captured at location: " + dest);
		//log.debug(" ########### Screenshot captured at location: ########### " + dest);

		ImageIO.write(screenshot.getImage(), "PNG", new File(dest));

		return dest;

	}

	@AfterSuite(alwaysRun=true)
	public void tearDown() {
		/*
		 * if (loginPage.blnLogin == true ) {userLogout(); }
		 */


		LoggerManager.info("----- Quitting browser -----");

		driver.quit();

		extent.flush();

		mail_send();

		LoggerManager.debug("------- Browser quit successfully -------");

	}





	public void mail_send() {

		//System.out.println("preparing to send message ..."); 
		String message = "Hi Team, \n\nPlease find attachment along with mail\n\n\n\n\n\n\n\n--\nThanks & Regards,\ntest k";

		String subject = "HRMS Test Reports_" + CommonUtilities.getCurrentDateTime();
		//String to = "test@gmail.com";
		
		//String to = "test@gmail.com";
		
		String to = "chhaganlal.nemade@kriosispl.in";
		//String to = "sharad.kamble@Kriosispl.com";
		
		
	

		String from = "test@gmail.com";

		// sendEmail(message,subject,to,from);
		sendAttach(message,subject,to,from,rept_loc);
		
	}

	//this is responsible to send the message with attachment
	private static void sendAttach(String message, String subject, String to, String from, String rept_path) 
	{

		//Variable for gmail
		String host="smtp.gmail.com";

		//get the system properties
		Properties properties = System.getProperties();
		//System.out.println("PROPERTIES "+properties);

		//setting important information to properties object

		//host set
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port","465");
		//properties.put("mail.smtp.port","587");
		//properties.put("mail.smtp.port","25");
		properties.put("mail.smtp.ssl.enable","true");
		properties.put("mail.smtp.auth","true");

		//Step 1: to get the session object..
		Session session=Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {				
				return new PasswordAuthentication("test@gmail.com", "incezcwqxcrgvarf");
			}



		});

		session.setDebug(true);

		//Step 2 : compose the message [text,multi media]
		MimeMessage m = new MimeMessage(session);

		try {

			//from email
			m.setFrom(from);
			
			//adding recipient to message
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			//adding subject to message
			m.setSubject(subject);


			//attachement..

			//file path
			//String path="C:\\Users\\DELL\\Pictures\\Screenshots\\Screenshot (4).png";
			//String path="D:\\Projects\\HRMS\\DevOps.png";

			//String path="D:\\Sharad\\Python\\HRMS\\hrms\\TestReports\\AutomationExtentReport_2024-04-23-055107.html";


			// String path="D:\\Sharad\\Python\\HRMS\\hrms\\TestReports\\AutomationExtentReport_2024-04-24-051641.html";

			String path= rept_path;

			//path = path.replaceAll("\\","\\\\");
			// abhay commented path = rept_path.replaceAll("\\\\", "\\\\\\\\");

			//path = path.replaceAll("\\/", "////");
			//path = path.replace("\\/", "//");


			//path = rept_path.replaceAll("\\", "/");

			// abhay ommented path = path.replaceAll("/", "\\\\");


			//System.out.println("rept_path__________________________" + path);


			// Get the current date
			LocalDate currentDate = LocalDate.now();

			// Display the current date
			//System.out.println("Current Date: " + currentDate);



			MimeMultipart mimeMultipart = new MimeMultipart();
			//text
			//file

			MimeBodyPart textMime = new MimeBodyPart();

			MimeBodyPart fileMime = new MimeBodyPart();

			try {

				textMime.setText(message);
				//System.out.println("This is a file path >> " + rept_loc);

				//System.out.println("\"" + rept_loc + "\"");

				//File file=new File(path);
				// Abhay commented File file=new File("\"" + rept_loc + "\"");

				File file=new File(rept_loc); // ("\"" + rept_loc + "\"");
				fileMime.attachFile(file);


				mimeMultipart.addBodyPart(textMime);
				mimeMultipart.addBodyPart(fileMime);


			} catch (Exception e) {

				e.printStackTrace();
			}


			m.setContent(mimeMultipart);


			//send 

			//Step 3 : send the message using Transport class
			Transport.send(m);



		}catch (Exception e) {
			e.printStackTrace();
		}








		//System.out.println("Sent success...................");


	}


	//this is responsible to send email.. 
	private static void sendEmail(String
			message, String subject, String to, String from) {

		//Variable for mail String host="smtp.gmail.com";

		//get the system properties 
		Properties properties = System.getProperties();
		//System.out.println("PROPERTIES "+properties);

		//setting important information to properties object

		//host set properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port","465");
		//properties.put("mail.smtp.port","587");
		properties.put("mail.smtp.ssl.enable","true");
		properties.put("mail.smtp.auth","true");

		//Step 1: to get the session object.. 
		Session
		session=Session.getInstance(properties, new Authenticator() {

			@Override protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("test@gmail.com",
						"test"); }



		});

		session.setDebug(true);

		//Step 2 : compose the message [text,multi media] 
		MimeMessage msg = new
				MimeMessage(session);

		try {

			//from email 
			msg.setFrom(from);

			//adding recipient to message 
			msg.addRecipient(Message.RecipientType.TO, new
					InternetAddress(to));

			//adding subject to message 
			msg.setSubject(subject);


			//adding text to message 
			msg.setText(message);

			//send

			//Step 3 : send the message using Transport class 
			Transport.send(msg);

			//System.out.println("Sent success...................");


		}catch (Exception e) { e.printStackTrace(); }

	}







}

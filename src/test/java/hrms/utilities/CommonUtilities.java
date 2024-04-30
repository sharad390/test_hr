package hrms.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtilities {

	protected static WebDriver driver;

	public static WebDriverWait wait;

	public static void setExplicitWait(int seconds) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public static String screenShot(WebDriver driver, String filename) {

		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);

		String destination = System.getProperty("user.dir") + "\\ScreenShot\\" + filename + "_" + dateName + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}

		// This new path for jenkins
		String newImageString = "http://localhost:8082/job/Demo4/ws/ExtentDemo/ScreenShot/" + filename + "_" + dateName
				+ ".png";
		return newImageString;
	}

	public static String getCurrentTime() {
		String currentDate = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
		//String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		return currentDate;
	}
	
	public static String getCurrentDateTime() {
		String currentDate = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
		//String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		return currentDate;
	}

}

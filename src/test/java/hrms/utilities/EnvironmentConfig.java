package hrms.utilities;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class EnvironmentConfig {

	public static Map<String, String> fileandenv = new HashMap<String, String>();
	public static Properties propMain = new Properties();
	public static Properties propPreSet = new Properties();

	private static void environmentVariables() {

		// BrowserType details
		fileandenv.put("BrowserType", propMain.getProperty("BrowserType"));

		// Application details
		fileandenv.put("ApplicationURL", propMain.getProperty("ApplicationURL"));
		
		// Home Page details
		fileandenv.put("HomePageURL", propMain.getProperty("HomePageURL"));

		// Page load timeout
		fileandenv.put("PAGE_LOAD_TIMEOUT", propMain.getProperty("PAGE_LOAD_TIMEOUT"));
		fileandenv.put("IMPLICIT_WAIT", propMain.getProperty("IMPLICIT_WAIT"));

		// FilePath
		fileandenv.put("TESTDATA_PATH", propMain.getProperty("TESTDATA_PATH"));
		fileandenv.put("REPORT_LOCATION", propMain.getProperty("REPORT_LOCATION"));
		fileandenv.put("SCREEN_SHOT_PATH", propMain.getProperty("SCREEN_SHOT_PATH"));

		// login details
		fileandenv.put("USERNAME", propMain.getProperty("USERNAME"));
		fileandenv.put("PASSWORD", propMain.getProperty("PASSWORD"));
		
		// login details
		fileandenv.put("USERNAME1", propMain.getProperty("u_name"));
		fileandenv.put("PASSWORD1", propMain.getProperty("u_pwd"));
		
		// login details for Invalid username and invalid password
		//fileandenv.put("INVALIDUSERNAME", propMain.getProperty("INVALIDUSERNAME"));
		//fileandenv.put("INVALIDPASSWORD", propMain.getProperty("INVALIDPASSWORD"));
		
		
		// Browserstack
		fileandenv.put("BROWSER_STACK_AUTOMATE_USERNAME_1", propMain.getProperty("BROWSER_STACK_AUTOMATE_USERNAME"));
		fileandenv.put("BROWSER_STACK_AUTOMATE_ACCESS_KEY_1",
				propMain.getProperty("BROWSER_STACK_AUTOMATE_ACCESS_KEY"));

	}

	public static Map<String, String> environmentSetup() {

		String environment = System.getProperty("env");

		String propFilePath = "/src/test/resources/envProperties";

		LoggerManager.info("------- Selected environment ------- " + environment);

		try {
			if (environment.equalsIgnoreCase("local")) {

				FileInputStream fisLocal = new FileInputStream(
						System.getProperty("user.dir") + propFilePath + "/local.properties");

				propMain.load(fisLocal);

				environmentVariables();

			} else if (environment.equalsIgnoreCase("dev")) {

				FileInputStream fisDev = new FileInputStream(
						System.getProperty("user.dir") + propFilePath + "/dev.properties");

				propMain.load(fisDev);

				environmentVariables();

			} else if (environment.equalsIgnoreCase("qa")) {

				FileInputStream fisQA = new FileInputStream(
						System.getProperty("user.dir") + propFilePath + "/qa.properties");

				propMain.load(fisQA);

				environmentVariables();

			} else if (environment.equalsIgnoreCase("stage")) {

				FileInputStream fisStaging = new FileInputStream(
						System.getProperty("user.dir") + propFilePath + "/stage.properties");

				propMain.load(fisStaging);

				environmentVariables();

			} else if (environment.equalsIgnoreCase("prod")) {

				FileInputStream fisProd = new FileInputStream(
						System.getProperty("user.dir") + propFilePath + "/prod.properties");

				propMain.load(fisProd);

				environmentVariables();

			}
		} catch (Exception e) {

			LoggerManager.error("+++++++++ Exception in environmentSetup() +++++++++ " + e.getMessage());

			e.printStackTrace();
		}

		return fileandenv;

	}

	public static Map<String, String> getConfigReader() {

		if (fileandenv == null) {

			fileandenv = environmentSetup();

		} else {

			LoggerManager.error("+++++++++ Exception in Map<String, String> getConfigReader() +++++++++ ");

		}

		return fileandenv;

	}

}
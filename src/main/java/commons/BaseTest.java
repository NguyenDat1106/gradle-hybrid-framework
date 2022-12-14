package commons;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import exception.BrowserNotSupport;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driver;
	protected final Log log;
	
	@BeforeSuite
	public void initBeforeSuite() {
		deleteAllureReport();
	}
	
 	protected BaseTest() {
		log = LogFactory.getLog(getClass());
	}
		
	protected WebDriver getBrowserDriver(String browserName) {
	if (browserName.equals("firefox")) {	
		WebDriverManager.firefoxdriver().setup();
	
		FirefoxOptions options = new FirefoxOptions();
		options.addPreference("browser_download.folderList", 2);
		options.addPreference("browser.download.dir", GlobalConstants.PROJECT_PATH + "\\downloadFiles");
		options.addPreference("browser.userDownloadDir", true);
		options.addPreference("browser.helperApps.neverAsk.saveToDisk", 
				"multipart/x-zip, application/zip, application/x-zip-compressed, application/x-compressed, application/msword ,application/csv, image/png, image/jpeg,application/pdf, text/html,text/plain, application/excel, application/vnd.ms-excel, application/x-excel, application/x-msexcel, application/octet-stream");
		options.addPreference("pdfjs.disabled", true);
		options.addArguments("-private");
		
		driver = new FirefoxDriver(options);
	} else if (browserName.equals("h_firefox")) {
		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--headless");
		options.addArguments("window-size=1920x1080");
		driver = new FirefoxDriver(options);
	} else if (browserName.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		
		Map<String, Object> prefs = new HashMap<String, Object>();
		
		prefs.put("profile.default_content_settings.popups", 0);
		prefs.put("download.default_directory", GlobalConstants.PROJECT_PATH + "//downloadFiles");
		
		prefs.put("credentials_enable_service", false);
		prefs.put("prefile.password_manager_enable", false);
		options.setExperimentalOption("prefs", prefs);
		
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-geolocation");
		options.setExperimentalOption("useAutomationExtension", false);
		options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		options.addArguments("--incognito");
		//options.addArguments("--lang=vi");
		driver = new ChromeDriver(options);
	} else if (browserName.equals("h_chrome")) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("window-size=1920x1080");
		driver = new ChromeDriver(options);
	} else if (browserName.equals("edge")) {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	} else if (browserName.equals("opera")) {
		WebDriverManager.operadriver().setup();
		driver = new OperaDriver();
	} else if (browserName.equals("coccoc")) {
		WebDriverManager.chromedriver().driverVersion("105.0.5195.52").setup();
		ChromeOptions options = new ChromeOptions();
		options.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");

		if (GlobalConstants.OS_NAME.startsWith("Window")) {
			options.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");
		} else {
			options.setBinary("......");
		}
		
		driver = new ChromeDriver(options);
	
	} else {
		throw new BrowserNotSupport(browserName);

	}
	driver.manage().timeouts().implicitlyWait(GlobalConstants.lONG_TIMEOUT, TimeUnit.SECONDS);
	driver.get(GlobalConstants.PORTAL_DEV_URL);
	return driver;
}

	protected WebDriver getBrowserDriver(String browserName, String appUrl) {
	if (browserName.equals("firefox")) {	
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	} else if (browserName.equals("h_firefox")) {
	    WebDriverManager.firefoxdriver().setup();
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--headless");
		options.addArguments("window-size=1920x1080");
		driver = new FirefoxDriver(options);
	} else if (browserName.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	} else if (browserName.equals("h_chrome")) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("window-size=1920x1080");
		driver = new ChromeDriver(options);
	} else if (browserName.equals("edge")) {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	} else if (browserName.equals("opera")) {
		WebDriverManager.operadriver().setup();
		driver = new OperaDriver();
	} else if (browserName.equals("coccoc")) {
		WebDriverManager.chromedriver().driverVersion("105.0.5195.52").setup();
		ChromeOptions options = new ChromeOptions();
		options.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");
		driver = new ChromeDriver(options);
	
	} else {
		throw new RuntimeException("Browser name invalid");

	}
	driver.manage().timeouts().implicitlyWait(GlobalConstants.lONG_TIMEOUT, TimeUnit.SECONDS);
	driver.get(appUrl);
	return driver;
}

	public WebDriver getDriverInstance() {
		return this.driver;
	}
	
	protected String getEnvironmentURL(String severName) {
		String envUrl = null;
		EnvironmentList environment = EnvironmentList.valueOf(severName.toUpperCase());
		if (environment == EnvironmentList.DEV) {
			envUrl = "https://demo.nopcommerce.com";
		} else if (environment == EnvironmentList.TESTING) {
			envUrl = "https://admin-demo.nopcommerce.com";
		} else  if (environment == EnvironmentList.STAGING) {
			envUrl = "https://admin-demo.nopcommerce.com";
		} else  if (environment == EnvironmentList.PRODUCTION) {
			envUrl = "https://admin-demo.nopcommerce.com";
		} 
		return envUrl;
	}
	
	protected int generateFakeNumber() {
		  Random rand = new Random();
		  return rand.nextInt(9999);
	  }
	
	protected boolean verifyTrue(boolean condition) {
		boolean pass = true;
		try {
			if (condition == true) {
				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				log.info(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			pass = false;

			// Add l???i v??o ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		boolean pass = true;
		try {
			if (condition == false) {
				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				log.info(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			log.info(" -------------------------- FAILED -------------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}
	
	public void deleteAllureReport() {
		try {
			String workingDir = System.getProperty("user.dir");
			String pathFolderDownload = workingDir + "/allure-results";
			File file = new File(pathFolderDownload);
			File[] listOfFiles = file.listFiles();
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					
					new File(listOfFiles[i].toString()).delete();
				}
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

	protected void closeBrowserAndDriver() {
		String cmd = "";
		try {
			String osName = System.getProperty("os.name").toLowerCase();
			log.info("OS name = " + osName);

			String driverInstanceName = driver.toString().toLowerCase();
			log.info("Driver instance name = " + driverInstanceName);

			if (driverInstanceName.contains("chrome")) {
				if (osName.contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
				} else {
					cmd = "pkill chromedriver";
				}
			} else if (driverInstanceName.contains("internetexplorer")) {
				if (osName.contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
				}
			} else if (driverInstanceName.contains("firefox")) {
				if (osName.contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
				} else {
					cmd = "pkill geckodriver";
				}
			} else if (driverInstanceName.contains("edge")) {
				if (osName.contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq msedgedriver*\"";
				} else {
					cmd = "pkill msedgedriver";
				}
			} else if (driverInstanceName.contains("opera")) {
				if (osName.contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq operadriver*\"";
				} else {
					cmd = "pkill operadriver";
				}
			} else if (driverInstanceName.contains("safari")) {
				if (osName.contains("mac")) {
					cmd = "pkill safaridriver";
				}
			}

			if (driver != null) {
				driver.manage().deleteAllCookies();
				driver.quit();
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		} finally {
			try {
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	protected String getCurrentDate() {
		DateTime nowUTC = new DateTime();
		int day = nowUTC.getDayOfMonth();
		if (day < 10) {
			String dayValue = "0" + day;
			return dayValue;
		}
		return String.valueOf(day);
	}

	protected String getCurrentMonth() {
		DateTime now = new DateTime();
		int month = now.getMonthOfYear();
		if (month < 10) {
			String monthValue = "0" + month;
			return monthValue;
		}
		return String.valueOf(month);
	}

	protected String getCurrentYear() {
		DateTime now = new DateTime();
		return String.valueOf(now.getYear());
	}

	protected String getCurrentDay() {
		return getCurrentDate() +  "/" + getCurrentMonth() + "/" + getCurrentYear();
	}
}

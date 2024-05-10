package SugerCRM;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.UnknownHostException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Unit test for simple App.
 */
public class CreateOrg {
	private static String UTILS = "Utils";
	public static WebElement webelement;
	public static List<WebElement> webelements = null;
	public static WebDriver driver = null;
	public static int defaultBrowserTimeOut = 30;
	public static List<String> windowHandlers;
	public static final String usernametxtfld = "//input[@placeholder='User Name']";
	public static final String passwordfld = "//input[@placeholder='Password']";
	public static final String signinbtn = "//a[@name='login_button']";
	public static final String orgbtn = "//button[@aria-label='Organizations - More']//i[@class='sicon sicon-chevron-down']";
	public static final String crorgdrpdn = "//span[contains(text(),'Create Organization')]";
	public static final String companyName = "//input[@name='name']";
	public static final String username = "Nivarti";
	public static final String password = "Captive@123";
	public static final String caStatus = "Regularisation of casual workers";
	public static final String addNames = "Private Org";
	public static final String addresstab = "//li[@class='tab tab-badgeable LBL_RECORDVIEW_PANEL2 active']//a";
	public static final String casualityStatus = "//input[@name='casualty_status_c']";
	public static final String AdditionalNames = "//input[@name='additional_names_c']";
	public static String company = null;

	@Test
	public static void createOrganization() throws UnknownHostException, InterruptedException, AWTException {
		startBrowser("firefox");
		driver.manage().window().maximize();
		String url = "https://sugardev.captiveresources.com/#";
		driver.get(url);
		Thread.sleep(2000);
		WebElement owausername = driver.findElement(By.xpath(usernametxtfld));
		owausername.sendKeys(username);
		Thread.sleep(2000);
		WebElement owapasswd = driver.findElement(By.xpath(passwordfld));
		owapasswd.sendKeys(password);
		Thread.sleep(2000);
		WebElement signin = driver.findElement(By.xpath(signinbtn));
		signin.click();
		Thread.sleep(3000);
		WebElement org = driver.findElement(By.xpath(orgbtn));
		org.click();
		Thread.sleep(2000);
		WebElement crorg = driver.findElement(By.xpath(crorgdrpdn));
		crorg.click();
		Thread.sleep(2000);
		for (int i = 1; i <= 2; i++) {
			company = "Testing_WI" + Timestamp.getTimeStamp();
			Thread.sleep(3000);
			WebElement comyName = driver.findElement(By.xpath(companyName));
			comyName.sendKeys(company);
			Thread.sleep(2000);
			WebElement casStatus = driver.findElement(By.xpath(casualityStatus));
			casStatus.sendKeys(caStatus);
			Thread.sleep(2000);
			WebElement AdditNames = driver.findElement(By.xpath(AdditionalNames));
			AdditNames.sendKeys(addNames);
			Thread.sleep(2000);

			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_T);
			Thread.sleep(2000);
			/*
			 * driver.close(); driver.quit();
			 */

		}

	}

	@Test(priority = 2)
	public void addressDetails() throws UnknownHostException, InterruptedException {
		startBrowser("firefox");
		driver.manage().window().maximize();
		String url = "https://sugardev.captiveresources.com/#";
		driver.get(url);
		Thread.sleep(2000);

	}

	public static WebDriver startBrowser(String browserName) throws UnknownHostException {

		if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C://Docs//Driver//geckodriver.exe");

			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("iexplorer")) {
			System.setProperty("webdriver.ie.driver", UTILS + "\\IEDriverServer.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capabilities.setCapability("ignoreZoomSetting", true);
			driver = new InternetExplorerDriver(capabilities);
		} else if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", UTILS + "\\chromedriver.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			driver = new ChromeDriver(capabilities);
		}
		driver.manage().timeouts().implicitlyWait(defaultBrowserTimeOut, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		if (browserName.equalsIgnoreCase("iexplorer"))
			SwitchAlert();

		if (windowHandlers == null)
			windowHandlers = new LinkedList<String>();
		else
			windowHandlers.clear();

		windowHandlers.add(driver.getWindowHandle());
		driver.manage().window().maximize();
		return driver;

	}

	private static FirefoxOptions FirefoxOptions() {
		// TODO Auto-generated method stub
		return null;
	}

	public static boolean SwitchAlert() {
		boolean Flag = false;

		try {
			if (driver.switchTo().alert() != null) {
				driver.switchTo().alert().accept();
				Flag = true;
			}
		} catch (NoAlertPresentException e) {
		}
		return Flag;
	}
}
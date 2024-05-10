package Ciber_PIC_Automation.Captiv;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.UnknownHostException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AppTest {
	private static String UTILS = "Utils";
	public static WebElement webelement;
	public static List<WebElement> webelements = null;
	public static WebDriver driver = null;
	public static int defaultBrowserTimeOut = 30;
	public static List<String> windowHandlers;
	public static Logger logger = Logger.getLogger("LoggerCreation");
	public static final String usernametxtfld = "//input[@name='username']";
	public static final String passwordfld = "//input[@name='password']";
	public static final String signinbtn = "//a[@name='login_button']";
	public static final String orgbtn = "//button[@aria-label='Organizations - More']//i[@class='sicon sicon-chevron-down']";
	public static final String crorgdrpdn = "//span[contains(text(),'Create Organization')]";
	public static final String companyName = "//input[@name='name']";
	public static final String PhyStreetfld = "//textarea[@placeholder='(Required) Physical Street']";
	public static final String PhyCityfld = "//input[@placeholder='(Required) Physical City']";
	public static final String PhyStatefld = "//input[@name='billing_address_state']";
	public static final String PhyPostcodefld = "//input[@placeholder='(Required) Physical Postal Code']";
	public static final String savebtn = "/html/body/div[1]/div/div[6]/div/div/div[1]/div[1]/div/div[1]/h1/div/span[3]/a";
	public static final String sublnk = "//div[@data-subpanel-link='opportunities']//i[@class='sicon sicon-plus']";
	public static final String subTab = "//h4[text()='Submissions']";
	public static final String waralt = "//button[@class='close btn btn-invisible']//i[@class='sicon sicon-close']";
	public static final String capName = "/html[1]/body[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[5]/div[1]/span[1]/span[1]/span[1]/div[1]";
	public static final String promgr = "/html[1]/body[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[6]/div[1]/span[1]/span[1]/span[1]/div[1]";
	public static final String memtyp = "/html[1]/body[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[8]/div[1]/span[1]/span[1]/span[1]/div[1]";
	public static final String brk = "/html[1]/body[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[9]/div[1]/span[1]/span[1]/span[1]/div[1]";
	public static final String capexe = "/html[1]/body[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[5]/div[2]/span[1]/span[1]/span[1]/div[1]";
	public static final String procor = "/html[1]/body[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[6]/div[2]/span[1]/span[1]/span[1]/div[1]";
	public static final String linbus = "/html[1]/body[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[9]/div[2]/span[1]/span[1]/span[1]/div[1]";
	public static final String prostr = "/html[1]/body[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/span[1]/span[1]/span[1]/div[1]";
	public static final String capSearch = "/html[1]/body[1]/div[6]/div[1]/input[1]";
	public static final String promgrSearch = "/html[1]/body[1]/div[6]/div[1]/input[1]";
	public static final String brkSearch = "//div[@id='select2-drop']//div[@class='select2-result-label'][normalize-space()='Search and Select...']";
	public static final String brkrad = "/html[1]/body[1]/div[1]/div[1]/div[6]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[18]/td[1]/span[1]/input[1]";
	public static final String captexeSearch = "/html/body/div[6]/ul[2]/li/div";
	public static final String procorSearch = "/html/body/div[7]/ul[2]/li/div";
	public static final String caprad = "/html/body/div[1]/div/div[6]/div[2]/div/div[1]/div[2]/div[2]/div/div[1]/div/div/table/tbody/tr[16]/td[1]/span/input";
	public static final String procorrad = "/html/body/div[1]/div/div[6]/div[2]/div/div[1]/div[2]/div[2]/div/div[1]/div/div/table/tbody/tr[14]/td[1]/span/input";
	public static final String memtySelect = "/html/body/div[6]/ul/li[2]/div";
	public static final String linbusSelect = "/html[1]/body[1]/div[8]/ul[1]/li[2]/div[1]";
	public static final String casualityStatus = "//input[@name='casualty_status_c']";
	public static final String AdditionalNames = "//input[@name='additional_names_c']";
	public static final String Broker = "//div[@id='s2id_autogen952']";
	public static final String ProgMng = "s2id_autogen942";
	public static final String addresstab = "//li[@class='tab tab-badgeable LBL_RECORDVIEW_PANEL2 active']//a";
	public static final String subName = "//input[@name='name']";
	public static final String recSub = "//input[@name='date_received_c']";
	public static final String effdate = "//input[@name='effective_date_c']";
	public static final String pcsvbtn = "//a[@class='btn btn-primary']";
	public static final String crsubname = "/html/body/div[1]/div/div[4]/div/div/div[1]/div[3]/div[2]/div[2]/div[1]/ul/li/div[2]/div/div/table/tbody/tr/td[2]/span/div/a";
	public static final String nwpr = "/html/body/div[1]/div/div[4]/div/div/div[1]/div[1]/div/div[2]/div/div/div[1]/div[3]/div[1]/span/span[1]/span/div";

	public static final String PhyStreet = "2142 S Main St";
	public static final String PhyCity = "Bangalore";
	public static final String PhyState = "KA";
	public static final String PhyPostcode = "560060";
	public static final String username = "Nivarti";
	public static final String password = "Captive@123";
	public static final String caStatus = "Regularisation of casual workers";
	public static final String addNames = "Private Org";
	public static final String rcsub = "01/09/2022";
	public static final String efdt = "05/25/2022";
	public static String company = null;
	public static String submissionName = null;

	@Test
	public static void createOrganization() throws UnknownHostException, InterruptedException, AWTException {

		startBrowser("firefox");
		driver.manage().window().maximize();
		String url = "https://sugardev.captiveresources.com/#";
		driver.get(url);
		Thread.sleep(2000);
		WebElement cpusername = driver.findElement(By.xpath(usernametxtfld));
		cpusername.sendKeys(username);
		Thread.sleep(2000);
		WebElement owapasswd = driver.findElement(By.xpath(passwordfld));
		owapasswd.sendKeys(password);
		Thread.sleep(2000);
		WebElement signin = driver.findElement(By.xpath(signinbtn));
		signin.click();
		Thread.sleep(5000);

		WebElement org = driver.findElement(By.xpath(orgbtn));
		org.click();
		Thread.sleep(3000);
		WebElement crorg = driver.findElement(By.xpath(crorgdrpdn));
		crorg.click();
		Thread.sleep(2000);
		WebElement wrwdw = driver.findElement(By.xpath(waralt));
		wrwdw.click();
		Thread.sleep(2000);

		company = "Testing_WI_" + Timestamp.getTimeStamp();
		Thread.sleep(2000);
		WebElement comyName = driver.findElement(By.xpath(companyName));
		comyName.sendKeys(company);
		Thread.sleep(2000);
		WebElement AdditNames = driver.findElement(By.xpath(AdditionalNames));
		AdditNames.sendKeys(addNames);
		Thread.sleep(2000);

		driver.findElement(By.linkText("Address")).click();
		Thread.sleep(2000);
		WebElement PStreet = driver.findElement(By.xpath(PhyStreetfld));
		insertTextIntoTextField(PStreet, MPSUPropertyFileRead.FileRead("ProjectData.properties", "PhyStreet"));
		WebElement PCity = driver.findElement(By.xpath(PhyCityfld));
		insertTextIntoTextField(PCity, MPSUPropertyFileRead.FileRead("ProjectData.properties", "PhyCity"));
		WebElement PState = driver.findElement(By.xpath(PhyStatefld));
		insertTextIntoTextField(PState, MPSUPropertyFileRead.FileRead("ProjectData.properties", "PhyState"));
		WebElement Street = driver.findElement(By.xpath(PhyPostcodefld));
		insertTextIntoTextField(Street, MPSUPropertyFileRead.FileRead("ProjectData.properties", "PhyPostcode"));
		Thread.sleep(2000);

		WebElement save = driver.findElement(By.xpath(savebtn));
		save.click();
		Thread.sleep(2000);

		driver.findElement(By.partialLinkText("Testing_WI_")).click();
		System.out.println("theLinkText: " + driver.getTitle());
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		WebElement submntab = driver.findElement(By.xpath(subTab));
		actions.moveToElement(submntab).perform();
		Thread.sleep(2000);
		WebElement sblnk = driver.findElement(By.xpath(sublnk));
		sblnk.click();
		Thread.sleep(2000);

		submissionName = "Testing_WI_" + Timestamp.getTimeStamp();
		Thread.sleep(2000);
		WebElement sbName = driver.findElement(By.xpath(subName));
		sbName.sendKeys(submissionName);
		Thread.sleep(2000);

		WebElement captive = driver.findElement(By.xpath(capName));
		actions.moveToElement(captive).click().perform();
		Thread.sleep(3000);
		WebElement capsearch = driver.findElement(By.xpath(capSearch));
		insertTextIntoTextField(capsearch, MPSUPropertyFileRead.FileRead("ProjectData.properties", "Captive"));
		Thread.sleep(3000);
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);

		WebElement promgrfld = driver.findElement(By.xpath(promgr));
		actions.moveToElement(promgrfld).click().perform();
		Thread.sleep(3000);
		WebElement prSearch = driver.findElement(By.xpath(promgrSearch));
		insertTextIntoTextField(prSearch, MPSUPropertyFileRead.FileRead("ProjectData.properties", "ProgramManager"));
		Thread.sleep(3000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);

		WebElement recisub = driver.findElement(By.xpath(recSub));
		recisub.sendKeys(rcsub);
		Thread.sleep(2000);

		WebElement memtypfld = driver.findElement(By.xpath(memtyp));
		actions.moveToElement(memtypfld).click().perform();
		Thread.sleep(2000);
		Action memtypAction = actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
		memtypAction.perform();
		Thread.sleep(2000);

		WebElement brkfld = driver.findElement(By.xpath(brk));
		actions.moveToElement(brkfld).click().perform();
		Thread.sleep(2000);
		WebElement brksearch = driver.findElement(By.xpath(brkSearch));
		brksearch.click();
		WebElement brkrd = driver.findElement(By.xpath(brkrad));
		brkrd.click();
		Thread.sleep(2000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);

		WebElement efdte = driver.findElement(By.xpath(effdate));
		efdte.sendKeys(efdt);
		Thread.sleep(2000);

		WebElement linbusfld = driver.findElement(By.xpath(linbus));
		actions.moveToElement(linbusfld).click().perform();
		Thread.sleep(2000);
		Action linbusAction = actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
		linbusAction.perform();
		Thread.sleep(2000);

		WebElement prostrfld = driver.findElement(By.xpath(prostr));
		actions.moveToElement(prostrfld).click().perform();
		Thread.sleep(3000);
		Action prostrAction = actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
		prostrAction.perform();
		Thread.sleep(2000);

		WebElement capexefld = driver.findElement(By.xpath(capexe));
		actions.moveToElement(capexefld).click().perform();
		Thread.sleep(3000);
		WebElement capexsearch = driver.findElement(By.xpath(brkSearch));
		capexsearch.click();
		WebElement bprd = driver.findElement(By.xpath(caprad));
		bprd.click();
		Thread.sleep(2000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);

		WebElement procorfld = driver.findElement(By.xpath(procor));
		actions.moveToElement(procorfld).click().perform();
		Thread.sleep(2000);
		WebElement prad = driver.findElement(By.xpath(brkSearch));
		prad.click();
		WebElement prrd = driver.findElement(By.xpath(procorrad));
		prrd.click();
		Thread.sleep(2000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);

		WebElement pcsv = driver.findElement(By.xpath(pcsvbtn));
		pcsv.click();
		Thread.sleep(2000);

		WebElement crsbnm = driver.findElement(By.xpath(crsubname));
		crsbnm.click();
		Thread.sleep(2000);

		WebElement newpr = driver.findElement(By.id(nwpr));
		newpr.getText();
		System.out.println("Printing " + nwpr);
		/*
		 * driver.close(); driver.quit();
		 */

	}

	public static WebDriver startBrowser(String browserName) throws UnknownHostException {

		if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:/Docs/Driver/geckodriver.exe");
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

	public static void insertTextIntoTextField(WebElement webElement, String inputText) {
		webElement.clear();
		webElement.sendKeys(inputText);
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

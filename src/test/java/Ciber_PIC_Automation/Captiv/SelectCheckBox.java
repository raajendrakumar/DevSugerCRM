package Ciber_PIC_Automation.Captiv;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SelectCheckBox {
	WebDriver driver;

	@Test
	public static void checkBox() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:\\Docs\\Driver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();

	}
}

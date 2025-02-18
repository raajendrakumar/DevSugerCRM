package Ciber_PIC_Automation.Captiv;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Practice {
// created reference variable for WebDriver
	WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C://Docs//Driver//geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
		driver.get("https://www.google.com");
		driver.findElement(By.id("lst-ib")).sendKeys("puli goru");
		driver.findElement(By.linkText("Images for puligoru")).click();

		System.out.println("before windows " + driver.getWindowHandles().size());
		System.out.println("before frames " + driver.findElements(By.tagName("iframe")).size());

		driver.findElement(By.xpath("//img[@class='rg_ic rg_i']")).click();

		System.out.println("after windows " + driver.getWindowHandles().size());
		System.out.println("after frames " + driver.findElements(By.tagName("iframe")).size());

		WebElement img = driver.findElement(By.xpath(
				"//img[@src='https://www.southjewellery.com/wp-content/uploads/2016/04/peacock_puligoru_pendant.jpg']"));

		Actions act = new Actions(driver);
		act.moveToElement(img).contextClick().sendKeys(Keys.ARROW_DOWN.ARROW_DOWN.ARROW_DOWN.ARROW_DOWN).build()
				.perform();

		Thread.sleep(2000);
		// driver.quit();

	}
}

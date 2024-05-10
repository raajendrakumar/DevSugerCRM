package Ciber_PIC_Automation.Captiv;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Scroll {
	@Test
	public void testBStackTakeScreenShot() throws Exception {

		WebDriver dr;
		System.setProperty("webdriver.gecko.driver", "C:/Docs/Driver/geckodriver.exe");
		dr = new FirefoxDriver();
		dr.manage().window().maximize();
		dr.get("https://opensource-demo.orangehrmlive.com/"); // testing webpage

		WebElement uname = dr.findElement(By.id("txtUsername")); // username
		uname.sendKeys("Admin");

		WebElement pwd = dr.findElement(By.name("txtPassword")); // password
		pwd.sendKeys("admin123");

		WebElement login_button = dr.findElement(By.xpath("//input[@id='btnLogin']"));
		login_button.click(); // login button

		WebElement admin = dr.findElement(By.id("menu_admin_viewAdminModule"));
		admin.click();

		WebElement job = dr.findElement(By.id("menu_admin_Job"));
		job.click();
		WebElement jobtitle_link = dr.findElement(By.linkText("Job Titles"));
		jobtitle_link.click();

		Actions act = new Actions(dr);
		act.sendKeys(Keys.PAGE_DOWN).build().perform(); // Page Down
		System.out.println("Scroll down perfomed");
		Thread.sleep(3000);

		act.sendKeys(Keys.PAGE_UP).build().perform(); // Page Up
		System.out.println("Scroll up perfomed");
		Thread.sleep(3000);
	}
}
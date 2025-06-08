package Ciber_PIC_Automation.Captiv;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {
	public static void main(String[] args) throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// logging in to the system
		driver.get(
				"https://captv-stg1.pegacloud.io/prweb/app/PIC/UuLDf6PK9-l7FZm2O0pKstkg4aAVpnvm*/!STANDARD?pzPostData=1697395401");
		driver.findElement(By.xpath("//input[@id=\"txtUserID\"]")).sendKeys("Samrat_qa");
		driver.findElement(By.xpath("//input[@id=\"txtPassword\"]")).sendKeys("rules");
		driver.findElement(By.xpath("//button[@id=\"sub\"]")).click();

		// opening dev studio

		driver.findElement(By.xpath("//a[@title=\"Launch portal\"]")).click();
		Thread.sleep(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//span[text()=\"Case Manager 7\"]")).click();
		Thread.sleep(Duration.ofSeconds(10));

		// searching credit case

		driver.findElement(By.name("$PpyDisplayHarness$ppySearchText")).sendKeys("CR-1201164");
		driver.findElement(By.name("$PpyDisplayHarness$ppySearchText")).sendKeys(Keys.ENTER);

		String has = driver.findElement(By.xpath("(//span[@data-ctl=\"Text\"])[1]")).getText();

		System.out.println(has);

	}

	public void window(int j) {
		int i = 0;
		ChromeDriver driver = new ChromeDriver();
		Set<String> str = driver.getWindowHandles();
		String[] srr = new String[str.size()];

		for (String d : str) {
			srr[i] = d;
			i++;
		}

		driver.switchTo().window(srr[j]);
	}
}

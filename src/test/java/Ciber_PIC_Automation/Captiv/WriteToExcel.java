package Ciber_PIC_Automation.Captiv;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WriteToExcel {
	public static void main(String args[]) throws IOException, InterruptedException {
		// set the ChromeDriver path
		System.setProperty("webdriver.gecko.driver", "C:/Docs/Driver/geckodriver.exe");
		// WebDriverManager.edgedriver().setup();

		// Create an object of File class to open xls file
		File file = new File("C:\\Docs\\Driver\\TestData1.xlsx");

		// Create an object of FileInputStream class to read excel file
		FileInputStream inputStream = new FileInputStream(file);

		// creating workbook instance that refers to .xls file
		XSSFWorkbook wb = new XSSFWorkbook(inputStream);

		// creating a Sheet object
		XSSFSheet sheet = wb.getSheet("STUDENT_DATA");

		// get all rows in the sheet
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

		// Creating an object of ChromeDriver
		WebDriver driver = new FirefoxDriver();
		// WebDriver driver = new EdgeDriver();
		// Navigate to the URL
		driver.get("https://demoqa.com/automation-practice-form");
		driver.manage().window().maximize();
		// Identify the WebElements for the student registration form
		WebElement firstName = driver.findElement(By.id("firstName"));
		WebElement lastName = driver.findElement(By.id("lastName"));
		WebElement email = driver.findElement(By.id("userEmail"));
		WebElement genderMale = driver.findElement(By.id("gender-radio-1"));
		WebElement mobile = driver.findElement(By.id("userNumber"));
		WebElement address = driver.findElement(By.id("currentAddress"));
		WebElement submitBtn = driver.findElement(By.id("submit"));

		// iterate over all the rows in Excel and put data in the form.
		for (int i = 1; i <= rowCount; i++) {
			// Enter the values read from Excel in
			// firstname,lastname,mobile,email,address
			firstName.sendKeys(sheet.getRow(i).getCell(0).getStringCellValue());
			lastName.sendKeys(sheet.getRow(i).getCell(1).getStringCellValue());
			email.sendKeys(sheet.getRow(i).getCell(2).getStringCellValue());
			mobile.sendKeys(sheet.getRow(i).getCell(4).getStringCellValue());
			address.sendKeys(sheet.getRow(i).getCell(5).getStringCellValue());

			// Click on the gender radio button using javascript
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", genderMale);

			WebElement adIframe = driver
					.findElement(By.id("google_ads_iframe_/21849154601,22343295815/Ad.Plus-Anchor_0"));
			((JavascriptExecutor) driver).executeScript("arguments[0].style.display='none';", adIframe);
			Thread.sleep(3000);

			WebElement button = driver.findElement(By.id("submit"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
			((JavascriptExecutor) driver).executeScript(
					"document.getElementById('google_ads_iframe_/21849154601,22343295815/Ad.Plus-Anchor_0__container__').style.display='none';");

			// Click on submit button
			submitBtn.click();

			// Verify the confirmation message
			WebElement confirmationMessage = driver
					.findElement(By.xpath("//div[text()='Thanks for submitting the form']"));

			// create a new cell in the row at index 6
			XSSFCell cell = sheet.getRow(i).createCell(6);

			// check if confirmation message is displayed
			if (confirmationMessage.isDisplayed()) {
				// if the message is displayed , write PASS in the excel sheet
				cell.setCellValue("PASS");

			} else {
				// if the message is not displayed , write FAIL in the excel
				// sheet
				cell.setCellValue("FAIL");
			}

			// Write the data back in the Excel file
			FileOutputStream outputStream = new FileOutputStream("C:\\Docs\\Driver\\TestData1.xlsx");
			wb.write(outputStream);

			WebElement button1 = driver.findElement(By.id("closeLargeModal"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button1);

			// close the confirmation popup
			WebElement closebtn = driver.findElement(By.id("closeLargeModal"));
			closebtn.click();

			// wait for page to come back to registration page after close
			// button is clicked
			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		}

		// Close the workbook
		((Closeable) wb).close();

		// Quit the driver
		driver.quit();
	}
}
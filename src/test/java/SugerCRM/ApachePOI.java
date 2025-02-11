package SugerCRM;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ApachePOI {
	public static void main(String args[]) throws IOException, InterruptedException {

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

		for (int i = 0; i <= rowCount; i++) {

			// get cell count in a row
			int cellcount = sheet.getRow(i).getLastCellNum();

			// iterate over each cell to print its value
			System.out.println("Row " + i + " data is :");

			for (int j = 0; j < cellcount; j++) {
				System.out.print(sheet.getRow(i).getCell(j).getStringCellValue() + " ,");
			}
			System.out.println();
		}
	}
}
package org.sel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

	public static WebDriver driver;
	
	public static void launchUrl(String url) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\RAM SARATH KUMAR\\eclipse-workspace\\JunitLearn10\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
	}
	
	public static void enterText(WebElement element, String value) {
		element.sendKeys(value);
	}
	
	public static String excelRead(String path, String name, int rownum, int cellnum) throws IOException {
		File f = new File(path);
		FileInputStream stream = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(stream);
		Sheet sheet = w.getSheet(name);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		int cellType = cell.getCellType();
		if(cellType==1) {
			String text = cell.getStringCellValue();
			return text;
		}
		else if(DateUtil.isCellDateFormatted(cell)) {
			Date dateCellValue = cell.getDateCellValue();
			SimpleDateFormat fo = new SimpleDateFormat("dd/MM/yyyy");
			String text = fo.format(dateCellValue);
			return text;
		}
		else {
			double numericCellValue = cell.getNumericCellValue();
			long l =(long)numericCellValue;
			String text = String.valueOf(l);
			return text;
			
		}
		
	}
	
	public static void buttonClick(WebElement element) {
		element.click();
		System.out.println("work by A");
		System.out.println("worked on login ");
		System.out.println("work by B");
		System.out.println("Create New Account");

	
	}
	
	
}

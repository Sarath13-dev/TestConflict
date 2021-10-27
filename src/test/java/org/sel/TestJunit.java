package org.sel;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestJunit {
	public static WebDriver driver;
	@BeforeClass
	public static void browserLaunch() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\RAM SARATH KUMAR\\eclipse-workspace\\JunitLearn10\\driver\\chromedriver.exe");
		
		 driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");

	}
	
	@Before
	public void timeBeforeEntry() throws InterruptedException {
		
		Date d = new Date();
		System.out.println(d);
		Thread.sleep(3000);
		driver.manage().window().maximize();
		
	}
	@Test
	public void usernameAndPassword() {
		String title = driver.getTitle();
		boolean contains = title.contains("Facebook");
		Assert.assertTrue("validating control is in facebook page or not", contains);
		System.out.println("control is in fb page");
		WebElement txtUsername = driver.findElement(By.id("email"));
		txtUsername.sendKeys("ramsss");
		
		WebElement txtPassword = driver.findElement(By.id("pass"));
		txtPassword.sendKeys("1234");
		
	}
	
	@AfterClass
	public static void closeBrowser() throws InterruptedException {
		
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.quit();
	}
	
	@After
	public void timeAfterEntry() throws InterruptedException {
		
		Date d1 = new Date();
		System.out.println(d1);
		Thread.sleep(3000);
		Dimension dimension = new Dimension(250, 250);
		driver.manage().window().setSize(dimension);
		
	}
	
	
}

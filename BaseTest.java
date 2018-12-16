package com.ibm.test;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ibm.pages.AdminPage;
import com.ibm.utilities.ExcelUtil;
import com.ibm.utilities.PropertiesFileHandler;

public class BaseTest {
	// TestCase 1 given to check the login of admin tab and modifying the tab and
	// its sort order
	@Test(priority = 2, testName = "Test for Tabs Edit")
	public void LoginAndEditTab() throws IOException, InterruptedException {
		// To take the data given in the 'data.properties' file
		String file = "./TestData/data.properties";
		PropertiesFileHandler propFileHandler = new PropertiesFileHandler();
		HashMap<String, String> data = propFileHandler.getPropertiesAsMap(file);
		String url = data.get("url");
		// To use the chrome driver and get the url, maximize window
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
		String userName = data.get("username");
		String password = data.get("password");
		// To run the xpath and method created in AdminPage.java
		AdminPage home = new AdminPage(driver, wait);
		// To get the mail address from properties file and calling the method from
		// Admin.java page
		home.EnetrEmailAddress(userName);
		Thread.sleep(3000);
		// To get the password
		home.EnetrPassword(password);
		Thread.sleep(3000);
		// To click on the login button
		home.ClickonLoginButton();
		Thread.sleep(3000);
		// To click on the Catalog button
		home.ClickonCatalogTabButton();
		Thread.sleep(3000);
		// To click on tab button
		home.ClickonTabButton();
		Thread.sleep(3000);
		// To click on Action button of the first data
		home.ClickonAction();
		Thread.sleep(3000);
		// To click on the edit button
		home.ClickonEditButton();
		Thread.sleep(3000);
		// To edit the tab name
		home.EntertheTabName();
		Thread.sleep(2000);
		// To edit the sort order
		home.EnetrtheSortOrder();
		Thread.sleep(2000);
		// To change the status
		home.EntertheStatus();
		Thread.sleep(2000);
		// To click on save once edit is done
		home.ClickonTheSaveButton();
		Thread.sleep(2000);
		// To verify whether after the save button it is going back and changes are
		// implement by checking it with the first page title over there
		Assert.assertTrue(driver.findElement(By.xpath("//img[@title='EasyOrdering']")).isDisplayed());
		Thread.sleep(2000);
		// home.ClickonLogoutButton();
	}

	@Test(priority = 1, testName = "Test for Tabs Edit")
	public void LoginAndCheckOnProdutImageTab() throws IOException, InterruptedException {
		String file = "./TestData/data.properties";
		PropertiesFileHandler propFileHandler = new PropertiesFileHandler();
		HashMap<String, String> data = propFileHandler.getPropertiesAsMap(file);
		String url = data.get("url");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
		String userName = data.get("username");
		String password = data.get("password");
		// To get the method created in Admin page
		AdminPage home = new AdminPage(driver, wait);
		// To get the mail id or user name
		home.EnetrEmailAddress(userName);
		Thread.sleep(2000);
		// To give to password
		home.EnetrPassword(password);
		Thread.sleep(2000);
		// To give the password
		home.ClickonLoginButton();
		Thread.sleep(2000);
		// To click on the Catalog tab
		home.ClickonCatalogTabButton();
		Thread.sleep(2000);
		// TO click on 'Product Image' under 'Catalog'
		home.ClickonProductImage();
		Thread.sleep(3000);
		// To check whether the Product Image page is opened so checking the title of
		// that page
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='header-title']")).isDisplayed());
		System.out.println("The Product Image tab is selected and the page is opened");
		// Search element to search for 'grain'
		home.EnterSerachEle();
		Thread.sleep(2000);
		// To check whether "No matching records found" is displayed or not
		Assert.assertTrue(driver.findElement(By.xpath("//td[@class='dataTables_empty']")).isDisplayed());
		System.out.println("No matching records found");
		System.out.println("The search given is not present in the product image tab");
	}

	@Test(priority = 1, testName = "Adding new notifications")
	public void AddPushNotification() throws IOException, InterruptedException {
		String file = "./TestData/data.properties";
		PropertiesFileHandler propFileHandler = new PropertiesFileHandler();
		HashMap<String, String> data = propFileHandler.getPropertiesAsMap(file);
		String url = data.get("url");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		TakesScreenshot ts = ((TakesScreenshot) driver);
		File file1 = ts.getScreenshotAs(OutputType.FILE);
		// Date date=new Date();
		// String currentDate=date.toString().replaceAll(":", "-");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
		String userName = data.get("username");
		String password = data.get("password");
		String notification = data.get("Notification");
		String notification1 = data.get("Notification1");
		// To get the method created in Admin page
		AdminPage home = new AdminPage(driver, wait);
		// To get the mail id or user name
		home.EnetrEmailAddress(userName);
		Thread.sleep(2000);
		// To give to password
		home.EnetrPassword(password);
		Thread.sleep(2000);
		// To give the password
		home.ClickonLoginButton();
		Thread.sleep(2000);
		// To click on Marketing Tab
		home.ClickOnMarketing();
		Thread.sleep(2000);
		// To click on push notifications
		home.ClickOnPushNotification();
		Thread.sleep(2000);
		// To add new notification
		home.ClickonAddButton();
		Thread.sleep(2000);
		// To enter notification name
		home.EnterNotificationName(notification);
		Thread.sleep(2000);
		// To enter notification msg
		home.EnetrNotificationMsg(notification1);
		Thread.sleep(2000);
		// To upload notification image
		home.UploadNotificationImage();
		Thread.sleep(2000);
		System.out.println("The image is uploaded");
		// To click on save button
		home.ClickonTheSaveButton();
		System.out.println("The new notification is successfully added");

	}
	@Test(priority = 1, testName = "Sales Return Tab")
	public void SalesReturnTab() throws IOException, InterruptedException {
		 String file = "./TestData/data.properties";
	 	PropertiesFileHandler propFileHandler = new PropertiesFileHandler();
	 	HashMap<String, String> data = propFileHandler.getPropertiesAsMap(file); 
	 	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	 	WebDriver driver = new ChromeDriver();
	 	WebDriverWait wait = new WebDriverWait(driver, 60);
	 	driver.manage().window().maximize();
	 	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String url = data.get("url");
		String userName = data.get("username");
		String password = data.get("password");
        driver.get(url);
        //To get the method created in Admin page
		AdminPage home = new AdminPage(driver, wait);
        //To get the mail id or user name
		home.EnetrEmailAddress(userName);Thread.sleep(2000);
        //To give to password
		home.EnetrPassword(password);Thread.sleep(2000);
        //To give the password
		home.ClickonLoginButton();Thread.sleep(2000);
		//To click on 'Sales' tab
		home.ClickOnSales();Thread.sleep(2000);
		//To click on 'Returns' under 'Sales' tab
		home.ClickOnReturn();
		//As no data in return checking the "No match record is found"
		WebElement text= driver.findElement(By.xpath("//td[@class='dataTables_empty']"));
		String Nodata=text.getText();
		System.out.println(Nodata);
		
		}

}

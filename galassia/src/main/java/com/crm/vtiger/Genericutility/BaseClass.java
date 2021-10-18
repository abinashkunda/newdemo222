package com.crm.vtiger.Genericutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import pompages.Home;
import pompages.Login;

public class BaseClass {
	public FileUtility pLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriver driver;
	
	@BeforeSuite
	//public void connectionDB() {
		//System.out.println("=========DB Connection succsessfull========");
	//}
	
	
	@BeforeClass
	public void launchBrowser() throws Throwable {
		//read data from propertyfile
		//System.out.println("LAUNCHING BROWSER "+BROWSER);
		
		String BROWSER = pLib.getPropertyKeyValue("browser");
		String URL = pLib.getPropertyKeyValue("url");
		
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver= new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")){
			driver= new FirefoxDriver();
		}
		else {
			System.out.println("invalisd browser name");
		}
		System.out.println("======Browser launch suucessful");
		wLib.maximizeWindow(driver);
		wLib.waitUntilPageLoad(driver);
		driver.get(URL);
	}
	@BeforeMethod
	public void loginToApp() throws Throwable {
		//read data from property file
		String USERNAME = pLib.getPropertyKeyValue("username");
		String PASSWORD = pLib.getPropertyKeyValue("password");
		
		//login to App
		Login lp = new Login(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("========login successful========");
	}
	@AfterMethod
	public void logoutToApp() {
		//sign out of home page
		Home hp = new Home(driver);
		hp.logout();
		System.out.println("=====sign out=========");
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
		System.out.println("======browser closed successfully==========");
	}
	
	@AfterSuite
    public void closeDB() {
		//dLib.close();
		System.out.println("======DB connection closed======");
	}

}

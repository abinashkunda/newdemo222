package testScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.pomrepository.Createopportunity;
import com.crm.pomrepository.Home;
import com.crm.pomrepository.Login;
import com.crm.pomrepository.Opportunities;
import com.crm.pomrepository.OrganizationPage;
import com.crm.vtiger.genericutilities2.ExcelUtility;
import com.crm.vtiger.genericutilities2.FileUtility;
import com.crm.vtiger.genericutilities2.JavaUtility;
import com.crm.vtiger.genericutilities2.WebDriverUtility;

public class TC_01 {

	public void test1() throws Throwable {

		 ExcelUtility elib = new ExcelUtility();
		 WebDriverUtility w = new WebDriverUtility();
		 JavaUtility jlib=new JavaUtility();
		 FileUtility flib = new FileUtility();
		 WebDriver driver;
		
		 //read comman data from property file 
		String BROWSER = flib.getPropertyKeyValue("browser");
		String userName = flib.getPropertyKeyValue("username");
		String password = flib.getPropertyKeyValue("password");
		String URL = flib.getPropertyKeyValue("url");
		
		//read the data from excel
		//String opponame = elib.getExcelData("Sheet1",1,1)+"_"+ jlib.getRandomData();
		//String opperName = elib.getExcelData("Sheet1", 2, 1)+"_";
		//load the browser
		if(BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
		}else if 
			(BROWSER.equals("chrome")){
			driver=new ChromeDriver();
		}
		else {
			driver=new ChromeDriver();
		}
		
		
		//load the app
		driver.get(URL);
		driver.manage().window().maximize();
		Login loginPage = new Login(driver);
		loginPage.loginToApp(userName,password );
		
		
		Home homePage = new Home(driver);
		homePage.getOpportunitieslinkElement().click();
		
		 Opportunities opportunitiespage = new Opportunities(driver);
		 opportunitiespage.getOppimgbtnElement().click();
		 
		 
		 
		 Createopportunity createopportunity = new Createopportunity(driver);
		 createopportunity.getReltodisplay().click();
		 
		 Createopportunity opname = new Createopportunity(driver);
		 Thread.sleep(4000);
		 opname.getOpportunitynamElement().sendKeys("qspiders");
		 Thread.sleep(4000);
		 
       w.switchToWindow(driver, "Accounts&action");
       
       OrganizationPage opOrganizations = new OrganizationPage(driver);
       opOrganizations.getOrgpage().click();
       
       w.switchToWindow(driver, "Opportunities");
       Createopportunity create = new Createopportunity(driver);
       homePage.logout();
	}}
}

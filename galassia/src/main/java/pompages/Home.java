package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.Genericutility.WebDriverUtility;



public class Home extends WebDriverUtility {
	WebDriver driver;
	public Home (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	@FindBy(linkText = "Opportunities")
	private WebElement opportunitieslinkElement;

	public WebElement getOpportunitieslinkElement() {
		return opportunitieslinkElement;
	}
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	public WebElement getAdministratorImg() {
		return administratorImg;
	}
	@FindBy(linkText = "Sign Out")
	private WebElement signoutlink;
	public WebElement getSignoutlink() {
		return signoutlink;
	}
	public void logout() {
		mouseOver(driver, administratorImg);
		waitForElementVisibility(driver, signoutlink);
		signoutlink.click();
	}

	}



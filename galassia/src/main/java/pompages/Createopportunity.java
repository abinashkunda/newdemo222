package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.Genericutility.WebDriverUtility;



public class Createopportunity extends WebDriverUtility {
	 WebDriver driver;
	 public Createopportunity(WebDriver driver) {
		 this.driver = driver;
		PageFactory.initElements(driver, this);
	 }
	 @FindBy(name ="potentialname")
	 private WebElement opportunitynamElement;
	 
	 @FindBy(id = "related_to_type")
	    private WebElement relatedto;
	 
	 @FindBy(xpath = "//img[@src='themes/softed/images/layerPopupBg.gif']")
	 private WebElement signout;
	 
	 @FindBy(linkText = "Sign Out")
	 private WebElement signoutlnk;
	 
	 
	 public WebElement getSignoutlnk() {
		return signoutlnk;
	}

	public WebElement getSignout() {
		return signout;
	}
	@FindBy(xpath = "//input[@name=\"related_to_display\"]/following-sibling::img")
	 private WebElement reltodisplay;
	 
	 @FindBy(linkText = "Abinash Kunda")
	 private WebElement contactsname;
	 
	 
	 @FindBy(xpath = "//input[@name=\"related_to_display\"]/following-sibling::img")
	 private WebElement reltoOrg;
	 
	 @FindBy(xpath = "//input[@id='related_to_display']//following-sibling::input")
	 private WebElement erasebtn;
	 
	 public WebElement getErasebtn() {
		return erasebtn;
	}
	@FindBy(name = "button")
	 private WebElement savebtn;
	 
	 
	 
	 
	 public WebElement getReltoOrg() {
		return reltoOrg;
	}

	//getter
	 public WebElement getSavebtn() {
		return savebtn;
	}
	
	public WebElement getContactsname() {
		return contactsname;
	}
	public WebElement getReltodisplay() {
		return reltodisplay;
	}
	public WebElement getOpportunitynamElement() {
		return opportunitynamElement;	
	}
	
	
	
	public WebElement getRelatedto() {
		return relatedto;
	}
	public void logout() {
		mouseOver(driver, signout);
		waitForElementVisibility(driver, signout);
		signoutlnk.click();
	}

	public void opporname(String oppname) {
		opportunitynamElement.sendKeys(oppname);
		
	}

}

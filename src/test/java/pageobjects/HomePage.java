package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	//constructor
	public HomePage(WebDriver driver) {
		super (driver);
		
	}
	
	//locators
	@FindBy(xpath = "//a[@title='My Account']")
	WebElement myaccount;
	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")
	WebElement register;
	@FindBy(xpath = "//a[normalize-space()='Login']")
	WebElement login;
	//methods
	public void clickMyAccount() {
		myaccount.click();
		
	}
	
	public void clickRegister() {
		register.click();
	}
	
	public void clickLogin() {
		login.click();
	}
}



package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	//locators
	@FindBy(xpath ="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement confirm_msg;
	
	@FindBy(xpath = "//h2[normalize-space()='My Account']")
	WebElement confirm_login;
	
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement btn_logout;
	
	//methods
	public String getConfirmMsg() {
		try {
		return confirm_msg.getText();
		} catch(Exception e) {
			return e.getMessage();
		}
	}
	
	public boolean confirmLogin() {
		try {
		return confirm_login.isDisplayed();
		} catch(Exception e) {
			return false;
		}
	}
	
	public void clickLogout() {
		btn_logout.click();
	}
	

}

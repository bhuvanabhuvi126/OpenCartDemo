package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	//locators:

	@FindBy(xpath="//input[@id='input-email']")
	WebElement txt_username;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txt_password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement btn_login;
	
	//action methods
	
	public void setUsername(String uname) {
		txt_username.sendKeys(uname);
	}
	public void setPassword(String pwd) {
		txt_password.sendKeys(pwd);
	}
	public void clickLogin() {
		btn_login.click();
	}
	

}

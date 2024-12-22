package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage{

	public RegisterPage(WebDriver driver) {
		super(driver);
	}
	//locators
	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txt_firstname;
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txt_lastname;
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txt_email;
	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txt_telephone;
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txt_password;
	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement txt_confirmpass;
	@FindBy(xpath = "//label[normalize-space()='Yes']")
	WebElement rdb_newsletter;
	@FindBy(xpath = "//input[@name='agree']")
	WebElement chk_agreement;
	
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btn_submit;
	
	//action methods:
	public void setFirstName(String fname) {
		txt_firstname.sendKeys(fname);
	}
	public void setLastName(String lname) {
		txt_lastname.sendKeys(lname);
	}
	public void setEmail(String email) {
		txt_email.sendKeys(email);
	}
	public void setTelephone(String telephone) {
		txt_telephone.sendKeys(telephone);
	}
	public void setPassword(String pwd) {
		txt_password.sendKeys(pwd);
	}
	public void setConfirmPassword(String cfpwd) {
		txt_confirmpass.sendKeys(cfpwd);
	}
//	public void setNewsLetter() {
//		rdb_newsletter.click();
//	}
	public void setAgreement() {
		chk_agreement.click();
	}
	public void submit() {
		btn_submit.click();
	}
}








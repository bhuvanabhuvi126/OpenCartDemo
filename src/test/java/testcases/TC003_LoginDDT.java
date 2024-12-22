package testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;
import testbase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass{
	@Test(dataProvider="login_credentials", dataProviderClass=DataProviders.class, groups= {"regression","master"})
	public void loginDDT(String username, String password, String status) {
		try {
			logger.info("TC003 started");
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("TC003 CLicked myaccount");
		hp.clickLogin();
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		logger.info("TC003 username set");
		lp.setPassword(password);
		logger.info("TC003 password set");
		lp.clickLogin();
		MyAccountPage map = new MyAccountPage(driver);
		boolean act_result = map.confirmLogin();
		if(status.equalsIgnoreCase("valid")) {
			if(act_result == true) {
				map.clickLogout();
				logger.info("TC003 account has been logged out");
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}
		}
		if(status.equalsIgnoreCase("invalid")) {
			if(act_result == true) {
				map.clickLogout();
				logger.info("TC003 invalid account has been logged out");
				Assert.assertTrue(false);
			} else {
				Assert.assertTrue(true);
			}
		}
	}catch(Exception e) {
		Assert.fail();
	}
		logger.info("TC003 finished");
	} 
	
	

}

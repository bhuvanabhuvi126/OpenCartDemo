package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;
import testbase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
	@Test(groups = {"regression", "master"})
	public void verifyLogin() {
		try {
		logger.info("TC002 started...");
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(pobj.getProperty("username"));
		logger.info("username set");
		lp.setPassword(pobj.getProperty("password"));
		logger.info("password set");
		lp.clickLogin();
		MyAccountPage map = new MyAccountPage(driver);
		boolean status = map.confirmLogin();
		Assert.assertTrue(status);
		} catch(Exception e) {
			Assert.fail();
		}
		logger.info("TC002 Finished.");
	}

}

package testcases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.MyAccountPage;
import pageobjects.RegisterPage;
import testbase.BaseClass;

public class TC001_AccountRegistration extends BaseClass{
	
  @Test(groups = {"sanity", "master"})
  public void registeraccount() {
	  try {
	  logger.info("Starting TC001");
	  HomePage hp = new HomePage(driver);
	  hp.clickMyAccount();
	  hp.clickRegister();
	  RegisterPage rp = new RegisterPage(driver);
	  rp.setFirstName(generateRandomString());
	  logger.info("fname set");
	  rp.setLastName(generateRandomString());
	  rp.setEmail(generateRandomString()+"@gmail.com");
	  logger.info("mail set");
	  rp.setTelephone(generateRandomNumber());
	  String pwd = generateRandomPassword();
	  rp.setPassword(pwd);
	  rp.setConfirmPassword(pwd);
	  logger.info("passwords set");
	  rp.setAgreement();
	  rp.submit();
	  logger.info("Registered Successfully");
	  MyAccountPage map = new MyAccountPage(driver);
	  String act_msg = map.getConfirmMsg();
	  
	  if(act_msg.equals("Your Account Has Been Created!")) {
		  Assert.assertTrue(true);
	  } else {
		  Assert.assertTrue(false);
	  }
	  } catch(Exception e) {
		  Assert.fail();
	  }
	  logger.info("TC001 Finished");
  }

  
}

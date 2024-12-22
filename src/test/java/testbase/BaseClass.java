package testbase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger;
	public Properties pobj;
	@BeforeClass (groups= {"sanity","regression","master"})
	@Parameters({"os","browser"}) 
	public void setup(String os, String br) throws IOException {
	    pobj = new Properties();
		FileReader file = new FileReader("./src//test//resources//config.properties");
		pobj.load(file);
		logger = LogManager.getLogger(this.getClass());
		DesiredCapabilities cap = new DesiredCapabilities();
		
		if(pobj.getProperty("execution_env").equalsIgnoreCase("remote")) {
			switch(os.toLowerCase()) {
				case "windows": cap.setPlatform(Platform.WIN11);break;
				case "linux": cap.setPlatform(Platform.LINUX);break;
				case "mac" : cap.setPlatform(Platform.MAC);break;
				default: System.out.println("no matching os found");return;
			}
			switch(br.toLowerCase()) {
				case "chrome": cap.setBrowserName("chrome");break;
				case "edge": cap.setBrowserName("MicrosoftEdge");break;
				case "firefox": cap.setBrowserName("firefox"); break;
				default:System.out.println("No matching browser found!."); return;
			}
			driver = new RemoteWebDriver( new URL("http://localhost:4444/wd/hub"),cap);
		}
		
		
		
		if(pobj.getProperty("execution_env").equalsIgnoreCase("local")) {
			switch(br.toLowerCase()) {
				case "chrome":driver = new ChromeDriver(); break;
				case "edge": driver = new EdgeDriver(); break;
				case "firefox": driver = new FirefoxDriver(); break;
				default:System.out.println("No matching browser found!."); return;
				}
		}
		
		driver.manage().deleteAllCookies();
		driver.get(pobj.getProperty("appurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	@AfterClass (groups= {"sanity","regression","master"})
	public void teardown() {
		driver.quit();
	}
	
	  public String generateRandomString() {
		  String str = RandomStringUtils.randomAlphabetic(5);
		  return str;
	  }
	  
	  public String generateRandomNumber() {
		  String str = RandomStringUtils.randomNumeric(10);
		  return str;
	  }
	  
	  public String generateRandomPassword() {
		  String str1 = RandomStringUtils.randomAlphabetic(5);
		  String str = RandomStringUtils.randomNumeric(3);
		  return str1+"@"+str;
	  }
	  
	  public String captureScreen(String tname) throws IOException {
		  String timeStamp = new SimpleDateFormat("yyyMMddhhmmss").format(new Date());
		  
		  TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		  File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		  
		  String targetFilePath = System.getProperty("user.dir")+"\\screenshots\\"+ tname + "_" + timeStamp+".png";
		  File targetFile = new File(targetFilePath);
		  
		  sourceFile.renameTo(targetFile);
		  
		  return targetFilePath;
	  }

}

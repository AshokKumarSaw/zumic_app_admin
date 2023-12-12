package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
//import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import utilities.ActionUtil;

public class BaseClass {
	public static WebDriver driver;
	public Logger logger;
	public ResourceBundle rb;
//	public Properties properties;
	HomePage homePage;
	LoginPage loginPage;

	@BeforeClass(groups = { "sanity", "master", "regression" })
	@Parameters("browser")
	public void setup(String br) throws IOException {
		logger = LogManager.getLogger(this.getClass());
		rb = ResourceBundle.getBundle("config"); // To read data from config.properties file

		/*
		 * File file = new File(".\\src\\test\\resources\\config.properties");
		 * FileInputStream fileInputStream = new FileInputStream(file); Properties
		 * properties = new Properties(); properties.load(fileInputStream);
		 */

		/*
		 * ChromeOptions options = new ChromeOptions();
		 * options.setExperimentalOption("excludeSwitches", new String[] {
		 * "enable-automation" }); driver = new ChromeDriver(options);
		 */

		/*
		 * ChromeOptions options = new ChromeOptions();
		 * options.setAcceptInsecureCerts(true); driver = new ChromeDriver(options);
		 */

		/*
		 * ChromeOptions options = new ChromeOptions();
		 * options.addArguments("--headless"); driver = new ChromeDriver(options);
		 */

		if (br.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (br.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new FirefoxDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(rb.getString("applicationUrl"));
		// driver.get(properties.getProperty("applicationUrl"));
		driver.manage().window().maximize();

		// Login into the application
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(rb.getString("username"), rb.getString("password"));

	}

	@AfterClass(groups = { "sanity", "master", "regression" })
	public void tearDown() 
	{
		homePage=new HomePage(driver);
		homePage.logout();
		loginPage = new LoginPage(driver);
		loginPage.validateLoggedOut();
		driver.quit();
		
	}

	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}

}

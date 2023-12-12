package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utilities.ActionUtil;

public class HomePage extends BasePage {
	public WebDriverWait explicitWait;
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	// Element
	@FindBy(xpath = "//a[@class='dropdown-toggle']//img")
	public WebElement drpdwnMyAccount;
	@FindBy(xpath = "//a[normalize-space()='Logout']")
	public WebElement lnkLogout;
	@FindBy(xpath = "//span[normalize-space()='Events']")
	public WebElement menuEvent;
	@FindBy(xpath = "//a[normalize-space()='Events List']")
	public WebElement submenuEventlist;
	// Element TC_0002
	@FindBy(xpath = "//span[normalize-space()='New']")
	public WebElement drpdwnNew;

	@FindBy(xpath = "//a[normalize-space()='Manager']")
	public WebElement drpdwnOptionManager;

	// Method

	/**
	 * Method would check whether Logout feature is displayed or not When User is
	 * Logged In Successfully into the Application
	 * 
	 * @return
	 */
	public boolean validateLoggedIn() {

		ActionUtil.click(drpdwnMyAccount);
		boolean result = lnkLogout.isDisplayed();
		Assert.assertTrue(validateLoggedIn(), "Logout button is not visible. User may not be logged in.");
		
		logger.info("User LogIn is Validated Successfully");
		return result;

	}

	/**
	 * Click on Event Menu and Subsequently Event List Sub Menu
	 */
	public void clickEventAndEventList() {
		ActionUtil.click(menuEvent);
		ActionUtil.click(submenuEventlist);
		logger.info("Clicked on Event Menu and Subsequently Event List Sub Menu");
	}

	/**
	 * Click on +NEW Dropdown Displayed on Top of Page And Select Manager
	 */

	public void goToAdminPage() {
		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		explicitWait.until(ExpectedConditions.elementToBeClickable(drpdwnNew)).click();
		explicitWait.until(ExpectedConditions.elementToBeClickable(drpdwnOptionManager)).click();
		logger.info("Clicked on +NEW Dropdown Displayed on Top of Page And Selected Manager");

	}
	
	/**
	 * Click on MyAccount Dropdown and Logout Link Subsequently
	 */
	public void logout()
	{	
	ActionUtil.click(drpdwnMyAccount);
	ActionUtil.click(lnkLogout);
	logger.info("User is Logged Out Successfully by clicking on Logout Link");
	}
}

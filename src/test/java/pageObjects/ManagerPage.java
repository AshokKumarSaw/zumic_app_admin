package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ActionUtil;

public class ManagerPage extends BasePage {
	public WebDriverWait explicitWait;
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public ManagerPage(WebDriver driver) {
		super(driver);
	}

	// Element
	@FindBy(xpath = "//input[@name='login']")
	WebElement inputUsername;

	@FindBy(xpath = "//input[@name='email']")
	WebElement inputEmail;

	@FindBy(xpath = "//input[@name='first_name']")
	WebElement inputFirstname;

	@FindBy(xpath = "//input[@name='last_name']")
	WebElement inputLastname;

	@FindBy(xpath = "//input[@name='password']")
	WebElement inputPassword;

	@FindBy(xpath = "//input[@name='repassword']")
	WebElement inputConfirmPassword;

	@FindBy(xpath = "//label[normalize-space()='Administrator']")
	WebElement chkboxAdmin;

	@FindBy(xpath = "//label[normalize-space()='Manager']")
	WebElement chkboxManager;

	@FindBy(xpath = "//label[normalize-space()='Test-Group']")
	WebElement chkboxTestgroup;

	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement btnSave;

	@FindBy(xpath = "//a[normalize-space()='Managers']")
	WebElement lnkManagers;

	// Method
	
/**
 * Manager details as shown below would be passed as input to the respective fields
 * @param username
 * @param email
 * @param fname
 * @param lname
 * @param password
 * @param confirmpassword
 */
	public void setManagerDetail(String username,String email,String fname,String lname,String password,String confirmpassword) {
		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		explicitWait.until(ExpectedConditions.elementToBeClickable(inputUsername)).sendKeys(username);
		inputEmail.sendKeys(email);
		inputFirstname.sendKeys(fname);
		inputLastname.sendKeys(lname);
		inputPassword.sendKeys(password);
		inputConfirmPassword.sendKeys(confirmpassword);
		logger.info("The Manager details username, email, fname, lname, password,confirmpassword are passed as input successfully" );
	}

	/**
	 * Authorization group would be selected,Manager is Saved and User is navigated to Manager's list page
	 */

	public void selectAccessGroupSavemanagerAndNavigateToManagerList() {
		ActionUtil.scrollWebPage(0, 500, (JavascriptExecutor) driver);
		ActionUtil.click(chkboxAdmin);
		ActionUtil.click(chkboxManager);
		ActionUtil.click(chkboxTestgroup);
		ActionUtil.click(btnSave);
		ActionUtil.scrollWebPage(0, -1000, (JavascriptExecutor) driver);
		ActionUtil.click(lnkManagers);
		logger.info("Authorization group is selected,Manager is Saved and User is navigated to Manager's list page");
	}

	

	
}

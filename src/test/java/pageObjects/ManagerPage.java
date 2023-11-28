package pageObjects;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

	public void setUsername(String username) {
		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		explicitWait.until(ExpectedConditions.elementToBeClickable(inputUsername)).sendKeys(username);
	}

	public void setEmail(String email) {
		inputEmail.sendKeys(email);
	}

	public void setFname(String fname) {
		inputFirstname.sendKeys(fname);
	}

	public void setLname(String lname) {
		inputLastname.sendKeys(lname);
	}

	public void setPassword(String password) {
		inputPassword.sendKeys(password);
	}

	public void confirmPassword(String confirmpassword) {
		inputConfirmPassword.sendKeys(confirmpassword);
	}

	public void selectAuthorizationGroup() {
		js.executeScript("window.scrollBy(0,500)");
		chkboxAdmin.click();
		chkboxManager.click();
		chkboxTestgroup.click();
	}

	public void saveNewlyCreatedManager() {
		btnSave.click();
	}

	public void goToAdministrationList() {
		js.executeScript("window.scrollBy(0,-1000)");
		lnkManagers.click();
	}

	public void handleAlertIfPresent() {

		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));
		explicitWait.until(ExpectedConditions.alertIsPresent());

		// Check if the alert is present
		if (isAlertPresent(driver)) {
			// Handle the alert
			Alert alert = driver.switchTo().alert();
			System.out.println("Alert text: " + alert.getText());
			alert.accept(); // You can use alert.dismiss() to dismiss the alert instead
		} else {
			System.out.println("No alert appeared.");
		}

	}

	public static boolean isAlertPresent(WebDriver driver) {
		try {
			// Attempt to switch to an alert; if successful, it means the alert is present
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			// If NoAlertPresentException is thrown, it means the alert is not present
			return false;
		}
	}
}

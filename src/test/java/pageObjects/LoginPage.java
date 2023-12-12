package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import utilities.ActionUtil;

public class LoginPage extends BasePage {
	public LoginPage(WebDriver driver) {
		super(driver);
	}

//Elements

	@FindBy(xpath = "//input[@placeholder='Username']")
	public WebElement txtUsername;
	@FindBy(xpath = "//input[@placeholder='Password']")
	public WebElement txtPassword;
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement btnLogin;

	// Methods

	/**
	 * User would login into the application
	 * 
	 * @param username
	 * @param password
	 */
	public void login(String username, String password) {
		txtUsername.sendKeys(username);
		txtPassword.sendKeys(password);
		Assert.assertEquals(txtUsername.getAttribute("value"), username,
				"The actual username used for logging into the application does not match the expected username");

		Assert.assertEquals(txtPassword.getAttribute("value"), password,
				"The actual password used for logging into the application does not match the expected password");

		btnLogin.click();
		logger.info("User entered correct username,password and clicked on Login button");
	}

	/**
	 * Method would check whether LogIn button is displayed or not When User is
	 * LoggedOut Successfully from the Application
	 * @throws InterruptedException 
	 * 
	 * 
	 */
	public void validateLoggedOut()  {

		Assert.assertTrue(btnLogin.isDisplayed(), "Login button is not visible. User may not be logged out.");
		logger.info("User Logout is Validated Successfully");
		
	}

}

package pageObjects;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdministrationListPage extends BasePage {
	public WebDriverWait explicitWait;

	public AdministrationListPage(WebDriver driver) {
		super(driver);
	}

	// Element
	@FindBy(xpath = "//input[@type='search']")
	WebElement inputSearch;

	@FindBy(xpath = "(//td[contains(text(),'Advika')])[1]")
	public WebElement exactUsernameToBeDeleted;

	@FindBy(xpath = "//i[@class='icon-trash']")
	WebElement iconDelete;

	// Method

	public void searchNewlyCreatedAdminByName(String username) {
		inputSearch.sendKeys(username);
	}

	public void deleteAdmin() {
		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));
		explicitWait.until(ExpectedConditions.elementToBeClickable(iconDelete)).click();
		// iconDelete.click();
		driver.switchTo().alert().accept();

	}

	public void handleAlertIfPresent() {

		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));
		try {
			explicitWait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			System.out.println("Alert text: ......................" + alert.getText()); // You can use alert.dismiss() to dismiss the alert
																	// instead
			alert.accept();
		} catch (Exception e) {
			// No alert present, continue with the rest of your code

			System.out.println("No alert found. Continuing with the rest of the code.");
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

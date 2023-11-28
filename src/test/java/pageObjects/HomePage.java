package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
	public WebDriverWait explicitWait;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	public HomePage(WebDriver driver) {
		super(driver);
	}

	// Element TC_0001
	@FindBy(xpath = "//a[@class='dropdown-toggle']//img")
	WebElement drpdwnMyAccount;
	@FindBy(xpath = "//a[normalize-space()='Logout']")
	WebElement lnkLogout;
	@FindBy(xpath = "//span[normalize-space()='Events']")
	WebElement menuEvent;
	@FindBy(xpath = "//a[normalize-space()='Events List']")
	WebElement submenuEventlist;
	// Element TC_0002
	@FindBy(xpath="//span[normalize-space()='New']")
	WebElement drpdwnNew;
	
	@FindBy(xpath="//a[normalize-space()='Manager']")
	WebElement drpdwnOptionManager;
	
	
	// Methods TC_0001
	public void clickMyAccountDrpdwn() {
		drpdwnMyAccount.click();
	}
	

	public void clickLogout() {
		drpdwnMyAccount.click();
		lnkLogout.click();
	}
	
	public boolean validateLoggedIn()
	{
		drpdwnMyAccount.click();
	    boolean result=lnkLogout.isDisplayed();
	    return 	result;
	}
	


	public void clickEvent() {
		menuEvent.click();
	}

	public void clickEvenlist() {
		submenuEventlist.click();
	}
	// Methods TC_0002
	
	public void goToAdminPage()
	{
	//	js.executeScript("window.scrollBy(0,800)");
		explicitWait=new WebDriverWait(driver,Duration.ofSeconds(10));
		explicitWait.until(ExpectedConditions.elementToBeClickable(drpdwnNew)).click();
		explicitWait.until(ExpectedConditions.elementToBeClickable(drpdwnOptionManager)).click();
		
		//drpdwnNew.click();
	//	drpdwnOptionManager.click();
	}
	
	
}

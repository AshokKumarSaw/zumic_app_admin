package pageObjects;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdministrationListPage extends BasePage{
	public WebDriverWait explicitWait;
	public AdministrationListPage(WebDriver driver) {
		super(driver);
	}
	// Element
		@FindBy(xpath="//input[@type='search']")
		WebElement inputSearch;
		
		@FindBy(xpath="//i[@class='icon-trash']")
		WebElement iconDelete;
		
		
	
	//Method
		
		public void searchNewlyCreatedAdminByName(String username)
		{
			inputSearch.sendKeys(username);
		}
		
		public void deleteAdmin()
		{
			explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));
			explicitWait.until(ExpectedConditions.elementToBeClickable(iconDelete)).click();
		//	iconDelete.click();
			driver.switchTo().alert().accept();
			
		}
		
	
}

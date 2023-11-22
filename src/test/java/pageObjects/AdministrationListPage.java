package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdministrationListPage extends BasePage{
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
			iconDelete.click();
			driver.switchTo().alert().accept();
			
		}
		
	
}

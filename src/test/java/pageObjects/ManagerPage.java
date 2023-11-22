package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManagerPage extends BasePage {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	public ManagerPage(WebDriver driver) {
		super(driver);
	}
	// Element
	@FindBy(xpath="//input[@name='login']")
	WebElement inputUsername;
	
	@FindBy(xpath="//input[@name='email']")
	WebElement inputEmail;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement inputFirstname;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement inputLastname;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement inputPassword;
	
	@FindBy(xpath="//input[@name='repassword']")
	WebElement inputConfirmPassword;
	
	@FindBy(xpath="//label[normalize-space()='Administrator']")
	WebElement chkboxAdmin;
	
	@FindBy(xpath="//label[normalize-space()='Manager']")
	WebElement chkboxManager;
	
	@FindBy(xpath="//label[normalize-space()='Test-Group']")
	WebElement chkboxTestgroup;
	
	@FindBy(xpath="//button[normalize-space()='Save']")
	WebElement btnSave;
	
	@FindBy(xpath="//a[normalize-space()='Managers']")
	WebElement lnkManagers;
	
	
	//Method
	
	public void setUsername(String username)
	{
		
		inputUsername.sendKeys(username);
	}
	
	public void setEmail(String email)
	{
		inputEmail.sendKeys(email);
	}
	
	public void setFname(String fname)
	{
		inputFirstname.sendKeys(fname);
	}
	
	public void setLname(String lname)
	{
		inputLastname.sendKeys(lname);
	}
	
	public void setPassword(String password)
	{
		inputPassword.sendKeys(password);
	}
	public void confirmPassword(String confirmpassword)
	{
		inputConfirmPassword.sendKeys(confirmpassword);
	}
	
	public void selectAuthorizationGroup()
	{
		js.executeScript("window.scrollBy(0,500)");
		chkboxAdmin.click();
		chkboxManager.click();
		chkboxTestgroup.click();
	}
	
	public void saveNewlyCreatedManager()
	{
		btnSave.click();
	}
	public void goToAdministrationList()
	{
		js.executeScript("window.scrollBy(0,-1000)");
		lnkManagers.click();
	}
}

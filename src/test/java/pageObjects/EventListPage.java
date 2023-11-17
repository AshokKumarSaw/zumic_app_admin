package pageObjects;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EventListPage extends BasePage {
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	public JavascriptExecutor js = (JavascriptExecutor) driver;
	public EventListPage(WebDriver driver) {
		super(driver);
	}

//Element
	@FindBy(xpath = "//a[normalize-space()='Create']")
	WebElement btnCreate;

	@FindBy(xpath = "//input[@id='event-name-input']")
	WebElement inputTitle;

	@FindBy(xpath = "//input[@name='date']")
	WebElement inputStartdate;

	@FindBy(xpath = "(//button[contains(text,Today)])[1]")
	WebElement inputTodaydate;
	
	@FindBy(xpath = "//div[@class='select2-result-repository clearfix']")
	WebElement drpdwnVenue;
	
	@FindBy(xpath = "//span[@class='select2-search select2-search--dropdown']//input[@role='textbox']")
	WebElement venueSearch;
	

	@FindBy(xpath = "//input[@name='event_time']")
	WebElement drpdwnEventtime;

	@FindBy(xpath = "(//li[@role='option'][normalize-space()='7:00 AM'])[2]")
	WebElement eventTimeselection;

	@FindBy(xpath = "//input[@name='search_tags']")
	WebElement inputArtistname;
	@FindBy(xpath = "//button[normalize-space()='Add']")
	WebElement btnAddArtist;

	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement btnSave;

	@FindBy(xpath = "//a[normalize-space()='Delete']")
	WebElement btnDelete;

	@FindBy(xpath = "//button[normalize-space()='Delete']")
	WebElement btnConfirmDelete;

	// Methods

	public void clickCreate() {
		btnCreate.click();
	}

	public void randomAlphaNumericEventTitle(String title) {
		String generatedString = RandomStringUtils.randomAlphabetic(8);
		String generatedNumber = RandomStringUtils.randomNumeric(8);
		inputTitle.sendKeys(generatedString + generatedNumber);
	}

	public void eventStartDate() {
		
		js.executeScript("window.scrollBy(0,150)");
		inputStartdate.click();
		inputTodaydate.click();

	}

	public void selectEventTime() {
		drpdwnEventtime.click();
		eventTimeselection.click();
	}

	public void addEventVenue() throws InterruptedException
	{
		drpdwnVenue.click();
		venueSearch.sendKeys("New York");
		Thread.sleep(5000);
		venueSearch.sendKeys(Keys.ENTER);
		
	}
	public void addArtist() throws InterruptedException
	{
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(5000);
		inputArtistname.sendKeys("Ashok");
		btnAddArtist.click();
	}
	public void saveEvent() throws InterruptedException
	{
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(5000);
		btnSave.click();
	}
	public void deleteSavedEvent() 
	{
		
		
		btnDelete.click();
	}
	public void confirmDelete()
	{
		btnConfirmDelete.click();
		
//		Alert alert = driver.switchTo().alert();
//		alert.accept();
	}
	
	
}

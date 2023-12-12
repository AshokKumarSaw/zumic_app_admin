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

import utilities.ActionUtil;

public class EventListPage extends BasePage {
	WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
	public JavascriptExecutor js = (JavascriptExecutor) driver;

	public EventListPage(WebDriver driver) {
		super(driver);
	}

//Element
	@FindBy(xpath = "//a[normalize-space()='Create']")
	public WebElement btnCreate;

	@FindBy(xpath = "//input[@id='event-name-input']")
	public WebElement inputEventTitle;

	@FindBy(xpath = "//input[@name='date']")
	public WebElement inputStartdate;

	@FindBy(xpath = "(//button[contains(text,Today)])[1]")
	public WebElement inputTodaydate;

	@FindBy(xpath = "//div[@class='select2-result-repository clearfix']")
	public WebElement drpdwnVenue;

	@FindBy(xpath = "//span[@class='select2-search select2-search--dropdown']//input[@role='textbox']")
	public WebElement venueSearch;

	@FindBy(xpath = "//input[@name='event_time']")
	public WebElement drpdwnEventtime;

	@FindBy(xpath = "(//li[@role='option'][normalize-space()='7:00 AM'])[2]")
	public WebElement eventTimeselection;

	@FindBy(xpath = "//input[@name='search_tags']")
	public WebElement inputArtistname;
	@FindBy(xpath = "//button[normalize-space()='Add']")
	public WebElement btnAddArtist;

	@FindBy(xpath = "//button[normalize-space()='Save']")
	public WebElement btnSave;

	@FindBy(xpath = "//a[normalize-space()='Delete']")
	public WebElement btnDelete;

	@FindBy(xpath = "//button[normalize-space()='Delete']")
	public WebElement btnConfirmDelete;

	// Methods
	/**
	 * Click on create button in Event List Page and Enter Random Alpha Numeric
	 * Characters as Event Name
	 */
	public void clickCreateAndAddEventTitle() {
		ActionUtil.click(btnCreate);
		ActionUtil.generateAndSendRandomAlphaNumericToInput(inputEventTitle);
		logger.info("Clicked Create and Added Random Alpha Numeric Characters as Event Name");
	}

	/**
	 * Select Start Date And Time for the Event
	 */
	public void eventStartDateAndTime() {
		ActionUtil.scrollWebPage(0, 150, (JavascriptExecutor) driver);
		ActionUtil.click(inputStartdate);
		ActionUtil.click(inputTodaydate);
		ActionUtil.click(drpdwnEventtime);
		ActionUtil.click(eventTimeselection);
		logger.info("Selected Start Date And Time for The Event ");

	}

	/**
	 * 
	 * Enter Event Venue And Select It From The Options Displayed
	 */

	public void addEventVenue() {
		ActionUtil.click(drpdwnVenue);
		venueSearch.sendKeys("New York");
		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));
		explicitWait.until(ExpectedConditions.elementToBeClickable(venueSearch)).sendKeys(Keys.ENTER);
		logger.info("Event Venue Added");

	}

	/**
	 * 
	 * Add Artist For The Event
	 */

	public void addArtist() {
		ActionUtil.scrollWebPage(0, 500, (JavascriptExecutor) driver);
		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));
		explicitWait.until(ExpectedConditions.elementToBeClickable(inputArtistname)).sendKeys("Ashok");
		ActionUtil.click(btnAddArtist);
		logger.info("Artist Name of the Event Added");
	}

	/**
	 * 
	 * Event is Saved
	 */
	public void saveEvent() {
		ActionUtil.scrollWebPage(0, 500, (JavascriptExecutor) driver);
		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));
		explicitWait.until(ExpectedConditions.elementToBeClickable(btnSave)).click();
		logger.info("The Event is saved successfully");

	}

	/**
	 * 
	 * Event is Deleted
	 */
	public void deleteEventAndConfirmDelete() {
		ActionUtil.click(btnDelete);
		ActionUtil.click(btnConfirmDelete);
		logger.info("The Event is Deleted successfully");
	}

}

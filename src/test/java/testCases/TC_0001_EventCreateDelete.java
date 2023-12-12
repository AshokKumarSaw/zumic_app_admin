package testCases;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.EventListPage;
import pageObjects.HomePage;
import testBase.BaseClass;
import utilities.ActionUtil;

public class TC_0001_EventCreateDelete extends BaseClass {
	public WebDriverWait explicitWait;

	@Test(groups = { "sanity", "master" })
	public void tesEeventCreationDeletion() {
		logger.info("*** Starting TC_0001_Event_Creation_Deletion ***");
		try {
			HomePage homePage = new HomePage(driver);
			homePage.clickEventAndEventList();
			EventListPage eventListPage = new EventListPage(driver);
			eventListPage.clickCreateAndAddEventTitle();
			eventListPage.eventStartDateAndTime();
			eventListPage.addEventVenue();
			eventListPage.addArtist();
			eventListPage.saveEvent();
			eventListPage.deleteEventAndConfirmDelete();
		} catch (Exception e) {
			Assert.fail("Test Method tesEeventCreationDeletion in Test Script TC_0001_EventCreateDelete is Failed");
		}

		logger.info("*** Finished TC_0001_Event_Creation_Deletion ***");
	}
}

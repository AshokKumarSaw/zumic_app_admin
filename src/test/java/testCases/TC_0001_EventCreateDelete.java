package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.EventListPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_0001_EventCreateDelete extends BaseClass {

	@Test(groups = { "sanity", "master" })
	public void tesEeventCreationDeletion() {
		logger.info("*** Starting TC_0001_Event_Creation_Deletion ***");
		try {
			HomePage homePage = new HomePage(driver);
			homePage.clickEvent();
			logger.info("Event Menu Clicked");
			homePage.clickEvenlist();
			logger.info("Event List SubMenu Clicked");
			EventListPage eventListPage = new EventListPage(driver);
			eventListPage.clickCreate();
			logger.info("Clicked on Create Button in the Event List Page");
			eventListPage.randomAlphaNumericEventTitle("title");
			logger.info("Random Alphanumeric Event Name Entered");
			eventListPage.eventStartDate();
			logger.info("Today's Date Selected From Calender");
			eventListPage.selectEventTime();
			logger.info("Event Time Selected");
			eventListPage.addEventVenue();
			logger.info("Event Venue Added");
			eventListPage.addArtist();
			logger.info("Artist Name of the Event Added");
			eventListPage.saveEvent();
			logger.info("Event is Saved Successfully");	
			eventListPage.deleteSavedEvent();
			logger.info("Clicked on Delete Button to Delete the Saved Event");
			eventListPage.confirmDelete();
			logger.info("Deletion of the Event is Confirmed");

		} catch (Exception e) {
			Assert.fail("Test Method tesEeventCreationDeletion in Test Script TC_0001_EventCreateDelete is Failed");
		}

		logger.info("*** Finished TC_0001_Event_Creation_Deletion ***");
	}
}

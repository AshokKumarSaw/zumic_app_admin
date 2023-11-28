package testCases;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Durations;
import pageObjects.AdministrationListPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ManagerPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_0002_RegisterNewAdmin extends BaseClass {

	@Test(groups = { "sanity" }, dataProvider = "NewAdminAccountData", dataProviderClass = DataProviders.class)
	public void testNewAdminCreation(String username, String email, String fname, String lname, String password,
			String confirmpassword) {
		logger.info("*** Starting TC_0002_RegisterNewAdmin ***");
		try {
			HomePage homePage = new HomePage(driver);
			homePage.goToAdminPage();
			logger.info("Navigated to the Manager or Admin Page");
			ManagerPage managerPage = new ManagerPage(driver);
			managerPage.setUsername(username);
			logger.info("Username is Set");
			managerPage.setEmail(email);
			logger.info("Email is set");
			managerPage.setFname(fname);
			logger.info("First Name is set");
			managerPage.setLname(lname);
			logger.info("Last Name is set");
			managerPage.setPassword(password);
			logger.info("Password is set");
			managerPage.confirmPassword(confirmpassword);
			logger.info("Password is reconfirmed");
			managerPage.selectAuthorizationGroup();
			logger.info("Authorization groups are selected");
			managerPage.saveNewlyCreatedManager();
			logger.info("Admin Accont is created successfully");
			managerPage.goToAdministrationList();
			logger.info("Admin is on administartion List page");
			AdministrationListPage administrationListPage = new AdministrationListPage(driver);
			administrationListPage.searchNewlyCreatedAdminByName(username);
			logger.info("Admin is searched using username on the administration list page");
			administrationListPage.deleteAdmin();
			logger.info("Newly created admin is deleted successfully");
			managerPage.handleAlertIfPresent();
			
			
			
		} catch (Exception e) {
			Assert.fail("Test Method testNewAdminCreation in Test Script TC_0002_RegisterNewAdmin is Failed");
		}

		logger.info("*** Finished TC_0002_RegisterNewAdmin ***");
	}
}

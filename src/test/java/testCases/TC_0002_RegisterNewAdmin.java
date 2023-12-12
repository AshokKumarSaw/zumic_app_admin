package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AdministrationListPage;
import pageObjects.HomePage;
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
			ManagerPage managerPage = new ManagerPage(driver);
			managerPage.setManagerDetail(username, email, fname, lname, password, confirmpassword);
			managerPage.selectAccessGroupSavemanagerAndNavigateToManagerList();
			AdministrationListPage administrationListPage = new AdministrationListPage(driver);
			administrationListPage.searchNewlyCreatedAdminByNameAndDelete(username);		
			administrationListPage.handleAlertIfPresent();

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Test Method testNewAdminCreation in Test Script TC_0002_RegisterNewAdmin is Failed");
		}

		logger.info("*** Finished TC_0002_RegisterNewAdmin ***");
	}
}

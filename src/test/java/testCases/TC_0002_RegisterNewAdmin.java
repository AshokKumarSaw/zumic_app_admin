package testCases;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ManagerPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_0002_RegisterNewAdmin extends BaseClass {
	@Test(groups = { "sanity",
			"master" }, dataProvider = "NewAdminAccountData", dataProviderClass = DataProviders.class)
	public void testNewAdminCreation(String username, String email, String fname, String lname, String password,
			String confirmpassword) {
		logger.info("*** Starting TC_0002_RegisterNewAdmin ***");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setLoginUsername(rb.getString("username"));
		logger.info("Username Entered");
		loginPage.setLoginPassword(rb.getString("password"));
		logger.info("Password Entered");
		loginPage.clickBtnLogin();
		logger.info("Clicked on Login Button");
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
		homePage.clickLogout();
		logger.info("Clicked on My Account Icon and subsequently Logout Link");
		logger.info("*** Finished TC_0002_RegisterNewAdmin ***");
	}
}
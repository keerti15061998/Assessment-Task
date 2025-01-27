package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginAccountPage;
import utilities.ExtentReportManager;
import utilities.TestData;

public class TC002_LoginAccount extends BaseClass {

	@Test
	void verify_account_signin() {

		// Instantiate the LoginAccountPage object
		LoginAccountPage signIn = new LoginAccountPage(driver);
		test = ExtentReportManager.createTest("Login Test");

		try {
			signIn.navigateToSignIn();
			test.info("Navigated to Sign In Page");

			signIn.Email(TestData.LOGIN_EMAIL);
			signIn.Password(TestData.LOGIN_PASSWORD);
			signIn.clickSignIN();
			test.info("Entered credentials and clicked Sign In");

			if (signIn.isSignInErrorDisplayed()) {
				String errorMsg = signIn.getSignInErrorMessage();
				test.fail("Login failed with error: " + errorMsg);
				Assert.fail("Login attempt failed: " + errorMsg);
			} else if (signIn.isSignInSuccessful()) {
				test.pass("Login successful for registered user!");
			} else {
				test.fail("Login failed: Unexpected state");
				Assert.fail("Login attempt failed: Unexpected state");
			}

		} catch (Exception e) {
			test.fail("Login test failed: " + e.getMessage());
			Assert.fail("Test failed due to exception: " + e.getMessage());
		}
	}
}

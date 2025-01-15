package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginAccountPage;
import utilities.TestData;

public class TC002_LoginAccount extends BaseClass {

	@Test
	void verify_account_signin() {

		// Instantiate the LoginAccountPage object
		LoginAccountPage signIn = new LoginAccountPage(driver);

		// Navigate to the Sign In page
		signIn.navigateToSignIn();

		// Enter login credentials
		signIn.Email(TestData.LOGIN_EMAIL);
		signIn.Password(TestData.LOGIN_PASSWORD);

		// Click the Sign In button
		signIn.clickSignIN();

		// Validate login outcome
		if (signIn.isSignInErrorDisplayed()) {
			// Handle login failure
			String errorMessage = signIn.getSignInErrorMessage();
			System.out.println("Login failed for registered user!");
			System.out.println("Error message: " + signIn.getSignInErrorMessage());
			Assert.fail("Login attempt failed for registered user.Error: " + errorMessage);
		} else {
			// Check if login is successful
			boolean isSignInMessageDisplayed = signIn.isSignInSuccessful();
			boolean isRedirected = signIn.isRedirectedToAccountDashboard();

			if (isSignInMessageDisplayed || isRedirected) {
				System.out.println("Login successful for registered user!");
			} else {
				System.out.println("Login failed for registered user!");
				Assert.fail("Login attempt failed for registered user.");
			}
		}

	}

}

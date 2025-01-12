package testCases;

import org.testng.annotations.Test;
import org.testng.Assert;
import pageObjects.LoginAccountPage;
import utilities.TestData;

public class TC002_LoginAccount extends BaseClass {

	@Test
	void verify_account_registration() {

		LoginAccountPage signIn = new LoginAccountPage(driver);
		signIn.navigateToSignIn();
		signIn.Email(TestData.LOGIN_EMAIL);
		signIn.Password(TestData.LOGIN_PASSWORD);
		signIn.clickSignIN();
		String expectedTitle = "Customer Login";
		String actualTitle = signIn.getPageTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Sign-In failed. Titles do not match.");
	}

}

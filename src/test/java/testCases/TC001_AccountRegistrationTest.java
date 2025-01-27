package testCases;

import org.testng.annotations.Test;
import org.testng.Assert;
import pageObjects.AccountRegistrationPage;
import utilities.ExtentReportManager;
import utilities.TestData;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test
	void verify_account_registration() {

		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		test = ExtentReportManager.createTest("Account Registration Test");

		try {
			// Navigate to the "Create Account" page
			regpage.navigateToCreateAccount();
			test.info("Navigated to Create Account page.");

			// Fill in registration details
			regpage.setFirstName(TestData.FIRST_NAME);
			regpage.setLastName(TestData.LAST_NAME);
			regpage.setEmail(TestData.EMAIL);
			regpage.setPassword(TestData.PASSWORD);
			regpage.setCnfPassword(TestData.CONFIRM_PASSWORD);
			regpage.clickSubmit();
			test.info("Filled in all registration details.");

			String confirmationMsg = regpage.getConfirmationMsg();
			Assert.assertEquals(confirmationMsg, "Thank you for registering with Main Website Store.");
			test.pass("Account registration successful: " + confirmationMsg);

		} catch (Exception e) {
			test.fail("Account registration failed: " + e.getMessage());
			Assert.fail("Test failed due to exception: " + e.getMessage());
		}
	}
}

package testCases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import org.testng.AssertJUnit;
import pageObjects.AccountRegistrationPage;
import utilities.TestData;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test
	void verify_account_registration() {
		test = extent.createTest("Verify Account Registration");
		test.log(Status.INFO, "Navigated to Magento website");
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		regpage.navigateToCreateAccount();
		regpage.setFirstName(TestData.FIRST_NAME);
		regpage.setLastName(TestData.LAST_NAME);
		regpage.setEmail(TestData.EMAIL);
		regpage.setPassword(TestData.PASSWORD);
		regpage.setCnfPassword(TestData.CONFIRM_PASSWORD);
		regpage.clickSubmit();
		
		String cnf = regpage.getConfirmationMsg();
		AssertJUnit.assertEquals(cnf, "Thank you for registering with Main Website Store.");
		
	}

}

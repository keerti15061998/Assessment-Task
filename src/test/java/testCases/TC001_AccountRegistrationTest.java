package testCases;

import org.testng.annotations.Test;
import org.testng.Assert;
import pageObjects.AccountRegistrationPage;
import utilities.TestData;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test
	void verify_account_registration() {
		
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		
		// Navigate to the "Create Account" page
		regpage.navigateToCreateAccount();
		System.out.println("Navigated to Create Account page.");
		
		// Fill in registration details
		regpage.setFirstName(TestData.FIRST_NAME);
		regpage.setLastName(TestData.LAST_NAME);
		regpage.setEmail(TestData.EMAIL);
		regpage.setPassword(TestData.PASSWORD);
		regpage.setCnfPassword(TestData.CONFIRM_PASSWORD);
		System.out.println("Filled in all registration details.");
		
		// Submit the registration form
		regpage.clickSubmit();
		System.out.println("Clicked the Submit button.");
		
		
		
		 // Handle both success and error cases
	    if (regpage.isErrorDisplayed()) {
	        // Email already exists
	        String errorMsg = regpage.getErrorMsg();
	        System.out.println("Account registration failed.");
	        System.out.println("Error message: " + errorMsg);
	        Assert.assertEquals(errorMsg, "There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.");
	    } else {
	        // Verify success message
	        String confirmationMsg = regpage.getConfirmationMsg();
	        Assert.assertEquals(confirmationMsg, "Thank you for registering with Main Website Store.");
	        System.out.println("Account registration successful!");
	    }
		
	}

}

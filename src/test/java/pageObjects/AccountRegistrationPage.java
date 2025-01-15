package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);

	}
	// Locators

	@FindBy(xpath = "//a[contains(text(),'Create an Account')]")
	private WebElement createAccountCTA;

	@FindBy(xpath = "//input[@id='firstname']")
	private WebElement txtFirstName;

	@FindBy(xpath = "//input[@id='lastname']")
	private WebElement txtLastName;

	@FindBy(xpath = "//input[@id='email_address']")
	private WebElement txtEmail;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement txtPassword;

	@FindBy(xpath = "//input[@id='password-confirmation']")
	private WebElement txtCnfPassword;

	@FindBy(xpath = "//button[@title='Create an Account']")
	private WebElement btnCreateAnAccount;

	@FindBy(xpath = "//div[@class='message-success success message']")
	private WebElement Confirmationmsg;

	@FindBy(xpath = "//div[@class='message-error error message']")
	private WebElement errorMsg;

	// Actions
	public void navigateToCreateAccount() {
		createAccountCTA.click();
		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.urlContains("customer/account/create/"));
	}

	public void setFirstName(String fname) {
		txtFirstName.sendKeys(fname);
	}

	public void setLastName(String lname) {
		txtLastName.sendKeys(lname);
	}

	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}

	public void setCnfPassword(String cnfpwd) {
		txtCnfPassword.sendKeys(cnfpwd);
	}

	public void clickSubmit() {
		btnCreateAnAccount.click();
	}

	// Validations
	public String getConfirmationMsg() {
		try {
			return (Confirmationmsg.getText());
		} catch (Exception e) {
			return null;
		}
	}

	public boolean isErrorDisplayed() {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(errorMsg));
			return errorMsg.isDisplayed();
		} catch (Exception e) {
			return false; // Return false if no error message is found
		}
	}

	public String getErrorMsg() {
		try {
			return errorMsg.getText();
		} catch (Exception e) {
			return null; // Return null if error message is not found
		}
	}

}

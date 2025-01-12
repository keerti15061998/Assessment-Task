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

	@FindBy(xpath = "//a[contains(text(),'Create an Account')]")
	WebElement createAccountCTA;

	@FindBy(xpath = "//input[@id='firstname']")
	WebElement txtFirstName;

	@FindBy(xpath = "//input[@id='lastname']")
	WebElement txtLastName;

	@FindBy(xpath = "//input[@id='email_address']")
	WebElement txtEmail;

	@FindBy(xpath = "//input[@id='password']")
	WebElement txtPassword;

	@FindBy(xpath = "//input[@id='password-confirmation']")
	WebElement txtCnfPassword;

	@FindBy(xpath = "//button[@title='Create an Account']")
	WebElement btnCreateAnAccount;

	@FindBy(xpath = "//div[@class='message-success success message']")
	WebElement Confirmationmsg;
	
	
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

	public String getConfirmationMsg() {
		try {
			return (Confirmationmsg.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}
	}

}

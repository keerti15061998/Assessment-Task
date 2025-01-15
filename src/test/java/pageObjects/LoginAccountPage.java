package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginAccountPage extends BasePage {

	public LoginAccountPage(WebDriver driver) {
		super(driver);

	}
	// Locators

	@FindBy(xpath = "//div[@class='panel header']//a[contains(text(),'Sign In')]")
	private WebElement SignInCTA;

	@FindBy(xpath = "//input[@id='email']")
	private WebElement EnterEmail;

	@FindBy(xpath = "//input[@title='Password']")
	private WebElement EnterPassword;

	@FindBy(xpath = "//button[@class='action login primary']")
	private WebElement SignInButton;

	@FindBy(xpath = "//div[@class='message-error error message']")
	private WebElement errorMsg;

	@FindBy(xpath = "//span[@class='base']")
	private WebElement ConfirmationSignInMsg;

	public void navigateToSignIn() {
		SignInCTA.click();
		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.urlContains("customer/account/login/"));

	}

	public void Email(String email) {
		EnterEmail.sendKeys(email);
	}

	public void Password(String pass) {
		EnterPassword.sendKeys(pass);
	}

	public void clickSignIN() {
		SignInButton.click();
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public boolean isSignInErrorDisplayed() {
		try {
			// Wait for the confirmation message to appear
			new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(errorMsg));
			return errorMsg.isDisplayed();
		} catch (Exception e) {
			// If confirmation message is not found, return false
			return false;
		}
	}

	public String getSignInErrorMessage() {
		return errorMsg.getText();
	}

	public boolean isSignInSuccessful() {
		try {
			// Wait for the confirmation message to appear
			new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.visibilityOf(ConfirmationSignInMsg));
			return ConfirmationSignInMsg.isDisplayed();
		} catch (Exception e) {
			// If confirmation message is not found, return false
			return false;
		}
	}

	public boolean isRedirectedToAccountDashboard() {
		try {
			// Wait for the URL to indicate successful login
			new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.urlContains("customer/account/"));
			return driver.getCurrentUrl().contains("customer/account/");
		} catch (Exception e) {
			return false;
		}
	}

}

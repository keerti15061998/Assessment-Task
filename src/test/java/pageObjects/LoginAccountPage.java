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

	@FindBy(xpath = "//div[@class='panel header']//a[contains(text(),'Sign In')]")
	WebElement SignInCTA;

	@FindBy(xpath = "//input[@id='email']")
	WebElement EnterEmail;

	@FindBy(xpath = "//input[@title='Password']")
	WebElement EnterPassword;

	@FindBy(xpath = "//button[@class='action login primary']")
	WebElement SignInButton;

	@FindBy(xpath = "//span[@class='base']")
	WebElement CinfirmationSignInMsg;

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

	public String getConfirmationSignInMsg() {
		try {
			return (CinfirmationSignInMsg.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}
	}

}

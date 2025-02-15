package testCases;

import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utilities.ExtentReportManager;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class BaseClass {

	WebDriver driver;
	protected static ExtentReports extent;
    protected static ExtentTest test;

	@BeforeClass
	void setup() throws InterruptedException {

		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://magento.softwaretestingboard.com/");
		extent = ExtentReportManager.createInstance();
		
	}

	@AfterClass
	void tearDown() {
		driver.quit();
		ExtentReportManager.flushReports();
		

	}

}

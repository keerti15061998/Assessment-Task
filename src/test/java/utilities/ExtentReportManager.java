package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
	
	private static ExtentReports extent;
    private static ExtentTest test;

    public static ExtentReports createInstance() {
        if (extent == null) {
            String reportPath = System.getProperty("user.dir") + "/test-output/ExtentReport.html";
            ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
            reporter.config().setDocumentTitle("Test Report");
            reporter.config().setReportName("Automation Test Report");

            extent = new ExtentReports();
            extent.attachReporter(reporter);
            extent.setSystemInfo("OS", System.getProperty("os.name"));
            extent.setSystemInfo("Tester", "Keerti Vardhan Dubey");
        }
        return extent;
    }

    public static ExtentTest createTest(String testName) {
        test = extent.createTest(testName);
        return test;
    }

    public static void flushReports() {
        if (extent != null) {
            extent.flush();
        }
    }

}

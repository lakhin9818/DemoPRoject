package Base;

//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;

public class Report {
	static ExtentTest test;
	static ExtentReports report;

	@BeforeClass
	public static void startTest() {
		report = new ExtentReports();
//		test = report.startTest("Report");
	}

	@AfterClass
	public static void endTest() {
//		report.endTest(test);
		report.flush();
	}
}
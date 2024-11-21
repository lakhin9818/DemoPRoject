package Base;

import java.lang.System.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Loggers {
	private static final Loggers instance = new Loggers();
	private static ExtentTest test;
	private static ExtentReports extent;
	private static Logger LOG;
	private static final String REPORT_LOCATION = "test-output/reports.extent.html";

	/**
	 * Returns an instance of {@link ExtentReports} object. If it doesn't exist
	 * creates a new instance and returns it
	 */
	public static ExtentReports getLogger() {
		if (extent == null) {
			createInstance();
		}
		return extent;
	}

	/**
	 * Create ExtentReport and attaches htmlReporter to it
	 */
	public static void createInstance() {
		ExtentSparkReporter spark = new ExtentSparkReporter("Spark.html");
		extent = new ExtentReports();
		extent.attachReporter(spark);
	}

	/**
	 * This method creates, configures and returns an instance of ExtentHtmlReporter
	 *
	 */
	public static ExtentSparkReporter getHTMLReporter() {
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter(REPORT_LOCATION);
		return htmlReporter;
	}

	/**
	 * This method logs a message with the INFO level for both instances of TestNG
	 * Logger and ExtentTest
	 */
	public void info(String message) {
		((ExtentTest) LOG).info(message);
		test.log(Status.INFO, message);
	}
}
package reports;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import base.PredefinedActions;

public class ExtentManager {

	static ExtentReports extentReport;
	static ExtentTest extentTest;

	public static void initExtentReport() {
		extentReport = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("Spark.html");
		extentReport.attachReporter(spark);

		spark.config().setDocumentTitle("Technocredits: Aug22 Hybrid");
		spark.config().setReportName(System.getProperty("user.name"));
		spark.config().setTheme(Theme.STANDARD);
//		spark.config().setTimeStampFormat("HH:mm:ss a");
		extentReport.setSystemInfo("Browser", "Chrome");
		extentReport.setSystemInfo("OS", "Win 11");
		extentReport.setSystemInfo("Env", "QA");
	}

	public static void createTest(String testName) {
		extentTest = extentReport.createTest(testName).createNode(testName);
	}

	public static void log(String msg) {
		extentTest.info(msg);
	}

	public static void pass() {
		extentTest.log(Status.PASS, "Test Case Executed Scuesssfully");
	}

	public static void fail(String msg) {
		extentTest.log(Status.FAIL, msg);
		try {
			extentTest.log(Status.FAIL,
					MediaEntityBuilder.createScreenCaptureFromBase64String(PredefinedActions.takeScreenShot()).build());
		} catch (IOException e) {
		}
	}

	public static void skip(String msg) {
		extentTest.log(Status.SKIP, msg);
		try {
			extentTest.log(Status.SKIP,
					MediaEntityBuilder.createScreenCaptureFromBase64String(PredefinedActions.takeScreenShot()).build());
		} catch (IOException e) {
		}
	}

	public static void warn(String msg) {
		extentTest.warning(msg);
	}

	public static void flushReport() {
		extentReport.flush();
	}

}

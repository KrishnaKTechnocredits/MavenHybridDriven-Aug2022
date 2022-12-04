package testscripts;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import base.PredefinedActions;
import constant.ConstantValue;
import pages.LoginPage;
import reports.ExtentManager;
import utility.PropertyFileOperations;

public class TestBase {

	@BeforeSuite
	public void beforeSuite() {
		ExtentManager.initExtentReport();
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
	}

	@AfterSuite
	public void afterSuite() {
		ExtentManager.flushReport();
	}

	@BeforeMethod
	public void setUp(ITestResult result) throws IOException {
		PropertyFileOperations fileOperations = new PropertyFileOperations(ConstantValue.CONFIGFILEPATH);
		String url = fileOperations.getValue("url");

		ExtentManager.createTest(result.getMethod().getMethodName());
		PredefinedActions.start(url);

		LoginPage loginPage = LoginPage.getObject();
		loginPage.login(fileOperations.getValue("username"), fileOperations.getValue("password"));
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		int status = result.getStatus();
		if (ITestResult.FAILURE == status) {
			ExtentManager.fail(result.getThrowable().getMessage());
		} else if (ITestResult.SUCCESS == status) {
			ExtentManager.pass();
		} else if (ITestResult.SKIP == status) {
			ExtentManager.skip(result.getThrowable().getMessage());
		}
		PredefinedActions.closeBrowser();
	}

}

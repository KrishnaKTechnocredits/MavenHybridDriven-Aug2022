package testscripts;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import base.PredefinedActions;
import constant.ConstantValue;
import pages.LoginPage;
import utility.PropertyFileOperations;

public class TestBase {

	@BeforeSuite
	public void intiLog4j() {
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
	}

	@BeforeMethod
	public void setUp() throws IOException {
		PropertyFileOperations fileOperations = new PropertyFileOperations(ConstantValue.CONFIGFILEPATH);
		String url = fileOperations.getValue("url");
		PredefinedActions.start(url);

		LoginPage loginPage = LoginPage.getObject();
		loginPage.login(fileOperations.getValue("username"), fileOperations.getValue("password"));
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		int status = result.getStatus();
		if (ITestResult.FAILURE == status) {
			PredefinedActions.takeScreenshot(result.getMethod().getMethodName());
		} else if (ITestResult.SUCCESS == status) {
			PredefinedActions.takeScreenshot(result.getMethod().getMethodName());
		}
		PredefinedActions.closeBrowser();
	}
}

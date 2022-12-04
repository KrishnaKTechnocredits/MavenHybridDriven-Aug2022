package testscripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import reports.ExtentManager;

public class ReportTest extends TestBase {

	@Test
	public void m1() {
		ExtentManager.log("Ope browser");
		ExtentManager.log("User Enter User Name");
		Assert.fail("unable to write value on locator");
	}

	@Test
	public void m2() {
		ExtentManager.log("Ope browser");
		ExtentManager.log("User Enter User Name");
		throw new SkipException("unable to write value on locator");
	}

	@Test
	public void m3() {
		ExtentManager.log("Ope browser");
		ExtentManager.log("User Enter User Name");
		ExtentManager.log("USer enter password");
		ExtentManager.log("User should see dashboard");
	}
}

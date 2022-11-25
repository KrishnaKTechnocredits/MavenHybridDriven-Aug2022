package testscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import constant.ConstantValue;

public class ChromeCapabilities {
	
	@Test
	public void openBrowser() {

		ChromeOptions options =new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--incognito");
		options.addArguments("--start-maximized");
		
		System.setProperty(ConstantValue.CHROMEDRIVERKEY, ConstantValue.CHROMEDRIVER);
		WebDriver driver = new ChromeDriver(options);
//		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
	}

}

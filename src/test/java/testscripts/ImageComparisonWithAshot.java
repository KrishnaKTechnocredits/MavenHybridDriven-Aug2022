package testscripts;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.PredefinedActions;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class ImageComparisonWithAshot {

	@Test
	public void comapreImage() throws IOException {
		WebDriver driver = PredefinedActions.startTemp("http://automationbykrishna.com/");
		WebElement actualLogo = driver.findElement(By.xpath("//a[@class='navbar-brand']/img"));

		Screenshot screenshot = new AShot().takeScreenshot(driver, actualLogo);

		BufferedImage actualImage = screenshot.getImage();
		BufferedImage expectedImage = ImageIO.read(new File("technoIconCropped.jpeg"));

		ImageDiffer imgDiffer = new ImageDiffer();

		ImageDiff imgDiff = imgDiffer.makeDiff(expectedImage, actualImage);
		if (imgDiff.hasDiff()) {
			System.out.println("Fail...");
		}else {
			System.out.println("Pass..");
		}

	}

}

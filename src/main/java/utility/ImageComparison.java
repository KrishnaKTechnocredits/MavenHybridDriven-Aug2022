package utility;

import java.awt.image.BufferedImage;

import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class ImageComparison {

	public static boolean checkDiffrence(BufferedImage actual, BufferedImage expected) {

//		BufferedImage actualImage = ImageIO.read(new File("technoIconCropped2.jpeg"));
//		BufferedImage expectedImage = ImageIO.read(new File("technoIconCropped.jpeg"));
		ImageDiffer imgDiffer = new ImageDiffer();
		return imgDiffer.makeDiff(actual, expected).hasDiff();
	}

}

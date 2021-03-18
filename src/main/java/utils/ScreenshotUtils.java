package utils;

import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author tahanima
 * @since 03/13/2021
 */
public class ScreenshotUtils {
    private static String imageFormat = "jpg";

    private static String getImagePath(String fileName, String directoryPath) {
        String filePath = directoryPath + "/" + fileName + "." + imageFormat
                .replace("/", File.separator);

        return filePath;
    }

    public static void captureFullScreen(String fileName, String directoryPath) {
        try {
            Robot robot = new Robot();
            Rectangle screenRegion = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage screenFullImage = robot.createScreenCapture(screenRegion);

            ImageIO.write(screenFullImage, imageFormat, new File(getImagePath(fileName, directoryPath)));
        } catch (AWTException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void captureFullPage(WebDriver driver, String fileName, String directoryPath) {
        Screenshot screenshot = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(1000))
                .takeScreenshot(driver);

        try {
            ImageIO.write(screenshot.getImage(), imageFormat, new File(getImagePath(fileName, directoryPath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

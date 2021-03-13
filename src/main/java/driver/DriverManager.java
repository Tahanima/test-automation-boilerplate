package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

/**
 * @author tahanima
 * @since 03/13/2021
 */
public class DriverManager {
    private static final int PAGE_TIME_OUT = 30;
    private static WebDriver driver;

    private DriverManager() {}

    private static WebDriver init() {
        /* automates browser driver management
         * currently, using only chromedriver
         * can be modified to make use of other drivers if needed
         */
        WebDriverManager.chromedriver().setup();

        ChromeOptions option = new ChromeOptions();
        option.addArguments("--ignore-certificate-errors");

        driver = new ChromeDriver(option);
        driver.manage().timeouts().implicitlyWait(PAGE_TIME_OUT, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        return driver;
    }

    public static WebDriver getDriver() {
        return (driver == null) ? init() : driver;
    }
}

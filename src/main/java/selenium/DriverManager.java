package selenium;

import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class DriverManager {
    private static final int PAGE_TIME_OUT = 20;
    private static WebDriver driver;

    private DriverManager() {}

    private static WebDriver init() {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--ignore-certificate-errors");

        if(SystemUtils.IS_OS_LINUX) {
            System.setProperty("webdriver.chrome.driver", "chrome-driver/linux/chromedriver");
        } else if(SystemUtils.IS_OS_MAC) {
            System.setProperty("webdriver.chrome.driver", "chrome-driver/mac/chromedriver");
        } else if(SystemUtils.IS_OS_WINDOWS) {
            System.setProperty("webdriver.chrome.driver", "chrome-driver\\windows\\chromedriver.exe");
        }

        driver = new ChromeDriver(option);
        driver.manage().timeouts().implicitlyWait(PAGE_TIME_OUT, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        return driver;
    }

    public static WebDriver getDriver() {
        return (driver == null) ? init() : driver;
    }
}

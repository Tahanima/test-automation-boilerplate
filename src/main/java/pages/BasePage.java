package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * @author tahanima
 * @since 03/13/2021
 */
public class BasePage {
    protected WebDriver driver;

    public void init(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}

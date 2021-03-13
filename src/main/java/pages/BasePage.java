package selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;

    public void init(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}

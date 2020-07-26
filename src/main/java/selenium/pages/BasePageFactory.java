package selenium.pages;

import org.openqa.selenium.WebDriver;

public class BasePageFactory {
    @SuppressWarnings("unchecked")
    public static <T extends BasePage> T createInstance(WebDriver driver, Class<? extends BasePage> pageClass) {
        try {
            BasePage instance = pageClass.newInstance();
            instance.init(driver);
            return (T) pageClass.cast(instance);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        throw new NullPointerException("Could not create the Page class");
    }
}

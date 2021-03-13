package pages.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import static utils.UrlConstants.BASE_URL;

/**
 * @author tahanima
 * @since 03/13/2021
 */
public class LoginPage extends BasePage {
    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement login;

    public LoginPage open() {
        driver.get(BASE_URL);
        return this;
    }

    public LoginPage fillUserName(String userName) {
        this.userName.clear();
        this.userName.sendKeys(userName);
        return this;
    }

    public LoginPage fillPassword(String password) {
        this.password.clear();
        this.password.sendKeys(password);
        return this;
    }

    public void clickLogin() {
        login.click();
    }

    public String getPageUrl() {
        return driver.getCurrentUrl();
    }
}

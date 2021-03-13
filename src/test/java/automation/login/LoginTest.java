package automation.login;

import automation.BaseTest;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import utils.ScreenshotUtils;

import static utils.UrlConstants.BASE_URL;
import static utils.UrlConstants.PRODUCT_PAGE_URL;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author tahanima
 * @since 03/13/2021
 */
public class LoginTest extends BaseTest {
    private Faker faker;

    @Override
    public void init() {
        faker = new Faker();
    }

    @Test(description = "Testing Successful Login Attempt", priority = 0)
    public void testSuccessfulLogin() {
        login("standard_user", "secret_sauce");
        ScreenshotUtils.captureFullPage(driver, "successfulLoginAttempt");

        assertThat(loginPage.getPageUrl()
                .equals(BASE_URL + PRODUCT_PAGE_URL))
                .isTrue();
    }

    @Test(description = "Testing Unsuccessful Login Attempt", priority = 1)
    public void testUnsuccessfulLogin() {
        login(faker.name().username(), faker.internet().password());
        ScreenshotUtils.captureFullPage(driver, "unsuccessfulLoginAttempt");

        assertThat(loginPage.getPageUrl()
                .equals(BASE_URL + PRODUCT_PAGE_URL))
                .isFalse();
    }
}

package automation.login;

import automation.BaseTest;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import util.ScreenshotUtils;

import static util.Globals.CONTEXT_URL;
import static util.Globals.PRODUCT_PAGE_URL;

import static org.assertj.core.api.Assertions.assertThat;

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

        assertThat(loginPage.getPageUrl().contentEquals(CONTEXT_URL + PRODUCT_PAGE_URL)).isTrue();
    }

    @Test(description = "Testing Unsuccessful Login Attempt", priority = 1)
    public void testUnsuccessfulLogin() {
        login(faker.name().username(), faker.internet().password());
        ScreenshotUtils.captureFullPage(driver, "unsuccessfulLoginAttempt");

        assertThat(loginPage.getPageUrl().contentEquals(CONTEXT_URL + PRODUCT_PAGE_URL)).isFalse();
    }
}

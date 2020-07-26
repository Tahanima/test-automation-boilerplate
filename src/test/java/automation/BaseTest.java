package automation;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import report.ExtentReportManager;
import selenium.DriverManager;
import selenium.pages.BasePageFactory;
import selenium.pages.login.LoginPage;

import java.lang.reflect.Method;

public abstract class BaseTest {
    protected ExtentReports report;
    protected ExtentTest test;
    protected LoginPage loginPage;
    protected WebDriver driver = DriverManager.getDriver();

    public abstract void init();

    public void login(String username, String password) {
        loginPage.open()
                .fillUserName(username)
                .fillPassword(password)
                .clickLogin();
    }

    @BeforeClass
    public void setup() {
        init();

        report = ExtentReportManager.createReport();
        loginPage = BasePageFactory.createInstance(driver, LoginPage.class);
    }

    @BeforeMethod
    public void register(Method method) {
        String testName = method.getName();
        test = report.createTest(testName);
    }

    @AfterMethod
    public void assessTestStatus(ITestResult result) {
        if(result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "TEST FAILED: " + result.getName());
            test.log(Status.FAIL, "TEST FAILED: " + result.getThrowable());
        } else if(result.getStatus() == ITestResult.SKIP) {
            test.log(Status.PASS, "TEST SKIPPED: " + result.getName());
        } else if(result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "TEST PASSED: " + result.getName());
        }
    }

    @AfterClass
    public void tearDown() {
        report.flush();
        driver.quit();
    }
}

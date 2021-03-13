package report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfiguration;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author tahanima
 * @since 03/13/2021
 */
public class ExtentReportManager {
    private static ExtentReports report;

    private ExtentReportManager() {}

    public static ExtentReports createReport() {
        String currentDateStr = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
        String name = "Test Automation Report " + currentDateStr;
        String fileName = "test-report/" + name + ".html".replace("/", File.separator);

        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(fileName);
        ExtentSparkReporterConfiguration config = sparkReporter.config();

        config.setTheme(Theme.STANDARD);
        config.setDocumentTitle(name);
        config.setEncoding("utf-8");
        config.setReportName(name);

        report = new ExtentReports();
        report.attachReporter(sparkReporter);

        return report;
    }
}

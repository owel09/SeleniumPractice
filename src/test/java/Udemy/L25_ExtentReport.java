package Udemy;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
/*
Extent Report Demo
ExtentSparkReporter - nagccreate ng report, kailangan nya ng path
ExtentReporters - pangconsolidate ng reports
ExtentTest - pangcontrol ng test result na lalabas sa index.html

mappunta sa reports folder yung index.html na pwede buksan via browser
Passed yung Run neto pero sa report Failed kasi sinadya ko magfail gamit yung ExtentTest
 */

public class L25_ExtentReport {

    ExtentReports extent;

    @BeforeTest
    public void config(){
        String path = System.getProperty("user.dir")+"\\reports\\index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);

        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("Test Results");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester","Owel");

    }

    @Test
    public void extentReportDemo(){
        ExtentTest test = extent.createTest("Initial Demo");
        System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Documents\\Driver\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://rahulshettyacademy.com");
        System.out.println(webDriver.getTitle());
        webDriver.close();
        test.fail("Result do not match");
        extent.flush();
    }

}

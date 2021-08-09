package Udemy;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class L14_MaximizeDeleteCookies {
    public static void main(String[] args) throws IOException {

        System.setProperty("webdriver.chrome.driver","C:\\Driver\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().deleteAllCookies();
        
        webDriver.get("https://rahulshettyacademy.com/AutomationPractice/");

        /*
       ((TakesScreenshot)webDriver) - casting webDriver to TakesScreenshot
        getScreenshotAs(OutputType.FILE) - output the screenshot as a file
         */

        File src = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);

        //copying the file in the local machine
        FileUtils.copyFile(src,new File("D:\\owel\\Documents\\screenshot.png"));


    }
}

package Pluralsight;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

/*
 *Created by owel on 19/08/2020 9:04 AM
 */
public class WebDriverDemoServer {

    public static void main(String[] args) throws MalformedURLException {

        System.setProperty("webdriver.chrome.driver","C:\\Driver\\chromedriver.exe");
//        WebDriver webDriver = new ChromeDriver();

        WebDriver webDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),DesiredCapabilities.chrome());

        webDriver.get("http://www.google.com");

        WebElement searchField = webDriver.findElement(By.name("q"));
        searchField.sendKeys("pluralsight");
        searchField.submit();

//        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(webDriver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Images")));

        WebElement imagesLink = webDriver.findElement(By.linkText("Images"));
        imagesLink.click();

        WebElement imageElement = webDriver.findElement(By.cssSelector("#islrg > div.islrc > div:nth-child(1) > a.wXeWr.islib.nfEiy.mM5pbd"));
        WebElement imageLink = imageElement.findElement(By.tagName("img"));
        imageLink.click();

    }

}

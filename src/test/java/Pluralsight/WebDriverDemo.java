package Pluralsight;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/*
 *Created by owel on 19/08/2020 9:04 AM
 */
public class WebDriverDemo {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","D://owel//Documents//Training//Driver//chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();

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

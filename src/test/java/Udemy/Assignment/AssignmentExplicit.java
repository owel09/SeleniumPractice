package Udemy.Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssignmentExplicit {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Documents\\Driver\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        WebDriver webDriver = new ChromeDriver();
        WebDriverWait webDriverWait = new WebDriverWait(webDriver,5);

        webDriver.get("https://www.itgeared.com/demo/1506-ajax-loading.html");

        webDriver.findElement(By.xpath("//a[contains(text(),'Click to load get data via Ajax!')]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#results")));
    }
}

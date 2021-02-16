package Rahul;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/*
 *Created by owel on 24/01/2021 10:23 AM
 */
public class AutoSuggestive {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Documents\\Driver\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        WebDriver webDriver = new ChromeDriver(chromeOptions);
        webDriver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        webDriver.findElement(By.id("autosuggest")).sendKeys("ind");

    }
}

package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 *Created by owel on 19/08/2020 9:04 AM
 */
public class WebDriverDemo {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","D://owel//Documents//1_Owel Docs//Training//Driver//chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();

        webDriver.get("http://www.google.com");

        webDriver.findElement(By.name("q"));
    }

}

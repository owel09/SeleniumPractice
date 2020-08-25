package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/*
 *Created by owel on 25/08/2020 7:51 AM
 */
public class WebDriverRadioButton {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","D://owel//Documents//1_Owel Docs//Training//Driver//chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("D:\\owel\\Documents\\1_Owel Docs\\Training\\SeleniumPractice\\src\\main\\webapp\\RadioButton.html");

        List<WebElement> radioButtons = webDriver.findElements(By.name("gender")); //bakit nga ba gumamit ng list?
        radioButtons.get(2).click();
    }
}

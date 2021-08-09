package Udemy;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/*
 *Created by owel on 28/02/2021 7:08 PM
 */
public class ActionToMove {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Driver\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.amazon.com");

        webDriver.manage().window().maximize();

        Actions actions = new Actions(webDriver);
        WebElement movetoEHello = webDriver.findElement(By.cssSelector("a[id='nav-link-accountList']"));

        //typing hello in capital and double click
        actions.moveToElement(webDriver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
        //moves to specific element
        actions.moveToElement(movetoEHello).contextClick().build().perform();


    }
}

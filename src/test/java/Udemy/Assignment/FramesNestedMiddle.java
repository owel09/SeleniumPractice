package Udemy.Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 *Created by owel on 20/04/2021 6:59 PM
 */
public class FramesNestedMiddle {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Driver\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();

        webDriver.get("https://the-internet.herokuapp.com");

        //SYNTAX USING LINKED TEXT
        webDriver.findElement(By.linkText("Nested Frames")).click();

        //SWITCHING TO PARENT FRAME
        webDriver.switchTo().frame("frame-top");

        webDriver.switchTo().frame("frame-middle");

        System.out.println(webDriver.findElement(By.id("content")).getText());
    }
}

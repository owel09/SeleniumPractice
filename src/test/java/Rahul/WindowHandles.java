package Rahul;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

/*
 *Created by owel on 28/02/2021 7:43 PM
 */
public class WindowHandles {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Documents\\Driver\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://rahulshettyacademy.com/loginpagePractise/#");
        webDriver.findElement(By.cssSelector("a.blinkingText")).click();

        Set<String> windows = webDriver.getWindowHandles(); //get the window ids open by the automation. return type is set of strings [parentid,childid]

        Iterator <String> it = windows.iterator(); //Use Iterator class in Set windows
        String parentID = it.next(); //grab parentID
        String chidID = it.next(); //grab childID

        webDriver.switchTo().window(chidID); //go to chid tab

        System.out.println(webDriver.findElement(By.cssSelector("p.im-para.red")).getText()); //using class locator pero may spaces
        String emailID = webDriver.findElement(By.cssSelector("p.im-para.red")).getText().split("at")[1].trim().split(" ")[0];

        webDriver.switchTo().window(parentID);
        webDriver.findElement(By.id("username")).sendKeys(emailID);
    }
}

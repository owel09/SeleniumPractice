package Udemy.Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

/*
 *Created by owel on 02/03/2021 7:46 AM
 */
public class AssignmentWindowHandles {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Documents\\Driver\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://the-internet.herokuapp.com/windows");

        webDriver.findElement(By.linkText("Click Here")).click();

        Set<String> windows = webDriver.getWindowHandles();

        Iterator <String> it = windows.iterator();
        String parentID = it.next(); //hasNext() boolean pala ang return which is ginagamit sa mga while and if
        String chilID = it.next();

        webDriver.switchTo().window(chilID);
        System.out.println(webDriver.findElement(By.xpath("//h3[contains(text(),'New Window')]")).getText());
        //driver.findElement(By.xpath("//div[@class='example']/h3")).getText();
        webDriver.switchTo().window(parentID);
        System.out.println(webDriver.findElement(By.xpath("//div[@class='example']/h3")).getText()); //xpath traverse

    }
}

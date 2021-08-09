package Udemy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/*
 *Created by owel on 20/04/2021 11:59 AM
 */
public class FramesDragDrop {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\Driver\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://jqueryui.com/droppable/");

        //COUNTING THE FRAME IN PAGE
        System.out.println(webDriver.findElements(By.tagName("iframe")).size());

        //SYNTAX USING CSS CLASS <TAGNAME>.<CLASSNAME>
//        webDriver.switchTo().frame(webDriver.findElement(By.cssSelector("iframe.demo-frame")));

        //SYNTAX USING CSS CLASS CLASSIC <TAGNAME>[class='<CLASSNAME>']
        webDriver.switchTo().frame(webDriver.findElement(By.cssSelector("iframe[class='demo-frame']")));

        webDriver.findElement(By.id("draggable")).isDisplayed();

        //DRAG AND DROP ACTION
        Actions a = new Actions(webDriver);
        WebElement source = webDriver.findElement(By.id("draggable"));
        WebElement target = webDriver.findElement(By.id("droppable"));
        a.dragAndDrop(source,target).build().perform();

        //PARA LUMABAS SA FRAME
        webDriver.switchTo().defaultContent();

    }
}

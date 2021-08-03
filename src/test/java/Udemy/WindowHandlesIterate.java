package Udemy;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

/*
 *Created by owel on 21/04/2021 10:56 AM
 */
public class WindowHandlesIterate {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Documents\\Driver\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //GET ALL THE LINKS OF THE ENTIRE PAGE
        System.out.println(webDriver.findElements(By.tagName("a")).size());

        //GET ALL THE LINKS IN THE FOOTER SECTION
        WebElement footerDriver = webDriver.findElement(By.id("gf-BIG"));
        System.out.println(footerDriver.findElements(By.tagName("a")).size());

        //GET ALL THE LINKS IN THE FIRST SECTION ONLY
        WebElement columnDriver = footerDriver.findElement(By.xpath("//tbody/tr/td[1]/ul[1]"));
        System.out.println(columnDriver.findElements(By.tagName("a")).size());

        //CLICK ALL THE LINKS AND ENSURE THE PAGES ARE OPEN
        for(int i = 1; i < columnDriver.findElements(By.tagName("a")).size(); i++ )
        {
            //KEYWORD DRIVEN DECLARING KEYS IN VARIABLE
            String clickOntabs = Keys.chord(Keys.CONTROL,Keys.ENTER);
            columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOntabs);

        }

        //PRINT ALL THE TITLE OF THE PAGE
        Set <String> abc = webDriver.getWindowHandles();
        Iterator<String> it = abc.iterator();

        //hasNext - tells us whether the next index is present or not
        //next - moves to the next index

        while (it.hasNext()){ //check if Practice page is present having 0 index and the next window is present

            webDriver.switchTo().window(it.next());
            System.out.println(webDriver.getTitle());
        }

        webDriver.close();

    }
}

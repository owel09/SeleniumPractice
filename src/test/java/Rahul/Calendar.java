package Rahul;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/*
 *Created by owel on 24/04/2021 11:04 AM
 */
public class Calendar {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Documents\\Driver\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.path2usa.com/travel-companions");

        webDriver.findElement(By.xpath("//input[@id='travel_date']")).click();

        //CSS SELECTOR USING CLASS ATTRIBUTE TRAVERSE WITH SPECIFIC ELEMENT
//        webDriver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).click();

        //! - NEGATION - kung false ang sagot gagawin nyang true para pumasok sa block ng while loop
        //contains method returns boolean value kaya pamasok sya sa while loop
        while (!webDriver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText().contains("May"))
        {
            webDriver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();

        }

        //STORING LAHAT NG DATES SA LIST
        List<WebElement> dates = webDriver.findElements(By.className("day"));
        int count = webDriver.findElements(By.className("day")).size();

        //GRAB THE COMMON ATTRIBUTE, PUT IT IN THE LIST AND ITERATE
        for(int i = 0 ; i < count ; i ++){
            String text = webDriver.findElements(By.className("day")).get(i).getText();

            if(text.equalsIgnoreCase("29")){
                webDriver.findElements(By.className("day")).get(i).click();
                break;
            }
        }

    }
}

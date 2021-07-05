package Rahul;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.stream.Collectors;

/*
 *Created by owel on 25/06/2021 10:11 AM
 * 113. Perform Web Table Sorting using Selenium Java Streams
 * Click yung Veg name header para mag-sort
 * Kunin yung list at ilagay sa originalList
 * Declare sortedList at gamitin yung sort method
 */
public class L15_1_WebtableSort {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Documents\\Driver\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        //click the column
        webDriver.findElement(By.xpath("//tr/th[1]")).click();

        //capture text in all webelements into new(original) list
        List<WebElement> elementList = webDriver.findElements(By.xpath("//tr/td[1]"));

        List<String> originalList = elementList.stream().map(s -> s.getText()).collect(Collectors.toList());

        //sort on  the original list -> sortedlist
        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

        //compare original vs sorted
        Assert.assertTrue(originalList.equals(sortedList));

    }
}

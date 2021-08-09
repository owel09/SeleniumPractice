package Udemy;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.stream.Collectors;

/*
 *Created by owel on 30/06/2021 2:26 PM
 * Using text box, search an item
 * webtable will display the result
 * capture the results and check if item is found
 */
public class L15_3_WebtableFilterSearch {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\Driver\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        webDriver.findElement(By.id("search-field")).sendKeys("Rice");

        //after magsearch, kunin mo muna laht ng result
        List<WebElement> veggies = webDriver.findElements(By.xpath("//tr/td[1]"));

        //filter condition
        List<WebElement> filteredList = veggies.stream().filter(veg->veg.getText().contains("Rice")).collect(Collectors.toList());

        Assert.assertEquals(veggies.size(),filteredList.size());
    }
}

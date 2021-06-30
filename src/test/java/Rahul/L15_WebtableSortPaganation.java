package Rahul;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.stream.Collectors;

/*
 *Created by owel on 30/06/2021 12:05 PM
 * Scan yung Veg name column and check kung nandoon yung "Rice".
 * Kapag wala click Next button.
 * Kapag nakita yung Beans, print the Price.
 */
public class L15_WebtableSortPaganation {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Documents\\Driver\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        List<String> price;

        //capture text yung Veg/fruit name column
        do {
            List<WebElement> vegList = webDriver.findElements(By.xpath("//tr/td[1]"));

            //scan the name of the column with getText and print the price
            price = vegList.stream().filter(s -> s.getText().contains("Beans"))
                    .map(s -> getPriceVeggie(s)).collect(Collectors.toList());

            price.forEach(a -> System.out.println(a));

            if(price.size()<1){

                webDriver.findElement(By.cssSelector("[aria-label='Next']")).click();
            }


        }while (price.size()<1);

    }

    private static String getPriceVeggie(WebElement s) {
        String pricevalue = s.findElement(By.xpath("following-sibling::td[1]")).getText();

        return pricevalue;

    }

}

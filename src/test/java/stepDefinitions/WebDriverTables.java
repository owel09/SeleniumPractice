package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 *Created by owel on 09/09/2020 6:40 AM
 */
public class WebDriverTables {

    public static void main(String[] args) {

        WebDriver webDriver = new ChromeDriver();
        webDriver.get("D:\\owel\\\\Documents\\1_Owel Docs\\Training\\SeleniumPractice\\src\\main\\\\webapp\\TableTest.html");

//        ito yung old method kaso di ko ko makuha yung table 2 row 2 kasi walang .get(1)
//        WebElement outerTable = webDriver.findElement(By.tagName("table"));
//        WebElement innerTable = outerTable.findElement(By.tagName("table"));
//        WebElement row = innerTable.findElement(By.tagName("td"));
//        System.out.println(row.getText());

//  ito yung xpath method para makuha yung table 2 row 2 value
//        /html/body/table/tbody/tr/td[2]/table/tbody/tr[2]/td

        WebElement row = webDriver.findElement(By.xpath("/html/body/table/tbody/tr/td[2]/table/tbody/tr[2]/td"));
        System.out.println(row.getText());





    }
}

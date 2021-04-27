package Rahul;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class JSScriptExecutor {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Documents\\Driver\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //CASTING JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scroll(0,500)");
        Thread.sleep(3000);
        js.executeScript("document.querySelector('.tableFixHead ').scrollTop=5000");

        //TABLE DATA CSS SYNTAX WITH PARENT TRAVERSE TO CHILD. kukunin nya yung 4th column sa table
        List<WebElement> values = webDriver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
        int sum = 0;

        for(int i = 0 ; i < values.size() ; i++){

            //LOGIC TO SUM ALL THE VALUES and CONVERTING STRING TO INTEGER USING ParseInt
            sum = sum + Integer.parseInt(values.get(i).getText());
        }
        System.out.println(sum);

        //$(".totalAmount") - syntax para macheck mo gamit yung Console developer tools. kailangan naka-wrap ng ("")

        webDriver.findElement(By.cssSelector(".totalAmount")).getText();
        int total = Integer.parseInt(webDriver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());

        Assert.assertEquals(sum,total);

    }
}

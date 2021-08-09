package Udemy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/*
gumamit ng Implicit and Explicit wait
method call ng webDriver
 */
public class ImplicitExplicitGreenKart {

    public static void main(String[] args) throws InterruptedException{

        System.setProperty("webdriver.chrome.driver","C:\\Driver\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        WebDriver webDriver = new ChromeDriver(chromeOptions);

        //IMPLICIT WAIT APPLIES GLOBALLY AND WILL WAIT 5 SECONDS PER LINE
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //EXPLICIT WAIT USING WEBDRIVER
        WebDriverWait w = new WebDriverWait(webDriver,5);

        webDriver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        //DECLARE ARRAY
        String [] productArray = {"Brocolli","Cucumber","Beetroot"};

        Thread.sleep(3000);
        addItems(webDriver,productArray);

        webDriver.findElement(By.cssSelector("img[alt='Cart']")).click();

        //RELATIVE XPATH USING CONTAINS TEXT
        webDriver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();

        //IMPLEMENTATION OF EXPLICIT WAIT
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));

        //CSS USING TAGNAME AND CLASSNAME
        webDriver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        webDriver.findElement(By.cssSelector("button.promoBtn")).click();


        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));

    }

    public static void addItems(WebDriver webDriver, String[] productArray) {
        int j = 0;

        //DECLARE LIST TO SAVE ALL 30 WEBELEMENTS OF PRODUCT-NAME
        List<WebElement> productList = webDriver.findElements(By.cssSelector("h4.product-name"));

        //FOR LOOP USING THE SIZE OF THE PRODUCTLIST
        for(int i= 0 ; i < productList.size() ; i ++){

            //PARSING PRODUCTNAME INTO ARRAY USING SPLIT
            String [] productName = productList.get(i).getText().split("-");

            //SAVING PRODUCT[0] AND TRIM IN NEW STRING TRIMMEDPRODUCTNAME
            String trimmedProductName = productName[0].trim();

            //CONVERTING ARRAY TO ARRAYLIST
            List productArrayList = Arrays.asList(productArray);

            //CROSSCHECK YUNG LAMAN NG PRODUCTARRAYLIST SA NAKUHA NG PRODUCTNAME
            if(productArrayList.contains(trimmedProductName)){
                j++;

                //CLICK ADD TO CARD BUTTON BY GETTING THE INDEX FIRST
                webDriver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();

                if(j==productArray.length){
                    break;
                }
            }
        }

    }
}

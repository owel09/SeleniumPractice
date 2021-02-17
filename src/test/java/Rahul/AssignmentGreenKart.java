package Rahul;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;
import java.util.List;

public class AssignmentGreenKart {

    public static void main(String[] args) throws InterruptedException{

        System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Documents\\Driver\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        WebDriver webDriver = new ChromeDriver(chromeOptions);
        webDriver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        //DECLARE ARRAY
        String [] productArray = {"Brocolli","Cucumber","Beetroot"};

        Thread.sleep(3000);
        addItems(webDriver,productArray);
    }

    private static void addItems(WebDriver webDriver, String[] productArray) {
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

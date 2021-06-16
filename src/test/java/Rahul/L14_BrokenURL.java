package Rahul;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class L14_BrokenURL {
    public static void main(String[] args) throws IOException {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Documents\\Driver\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://rahulshettyacademy.com/AutomationPractice/");

        SoftAssert softAssert = new SoftAssert();


        //get the generic CSS in the footer
        List<WebElement> links = webDriver.findElements(By.cssSelector("li[class='gf-li'] a"));

        for (WebElement link:links){

            //CSS SELECTOR WITH REGULAR EXPRESSION - sa url ito tumingin kasi lahat ng url href attribute yung gamit
            String url = link.getAttribute("href");

            //new URL().openConnection() - method in URL class. inopen nya yung link pero di kita
            HttpURLConnection  conn =  (HttpURLConnection)new URL(url).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();

            int respCode = conn.getResponseCode();
            System.out.println(respCode);
            softAssert.assertTrue(respCode<400,"The link with Text broken link " + link.getText() + " is broken with response code: " +respCode);


        }

        softAssert.assertAll();

    }
}

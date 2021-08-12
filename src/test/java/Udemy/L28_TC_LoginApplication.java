package Udemy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/*
 *Created by Work on 12/08/2021 16:48
 *Test Case sample na connected sa L28_OR_RediffLoginPage. Tinawag ko lang dito yung mga object
 */
public class L28_TC_LoginApplication {

    @Test
    public void Login(){
        System.setProperty("webdriver.chrome.driver","C:\\Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

        L28_OR_RediffLoginPage rediffLoginPage = new L28_OR_RediffLoginPage(driver);
        rediffLoginPage.emailID().sendKeys("example@yahoo.com");
        rediffLoginPage.passwordInput().sendKeys("password123");

    }
}

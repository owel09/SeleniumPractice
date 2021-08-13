package Udemy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/*
 *Created by Work on 12/08/2021 16:47
 *Page Object Factory Sample
 */
public class L28_2_TC_SearchApp {

    @Test
    public void Search(){
        System.setProperty("webdriver.chrome.driver","C:\\Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.rediff.com/");

        L28_2_POF_RediffHomePage rediffHomePage = new L28_2_POF_RediffHomePage(driver);

        rediffHomePage.searchBox.sendKeys("last of us");
        rediffHomePage.submit.click();

    }


}

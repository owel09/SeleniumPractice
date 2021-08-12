package Udemy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
 *Created by Work on 12/08/2021 16:47
 *Object Repository sample ng Login page
 */
public class L28_OR_RediffLoginPage {
    WebDriver driver;

    public L28_OR_RediffLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By username = By.xpath("//input[@id='login1']");
    By password = By.xpath("//input[@id='password']");
    By go = By.name("proceed");

    //emailID() kaya walang laman ito kasi yung instance variable yung gagamitin natin at dapat walang magpapasa sa kanya
    public WebElement emailID(){
        return driver.findElement(username);
    }

    public WebElement passwordInput() {
        return driver.findElement(password);
    }

}

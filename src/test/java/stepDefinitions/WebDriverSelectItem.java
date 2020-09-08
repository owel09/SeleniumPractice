package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/*
 *Created by owel on 03/09/2020 1:04 PM
 */
public class WebDriverSelectItem {

    public static void main(String[] args) {

        WebDriver webDriver = new ChromeDriver(); // new instance ng webDriver
        webDriver.get("D:\\owel\\\\Documents\\1_Owel Docs\\Training\\SeleniumPractice\\src\\main\\\\webapp\\SelectButton.html"); //ito yung url na ioopen or yun html file

        WebElement selectElement = webDriver.findElement(By.id("select1"));
        Select select = new Select(selectElement);
        select.selectByVisibleText("Maybe");


    }
}

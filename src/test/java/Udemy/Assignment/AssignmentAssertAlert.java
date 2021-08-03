package Udemy.Assignment;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/*
 *Created by owel on 21/04/2021 5:52 PM
 */
public class AssignmentAssertAlert {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Documents\\Driver\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://rahulshettyacademy.com/AutomationPractice/");

        Actions actions = new Actions(webDriver);
        WebElement checkBox = webDriver.findElement(By.id("checkBoxOption1"));

        actions.click(checkBox).build().perform();
        String option = checkBox.getAttribute("value");

        WebElement dropdown = webDriver.findElement(By.id("dropdown-class-example"));
        Select select = new Select(dropdown);

        select.selectByValue(option);

        webDriver.findElement(By.id("name")).sendKeys(option);

        webDriver.findElement(By.id("alertbtn")).click();

        Assert.assertEquals(option,webDriver.switchTo().alert().getText().split(",")[0].split(" ")[1]);

    }

}

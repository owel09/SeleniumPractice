package Rahul;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

/*
 *Created by owel on 21/02/2021 5:37 PM
 */
public class FluentWaitTest {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Documents\\Driver\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //css selector invoking child button
        webDriver.findElement(By.cssSelector("[id= 'start'] button")).click();

        /*
        FluentWait - class
        Wait - interface
        fluentWait - object

        pass the webDrver and explicitly declare the WebDriver

        withTimeout - how much time we will wait to monitor the object
         */
        Wait <WebDriver> fluentWait = new FluentWait <WebDriver>(webDriver).withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);


        WebElement foo = fluentWait.until(new Function<WebDriver, WebElement>() {
            /*
            automatic lumabas ito after ng until
            walang ExpectedConditions si fluenWait kaya gagawa ka ng method na magrereturn ng WebElement

            WebElement - return type ng method
            WebDriver webriver - passing argument
            */
            @Override
            public WebElement apply(WebDriver webDriver) {

                if(webDriver.findElement(By.cssSelector("[id='finish']")).isDisplayed()){
                    return webDriver.findElement(By.cssSelector("[id='finish']"));
                }else
                    return null;
            }
        });
        System.out.println(webDriver.findElement(By.cssSelector("[id='finish']")).getText());


    }
}

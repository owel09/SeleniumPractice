package Rahul;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectListForClearTrips {
    public static void main(String[] args) throws InterruptedException{

        System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Documents\\Driver\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        WebDriver webDriver = new ChromeDriver(chromeOptions);
        webDriver.get("https://www.cleartrip.com/flights");

        //declare dropdown in variable kasi gagamitin ito sa select class
        WebElement adultsDropdown = webDriver.findElement(By.id("Adults"));
        WebElement childrenDropdown = webDriver.findElement(By.id("Childrens"));

        //select return type is webelement
        Select selectAdult = new Select(adultsDropdown);
        selectAdult.selectByIndex(1);

        Select selectChildren = new Select(childrenDropdown);
        selectChildren.selectByIndex(2);

        webDriver.findElement(By.id("DepartDate")).click();

        webDriver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();

        webDriver.findElement(By.id("MoreOptionsLink")).click();
        webDriver.findElement(By.id("AirlineAutocomplete")).sendKeys("airasia");

        Thread.sleep(2000L);

        List<WebElement> option = webDriver.findElements(By.cssSelector("li[class='list'] a"));

        for (WebElement varOption:option){
            if (varOption.getText().contains("AirAsia Japan (DJ)")){
                varOption.click();
                break;
            }
        }

        webDriver.findElement(By.id("SearchBtn")).click();
        System.out.println(webDriver.findElement(By.id("homeErrorMessage")).getText());
    }
}

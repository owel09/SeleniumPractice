package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;
import java.util.List;

/*
 *Created by owel on 25/08/2020 7:51 AM
 */
public class WebDriverRadioButton {
    public static void main(String[] args) {

        WebDriver webDriver = new ChromeDriver(); // new instance ng webDriver
        webDriver.get("D:\\owel\\\\Documents\\1_Owel Docs\\Training\\SeleniumPractice\\src\\main\\\\webapp\\RadioButton.html"); //ito yung url na ioopen or yun html file

        List<WebElement> radioButtons = webDriver.findElements(By.name("gender")); //kaya naka list para ilagay lahat ng radio button sa list
        radioButtons.get(2).click();
        
        for (WebElement radiobutton : radioButtons) {
            if(radiobutton.isSelected()){
                System.out.println(radiobutton.getAttribute("value"));
            }

            
        }




    }
}

package Udemy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
 *Created by Work on 12/08/2021 16:47
 *Page Object Factory Sample
 */
public class L28_2_POF_RediffHomePage {
    WebDriver driver;

    @FindBy(xpath = "//input[@name='srchquery_tbox']")
    WebElement searchBox;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement submit;

    public L28_2_POF_RediffHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }



}

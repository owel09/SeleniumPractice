package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 *Created by owel on 03/08/2020 8:45 AM
 */
public class OrangeHRMsteps {

    WebDriver webDriver;

    @Given("I launch chrome browser")
    public void i_launch_chrome_browser() {

        System.setProperty("webdriver.chrome.driver","D://owel//Documents//Training//Driver//chromedriver.exe");
        webDriver = new ChromeDriver();

    }

    @When("I open orange hrm homepage")
    public void i_open_orange_hrm_homepage() {

        webDriver.get("https://opensource-demo.orangehrmlive.com/");

    }

    @Then("I verify that the logo is present on the page")
    public void i_verify_that_the_logo_is_present_on_the_page() {

        boolean status = webDriver.findElement(By.xpath("//*[@id=\"divLogo\"]/img")).isDisplayed();
        Assert.assertEquals(true,status);

    }

    @Then("close the browser")
    public void close_the_browser() {
        webDriver.quit();

    }
}

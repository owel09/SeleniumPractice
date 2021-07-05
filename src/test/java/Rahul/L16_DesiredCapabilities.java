package Rahul;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/*
 *Created by owel on 05/07/2021 4:36 PM
 */
public class L16_DesiredCapabilities {

    public static void main(String[] args) throws MalformedURLException {

        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setBrowserName("chrome");
        dc.setPlatform(Platform.WINDOWS);

        WebDriver webDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),dc);
        webDriver.get("http://www.google.com");
    }
}

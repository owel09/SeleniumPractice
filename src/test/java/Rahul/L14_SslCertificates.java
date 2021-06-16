package Rahul;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class L14_SslCertificates {

    public static void main(String[] args) {

        //help me to customize chrome browser
        //general chrome profile
        DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
        desiredCapabilities.acceptInsecureCerts();

        desiredCapabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
        desiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);

        //belongs to local browser
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.merge(desiredCapabilities);

        System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Documents\\Driver\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver(chromeOptions);

    }
}

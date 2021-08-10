package Udemy;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
 *Created by Work on 10/08/2021 11:45
 *Running will only display Error and Fatal log in console kasi yung configuration sa log4j2.xml
 *<Root level="error">
 *<AppenderRef ref="Console"/>
 *applies globally yan
*/
public class L27_BetaLog4j {

    private static Logger log = LogManager.getLogger(L27_BetaLog4j.class.getName());

    public static void main(String[] args) {

        log.debug("Beta I clicked button1");
        //When each Selenium action is performed like click, SendKeys, getText()

        log.info("Beta Confirmation page is displayed");
        //When operation is successfully completed ex: After loading page, or after any successful validations
        //It’s just counterpart to log. Error()

        log.error("Beta Confirmation page is not displayed");
        //to log when elements are not displayed in the page or if any validations fail

        log.fatal("Beta button1 is missing");

    }

}

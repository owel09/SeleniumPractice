package Udemy;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
 *Created by Work on 10/08/2021 11:45
 *Running will display all the log message kasi
 *<Logger name = "Udemy.L27_AlphaLog4j" level="trace"
 *Ginawa ko ito in case ang requirement ng client is to view all logs in Alpha but wants only error logs in Beta
 */
public class L27_AlphaLog4j {

    /*
    dapat nasa labas ng psvm yung declaration, bawl kasi yung static sa loob ng psvm
    log - log object. parang initialization ng webDriver
    LogManager - this is an API at nasa loob nya kasi yung getLogger
    getLogger - accepts class argument
    L27_Logger4j.class.getName() - getting the entire path class URL using getName
     */
    private static Logger log = LogManager.getLogger(L27_AlphaLog4j.class.getName());

    public static void main(String[] args) {

        log.debug("I clicked button1");
        //When each Selenium action is performed like click, SendKeys, getText()

        log.info("Confirmation page is displayed");
        //When operation is successfully completed ex: After loading page, or after any successful validations
        //It’s just counterpart to log. Error()

        log.error("Confirmation page is not displayed");
        //to log when elements are not displayed in the page or if any validations fail

        log.fatal("button1 is missing");

    }

}

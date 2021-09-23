package Udemy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.*;

/*
 *Created by Work on 23/9/2021 5:50 PM
 */
public class L31_MySQL_SalesForce {

    public static void main(String[] args) {
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/credentials","root","root");
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from SalesForceLogin");
            while (resultSet.next()){
                System.setProperty("webdriver.chrome.driver","C:\\Driver\\chromedriver.exe");
                WebDriver webDriver = new ChromeDriver();
                webDriver.get("https://login.salesforce.com/");

                webDriver.findElement(By.cssSelector("input[id='username']")).sendKeys(resultSet.getString("SFusername"));
                webDriver.findElement(By.cssSelector("input[id='password']")).sendKeys(resultSet.getString("SFpassword"));

                connection.close();
            }

        }catch(Exception e){
            System.out.println(e);
        }
    }





}

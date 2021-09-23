package Udemy;

import java.sql.*;

/*
 *Created by Work on 21/9/2021 5:00 PM
 */
public class L31_MySQL_Connect_Demo {

    public static void main(String[] args) {

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeportal","root","root");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from employeeinfo");

            while(resultSet.next())
                System.out.println(resultSet.getString(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3)+" "+
                        resultSet.getInt(4));
                connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}

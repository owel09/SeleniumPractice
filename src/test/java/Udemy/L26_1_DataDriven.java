package Udemy;

import java.io.IOException;
import java.util.ArrayList;

/*
Main method ng DataDriven, tinawag nya yung method DataDrivenGetData kasi ipapasa natin yung column value
Identify Name column in the 1st row
Look for Rowell in the column then retrieve the values
 */
public class L26_1_DataDriven {

    public static void main(String[] args) throws IOException {

    L26_1_DataDrivenGetData dataDrivenGetData = new L26_1_DataDrivenGetData();
    ArrayList<String> excelData = dataDrivenGetData.getData("Rowell");

        System.out.println(excelData.get(0));
        System.out.println(excelData.get(1));
        System.out.println(excelData.get(2));
        System.out.println(excelData.get(3));

    }
}

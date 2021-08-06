package Udemy;

import java.io.IOException;
import java.util.ArrayList;

/*
Identify Name column in the 1st row
Look for Rowell in the column then retrieve the values
 */
public class L26_DataDrivenExcel {

    public static void main(String[] args) throws IOException {

    L26_DataDrivenGetData dataDrivenGetData = new L26_DataDrivenGetData();
    ArrayList<String> excelData = dataDrivenGetData.getData("Rowell");

        System.out.println(excelData.get(0));

    }
}

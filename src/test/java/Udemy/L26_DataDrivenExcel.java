package Udemy;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

/*
Basic template para makapag traverse sa sheet
fis - object that gives permission to read the file. Ito lang yung tinatanggap ng workbook
 */
public class L26_DataDrivenExcel {

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\User\\Documents\\Driver\\CardDetails.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        int sheets = workbook.getNumberOfSheets();

        for(int i = 0; i < sheets; i++){

            //after mavalidate yung correct sheet name gamit yung if
            //getSheetName - kailangan nya ng int para magreturn ng string at para makapagcompare tayo
            //idedeclare natin yung sheet para makapagtraverse pa

            if(workbook.getSheetName(i).equalsIgnoreCase("Sheet1")){
                XSSFSheet sheet = workbook.getSheetAt(i);

            }
        }


    }
}

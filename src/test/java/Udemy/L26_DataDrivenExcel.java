package Udemy;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

/*
Basic template para makapag traverse sa sheet
fis - object that gives permission to read the file. Ito lang yung tinatanggap ng workbook
 */
public class L26_DataDrivenExcel {

    public static void main(String[] args) throws IOException {

        //declare fis and workbook
        FileInputStream fis = new FileInputStream("C:\\Users\\User\\Documents\\Driver\\CardDetails.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        //kunin mo yung number of sheets para sa for loop
        int sheets = workbook.getNumberOfSheets();

        //pangtraverse lan ito sa lahat ng sheet
        for(int i = 0; i < sheets; i++){

            //if condition to check yung sheetName tapos idedeclare as sheet
            if(workbook.getSheetName(i).equalsIgnoreCase("Sheet1")){
                XSSFSheet sheet = workbook.getSheetAt(i);

                //access yung first row
                Iterator<Row> rows = sheet.iterator();
                Row firstRow = rows.next();

                //access yung columns
                Iterator<Cell> cells = firstRow.cellIterator();
                while(cells.hasNext()){

                    Cell value = cells.next();
                    if(value.getStringCellValue().equalsIgnoreCase("CardNumber")){
                        System.out.println("true");
                    }
                }

            }
        }


    }
}

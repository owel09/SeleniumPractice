package Udemy;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class L26_DataDrivenPractice1 {

    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("C:\\Users\\Work\\Documents\\CardDetails.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        int numSheet = workbook.getNumberOfSheets();

        for(int i = 0 ; i < numSheet ; i++ ){
            if(workbook.getSheetName(i).equalsIgnoreCase("Sheet2")){

                XSSFSheet correctSheet = workbook.getSheetAt(i);

                Iterator<Row> rowIterator = correctSheet.iterator();
                Row firstRow = rowIterator.next();

                Iterator<Cell> cells = firstRow.cellIterator();

                while(cells.hasNext()){

                    Cell headerValue = cells.next();
                    if(headerValue.getStringCellValue().equalsIgnoreCase("Test Case")){
                        System.out.println(headerValue);
                        System.out.println(headerValue.getColumnIndex());
                        int correctColumn = headerValue.getColumnIndex();

                        while(rowIterator.hasNext()){
                            Row rowSearch = rowIterator.next();
                            if(rowSearch.getCell(correctColumn).getStringCellValue().equalsIgnoreCase("Login")){
                                Iterator<Cell> cellGrab = rowSearch.cellIterator();

                                while (cellGrab.hasNext()){
                                    System.out.println(cellGrab.next());
                                }
                            }
                        }
                    }


                }




            }

        }


    }

}

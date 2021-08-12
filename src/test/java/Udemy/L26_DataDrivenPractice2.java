package Udemy;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class L26_DataDrivenPractice2 {

    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("C:\\Users\\Work\\Documents\\CardDetails.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        for(int i = 0 ; i < workbook.getNumberOfSheets() ; i++){
            if(workbook.getSheetName(i).equalsIgnoreCase("Sheet3")){
                XSSFSheet correctSheet = workbook.getSheetAt(i);

                Iterator<Row> rowIterator = correctSheet.iterator();
                Row firstRow = rowIterator.next();

                Iterator<Cell> cellSearch = firstRow.cellIterator();

                while (cellSearch.hasNext()){
                    Cell cellValue = cellSearch.next();

                    if(cellValue.getStringCellValue().equalsIgnoreCase("Factory")){
                        Cell correctHeader = cellValue;

                        System.out.println(correctHeader);
                        int correctColumnIndex = correctHeader.getColumnIndex();
                        System.out.println(correctColumnIndex);

                        while (rowIterator.hasNext()){
                            Row rowSearch = rowIterator.next();
                            if(rowSearch.getCell(correctColumnIndex).getStringCellValue().equalsIgnoreCase("Oklahoma")){
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

package Udemy;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class L26_1_DataDrivenGetData {

    public ArrayList<String> getData(String userInput) throws IOException {
        //declare fis and workbook
        //fis - object that gives permission to read the file. Ito lang yung tinatanggap ng workbook
        FileInputStream fis = new FileInputStream("C:\\Users\\Work\\Documents\\CardDetails.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        //declare array list kasi dito natin iistore yung nakuha natin sa excel
        ArrayList<String> arrayList = new ArrayList<>();

        //kunin mo yung number of sheets para sa for loop
        int sheets = workbook.getNumberOfSheets();

        //pangtraverse lan ito sa lahat ng sheet
        for(int i = 0; i < sheets; i++){

            //if condition to check yung sheetName tapos idedeclare as sheet
            if(workbook.getSheetName(i).equalsIgnoreCase("Sheet1")){

                //Access to the sheet
                XSSFSheet sheet = workbook.getSheetAt(i);

                //Access to all the rows in the sheet
                //sheet - have all the rows but we need to iterate
                //rows - will have the ability to iterate each rows in the excel
                Iterator<Row> rows = sheet.iterator();

                //Access to 1st rows from all the rows
                Row firstRow = rows.next();

                //Reading each cell/column in the row
                Iterator<Cell> cells = firstRow.cellIterator();

                //initialize counter k so I could store it in the column;
                int k = 0;
                int column = 0;

                //checking if the next cell is still present or not. left to right ang movement
                while(cells.hasNext()){

                    //kapag present, dito pa lang sya mag-momove
                    Cell value = cells.next();
                    if(value.getStringCellValue().equalsIgnoreCase("Name")){
                        column = k;

                    }
                    k++;
                }

                //Scan only specific column
                //this is the concept how we go each cell in the first row like above, if present then proceed
                //sa line 52 kasi cell yun pero dito row, pababa ang movement natin at checking kung may value
                while(rows.hasNext()){

                    //if row is present mapupunta siya sa column index 1, hindi sa header
                    Row rowSearch = rows.next();

                    //kunin mo muna yung correct column gamit yung getCell tapos icompare yung laman ng row gamit IF
                    if(rowSearch.getCell(column).getStringCellValue().equalsIgnoreCase(userInput)){

                        //going to each cell again gamit ulit yung Iterator
                        Iterator<Cell> cellGrab = rowSearch.cellIterator();
                        while (cellGrab.hasNext()){

                            //LOGIC TO CHECK VALUE EACH CELL IF STRING OR NUMERIC. Di kasi ireretrieve kapag naka General mode yung cell sa excel
                            //Store muna sa checker
                            Cell checkCellType = cellGrab.next();
                            if(checkCellType.getCellType()== CellType.STRING){
                                //yung string ilalagay mo sa arraylist gamit yung add
                                arrayList.add(checkCellType.getStringCellValue());
                            }
                            else{
                                arrayList.add(NumberToTextConverter.toText(checkCellType.getNumericCellValue()));
                            }

                        }

                    }
                }

            }
        }

        return arrayList;
    }
}

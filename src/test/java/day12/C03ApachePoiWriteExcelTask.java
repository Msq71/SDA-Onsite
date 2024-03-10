package day12;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class C03ApachePoiWriteExcelTask {

    //Create an object of File class to open xlsx file.
    //Create an object of FileInputStream class to read excel file.
    //Create an object of FileInputStream class to read excel file.
    //Creating workbook instance that refers to .xlsx file.
    //Creating a Sheet object.
    //Get all rows in the sheet.
    //Create a row object to retrieve row at index 3.
    //Create a cell object to enter value in it using cell Index.
    //Write the data in excel using output stream.

    @Test
    public void test01() throws IOException {

        //Create an object of File class to open xlsx file.
        //Create an object of FileInputStream class to read excel file.
        //Create an object of FileInputStream class to read excel file.
        //Creating workbook instance that refers to .xlsx file.
        String separator = System.getProperty("file.separator");
        String path = System.getProperty("user.dir") + separator + "resources" + separator + "excelfile.xlsx";

        FileInputStream fis = new FileInputStream(path);
        Workbook wb = WorkbookFactory.create(fis);

        //Creating a Sheet object.
        Sheet sheet1 = wb.getSheetAt(0);

        //Get all rows in the sheet.
        int rowsUsed = 0;
        while (true) {
            if (sheet1.getRow(rowsUsed).getCell(0) == null) {
                rowsUsed--;
                break;
            }
            rowsUsed++;
        }
        List<Row> rowsList = new ArrayList<>();
        for (int i = 0; i <= rowsUsed; i++) {
            rowsList.add(sheet1.getRow(i));
        }
        System.out.println(rowsList.size());

        //Create a row object to retrieve row at index 3.
        Row row3 = sheet1.getRow(2);

        //Create a cell object to enter value in it using cell Index.
        Cell cell3 = row3.createCell(2);
        cell3.setCellValue("test");

        //Write the data in excel using output stream.
        FileOutputStream fos = new FileOutputStream(path);
        wb.write(fos);

        wb.close();
        fis.close();
        fos.close();

    }

    @Test
    public void test02() throws IOException {

        //Store the path of the file as string and open the file.
        String separator = System.getProperty("file.separator");
        String path = System.getProperty("user.dir") + separator + "resources" + separator + "excelfile.xlsx";

        //Open the workbook.
        FileInputStream fis = new FileInputStream(path);
        Workbook wb = WorkbookFactory.create(fis);

        //Open the first worksheet.
        Sheet sheet1 = wb.getSheetAt(0);

        //Go to the second row.
        Row row2 = sheet1.getRow(1);
        //Modify third cell,
        Cell c23 = row2.getCell(2);
        c23.setCellValue(1111);

        //Get the number of rows used:
        int rowsUsed = 0;
        while (true) {
            if (sheet1.getRow(rowsUsed).getCell(0) == null) {
                break;
            }
            rowsUsed++;
        }

        System.out.println(rowsUsed);

        // for loop to modify all cell in column 3 as 1111 , 2222 , ...
        for (int i = 1; i < rowsUsed; i++) {   // start from i=1 to skip row1
            Row row = sheet1.getRow(i);        // it will write 15 times
            Cell cell = row.createCell(2);
            cell.setCellValue(i + "" + i + "" + i + "" + i);
        }

        //to clear the value of a cell use cell.setBlank():
       /* Row row17 = sheet1.getRow();
        Cell c173 = row17.getCell();
        c173.setBlank();
        */

        //Write and save the workbook.
        FileOutputStream fos = new FileOutputStream(path);
        wb.write(fos);

        //Close the file.
        //Close the workbook.
        wb.close();
        fos.close();
        fis.close();

    }
}


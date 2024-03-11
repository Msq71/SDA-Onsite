package day13;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


/*
Go to URL: http://demo.guru99.com/test/web-table-element.php
To find third row of table
To get 3rd row's 2nd column data
Get all the values of a Dynamic Table
 */
public class C01WebTables extends TestBase {

    @Test
    public void test01() {

        driver.get("http://demo.guru99.com/test/web-table-element.php");

        // 1) To find third row of table:
        WebElement thirdRow = driver.findElement(By.xpath("//table[@class = 'dataTable']//tbody//tr[3]"));


        // 2) To get 3rd row's 2nd column data:
        WebElement thirdRow2SecondData = driver.findElement(By.xpath("//table[@class='dataTable']//tbody//tr[3]/td[2]"));


        // 3) Get all the values of a Dynamic Table:  (all rows data)
        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='dataTable']//tbody//tr"));

        List<String> allRowsValues = new ArrayList<>();

        for (WebElement tr : rows) {
            allRowsValues.add(tr.getText());
        }

        for (String r : allRowsValues) {
            // System.out.println(r);
            // System.out.println("----------------------------------------");
        }

        //-----------------------------------------------------------------------------------------------------------------


        for (int i = 0; i < rows.size(); i++) {
            List<WebElement> rowsData = rows.get(i).findElements(By.tagName("td"));
            int columnSize = rowsData.size();
            for (int j = 0; j < columnSize; j++) {
                System.out.print(rowsData.get(j).getText() + " ");
            }
            System.out.println();
        }

    }
}

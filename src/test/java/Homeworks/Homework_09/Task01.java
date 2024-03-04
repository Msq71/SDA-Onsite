package Homeworks.Homework_09;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Task01 extends TestBase {
    /*
    Go to URL: http://demo.guru99.com/test/drag_drop.html
Drag and drop the BANK button to the Account section in DEBIT SIDE
Drag and drop the SALES button to the Account section in CREDIT SIDE
Drag and drop the 5000 button to the Amount section in DEBIT SIDE
Drag and drop the second 5000 button to the Amount section in CREDIT SIDE
Verify the visibility of Perfect text.
     */
    @Test
    public void test() throws InterruptedException {

        //Go to http://demo.guru99.com/test/drag_drop.html
        driver.get("http://demo.guru99.com/test/drag_drop.html");

        //Drag and drop the BANK button to the Account section in DEBIT SIDE
        WebElement bank = driver.findElement(By.id("credit2"));
        WebElement accountDebit = driver.findElement(By.id("bank"));
        actions.dragAndDrop(bank, accountDebit).perform();

        //Drag and drop the SALES button to the Account section in CREDIT SIDE
        WebElement sales = driver.findElement(By.id("credit1"));
        WebElement accountCredit = driver.findElement(By.id("loan"));
        actions.dragAndDrop(sales, accountCredit).perform();

        //Drag and drop the 5000 button to the Amount section in DEBIT SIDE
        WebElement button5k = driver.findElement(By.id("fourth"));
        WebElement amountDebit = driver.findElement(By.id("amt7"));
        actions.dragAndDrop(button5k, amountDebit).perform();

        //Drag and drop the second 5000 button to the Amount section in CREDIT SIDE
        WebElement sbutton5k = driver.findElement(By.xpath("//li[@id='fourth'][2]"));
        WebElement amountCredit = driver.findElement(By.id("amt8"));
        actions.dragAndDrop(sbutton5k, amountCredit).perform();

        //Verify the visibility of Perfect text.
        WebElement perfect = driver.findElement(By.xpath("//a[.='Perfect!']"));
        Assert.assertTrue(perfect.isDisplayed());
    }
}

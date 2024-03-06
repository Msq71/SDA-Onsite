package Homeworks.Homework_11;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Task03 extends TestBase {
    /*
    Day:11/HW:3 ------> Will be done on weekend
Go to URL: https://opensource-demo.orangehrmlive.com/
Login page valid credentials.
Click PIM on the left sidebar
Click Configuration and select Data Import
Download sample CSV file.
Verify if the file downloaded successfully.
     */
    @Test
    public void test(){
        By userName = By.name("username");
        By password = By.name("password");
        By submit = By.xpath("//button[@type='submit']");
        By pin = By.xpath("//a[normalize-space()='']");


        //Go to URL: https://opensource-demo.orangehrmlive.com/
        driver.get("https://opensource-demo.orangehrmlive.com/");

        //Login page valid credentials.  //Username: Admin , //Password: admin123

        //Entering Username:
        driver.findElement(userName).sendKeys("Admin");
        //Entering Password:
        driver.findElement(password).sendKeys("admin123");
        //Click on Login button:

       WebElement login = driver.findElement(submit);
        actions.click(login).perform();

        //Click PIM on the left sidebar
        driver.findElement(pin).click();

        //Click Configuration and select Data Import

        //Download sample CSV file.

        //Verify if the file downloaded successfully.
    }

}

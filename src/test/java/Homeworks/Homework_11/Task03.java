package Homeworks.Homework_11;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.nio.file.Files;
import java.nio.file.Path;

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
    public void test() throws InterruptedException {
        By userName = By.name("username");
        By password = By.name("password");
        By submit = By.xpath("//button[@type='submit']");
        By pin = By.xpath("//a[@href=\"/web/index.php/pim/viewPimModule\"]");
        By configuration = By.xpath("//span[@class='oxd-topbar-body-nav-tab-item']");
        By dataImport = By.xpath("//li[.='Data Import']");
        By download = By.className("download-link");


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
        driver.findElement(configuration).click();
        Thread.sleep(1200);
        driver.findElement(dataImport).click();


        //Download sample CSV file.
        driver.findElement(download).click();
        Thread.sleep(800);


        //Verify if the file downloaded successfully.
        String fileName = "importData.csv";
        String userHome = System.getProperty("user.home");
        String separator = System.getProperty("file.separator");
        String pathOfFile = userHome + separator + "Downloads" + separator + fileName;
        // "C:\Users\Msqx7\Downloads\importData.csv"
        boolean isExist = Files.exists(Path.of(pathOfFile));
        Assert.assertTrue(isExist);
    }

}

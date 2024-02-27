package Homeworks.Homework_05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.sql.Driver;
import java.time.Duration;
import java.util.List;
public class Task01 {
  /*  Task 1:
    Go to URL: https://demoqa.com/radio-button
    Verify whether all 3 options given to the question can be selected.
    When each option is selected, print the following texts on the console. */

    @Test
    public void radButtonTest() throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        WebDriver driver= new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Go to URL:  https://demoqa.com/radio-button
        driver.get("https://demoqa.com/radio-button");

       // Verify whether all 3 options given to the question can be selected.

        WebElement yes = driver.findElement(By.xpath("//*[@id=\"yesRadio\"]"));
        yes.click();
        Assert.assertTrue(yes.isSelected());
        System.out.println("yesRadButton is selectable");

        WebElement impressive = driver.findElement(By.xpath("//*[@id=\"impressiveRadio\"]"));
        impressive.click();
        Assert.assertTrue(impressive.isSelected());
        System.out.println("impRadButton is selectable");

        WebElement radioNo = driver.findElement(By.xpath("//*[@id=\"noRadio\"]"));
        radioNo.click();
        Assert.assertFalse(radioNo.isSelected());
        System.out.println("noRadButton is not selectable");

        //close driver/
        driver.quit();

    }

}

//  JavascriptExecutor js = (JavascriptExecutor) driver;
// js.executeScript();
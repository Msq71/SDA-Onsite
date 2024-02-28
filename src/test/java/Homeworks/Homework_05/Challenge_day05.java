package Homeworks.Homework_05;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class Challenge_day05 {

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
       //Launch Browser
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Assert Browser is opened
        Assert.assertNotNull(driver);
    }

    @Test
    public void test1() throws InterruptedException {
        //Navigate to the application
        driver.get("https://webdriveruniversity.com/To-Do-List/index.html");
        System.out.println(driver.getCurrentUrl());
        //Assert Page is visible successfully
        Assert.assertEquals("https://webdriveruniversity.com/To-Do-List/index.html", driver.getCurrentUrl());

        Thread.sleep(2000);

        //Add a TODO to the list
        String toDoText = "task1";
        driver.findElement(By.xpath("//input[@placeholder='Add new todo']")).sendKeys(toDoText+ Keys.ENTER);

        //Assert TODO has been added to the list
        WebElement task1 = driver.findElement(By.xpath("//li[contains(text(), 'task1')]"));
        Assert.assertTrue(task1.isDisplayed());

        Thread.sleep(2000);

        //Remove the TODO that you've added
        WebElement delTask = driver.findElement(By.xpath("//li[contains(text(), '"+toDoText+"')]//i[@class='fa fa-trash']"));
        delTask.click();

        Thread.sleep(2000);
        // Assert TODO has been removed from the list
        List<WebElement> toDoList = driver.findElements(By.xpath("//ul/li"));
        boolean result = true;
        for(WebElement t:toDoList){
           if(t.getText().equals(toDoText)) {
               result = false;
           }
        }
        Assert.assertTrue(result); // ?

        Thread.sleep(2000);

        //Mark a TODO as completed
        //Mark (click) "Go to potion class" (first todo task)
        driver.findElement(By.xpath("//ul/li[1]")).click();

        //after click , TODO has been marked as completed successfully
        boolean lined = driver.findElement(By.xpath("//li[@class='completed']")).isDisplayed();
        Assert.assertTrue(lined);


        //close driver
        driver.quit();
    }


}
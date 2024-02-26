package Homeworks.Homework_03;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task_10 {
    // Go to Automation Exercises homepage
// Find the locators of the relevant areas and click on them
// https://automationexercise.com/
// Task 01 --> " Home "
// Task 02 --> " Products "
// Task 03 --> " Cart "
// Task 04 --> " Signup / Login "
// Task 05 --> " Test Cases "
// Task 06 --> " API Testing "
// Task 07 --> " Video Tutorials "
// Task 08 --> " Contact us "
    static WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
    @Test
    public void findHome() {
        WebElement homeButton = driver.findElement(By.tagName("a"));
        homeButton.click();
        WebElement homeButton2 = driver.findElement(By.linkText("Home")); homeButton2.click();
        WebElement homeButton3 = driver.findElement(By.xpath("//*[@class='fa fa-home']"));
        homeButton3.click(); }

}

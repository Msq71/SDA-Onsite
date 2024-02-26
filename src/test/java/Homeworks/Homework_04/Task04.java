package Homeworks.Homework_04;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task04 {
    /* Task 4:
Navigate to https://testpages.herokuapp.com/styled/index.html
Click on Simple Calculator under Micro Apps.
Type any number in the first input.
Type any number in the second input.
Click on Calculate.
Get the result.
Print the result. */

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
       // Navigate to https://testpages.herokuapp.com/styled/index.html
        driver.get("https://testpages.herokuapp.com/styled/index.html");
    }

    @AfterClass // Close driver.
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void test() {
        // Click on Simple Calculator under Micro Apps.
        driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div[1]/a/img")).click();

        // Type any number in the first input.
        driver.findElement(By.id("number1")).sendKeys("2");

        // Type any number in the second input.
        driver.findElement(By.id("number2")).sendKeys("4");

        // Click on Calculate.
        driver.findElement(By.id("calculate")).click();

        // Get the result.
        String result = driver.findElement(By.id("answer")).getText();

        // Print the result.
        System.out.println("result = "+ result);
    }
}

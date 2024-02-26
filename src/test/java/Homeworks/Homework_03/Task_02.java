package Homeworks.Homework_03;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Task_02 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        // Go to www.yahoo.com
        driver.get("https://yahoo.com");

        // Maximize Window
        driver.manage().window().maximize();
        ;
        // Go to www.amazon.com
        driver.get("https://www.amazon.com");

        // Maximize Window
        driver.manage().window().maximize();

        // Navigate Back
        driver.navigate().back();

        // Navigate Forward
        driver.navigate().forward();

        // Refresh The Page
        driver.navigate().refresh();

        // Close the Browser.
        driver.quit();

    }
}

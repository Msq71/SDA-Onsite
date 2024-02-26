package Homeworks.Homework_03;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;

public class Task_03 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        // Expected Title
        String expectedTitle = "Github";

        // Open URL of Website
        driver.get("https://Github.com");
        Thread.sleep(1000);

        // Maximize Window
        driver.manage().window().maximize();
        Thread.sleep(2000);

        // Get Title of current Page
       String actualTitle = driver.getTitle();

        // Validate/Compare Page Title
        if (expectedTitle.equals(actualTitle)){
            System.out.println("pass");
        } else System.out.println("fail");

        System.out.println("actualTitle is : "+ actualTitle);

        // Close Browser
        driver.quit();
    }
}

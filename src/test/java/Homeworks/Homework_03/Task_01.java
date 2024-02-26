package Homeworks.Homework_03;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task_01 {

    public static void main(String[] args) {

        // Invoke Chrome Browser
        WebDriver driver = new ChromeDriver();

        // Navigate to URL: https://www.w3schools.com/
        driver.get("https://www.w3schools.com");

        // Navigate to URL: https://stackoverflow.com/
        driver.get("https://stackoverflow.com");

        // Come back to the w3schools using the back command.
        driver.navigate().back();

        // Again go back to the stackoverflow website using forward command
        driver.navigate().forward();

        // Refresh the Browser using refresh command.
        driver.navigate().refresh();

        // Close the Browser.
        driver.quit();
    }










}

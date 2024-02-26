package Homeworks.Homework_03;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task_04 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        // Go to the w3school URL : https://www.w3schools.com/
        driver.get("https://www.w3schools.com/");

        // Print the position and size of the page.
        System.out.println("Position of the page = " + driver.manage().window().getPosition());
        System.out.println("Size of the page = " + driver.manage().window().getSize());

        // Adjust the position and size of the page as desired.
        Point newPosition = new Point(50,50);
        driver.manage().window().setPosition(newPosition);

        Dimension newSize = new Dimension(1300,400);
        driver.manage().window().setSize(newSize);

        // Test that the page is in the position and size you want. // Close the page.
        Thread.sleep(2000);
        System.out.println("New position = " + driver.manage().window().getPosition());
        System.out.println("New size = " + driver.manage().window().getSize());
        driver.quit();
    }
}

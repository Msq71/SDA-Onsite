package Homeworks.Homework_03;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Task_06 {
    public static void main(String[] args) {


        // Invoke MicrosoftEdge Driver
        WebDriver driver = new EdgeDriver();

        // Go to https://www.youtube.com/
        driver.get("https://www.youtube.com/");

        // Maximize the window
        driver.manage().window().maximize();

        // Verify the page title contains the word video.
        if (driver.getTitle().contains("video")){
            System.out.println("Contains 'Video'");
        } else System.out.println("does not contain 'video'");

        // Minimize the window
        driver.manage().window().minimize();

        // Make the page fullscreen
        driver.manage().window().fullscreen();

        // Close the driver.
        driver.quit();
    }
}

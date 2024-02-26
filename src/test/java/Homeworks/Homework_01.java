package Homeworks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework_01 {

    //Create main method
        public static void main(String[] args) {

    //Create chrome driver
        WebDriver driver = new ChromeDriver();

    //Open google home page: https://www.google.com
        driver.get("https://www.google.com");

    //Print Title on page
        System.out.println("Title is: " + driver.getTitle());

    //Print Current URL on page
        System.out.println("Current url is: " + driver.getCurrentUrl());

    //Close/Quit the browser
    driver.quit();

    }
}

package day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03NavigationCommands {

    public static void main(String[] args) {

        // Creating a WebDriver object
        WebDriver driver = new ChromeDriver();

        // Opening Google website
        driver.get("https://www.google.com");

        // Opening Clarusway website
        driver.get("https://www.clarusway.com");

        // NAVIGATION COMMANDS

        // back() opens the previous page
        System.out.println("Current Url is: " + driver.getCurrentUrl());
        driver.navigate().back();
        System.out.println("title is = " + driver.getTitle());

        // forward() opens the next page after going back
        driver.navigate().forward();
        System.out.println("Current Url is: " + driver.getCurrentUrl());

        // refresh() refreshes the page
        driver.navigate().refresh();

        // to() - performs the same function as the get() method
         driver.navigate().to("https://www.amazon.com");

         driver.quit();

    }
}

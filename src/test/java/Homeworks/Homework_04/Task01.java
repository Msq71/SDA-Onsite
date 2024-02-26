package Homeworks.Homework_04;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task01 {

    // task01:
    // Type "Green Mile" in the search box and print the number of results.
    // Type "Premonition" in the search box and print the number of results.
    // Type "The Curious Case of Benjamin Button" in the search box and print the number of results.
        static WebDriver driver;
        By searchBox = By.name("q"); // make findElement by easy to read
        By result = By.id("result-stats"); // make findElement by easy to read

        @BeforeClass
        public static void setUp() {
           // Create the driver with BeforeClass and make it static inside the class.
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
           // Go to http://www.google.com
            driver.get("https://www.google.com/");
        }

        @AfterClass // Close with AfterClass
        public static void tearDown() {
            driver.quit();
        }

        @Test
        public void test1() {
            // Type "Green Mile" in the search box.
            driver.findElement(searchBox).sendKeys("Green Mile"+ Keys.ENTER);
            String totalResult = driver.findElement(result).getText();
            // print the number of results
            System.out.println(totalResult);
        }

    @Test
    public void test2() {
        // Clear the textBox or go again to home page driver.get(google)
        driver.get("https://www.google.com/");
        // Type "Premonition" in the search box.
        driver.findElement(searchBox).sendKeys("Premonition"+ Keys.ENTER);
        // print the number of results.
        System.out.println(driver.findElement(result).getText());
    }

    @Test
    public void test3() {
        // Clear the textBox
        driver.findElement(searchBox).clear();
        // Type "The Curious Case of Benjamin Button" in the search box.
        driver.findElement(searchBox).sendKeys("The Curious Case of Benjamin Button"+ Keys.ENTER);
        // print the number of results.
        System.out.println(driver.findElement(By.id("result-stats")).getText());
    }
}


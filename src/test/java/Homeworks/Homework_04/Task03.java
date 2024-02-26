package Homeworks.Homework_04;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task03 {

    /*  Task 3:
    Go to https://id.heroku.com/login.
    Enter an e-mail address.
    Enter a password.
    Click on the Login button.
    There was a problem with your login.
    If text is visible, print "Registration Failed".
    If the text is not visible, print "Registered".
    Close all pages. */

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Go to https://id.heroku.com/login
        driver.get("https://id.heroku.com/login");
    }

    @AfterClass // Close driver.
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void test() {
        // Enter an e-mail address.
        driver.findElement(By.id("email")).sendKeys("Msqx71@gmail.com");
        // Enter a password
        driver.findElement(By.id("password")).sendKeys("123456");
        // Click on the Login button.
        driver.findElement(By.name("commit")).click();
        // There was a problem with your login.
        WebElement message = driver.findElement(By.xpath("//*[@id='login']/form/div[1]"));
        // If text is visible, print "Registration Failed".
        if(message.isDisplayed()){
            System.out.println("Registration Failed");
            // If the text is not visible, print "Registered".
        } else System.out.println("Registered");
    }
}

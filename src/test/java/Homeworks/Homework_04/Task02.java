package Homeworks.Homework_04;

import net.bytebuddy.asm.Advice;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/* Navigate to website  https://testpages.herokuapp.com/styled/index.html
Under the Examples
Click on Locators - Find By Playground Test Page
Print the URL
Navigate back
Print the URL
Click on WebDriver Example Page
Print the URL
Enter value 🡪 20 and Enter to "Enter Some Numbers inputBox"
And then verify 'two, zero' message is displayed on page
Close driver. */

public class Task02 {

  static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        // Go to https://testpages.herokuapp.com/styled/index.html
        driver.get("https://testpages.herokuapp.com/styled/index.html");
    }

    @AfterClass // Close driver.
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void test() {
        // Click on Locators - Find By Playground Test Page
        driver.findElement(By.partialLinkText("Locators - Find")).click(); // We can find it by id also.
        // Print the URL
        System.out.println("Url1 = " + driver.getCurrentUrl());
        // Navigate back
        driver.navigate().back();
        // Print the URL
        System.out.println("Url2 = " + driver.getCurrentUrl());
        // Click on WebDriver Example Page
        driver.findElement(By.id("webdriverexamplepage")).click();
        // Print the URL
        System.out.println("Url3 = " + driver.getCurrentUrl());
       // Enter value 🡪 20 and Enter to "Enter Some Numbers inputBox"
        driver.findElement(By.id("numentry")).sendKeys("20" + Keys.ENTER);
       // verify 'two, zero' message is displayed on page
        WebElement message = driver.findElement(By.id("message"));
        Assert.assertTrue(message.isDisplayed());
    }
}

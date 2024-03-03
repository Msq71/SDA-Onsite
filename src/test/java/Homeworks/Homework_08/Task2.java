package Homeworks.Homework_08;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Task2 {
    /*
    Go to URL: https://the-internet.herokuapp.com/windows
Verify the text: “Opening a new window”
Verify the title of the page is “The Internet”
Click on the “Click Here” button
Verify the new window title is “New Window”
Go back to the previous window and then verify the title: “The Internet”
     */
    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test() throws InterruptedException {
        //Go to URL: https://the-internet.herokuapp.com/windows
        driver.get("https://the-internet.herokuapp.com/windows");
        String handle1 = driver.getWindowHandle();

        //Verify the text: “Opening a new window”
        WebElement text = driver.findElement(By.xpath("//h3[.='Opening a new window']"));
        Assert.assertTrue(text.isDisplayed());

        //Verify the title of the page is “The Internet”
       String title = driver.getTitle();
       Assert.assertEquals("The Internet",title);

       //Click on the “Click Here” button
        WebElement clickButton = driver.findElement(By.xpath("//a[@href='/windows/new']"));
        clickButton.click();


        // Wait for the new window to be available
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        String handle2 = driver.getWindowHandle();
        driver.switchTo().window(handle2);
        //Verify the new window title is “New Window”
        String title2 = driver.getTitle();
        Assert.assertEquals("New Window",title2);

        //Go back to the previous window and then verify the title: “The Internet”
        driver.switchTo().window(handle1);
        System.out.println("driver.getTitle() = " + driver.getTitle());
        Assert.assertEquals("The Internet",title);
    }

}

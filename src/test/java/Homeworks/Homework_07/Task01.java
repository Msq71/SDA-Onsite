package Homeworks.Homework_07;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task01 {

    //Go to: https://the-internet.herokuapp.com/javascript_alerts
    //click on JS alert.
    //click on JS confirm.
    //click on JS prompt.

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test
    public void test() throws InterruptedException {
        //click on JS alert.
        driver.findElement(By.xpath("//button[@onclick = 'jsAlert()']")).click();
        Thread.sleep(1000);

        Alert alert = driver.switchTo().alert();

        //Handling first alert
        alert.accept();
        //Assert
        WebElement result = driver.findElement(By.id("result"));
        result.getText().equals("You successfully clicked an alert");
        boolean a1 = result.isDisplayed();
        Assert.assertTrue(a1);

        //click on JS confirm.
        driver.findElement(By.xpath("//button[@onclick = 'jsConfirm()']")).click();
        Thread.sleep(1000);
        //Handling Second alert
        alert.accept();
        //Assert
        result.getText().equals("You clicked: Ok");
        boolean a2 = result.isDisplayed();
        Assert.assertTrue(a2);

        //click on JS prompt.
        driver.findElement(By.xpath("//button[@onclick = 'jsPrompt()']")).click();
        Thread.sleep(1000);

        //Handling third alert
        alert.sendKeys("Mohammed");
        Thread.sleep(1000);
        alert.accept();
        //Assert
        result.getText().equals("Mohammed");
        boolean a3 = result.isDisplayed();
        Assert.assertTrue(a3);


    }
}

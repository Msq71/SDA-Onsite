package day04;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Challenge {
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        Assert.assertNotNull(driver);
    }
    @Test
    public void test1() {

        driver.get("http://automationexercise.com");
         Assert.assertEquals("https://automationexercise.com/",driver.getCurrentUrl());

        driver.findElement(By.xpath("//a[@href = '/login']")).click();
        Assert.assertFalse(driver.getCurrentUrl().equals("http://automationexercise.com"));
        WebElement emailBox = driver.findElement(By.name("email"));
        Assert.assertTrue(emailBox.isDisplayed());

        driver.findElement(By.name("email")).sendKeys("sda@test.com");
        driver.findElement(By.name("password")).sendKeys("sdainclasstask");


         driver.findElement(By.xpath("//button[. = 'Login']")).click();
        WebElement deleteAcc = driver.findElement(By.xpath("//a[@href ='/delete_account']"));
        Assert.assertTrue(deleteAcc.isDisplayed());


    }
}
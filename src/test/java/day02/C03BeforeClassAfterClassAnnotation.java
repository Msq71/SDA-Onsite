package day02;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;

public class C03BeforeClassAfterClassAnnotation {
    static WebDriver driver;

    @BeforeClass
    public static void beforeClass(){
        driver = new ChromeDriver();
        System.out.println("Before class method is executed...");
    }

    @AfterClass
    public static void afterClass(){
        driver.quit();
        System.out.println("After class method is executed...");
    }

    @Test
    public void test01()
    {
        driver.get("https://www.clarusway.com");
        driver.manage().window().maximize();
        System.out.println("Test 1 is executed");
    }

    @Test
    public void test02()
    {
        driver.get("https://www.Google.com");
        System.out.println("Test 2 is executed");
    }
}
package day14;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Driver;


public class C02TestNG {
    static WebDriver driver;

    @Test(priority = 2)
    public void test01() {
        System.out.println("Test01 is executed");
    }

    @Test(priority = 1, dependsOnMethods = {"test01"})
    public void test02() {
        System.out.println("Test02 is executed");
    }

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test(description = "this is faceBook TEST")
    public void faceBook() {
        driver.get("https://www.facebook.com/");
    }

    @Test(dependsOnMethods = {"faceBook"} , description = "this is google TEST")
    public void google() {
        driver.get("https://www.google.com.sa/");
    }

    @Test(dependsOnMethods = {"google"}, description = "this is amazon TEST")
    public void amazon() {
        driver.get("https://www.amazon.sa/");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}

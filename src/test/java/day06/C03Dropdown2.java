package day06;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C03Dropdown2 {
    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/select-menu");
    }

    @Test
    public void dropDownTest(){
        // first locate the webElement with 'select' tag
        WebElement element = driver.findElement(By.id("oldSelectMenu"));

        // Create select object
        Select select = new Select(element);

        // Use methods through the select object

        // select by index
        select.selectByIndex(3);
        select.selectByValue("4");
        select.selectByValue("red");
        select.selectByVisibleText("Purple");
        System.out.println("select.isMultiple() = " + select.isMultiple()); //false --> cannot select multiple options
        //////////////////////////
        // Standard multi select (drop down)
        WebElement element2 = driver.findElement(By.id("cars"));
        Select select2 = new Select(element2);
        System.out.println("select2.isMultiple() = " + select2.isMultiple()); //true --> can select multiple options
    }
    
    @AfterClass
    public static void tearDown(){
        //driver.quit();
    }

}

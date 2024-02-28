package day06;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C05DropDownExercise {
    /*
    https://demoqa.com/select-menu
    Get all the options of the dropdown
    Options size
    Print all test
    Verify the dropdown has option "Black"
    Print FirstSelectedOptionTest
    Select option "Yellow"
     */
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/select-menu");
    }
    @AfterClass
    public static void tearDown (){
        driver.quit();
    }
    @Test
    public void test(){
        //Get all the options of the dropdown
        WebElement element = driver.findElement(By.id("oldSelectMenu"));
        Select select = new Select(element);
        List<WebElement> options = select.getOptions();

        //Options size
        int sizeOfOptions = options.size();

        //Print all test
        for (WebElement option:options){
            System.out.println(option.getText());
        }
        /*or use for loop

         for (int i =0; i<options.size(); i++){
            System.out.println(options.get(i).getText());
        }
        */

        //Verify the dropdown has option "Black"
        List<String> coloursList = new ArrayList<>();

        for (WebElement option: options){
            coloursList.add(option.getText());
        }

        Assert.assertTrue(coloursList.contains("Black"));
        //Print FirstSelectedOptionTest
        System.out.println(select.getFirstSelectedOption().getText());

        //Select option "Yellow"
        select.selectByVisibleText("Yellow");

    }
}
package Homeworks.Homework_06;

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

public class Task01 {
    /*
    Hw:1
Go to URL: https://the-internet.herokuapp.com/dropdown
Create method selectByIndex and Select Option 1 using index.
Create method selectByValue Select Option 2 by value.
Create method selectByVisibleText Select Option 1 value by visible text.
Create method printAll Print all dropdown value.
Verify the dropdown has Option 2 text.
Create method printFirstSelectedOption Print first selected option.
Find the size of the dropdown, Print "Expected Is Not Equal Actual" if there are not 3 elements in the dropdown.
     */
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        //Go to URL: https://the-internet.herokuapp.com/dropdown
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(2000);
         driver.quit();
    }

    @Test  // By calling methods...
    public void test() throws InterruptedException {
        WebElement element = driver.findElement(By.id("dropdown"));

        //Create method selectByIndex and Select Option 1 using index.
        selectByIndex(element);
        Thread.sleep(1000);

        //Create method selectByValue Select Option 2 by value.
        selectByValue(element);
        Thread.sleep(1000);

        //Create method selectByVisibleText Select Option 1 value by visible text.
        selectByVisibleText(element);
        Thread.sleep(1000);

        //Create method printAll Print all dropdown value.
        printAll(element);
        Thread.sleep(1000);

        //Verify the dropdown has Option 2 text.
        Select select = new Select(element);
        //Using flag
        boolean option2 = false;
        //Creating List of web elements (options)
        List<WebElement> options = select.getOptions();
        for (WebElement option : options ) {
            if (option.getText().equals("Option 2")) {
                option2 = true; // Option2 found
                break;
            }
        }
            Assert.assertTrue(option2);

        //Create method printFirstSelectedOption Print first selected option.
        printFirstSelectedOption(element);

        //Find the size of the dropdown
        int size = options.size();
        System.out.println("size = " + size);

        // Print "Expected Is Not Equal Actual" if there are not 3 elements in the dropdown.
        Assert.assertEquals("\"Expected Is Not Equal Actual",3,size);
    }

    //Create method selectByIndex and Select Option 1 using index.
    public void selectByIndex(WebElement e) {
        Select select = new Select(e);
        select.selectByIndex(1);
    }

    //Create method selectByValue Select Option 2 by value.
    public void selectByValue(WebElement e) {
        Select select = new Select(e);
        select.selectByValue("2");
    }

    //Create method selectByVisibleText Select Option 1 value by visible text.
    public void selectByVisibleText(WebElement e) {
        Select select = new Select(e);
        select.selectByVisibleText("Option 1");
    }

    //Create method printAll Print all dropdown value.
    public void printAll(WebElement e) {
        Select select = new Select(e);
        // Creating List of web elements to extract the options
        List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
            String optionText = option.getText();
            System.out.println(optionText);
        }
    }

    //Create method printFirstSelectedOption Print first selected option.
    public void printFirstSelectedOption(WebElement e) {
        Select select = new Select(e);
        System.out.println("FirstSelectedOption is " + select.getFirstSelectedOption().getText());
    }
}

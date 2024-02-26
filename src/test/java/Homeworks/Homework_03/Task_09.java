package Homeworks.Homework_03;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task_09 {

// Do the following tasks by creating 2 different test methods.
    static WebDriver driver;

    @BeforeClass // Go to w3school homepage
    public static void setUp() {
        System.out.println("STARTED");
        driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/");
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("FINISHED");
        driver.close();
    }

    @Before  // Print "STARTED" before all test() methods run
    public void beforeClass() {
        System.out.println("Test has started");
}

    @After
    public void afterClass() {
        System.out.println("Test finished");
    }

    @Test // Test if the title contains "w3school" when the page window is minimize
    public void test1() {
        driver.manage().window().minimize();
        if (driver.getTitle().contains("w3school")) {
            System.out.println("Contains 'w3school'");
        } else System.out.println("Does not contain 'w3school'");
    }

    @Test  // Test if the title does not contain "boss" when the page window is fullscreen
    public void test2() {
        driver.manage().window().fullscreen();
        if (driver.getTitle().contains("boss")) {
            System.out.println("Contains 'boss'");
        } else System.out.println("Does not contain 'boss'");
    }
}

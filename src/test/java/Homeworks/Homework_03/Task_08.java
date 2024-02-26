package Homeworks.Homework_03;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task_08 {

// Do the following tasks by creating 3 different test methods.

// Test if the URL contains "google"

    static WebDriver driver;

    @BeforeClass // Go to google homepage
    public static void setUp() {
        driver = new ChromeDriver();
        driver.get("https://google.com");
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Before  // *- Print "Tests are starting to run" before each test() method
    public void beforeEach(){
        System.out.println("Tests are starting to run");
    }

    @After  // *- Print "Tests have finished running" after each test() method
    public void afterEach(){
        System.out.println("Tests have finished running");
    }

    @Test // Test if the title is the same when the page window is maximize and minimize
    public void method1(){
        driver.manage().window().maximize();
        String titleMax = driver.getTitle();
        driver.manage().window().minimize();
        String titleMin = driver.getTitle();
        if(titleMax.equals(titleMin)){
            System.out.println("they have same titles");
        } else System.out.println("they have different titles");
    }

    @Test // Test if the title does not contain "Video" when the page window is fullscreen
    public void method2(){
        driver.manage().window().fullscreen();
        if(driver.getTitle().contains("Video")){
            System.out.println("Contains 'video'");
        } else System.out.println("Does not contain 'video'");
    }

    @Test // Test if the URL contains "google".
    public void method3(){
        String url = driver.getCurrentUrl();
        if(url.contains("google")){
            System.out.println("Contains 'google'");
        } else System.out.println("Does not contain 'google'");
    }
}

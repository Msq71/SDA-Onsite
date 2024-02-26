package Homeworks.Homework_03;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task_07 {
    // Go to YouTube homepage
    // Do the following tasks by creating 3 different test methods.
    static WebDriver driver;

    @Before  // *- Print "Test is running" before each test() method
    public void beforeEach(){
        System.out.println("Test is running");
    }

    @After  // *- Print "Test finished" after each test() method
    public void afterEach(){
        System.out.println("Test finished");
    }

    @Test  // Test if the currentURL contains "youtube"
      public void method1(){
        driver = new ChromeDriver();
        driver.get("https://www.youtube.com/");
    if (driver.getCurrentUrl().contains("youtube")){
        System.out.println("Pass, Contains 'youtube'");
    } else System.out.println("Fail, does not contain 'youtube'");
}

    @Test  // Test if the title does not contain "Video".
        public void method2(){
        driver = new ChromeDriver();
        driver.get("https://www.youtube.com/");
        if (driver.getTitle().contains("Video")){
        System.out.println("Fail, Contains 'Video'");
        } else System.out.println("Pass, does not contain 'Video'");
    }

    @Test  // Test if the sourcePage contains "youtube".
       public void method3(){
           driver = new ChromeDriver();
           driver.get("https://www.youtube.com/");
           if (driver.getPageSource().contains("youtube")){
               System.out.println("Pass, Contains 'youtube'");
           } else System.out.println("Fail, does not contain 'youtube'");
       }


}

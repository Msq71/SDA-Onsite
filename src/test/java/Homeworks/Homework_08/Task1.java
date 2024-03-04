package Homeworks.Homework_08;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Task1 {
    /*
    Go to URL: http://demo.guru99.com/test/guru99home/
Find the number of iframes on the page.
Link to the third iframe (JMeter Made Easy) (https://www.guru99.com/live selenium project.html) click here.
Exit the iframe and return to the main page.
     */
    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test() throws InterruptedException {

        //Go to URL: http://demo.guru99.com/test/guru99home/
        driver.get("http://demo.guru99.com/test/guru99home/");
        String handle1 = driver.getWindowHandle();

        //Find the number of iframes on the page:
        List<WebElement> iframes = driver.findElements(By.xpath("//iframe"));
        System.out.println("number of iframes = " + iframes.size());

        //Link to the third iframe (JMeter Made Easy) (https://www.guru99.com/live selenium project.html) click here.
        driver.switchTo().frame("a077aa5e");
        driver.findElement(By.xpath("//a[@href='http://www.guru99.com/live-selenium-project.html']")).click();
        String handle2 = driver.getWindowHandle();

        //Exit the iframe and return to the main page.
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
        driver.switchTo().window(handle1);

    }
}

package day04;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C01RelativeLocators {


    @Test
    public void test(){
        WebDriver driver  = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.linkedin.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        By emailField = RelativeLocator.with(By.tagName("input")).above(By.id("session_password"));

    }
}

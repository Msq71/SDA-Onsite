package Homeworks.Homework_07;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Challenge_day07 {
    /*
    navigate to https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver
click on "Click me, to Open an alert after 5 seconds" button
click on accept alert
click on "Change Text to Selenium Webdriver"
verify "Selenium Webdriver" message is displayed
     */

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //navigate to https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
    }

    @Test
    public void test() throws InterruptedException {
        //click on "Click me, to Open an alert after 5 seconds" button
        driver.findElement(By.id("alert")).click();

        //click on accept alert.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

        //click on "Change Text to Selenium Webdriver"
        driver.findElement(By.id("populate-text")).click();

        WebElement msg = driver.findElement(By.xpath("//h2[@id='h2']"));

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(12));

        wait.until(ExpectedConditions.visibilityOf(msg));

        //verify "Selenium Webdriver" message is displayed
        boolean selWeb = msg.isDisplayed();
        Assert.assertTrue(selWeb);

        //click on "Display button after 10 seconds" button
        driver.findElement(By.id("display-other-button")).click();

        //verify the button is displayed
        WebElement button = driver.findElement(By.xpath("//button[@id='hidden']"));
        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(12));
        wait3.until(ExpectedConditions.visibilityOf(button));
        boolean bt = button.isDisplayed();
        Assert.assertTrue(bt);

        //click on "Enable button after 10 seconds" button
        driver.findElement(By.xpath("//button[@id='enable-button']")).click();

        //verify the button is enabled
        WebElement button2 = driver.findElement(By.xpath("//button[@id='disable']"));
        WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(12));
        wait3.until(ExpectedConditions.elementToBeClickable(button2));
        boolean bt2 = button.isEnabled();
        Assert.assertTrue(bt2);

        //click on "Check Checkbox after 10 seconds" button
        driver.findElement(By.xpath("//button[@id='checkbox']")).click();

        // verify the checkBox is checked
        WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"ch\"]"));
        WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(12));
        WebElement smallcheckbox = driver.findElement(By.xpath("//input[@id='ch']"));
        wait4.until(ExpectedConditions.elementToBeSelected(checkbox));
        boolean sml = smallcheckbox.isSelected();
        Assert.assertTrue(sml);
    }
}

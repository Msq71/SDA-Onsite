package Homeworks.Homework_05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.sql.Driver;
import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class Task02 {
    /*Task 2:
     * breakout task: (in a separate class)
     * navigate to this url https://www.saucedemo.com/v1/inventory.html
     * add the first item you find to your cart
     * open your cart*
     * assert that the item name is correct inside the cart
     */
    @Test
    public void radButtonTest() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        WebDriver driver= new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Go to URL:https://www.saucedemo.com/v1/inventory.html
        driver.get("https://www.saucedemo.com/v1/inventory.html");

       //add the first item you find to your cart
        driver.findElement(By.xpath("(//button[@class ='btn_primary btn_inventory'])[1]")).click();

        //open your cart*
        driver.findElement(By.xpath("//a[@href ='./cart.html']")).click();

        //assert that the item name is correct inside the cart
        WebElement itemNameInCart = driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
        String expectedItemName = "Sauce Labs Backpack";
        assertEquals(expectedItemName, itemNameInCart.getText());

        // Close the browser
        Thread.sleep(2000);
        driver.quit();
    }

}

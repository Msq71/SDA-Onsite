package day09;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class C01HandlesOfMultipleWindows extends TestBase {

    /*
    Go to URL: https://demoqa.com/browser-windows
Click on all the child windows.
Print the text present on all the child windows in the console.
Print the heading of the parent window in the console.
     */
    @Test
    public void test() {
        //Go to URL: https://demoqa.com/browser-windows
        driver.get("https://demoqa.com/browser-windows");

        By tabButton = By.id("tabButton");
        By windowButton = By.id("windowButton");
        By messageWindowButton = By.id("messageWindowButton");
        By messageOnTab = By.id("sampleHeading");

        //Click on all the child windows.
        driver.findElement(tabButton).click();
        driver.findElement(windowButton).click();
        driver.findElement(messageWindowButton).click();

        //Print the text present on all the child windows in the console.

        //Using Set and Iterator to store and retrieve tabs handles.
        Set<String> handles = driver.getWindowHandles();
        System.out.println("windowHandles = " + handles);
        Iterator<String> itr = handles.iterator();

        //Getting and storing all handles:
        String handleMain = itr.next();
        String handleTab = itr.next();
        String handleWindowButton = itr.next();
        String handleMessageWindowButton = itr.next();

        //Print the heading of the parent window in the console.
        driver.switchTo().window(handleTab);
        System.out.println(driver.findElement(messageOnTab).getText());
        //---
        driver.switchTo().window(handleWindowButton);
        System.out.println(driver.findElement(messageOnTab).getText());

    }
}

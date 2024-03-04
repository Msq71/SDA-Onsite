package day09;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class C05KeyBoardActions extends TestBase {
    /*
    Go to URL: https://demoqa.com/auto-complete
In the Type single color name section, print "Exceptional" by using the action methods.
     */
    @Test
    public void keyBoardTest() {
        By boxId = By.id("autoCompleteMultiple");

        driver.get("https://demoqa.com/auto-complete");

        WebElement textBox = driver.findElement(boxId);

        actions
                .click(textBox)
                .keyDown(Keys.SHIFT)
                .sendKeys("e")
                .keyUp(Keys.SHIFT)
                .sendKeys("xceptional")
                .build()
                .perform();
    }
}

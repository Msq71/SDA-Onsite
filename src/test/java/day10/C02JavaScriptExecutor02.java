package day10;

import Utilities.JScriptUtilities;
import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C02JavaScriptExecutor02 extends TestBase {

    /*
   Go to URL: https://api.jquery.com/dblclick/
DoubleClick on the blue square at the bottom of the page
Write the changed color on search box on the top of the page
Click "jQuery in Action" at the bottom of the page.
     */
    @Test
    public void test() throws InterruptedException {

        //Go to URL: https://api.jquery.com/dblclick/
        driver.get("https://api.jquery.com/dblclick/");

        //DoubleClick on the blue square at the bottom of the page

        // 1) Switch to iframe to locate the element:
        driver.switchTo().frame(0);
        // 2) Locate the blue square button:
        WebElement blue = driver.findElement(By.xpath("//span[.='Double click the block']/preceding-sibling::div"));
        // 3) Scrolling down by Jscript until blue square button is displayed
        JScriptUtilities.scrollIntoViewJS(driver, blue);
        Thread.sleep(1000);
        // 4) DoubleClick on the blue square at the bottom of the page
        actions.doubleClick(blue).perform();
        Thread.sleep(1000);
        // 5) Getting the new color of the button:
        String colorCode = blue.getCssValue("background-color");
        //----------------------------------------------------------------//

        //Write the changed color on search box on the top of the page

        // 1) Back to default content
        driver.switchTo().defaultContent();
        // 2) Locate the blue square button:
        WebElement searchBox = driver.findElement(By.xpath("//input[@type='search']"));
        // 3) Scrolling up by Jscript until search box is displayed:
        JScriptUtilities.scrollIntoViewJS(driver, searchBox);
        Thread.sleep(1000);
        // 4) Write the changed color:
        searchBox.sendKeys(colorCode);
        Thread.sleep(1000);

        //----------------------------------------------------------------//

        //Click "jQuery in Action" at the bottom of the page.

        // 1) Locate the "jQuery in Action" button:
        WebElement jqueyButton = driver.findElement(By.xpath("//a[@href=\"https://www.manning.com/books/jquery-in-action-third-edition\"]"));
        // 2) Scrolling down by Jscript until "jQuery in Action" button is displayed:
        JScriptUtilities.scrollIntoViewJS(driver, jqueyButton);
        Thread.sleep(1100);
        // 3) Click "jQuery in Action"
        actions.click(jqueyButton).perform();


    }

}

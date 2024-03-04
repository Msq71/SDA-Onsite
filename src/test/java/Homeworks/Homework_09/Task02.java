package Homeworks.Homework_09;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class Task02 extends TestBase {
    /*
    Go to URL: https://rangeslider.js.org/
    Shift 100 units to the right and 100 units to the left on the horizontal axis.

     */
    @Test
    public void test() {
        By slider = By.id("js-rangeslider-0");

        //Go to URL: https://rangeslider.js.org/
        driver.get("https://rangeslider.js.org/");

        //Locate the element
        WebElement sliderButton = driver.findElement(slider);

        //Shift 100 units to the right and 100 units to the left on the horizontal axis.
        actions
                .dragAndDropBy(sliderButton, 100, 0)
                .pause(Duration.ofSeconds(2))
                .dragAndDropBy(sliderButton, -100, 0)
                .build()
                .perform();
    }


}

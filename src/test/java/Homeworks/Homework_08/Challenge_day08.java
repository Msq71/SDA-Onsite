package Homeworks.Homework_08;

import Utilities.TestBase;
import com.sun.jdi.Value;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Challenge_day08 extends TestBase {
    @Test
    public void test1() throws InterruptedException {
        //Go to https://clarusway.getlearnworlds.com/sda-test-registration-form
        driver.get("https://clarusway.getlearnworlds.com/sda-test-registration-form");

        //Create a frame web element to switch to it
        WebElement frame = driver.findElement(By.xpath("//*[@id=\"el_1706889795510_354\"]/iframe"));
        driver.switchTo().frame(frame);

        //Try to click submit without filing firstname,lastname and choosing from dropdown:
        WebElement submit = driver.findElement(By.xpath("//em[normalize-space()='Submit']"));
        submit.click();
        Thread.sleep(2000);
        WebElement nameErrorMsg = driver.findElement(By.xpath("//p[@id='error-Name']"));
        Assert.assertTrue(nameErrorMsg.isDisplayed());

        WebElement dropErrorMsg = driver.findElement(By.xpath("//p[@id='error-Dropdown']"));
        Assert.assertTrue(dropErrorMsg.isDisplayed());

        //fill the form...

        //First name
        WebElement fname = driver.findElement(By.xpath("//li[@id='Name-li']//span[1]//input[1]"));
        fname.sendKeys("Mohammed");

        //Last name
        WebElement lname = driver.findElement(By.xpath("//li[@id='Name-li']//span[2]//input[1]"));
        lname.sendKeys("Sultan");

        //Click on first radio button:
        WebElement rButton1 = driver.findElement(By.xpath("//*[@id=\"Radio-li\"]/div[2]/div/span[2]"));
        Thread.sleep(2000);
        rButton1.click();

        //Locate the Dropdown
        WebElement dropDown = driver.findElement(By.id("Dropdown-arialabel"));
        //Create select object
        Select select = new Select(dropDown);
        //Select the second choice
        select.selectByIndex(1);

        //Create a Checkboxes list
        List<WebElement> checkboxes = driver.findElements(By.xpath("//*[contains(@for, 'Checkbox_')]"));
        //Select the first checkbox:
        checkboxes.get(0).click();

        //Trying to send keys to disabled field...

        //Locate the element:
        WebElement disabledField = driver.findElement(By.xpath("//input[@id='SingleLine-arialabel']"));

        //Verify that we cannot send keys to the disabled Field
        Assert.assertThrows(ElementNotInteractableException.class, () -> {
            disabledField.sendKeys("Hello");
        });

            // If we reach this point, it means no exception was thrown, which is unexpected


        //Select a rating stars:
        List<WebElement> rating = driver.findElements(By.xpath("//a[@role='radio']"));

        rating.get(0).click();
        Thread.sleep(2000);
              // boolean pleaseWork =
        System.out.println("rating.get(0).getCssValue(\"fill\") = " + rating.get(0).getCssValue("fill"));
        // Assert.assertTrue(pleaseWork);
        //System.out.println(pleaseWork);
        //Select 5 stars one by one and verify the color:
       /* for (WebElement star : rating) {
            star.click();
            String actualColor = star.getCssValue("fill");
            Assert.assertEquals("#faea29", actualColor);
            Thread.sleep(1000);
            #faea29
        }*/
    }
}

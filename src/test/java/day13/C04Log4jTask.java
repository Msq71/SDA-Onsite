package day13;

import Utilities.TestBase;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class C04Log4jTask extends TestBase {
    /*
    Go to URL: https://healthunify.com/bmicalculator/
                Entering weight
                Selecting kilograms
                Selecting height in feet
                Selecting height in inchs
                Clicking on calculate
                Getting SIUnit value
                Getting USUnit value
                Getting UKUnit value
     */

    Logger logger;

    @Test
    public void test01() throws InterruptedException {

        PropertyConfigurator.configure("log4j.Properties");
        logger = Logger.getLogger(C04Log4jTask.class);
        // 1) Go to URL: https://healthunify.com/bmicalculator/
        driver.get("https://healthunify.com/bmicalculator/");

        // 2) Entering weight
        WebElement weight = driver.findElement(By.xpath("//input[@name='wg']"));
        logger.info("Entering weight: 78");
        weight.sendKeys("78");

        // 3) Selecting kilograms
        WebElement weightType = driver.findElement(By.xpath("//select[@name='opt1']"));
        Select selectWeight = new Select(weightType);
        logger.info("Selecting weight type: kilograms");
        selectWeight.selectByValue("kilograms");

        // 4) Selecting height in feet
        WebElement height = driver.findElement(By.xpath("//select[@name='opt2']"));
        Select selectHeight = new Select(height);
        logger.info("Selecting height in feet 6");
        selectHeight.selectByValue("6");

        // 5) Selecting height in inchs
        WebElement heightInchs = driver.findElement(By.xpath("//select[@name='opt3']"));
        Select selectInchs = new Select(heightInchs);
        logger.info("Selecting height in inchs 6");
        selectInchs.selectByValue("10");

        // 6) Clicking on calculate
        WebElement clickButton = driver.findElement(By.xpath("//input[@name='cc']"));
        //use log
        clickButton.click();

        // 7) Getting SIUnit value
        WebElement sIUnit = driver.findElement(By.xpath("//input[@name='si']"));
        logger.info("sIUnit value: " + sIUnit.getText());

        System.out.println("sIUnit.getText() = " + sIUnit.getText());

        Thread.sleep(2000);

        // 8) Getting USUnit value
        WebElement uSUnit = driver.findElement(By.xpath("//input[@name='us']"));
        logger.info("uSUnit value: " + uSUnit.getText());
        System.out.println("uSUnit.getText() = " + uSUnit.getText());

        // 9) Getting UKUnit value
        WebElement uKUnit = driver.findElement(By.xpath("//input[@name='uk']"));
        logger.info("uKUnit value: " + uKUnit.getText());
        System.out.println("uKUnit.getText() = " + uKUnit.getText());


    }
}

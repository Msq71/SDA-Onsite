package day08;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01IFrames01 {
    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test() throws InterruptedException {

        //Go to URL: https://the-internet.herokuapp.com/iframe
        driver.get("https://the-internet.herokuapp.com/iframe");

        //Verify the Bolded text contains "Editor"
        WebElement boldedtext = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(boldedtext.getText().contains("Editor"));
        //  xpath : //h3[.='An iFrame containing the TinyMCE WYSIWYG Editor']  , //h3  ,  tagName : h3

        //Locate the Bold 'B and click on it'
        driver.findElement(By.xpath("//button[@title='Bold']")).click();

        // To access the textBox web element, we need to switch to the iframe; otherwise, we will encounter a NoSuchElementExcepion.


        // Switching to the iframe

        // Using index (starts at 0)
        //driver.switchTo().frame(0);

        // Using id or name
        //driver.switchTo().frame("mce_0_ifr");
        // Using webElement
        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);

        //Locate webElement after switching frame
        WebElement textBox = driver.findElement(By.xpath("//*[@id='tinymce']/p"));


        // Delete the text in the text box
        textBox.clear();
        // Type "Hi everyone"
        textBox.sendKeys("Hi everyone");

        //If we want to perform operations outside the iframe again

        //  driver.switchTo().parentFrame(); // Brings it up by one level

        //Verify that the text "Elemental Selenium" is displayed on the page.
        driver.switchTo().defaultContent();

        WebElement elSelenium = driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(elSelenium.isDisplayed());

        //Close Driver
        Thread.sleep(2000);
        driver.quit();
    }

}


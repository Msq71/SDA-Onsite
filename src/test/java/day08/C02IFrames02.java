package day08;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02IFrames02 {
    /*
    Go to https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/.
    Maximize the website.
    Click on the second emoji.
    Click on all second emoji items. //
    Return to the parent iframe.
    Fill out the form (Fill the form with the text you want) and press the apply button.

     */

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        driver = new ChromeDriver();
        //Maximize the website.
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test() {

        //Go to URL: https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        //switch to emoojis iFrame:
        driver.switchTo().frame("emoojis");

        //Click on the second emoji.
        List<WebElement> listOfEmojis = driver.findElements(By.xpath("//*[contains(@id, 'tool')]"));
        listOfEmojis.get(1).click();


        //Return to the parent iframe.
        driver.switchTo().defaultContent();

        //Fill out the form (Fill the form with the text you want) and press the apply button.
        driver.findElement(By.id("smiles")).sendKeys("animal");


        //We can create a method which calls element with given index Click:
        /*public void clickOnElementByIndex(int index){
            driver.findElement(By.xpath("//Div[@class='mdl-tabs__tab-bar']/a["+index+"]")).click();
        }*/

    }
}


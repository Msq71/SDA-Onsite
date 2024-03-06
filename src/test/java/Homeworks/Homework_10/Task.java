package Homeworks.Homework_10;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Task extends TestBase {
    @Test
    public void test() {

       /* By search = By.xpath("//input[@id='search']");
        driver.get("https://www.youtube.com/");
        WebElement searchBox = driver.findElement(search);
        searchBox.sendKeys("interstellar stay");
        searchBox.submit();

        WebElement videoLink = driver.findElement(By.xpath("//yt-formatted-string[contains(@aria-label, 'S.T.A.Y. by Hans Zimmer')]"));
        videoLink.click();

        WebElement video = driver.findElement(By.xpath("//video[@tabindex='-1']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(video));
        Assert.assertTrue(video.isDisplayed());
        */
        playMyvideo("S.T.A.Y");
    }

    public void playMyvideo(String videoName){
        By search = By.xpath("//input[@id='search']");
        driver.get("https://www.youtube.com/");
        WebElement searchBox = driver.findElement(search);
        searchBox.sendKeys(videoName);
        searchBox.submit();

        WebElement videoLink = driver.findElement(By.xpath("//a[@title ='"+videoName+"']"));
        videoLink.click();

        WebElement video = driver.findElement(By.xpath("//video[@tabindex='-1']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(video));
        Assert.assertTrue(video.isDisplayed());
    }
}

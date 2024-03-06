package day11;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.nio.file.Files;
import java.nio.file.Path;

//Go to URL: https://the-internet.herokuapp.com/download
//Download selenium-snapshot.png
//Verify if the file downloaded successfully.
public class C03FileDownLoad extends TestBase {
    @Test
    public void test() throws InterruptedException {
        // 1) Go to URL: https://the-internet.herokuapp.com/download
        driver.get("https://the-internet.herokuapp.com/download");

        // 2) Find the element and click on it to download selenium-snapshot.png
        driver.findElement(By.linkText("selenium-snapshot.png")).click();
        Thread.sleep(500);
        // 3) Verify if the file downloaded successfully.
        //we can use: Files.deleteIfExist(path.pathOf)
        //"C:\Users\Msqx7\Downloads\selenium-snapshot.png"
        String userHome = System.getProperty("user.home");
        String separator = System.getProperty("file.separator");

        String pathOfFile = userHome + separator + "Downloads" + separator + "selenium-snapshot.png";

        boolean existence = Files.exists(Path.of(pathOfFile));

        Assert.assertTrue(existence);



    }
}

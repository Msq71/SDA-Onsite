package day12;

import Utilities.TestBase;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C04TakeScreenShot extends TestBase {
    //Go to LinkedIn.com
    // Take Page ScreenShot.
    // Specify WebElement ScreenShot

    @Test
    public void test() throws IOException {
        driver.get("https://www.linkedin.com");

        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        String date = new SimpleDateFormat("yyyy_MM_dd_hh_m_ss").format(new Date());
        System.out.println("date = " + date);
        String separator = System.getProperty("file.separator");
        File destination = new File((System.getProperty("user.dir")) + separator + "test-output" + separator + "screenshots" + "Linkedin" + date + ".png");

        FileUtils.copyFile(source, destination);
    }


    @Test
    public void takeSpecificElementScreenShot() throws IOException {
        driver.get("https://www.linkedin.com");
        WebElement LoginForm = driver.findElement(By.xpath("//*[@id=\"main-content\"]/section[1]/div/div/form"));
        File source = LoginForm.getScreenshotAs(OutputType.FILE);

        String separator = System.getProperty("file.separator");
        String date = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Date());

        File destination = new File(System.getProperty("user.dir") + separator + "test-output" + separator + "screenshots" + "LoginForm" + date + ".png");

        FileUtils.copyFile(source, destination);


    }


}

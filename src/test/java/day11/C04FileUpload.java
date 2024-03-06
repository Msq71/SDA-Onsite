package day11;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C04FileUpload extends TestBase {
    /*
    Go to URL: https://the-internet.herokuapp.com/upload
Find the path of the file that you want to upload.
Click on Upload button.
Verify the upload message.
     */
    @Test
    public void test() {
        By uploadId = By.id("file-upload");
        By submitId = By.id("file-submit");

        String userDirectory = System.getProperty("user.dir");
        String separator = System.getProperty("file.separator");
        String fileName = "FileExist";
        String path = userDirectory + separator + fileName;

        //Go to URL: https://the-internet.herokuapp.com/upload
        driver.get("https://the-internet.herokuapp.com/upload");

        //Find the path of the file that you want to upload.
        WebElement chooseFileButton = driver.findElement(uploadId);
        chooseFileButton.sendKeys(path);

        //Click on Upload button.
        WebElement uploadButton = driver.findElement(submitId);
        uploadButton.click();

        //Verify the upload message.
        WebElement FileText = driver.findElement(By.xpath("//div[@id='uploaded-files']"));
        System.out.println("FileText.getText() = " + FileText.getText());
        Assert.assertTrue(FileText.isDisplayed());
    }
}

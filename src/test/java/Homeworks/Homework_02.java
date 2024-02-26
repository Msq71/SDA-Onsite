package Homeworks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework_02 {

    //Create main method
        public static void main(String[] args) {

    //Create chrome driver
        WebDriver driver = new ChromeDriver();

    //Open Facebook home page: https://www.Facebook.com/
        driver.get("https://www.Facebook.com/");

   //Assigning an incorrect URL to a String is an expected result.
        String expectedUrl = "https://www.Facebook.com1/";

    //Assigning the correct/real URL to a String is an actual result.
        String actualUrl = driver.getCurrentUrl();

    //Checking whether they are matching or not.
        if(expectedUrl.equals(actualUrl)){
            System.out.println("They are the same");
        }else {
            System.out.println("They are different");
        }

    //Assigning Page source to a String
        String pageSource = driver.getPageSource();

    //Verify if the page source contains "Facebook"
        if (pageSource.contains("Facebook")) {
                System.out.println("Page source contains 'Facebook'");
        } else {
                System.out.println("Page source does not contain 'Facebook'");
        }

            driver.quit();
    }
}




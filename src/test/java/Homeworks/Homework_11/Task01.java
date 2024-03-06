package Homeworks.Homework_11;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class Task01 extends TestBase {
    /*
Task01...
Go to URL: https://facebook.com
print all cookies,
getCookies,
addCookies,
deleteCookieNamed,
deleteAllCookies.
     */
    @Test
    public void test() throws InterruptedException {
        // 1) Go to URL: https://facebook.com
        driver.get("https://facebook.com");

        // 2) print all cookies
        Thread.sleep(2000);
        Set<Cookie> cookies = driver.manage().getCookies();
        for (Cookie c : cookies) {
            System.out.println(c);
        }
        System.out.println("------------------------------------");

        // 3) getCookies
        //Getting second cookie:
        Cookie secondCookie = driver.manage().getCookieNamed("fr");
        System.out.println("secondCookie = " + secondCookie);
        System.out.println("------------------------------------");

        // 4) get number of Cookies
        int numOfCookies = cookies.size();
        System.out.println("numOfCookies = " + numOfCookies);
        System.out.println("------------------------------------");

        // 5) addCookies
        Cookie newCookie = new Cookie("newName", "newValue");
        driver.manage().addCookie(newCookie);
        driver.manage().getCookies().forEach(t -> System.out.println(t));
        System.out.println("------------------------------------");

        // 6) deleteCookieNamed
        //delete newCookie name:
        driver.manage().deleteCookieNamed("newName");
        driver.manage().getCookies().forEach(t -> System.out.println(t));
        System.out.println("------------------------------------");

        // 7) deleteAllCookies
        driver.manage().deleteAllCookies();
        System.out.println("End here...");
        driver.manage().getCookies().forEach(t -> System.out.println(t));
    }
}

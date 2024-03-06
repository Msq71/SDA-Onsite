package day11;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class C01Cookies extends TestBase {
    //Go to URL: https://kitchen.applitools.com/ingredients/cookie
    //Print all the cookies.
    //Get Cookie.
    //Find the total number of cookies.
    //Add Cookie.
    //Edit Cookie.
    //Delete Cookie.
    //Delete All Cookies.
    @Test
    public void test() {
        //Go to URL: https://kitchen.applitools.com/ingredients/cookie
        driver.get("https://kitchen.applitools.com/ingredients/cookie");
        //Print all the cookies.
        Set<Cookie> cookies = driver.manage().getCookies();
        for (Cookie c : cookies) {
            System.out.println(c);
        }
        System.out.println("--------------------------------------------");
        //Get Cookie.
        Cookie secondCookie = driver.manage().getCookieNamed("vegetable");
        System.out.println("secondCookie = " + secondCookie);
        System.out.println("--------------------------------------------");

        System.out.println("secondCookie.getValue() = " + secondCookie.getValue());
        System.out.println("--------------------------------------------");

        //Find the total number of cookies.
        int numberOfCookies = cookies.size();
        System.out.println("numberOfCookies = " + numberOfCookies);
        System.out.println("--------------------------------------------");

        //Add Cookie.
        Cookie newCookie = new Cookie("fruit","mango");
        driver.manage().addCookie(newCookie);
        driver.manage().getCookies().forEach(t-> System.out.println(t));
        System.out.println("--------------------------------------------");

        //Edit Cookie. //replace
        Cookie anotherCookie = new Cookie("fruit","apple");
        driver.manage().addCookie(anotherCookie);
        System.out.println("anotherCookie = " + anotherCookie);
        System.out.println("--------------------------------------------");

        //Delete Cookie.
        driver.manage().deleteCookie(secondCookie);
        driver.manage().deleteCookieNamed("fruit");
        driver.manage().getCookies().forEach(System.out::println);
        System.out.println("--------------------------------------------");
        //Delete All Cookies.
        driver.manage().deleteAllCookies();
        driver.manage().getCookies().forEach(t-> System.out.println(t));
        System.out.println("end here...");
    }
}

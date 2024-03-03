package day08;

import Utilities.TestBase;
import org.junit.Test;

public class C03BaseClass extends TestBase {

    @Test
    public void test(){
        driver.get("https://google.com");
        System.out.println("Title = " + driver.getTitle());
    }

    @Test
    public void test2(){
        driver.get("https://amazon.com");
        System.out.println("Title = " + driver.getTitle());
    }

    @Test
    public void test3(){
        driver.get("https://clarusway.com");
        System.out.println("Title = " + driver.getTitle());
    }
}

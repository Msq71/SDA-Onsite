package day08;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.WindowType;

public class C04WindowHandle01 extends TestBase {
    // driver.getWindowHandle(); -> Returns the window handle (ID) of the active window or tab.
// driver.getWindowHandles(); -> Returns all window handles (IDs) of open windows or tabs as a Set.
// driver.switchTo().window(id); -> Allows us to switch to the window or tab with the specified window handle (ID).
// driver.switchTo().newWindow(TAB); -> Creates a new tab.
// driver.switchTo().newWindow(WINDOW); -> Creates a new window.

// Open browser
// Open https://www.amazon.com/ in the open tab
// Create a new tab
// Open https://www.linkedin.com/ in the open tab
// Create a new window
// Open https://opensource-demo.orangehrmlive.com/web/index.php/auth/login in the window that opens

    @Test
    public void test() {
        driver.get("https://amazon.com");
        //Store WindowHandle for amazon tab in String:
        String handle1 = driver.getWindowHandle();

        //Create anew tab
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://Google.com");

        //Store WindowHandle for Google tab in String:
        String handle2 = driver.getWindowHandle();

        //Switching to amazon tab
        driver.switchTo().window(handle1);

        //Create a new Window:
        driver.switchTo().newWindow(WindowType.WINDOW);
        //Store WindowHandle for Google tab in String:
        String handle3 = driver.getWindowHandle();

        // Open https://opensource-demo.orangehrmlive.com/web/index.php/auth/login in the window that opens
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
}

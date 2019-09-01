import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.GregorianCalendar;

public class Manage {
    WebDriver driver;


    @BeforeEach
    public void driverSetup(){
       System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
       driver = new ChromeDriver();
       driver.manage().window().setSize(new Dimension(1290, 730));
       driver.manage().window().setPosition(new Point(8, 30));
       driver.navigate().to("https://www.amazon.com");
       try {
           Thread.sleep(1000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
        Assertions.assertEquals(9, driver.manage().getCookies().size(), "Number of cookies is not what expected.");
    }

    @AfterEach
    public void closeAndQuit(){
        driver.close();
        driver.quit();
    }

    @Test
    public void getAndDeleteCookies(){
        Cookie cookieSessionId = driver.manage().getCookieNamed("session-id");
        driver.manage().deleteCookieNamed("session-id");
        Assertions.assertEquals(6, driver.manage().getCookies().size(), "Number of cookies is not what expected.");
        driver.manage().deleteAllCookies();
        Assertions.assertEquals(0, driver.manage().getCookies().size(), "Number of cookies is not what expected.");
    }

    @Test
    public void addAndDeleteCookies(){
        Cookie newCookie = new Cookie("test_cookie", "test_value", ".amazon.com",
                "/", new GregorianCalendar(2019, 11, 31).getTime(), true,true);
        driver.manage().addCookie(newCookie);
        Assertions.assertEquals(10, driver.manage().getCookies().size(), "Number of cookies is not what expected.");
        driver.manage().deleteCookie(newCookie);
        Assertions.assertEquals(9, driver.manage().getCookies().size(), "Number of cookies is not what expected.");
    }
}

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

public class TaskManageCookies {
    WebDriver driver;


    @BeforeEach
    public void driverSetup(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1290, 730));
        driver.manage().window().setPosition(new Point(8, 30));
        driver.navigate().to("http://wikipedia.pl");

    }

    @AfterEach
    public void closeAndQuit(){
        driver.close();
        driver.quit();
    }

    @Test
    public void getAllCookies(){
        Assertions.assertEquals(5, driver.manage().getCookies().size(), "Number of cookies is not what expected");
        Cookie testEllaCookie = new Cookie("test_cookie", "test_value", ".amazon.com",
                "/", new GregorianCalendar(2019, 11, 31).getTime(), true,true);
        driver.manage().addCookie(testEllaCookie);
        Assertions.assertEquals(6, driver.manage().getCookies().size(), "Number of cookies is not what expected");
        driver.manage().deleteCookie(testEllaCookie);
        Assertions.assertEquals(5, driver.manage().getCookies().size(), "Number of cookies is not what expected");
        driver.manage().deleteCookieNamed("GeoIP");
        Assertions.assertEquals(4, driver.manage().getCookies().size(), "Number of cookies is not what expected");

        Cookie cookie = driver.manage().getCookieNamed("WMF-Last-Access");
        Assertions.assertEquals(".pl.wikipedia.pl", cookie.getDomain(), "Cookie domain is not what expected");
        Assertions.assertEquals("/", cookie.getPath(), "Cookie path is not what expected");
        Assertions.assertTrue(cookie.isHttpOnly(), "Cookie is not HTTP only.");











    }
}

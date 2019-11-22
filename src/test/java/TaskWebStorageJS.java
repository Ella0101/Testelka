import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.SessionStorage;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TaskWebStorageJS {
    ChromeDriver driver;

    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1295, 730));
        driver.manage().window().setPosition(new Point(10, 40));
        driver.manage().timeouts().pageLoadTimeout (10, TimeUnit.SECONDS);
        driver.navigate().to("https://fakestore.testelka.pl/product/fuerteventura-sotavento/");
    }

    @AfterEach
    public void driverQuit()
    {
        driver.quit();
    }

    @Test
    public void localStorageExampleTest()
    {

        String key = "wc_cart_hash_a5375b243ad4e752a98b6f54e384eba8";

        String value = (String) ((JavascriptExecutor) driver).executeScript("return localStorage.getItem(arguments[0]);", key);

        //((JavascriptExecutor) driver).executeScript("localStorage.setItem(arguments[0], arguments[1]);", "spell", "Alhambra");
        //((JavascriptExecutor) driver).executeScript("localStorage.removeItem(arguments[0]);", key);
       // String indexValue = (String) ((JavascriptExecutor) driver).executeScript("return localStorage.key(arguments[0]);", 2);
        //long size = (long) ((JavascriptExecutor) driver).executeScript("return localStorage.length;");
        //((JavascriptExecutor) driver).executeScript("localStorage.clear;");
    }

    @Test
    public void sessionStorageExampleTest(){
        SessionStorage session = driver.getSessionStorage();
        String value = session.getItem("wc_fragments_a5375b243ad4e752a98b6f54e384eba8");
        String value2 = session.getItem("wc_cart_hash_a5375b243ad4e752a98b6f54e384eba8");
    }

    @Test
    public void addToCartSessionStorage(){
        SessionStorage session = driver.getSessionStorage();
        String addedValue = session.getItem("wc_cart_created");
    }

    @Test
    public void removeFromCartSessionStorage(){
        SessionStorage session = driver.getSessionStorage();
        String removedValue = session.removeItem("wc_fragments_a5375b243ad4e752a98b6f54e384eba8");
        session.clear();


    }
}

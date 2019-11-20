import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.SessionStorage;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WebStorageExamples {
    ChromeDriver driver;

    @BeforeEach
    public void systemSetup(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1295, 730));
        driver.manage().window().setPosition(new Point(10, 40));
        driver.manage().timeouts().pageLoadTimeout (10, TimeUnit.SECONDS);
    }
    @AfterEach
    public void driverQuit(){
        driver.quit();
    }

    @Test
    public void localStorageExample(){
        driver.navigate().to("https://airly.eu/map/pl/#50.09868,20.21169,i9979");
        LocalStorage local = driver.getLocalStorage();
        String value = local.getItem("persist:map");
        int size = local.size();
        Set<String> keys =local.keySet();
        String removedValue = local.removeItem("persist:map");
        local.setItem("spell", "Alhambra");
        local.clear();
    }

    @Test
    public void sessionStorageExample(){
        driver.navigate().to("https://www.youtube.com/watch?v=Rxd8gT5oZHU");
        SessionStorage session = driver.getSessionStorage();
        String value = session.getItem("yt-remote-session-app");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(a->session.size()==5);
        int size = session.size();
        Set<String> keys =session.keySet();
        String removedValue = session.removeItem("yt-remote-session-app");
        session.setItem("spell", "Alhambra");
        session.clear();
    }
}

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Frames {
    WebDriver driver;
    WebDriverWait wait;


    @BeforeEach
    public void driverSetUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1295, 730));
        driver.manage().window().setPosition(new Point(10, 40));
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.navigate().to("https://nasa.gov");

        wait = new WebDriverWait(driver, 5);
    }

    @AfterEach
    public void driverQuit(){
        driver.close();
        driver.quit();
    }

    @Test
    public void frameExamples(){
        //jako webelement
        WebElement frame = driver.findElement(By.cssSelector("iframe#twitter-widget-0"));
        driver.switchTo().frame(frame);
        //po id
        //driver.switchTo().frame("twitter-widget-0");
        //po kolejnosci
        //driver.switchTo().frame(0);
        //driver.findElement(By.cssSelector("a[data-scribe*='twitter_url']")).click();
        //driver.switchTo().defaultContent();
        //przelacza ramke wyzej
        driver.switchTo().parentFrame();
        driver.findElement(By.cssSelector("div.navbar-header>a.logo"));
    }



}

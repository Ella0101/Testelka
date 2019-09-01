import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Waits {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeEach
    public void driverSetup(){
        System.setProperty("webdriver.chrome.driver",  "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1295, 730));
        driver.manage().window().setPosition(new Point(10, 40));
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.navigate().to("https://www.dunckelfeld.de/");

        wait = new WebDriverWait(driver, 10);
    }

    @AfterEach
    public void driverShut(){
        driver.close();
        driver.quit();
    }

    @Test
    public void waitExample(){
        WebElement animation = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".startanimation")));
        wait.until(ExpectedConditions.stalenessOf(animation));
        driver.findElement(By.cssSelector("a.cc-dismiss")).click();
        driver.findElement(By.cssSelector("a[title='Projekte']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[title='UNIVERSAL MUSIC Deutschland']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='#zusammenfassung']"))).click();

        By wireframesBy = By.xpath(".//span[text()='Wireframes']/../span[@class='countup']");
        wait.until(ExpectedConditions.textToBe(wireframesBy, "670"));
    }

}

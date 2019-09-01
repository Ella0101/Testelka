import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Alerts {
        WebDriver driver;
        WebDriverWait wait;
        JavascriptExecutor js;

    @BeforeEach
    public void setDriver(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
//        driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1295, 760));
        driver.manage().window().setPosition(new Point(10, 40));
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        js = (JavascriptExecutor)driver;
        wait = new WebDriverWait(driver, 5);
    }

    @AfterEach
    public void driverShut(){
        driver.close();
        driver.quit();
    }

    @Test
    public void promptBoxTest(){
        String javascript = "prompt('Możesz tutaj coś wpisać:')";
        js.executeScript(javascript);
        wait.until(ExpectedConditions.alertIsPresent());
        String text = driver.switchTo().alert().getText();
        driver.switchTo().alert().sendKeys("Teeeeeeeeeeest");
        driver.switchTo().alert().accept();
        js.executeScript(javascript);
        driver.switchTo().alert().dismiss();
    }
}

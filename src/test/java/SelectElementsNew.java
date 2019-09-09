import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class SelectElementsNew {
    WebDriver driver;

    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1295, 730));
        driver.manage().window().setPosition(new Point(10, 40));
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.navigate().to("https://www.w3schools.com/code/tryit.asp?filename=FZKB5XSEVTU8");
        driver.findElement(By.cssSelector("button.w3-bar-item")).click();
        driver.switchTo().frame("iframeResult");
    }

    @AfterEach
    public void driverQuit(){
        driver.quit();
    }

    @Test
    public void selectElement(){
        WebElement dropdownElement = driver.findElement(By.cssSelector("select"));
        Select dropdown = new Select(dropdownElement);
        Boolean isMultiple = dropdown.isMultiple();
        dropdown.selectByIndex(1);
        dropdown.selectByIndex(3);

        dropdown.deselectAll();
    }
}

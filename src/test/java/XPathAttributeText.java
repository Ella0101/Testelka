import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class XPathAttributeText {
    WebDriver driver;
    WebDriverWait wait;


    @BeforeEach
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1295, 730));
        driver.manage().window().setPosition(new Point(10, 40));
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.navigate().to("https://fakestore.testelka.pl/cwiczenia-z-selektorow-xpath/");

        wait = new WebDriverWait(driver, 10);
    }


    @AfterEach
    public void driverQuit(){
        driver.quit();
    }

    @Test
    public void FindSelector(){
        driver.findElement(By.xpath(".//strong[text()='Nabywca:']/parent::td"));
        driver.findElement(By.xpath(".//*[text()='Bloczek samoprzylepny']/following-sibling::td"));
        driver.findElement(By.xpath(".//*[text()='Bloczek samoprzylepny']/following-sibling::td[2]"));
        driver.findElement(By.xpath(".//*[text()='Bloczek samoprzylepny']/following-sibling::td[3]"));
    }
}

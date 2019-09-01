import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TaskSimpleLocators {
    WebDriver driver;

    @BeforeEach
    public void driverSetup(){
        System.setProperty("webdriver.chrome.driver",  "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1290, 730));
        driver.manage().window().setPosition(new Point(8, 30));
        driver.navigate().to("https://fakestore.testelka.pl/moje-konto/");
    }

    @AfterEach
    public void driverStop(){
        driver.close();
        driver.quit();
    }

    @Test
    public void simpleLocators(){
        driver.findElement(By.id("woocommerce-product-search-field-0"));
        driver.findElement(By.id("username"));
        driver.findElement(By.name("username"));
        driver.findElement(By.id("password"));
        driver.findElement(By.name("password"));
        driver.findElement(By.name("login"));
        driver.findElement(By.id("rememberme"));
        driver.findElement(By.name("rememberme"));
        driver.findElement(By.partialLinkText("Nie pamiętasz"));
        driver.findElement(By.linkText("Nie pamiętasz hasła?"));
        driver.findElement(By.linkText("Żeglarstwo"));
    }
}

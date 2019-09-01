import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TaskAttributesForCSSSelectors {

    WebDriver driver;

    @BeforeEach
    public void driverSetup(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1280, 720));
        driver.navigate().to("https://fakestore.testelka.pl/moje-konto/");
    }

    @AfterEach
    public void driverClose(){
        driver.close();
        driver.quit();
    }

    @Test
    public void findAttributes(){
        driver.findElement(By.cssSelector("[id='twotabsearchtextbox']"));
        driver.findElement(By.cssSelector("[id='']"));
        driver.findElement(By.cssSelector("[id='username']"));
        driver.findElement(By.cssSelector("[id='password']"));
        driver.findElement(By.cssSelector("button[class='woocommerce-LostPassword lost_password']"));
        driver.findElement(By.cssSelector("button[type='checkbox']"));
        driver.findElement(By.cssSelector("button[type='submit']"));
    }
}

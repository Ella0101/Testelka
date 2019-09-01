import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindingElementsCSSSelectors {

    WebDriver driver;

    @BeforeEach
    public void driverSetup(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1280, 720));
        driver.navigate().to("https://www.amazon.com/");
    }

    @AfterEach
    public void driverQuit(){
        driver.close();
        driver.quit();
    }

    @Test
    public void getCurrentURLExample(){
        driver.findElement(By.cssSelector("[id='twotabsearchtextbox']"));
    }
}

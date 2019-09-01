import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TaskWindowResolution {
    WebDriver driver;

    @BeforeEach
    public void driverSetup(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(854, 480));
        driver.manage().window().setPosition(new Point(444, 30));
        driver.navigate().to("https://amazon.com");


    }

    @AfterEach
    public void driverQuit(){
        driver.close();
        driver.quit();
    }

    @Test
    public void windowResolution() {
        Point position = driver.manage().window().getPosition();
        Assertions.assertEquals(new Point(444, 30), position, "Position of the window is now what expected");
        Dimension size = driver.manage().window().getSize();
        Assertions.assertEquals(new Dimension(854, 480), size, "Position of the window is now what expected");

        driver.manage().window().fullscreen();
        try {
            Thread.sleep(3000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.manage().window().maximize();
        try {
            Thread.sleep(3000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

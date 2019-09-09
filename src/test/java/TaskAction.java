import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class TaskAction {
    WebDriver driver;
    Actions actions;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1295, 730));
        driver.manage().window().setPosition(new Point(10, 40));
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        actions = new Actions(driver);
        driver.navigate().to("https://fakestore.testelka.pl/actions");
    }

    @AfterEach
    public void driverQuit(){
        driver.quit();
    }

    @Test
    public void addToBasket(){
        WebElement 

    }

    @Test
    public void changeColorRectangular(){

    }

    @Test
    public void enterYourText(){

    }

    @Test
    public void selectRectangles(){

    }
}

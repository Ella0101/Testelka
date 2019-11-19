import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class DragAndDrop {
    WebDriver driver;
    Actions actions;

    @BeforeEach
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1295, 730));
        driver.manage().window().setPosition(new Point(10,40));
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        actions = new Actions(driver);
    }
    @AfterEach
    public void driverQuit()
    {
        driver.quit();
    }
    @Test
    public void offsetExample(){
        driver.navigate().to("https://marcojakob.github.io/dart-dnd/detection_only/");
        WebElement draggableElement = driver.findElement(By.cssSelector(".draggable"));


        //actions.dragAndDropBy(draggableElement,20, 20 ).build().perform();
        //actions.clickAndHold(draggableElement).moveByOffset(20, 20).release().build().perform();
        actions.moveToElement(draggableElement).clickAndHold().moveByOffset(20,20).release().build().perform();

    }

    @Test
    public void toElementExample(){
        driver.navigate().to("https://marcojakob.github.io/dart-dnd/nested_dropzones/");
        WebElement draggableElement = driver.findElement(By.cssSelector(".draggable"));
        WebElement dropElement = driver.findElement(By.cssSelector(".dropzone-inner"));
        //actions.dragAndDrop(draggableElement, dropElement).build().perform();
        actions.clickAndHold(draggableElement).moveToElement(dropElement).release().build().perform();
    }
}

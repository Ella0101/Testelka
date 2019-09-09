import org.junit.jupiter.api.AfterEach;
        import org.junit.jupiter.api.BeforeEach;
        import org.junit.jupiter.api.Test;
        import org.openqa.selenium.*;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.interactions.Actions;

        import java.util.List;
        import java.util.concurrent.TimeUnit;

public class ActionKeyboardExamples {
    WebDriver driver;
    Actions actions;

    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1295, 730));
        driver.manage().window().setPosition(new Point(10, 40));
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        actions = new Actions(driver);
    }

    @AfterEach
    public void driverQuit(){
        driver.quit();
    }

    @Test
    public void sendKeysExample(){
        driver.navigate().to("https://fakestore.testelka.pl/moje-konto");
        WebElement login = driver.findElement(By.cssSelector("#username"));
        //actions.sendKeys(login, Keys.SHIFT, "testowy user").build().perform();

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", login);

        actions.click(login).sendKeys(Keys.SHIFT, "testowy user").build().perform();
    }
    @Test
    public void pressingKeysExample(){
        //driver.navigate().to("https://fakestore.testelka.pl/moje-konto");
        // WebElement login = driver.findElement(By.cssSelector("#username"));
        //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", login);
        // actions.keyDown(Keys.SHIFT).sendKeys(login, "testowy user").keyUp(Keys.SHIFT).build().perform();

        driver.navigate().to("https://jqueryui.com/selectable/#default");
        driver.switchTo().frame(0);
        List<WebElement> listItems = driver.findElements(By.cssSelector("li.ui-selectee"));
        actions.keyDown(Keys.CONTROL).click(listItems.get(0)).click(listItems.get(1)).click(listItems.get(2)).keyUp(Keys.CONTROL).build().perform();

        //I want just one element to be clicked, let;s say element 4
        //actions.keyDown(Keys.CONTROL).click(listItems.get(0)).click(listItems.get(1)).click(listItems.get(2)).keyUp(Keys.CONTROL).click(listItems.get(3)).build().perform();
    }
}

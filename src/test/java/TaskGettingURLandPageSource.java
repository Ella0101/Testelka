import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.By.cssSelector;

public class TaskGettingURLandPageSource {

    WebDriver driver;

    @BeforeEach
    public void driverStart() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1280, 720));
        driver.manage().window().setPosition(new Point(8,30));
    }

    @AfterEach
    public void driverQuit() {
        driver.close();
        driver.quit();
    }

    @Test
    public void locate(){
        driver.navigate().to("http://wikipedia.pl");
        String expectedPolishTitle = "Wikipedia, wolna encyklopedia";
        Assertions.assertEquals(expectedPolishTitle, driver.getTitle(), "Page title is not: " + expectedPolishTitle);
        String expectedPolishURL = "https://pl.wikipedia.org/wiki/Wikipedia:Strona_g%C5%82%C3%B3wna";
        Assertions.assertEquals(expectedPolishURL, driver.getCurrentUrl(), "Current URLis not:" + expectedPolishURL);
        String polishLanguage ="lang=\"pl\"";
        Assertions.assertTrue(driver.getPageSource().contains(polishLanguage), "Page source does not contain:" + polishLanguage);
        driver.findElement(cssSelector("a[title='hiszpański']")).click();
        String expectedSpanishTitle = "Wikipedia, la enciclopedia libre";
        Assertions.assertEquals(expectedSpanishTitle, driver.getTitle(), "Page title is not: " + expectedSpanishTitle);
        String expectedSpanishURL = "https://es.wikipedia.org/wiki/Wikipedia:Portada";
        Assertions.assertEquals(expectedSpanishURL, driver.getCurrentUrl(), "Current URLis not:" + expectedSpanishURL);
        String spanishLanguage ="lang=\"es\"";
        Assertions.assertTrue(driver.getPageSource().contains(spanishLanguage), "Page source does not contain: " + spanishLanguage);
    }
}

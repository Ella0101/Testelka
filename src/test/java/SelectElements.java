import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SelectElements {
    WebDriver driver;


    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1295, 730));
        driver.manage().window().setPosition(new Point(10, 40));
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.navigate().to("https://allegro.pl");
        driver.manage().addCookie(new Cookie ("gdpr permission given", "1"));
        driver.navigate().refresh();

    }
    @AfterEach
    public void driverQuit(){
        driver.quit();
    }

    @Test
    public void selectElements(){
        WebElement productCategories = driver.findElement(By.cssSelector("[data-role='filters-dropdown-toggle']"));
        Select categoriesDropdown = new Select(productCategories);
        categoriesDropdown.selectByIndex(3);
        //categoriesDropdown.selectByValue("/kategoria/kultura-i-rozrywka");
        //categoriesDropdown.selectByVisibleText("Zdrowie");
        Boolean isMultiple = categoriesDropdown.isMultiple();
        List<WebElement> options = categoriesDropdown.getOptions();
        List<WebElement> selectedOptions = categoriesDropdown.getAllSelectedOptions();
        WebElement firstSelectedOption = categoriesDropdown.getFirstSelectedOption();
    }
}

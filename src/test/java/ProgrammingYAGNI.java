import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProgrammingYAGNI {
    WebDriver driver;
    String country;
    String firstName;
    String lastName;

    @BeforeEach
    public void driverSetup(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1280, 720));
        driver.manage().window().setPosition(new Point(10, 40));
    }

    @AfterEach
    public void driverShut(){
        driver.close();
        driver.quit();
    }

    @Test
    public void registerUserPortugal(){
        country = "Portugal";
        registerUser(firstName, lastName, country);
        Assertions.assertEquals("Portuguese user registered", getAlertText(),
                "Displayed message is not what expected");
    }

    private void registerUser(String firstName, String lastName, String country){
        driver.findElement(By.cssSelector("input[id='first-name']")).sendKeys(firstName);
        driver.findElement(By.cssSelector("input[id='last-name']")).sendKeys(lastName);
        driver.findElement(By.cssSelector("input[id='country']")).sendKeys(country);
        driver.findElement(By.cssSelector("button[name='register']")).click();
    }
    private String getAlertText(){
        return driver.findElement(By.cssSelector("id='alert'")).getText();
    }


}

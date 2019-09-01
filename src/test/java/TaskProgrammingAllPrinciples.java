import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TaskProgrammingAllPrinciples {

    WebDriver driver;
    String userName = "TestUser";
    String email = "test@testelka.pl";
    String password = "m^45439539082fkdjjsgf";
    String wrongPassword = "wrong";
    String nonexistentUserName = "NonExistentUser";
    String nonexistentEmail = "notexistingemail@testelka.pl";
    String userFullName = "Geralt z Rivii";
    String myAccountContent;
    String errorMessageText;
    String expectedMessage;

    @BeforeEach
    public void driverSetup(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1280, 720));
        driver.manage().window().setPosition(new Point(10, 40));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.navigate().to("https://fakestore.testelka.pl/moje-konto/");
    }

    @AfterEach
    public void driverShut(){
        driver.close();
        driver.quit();
    }

    @Test
    public void existentUsernameCorrectPasswordTest(){
        logIn(userName, password);
        myAccountContent = getDisplayedName();
        Assertions.assertTrue(myAccountContent.contains(userFullName),"My Account page does not contain correct name. " +
                "Expected name: " +userFullName + "was not found in a string: " +myAccountContent);
    }

    @Test
    public void existentEmailCorrectPasswordTest(){
        logIn(email, password);
        myAccountContent = getDisplayedName();
        Assertions.assertTrue(myAccountContent.contains(userFullName), "My Account page does not contain correct name. " +
                "Expected name: " + userFullName + "was not found in a string: " + myAccountContent);
    }

    @Test
    public void nonexistentEmailIncorrectPasswordTest(){
        logIn(nonexistentEmail, wrongPassword);
        errorMessageText = getErrorMessage();
        expectedMessage = "BŁĄD: Nieprawidłowy adres email. Nie pamiętasz hasła?";
        Assertions.assertEquals(expectedMessage, errorMessageText, "Error message is not correct.");
    }

    private void logIn(String userName, String password){
        driver.findElement(By.cssSelector("input[id='username']")).sendKeys(userName);
        driver.findElement(By.cssSelector("input[id=password']")).sendKeys(password);
        driver.findElement(By.cssSelector("button[name='login']")).click();
    }

    private String getDisplayedName(){
        return driver.findElement(By.cssSelector("div[class='woocommerce-MyAccount-content']>p")).getText();
    }

    private String getErrorMessage(){
        return driver.findElement(By.cssSelector("ul[class='woocommerce-error']")).getText();
    }


}

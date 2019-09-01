import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class JavaScript {
    WebDriver driver;
    WebDriverWait wait;

@BeforeEach
    public void driverSetup() {
    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().setSize(new Dimension(1295, 760));
    driver.manage().window().setPosition(new Point(10,40));
    driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
    wait = new WebDriverWait(driver, 10);
    driver.manage().timeouts().setScriptTimeout(1000, TimeUnit.MILLISECONDS);
}

@AfterEach
    public void driverShut(){
    driver.close();
    driver.quit();
}

@Test
public void exampleTest(){
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("console.log('Właśnie coś wpisałam w konsolę');");
    String domainName = (String)js.executeScript("return document.domain;");
}

@Test
public void aSyncTest(){
    long start = System.currentTimeMillis();
    ((JavascriptExecutor)driver).executeAsyncScript(
            "window.setTimeout(arguments[arguments.length -1], 500);");
    long elapsedTime = System.currentTimeMillis() - start;
    System.out.println("Elapsed time: " + elapsedTime);
}

@Test
public void syncTest() {
    long start = System.currentTimeMillis();
    ((JavascriptExecutor) driver).executeScript(
            "window.setTimeout(arguments[arguments.length -1], 500);");
    long elapsedTime = System.currentTimeMillis() - start;
    System.out.println("Elapsed time: " + elapsedTime);
}

}



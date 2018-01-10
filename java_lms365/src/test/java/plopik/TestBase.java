package plopik;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class TestBase extends ApplicationManager {
    FirefoxDriver wd;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() throws Exception {
        init();
    }

    private void init() {
        wd = new FirefoxDriver();
        wait = new WebDriverWait(wd,10);
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("https://lms365qa.sharepoint.com/sites/basic flow");
        login("t3@lms365qa.onmicrosoft.com", "!QAZ2wsx");
    }

    private void login(String username, String password) {
        type(By.name("loginfmt"), username);
        click(By.xpath("//input[contains(@type, 'submit')]"));
        waitElement(By.name("passwd"));
        type(By.name("passwd"), password);
        click(By.xpath("//input[contains(@type, 'submit')]"));
//        wait.until(visibilityOfElementLocated(By.id("idBtn_Back")));
//        wd.findElement(By.id("idBtn_Back")).click();
    }

    private void waitElement(By locator) {
        wait.until(visibilityOfElementLocated(locator));
    }

    private void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    private void click(By locator) {
        wd.findElement(locator).click();
    }

    @AfterMethod
    public void tearDown() {
        stop();
    }

    private void stop() {
        wd.quit();
    }
}

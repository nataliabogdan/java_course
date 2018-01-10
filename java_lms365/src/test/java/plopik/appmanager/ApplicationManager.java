package plopik.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class ApplicationManager {
    public FirefoxDriver wd;
    public WebDriverWait wait;

    public void init() {
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

    public void waitElement(By locator) {
        wait.until(visibilityOfElementLocated(locator));
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void stop() {
        wd.quit();
    }
}

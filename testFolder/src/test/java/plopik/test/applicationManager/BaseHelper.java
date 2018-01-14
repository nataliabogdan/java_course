package plopik.test.applicationManager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseHelper {
    protected WebDriver wd;
    WebDriverWait wait;

    public BaseHelper(WebDriver wd) {

        this.wd = wd;
    }


    protected void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    protected void click(By locator) {
        wd.findElement(locator).click();
    }

    protected void waitElementIsVisible(By locator, int seconds) {
        wait = new WebDriverWait(wd, seconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    public static boolean isAlertPresent(WebDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException ex) {
            return false;
        }
    }

}

package plopik.lms365.appmanager;

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

    public void type(By locator, String text) {
        click(locator);
        if (text != null) {
            String existingText = wd.findElement(locator).getAttribute("value");
            if (! existingText.equals(text)){
                wd.findElement(locator).clear();
                wd.findElement(locator).sendKeys(text);

            }
        }
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void waitElement(By locator, int seconds){
        wait = new WebDriverWait(wd, seconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}

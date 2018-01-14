import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    ChromeDriver wd;
    WebDriverWait wait;

    @BeforeTest
    public void setUp() throws Exception{
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.manage().window().maximize();
    }

    @Test

    public void testLogin(){
        wd.get("https://lms365qa.sharepoint.com/sites/basic flow/SitePages/Home.aspx");
        type(By.name("loginfmt"), "t3@lms365qa.onmicrosoft.com");
        click(By.cssSelector("input#idSIButton9"));
        waitElementIsVisible(By.name("passwd"), 10);
        type(By.name("passwd"), "!QAZ2wsx");
        click(By.xpath("//input[@type='submit']"));
    }

    private void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    private void click(By locator) {
        wd.findElement(locator).click();
    }

    private void waitElementIsVisible(By locator, int seconds) {
        wait = new WebDriverWait(wd, seconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    @AfterTest
    public void tearDown(){
        wd.quit();
    }

    public static boolean isAlertPresent(ChromeDriver wd){
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException ex){
            return false;
        }
    }
}

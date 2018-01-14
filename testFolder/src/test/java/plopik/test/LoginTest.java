package plopik.test;

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
        wd.get("https://lms365qa.sharepoint.com/sites/basic flow/SitePages/Home.aspx");
        login("t3@lms365qa.onmicrosoft.com","!QAZ2wsx" );

    }

    @Test
    public void testLogin(){
        wd.get("https://lms365qa.sharepoint.com/sites/basic flow/_layouts/15/appredirect.aspx?instance_id={2fb42468-c7ae-4329-9e56-ebe12927573b}");

    }

    private void login(String loginName, String password) {
        wd.findElement(By.name("loginfmt")).click();
        wd.findElement(By.name("loginfmt")).clear();
        wd.findElement(By.name("loginfmt")).sendKeys(loginName);
        wd.findElement(By.cssSelector("input#idSIButton9")).click();
        waitElementIsVisible(By.name("passwd"), 10);
        wd.findElement(By.name("passwd")).click();
        wd.findElement(By.name("passwd")).clear();
        wd.findElement(By.name("passwd")).sendKeys(password);
        wd.findElement(By.xpath("//input[@type='submit']")).click();
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

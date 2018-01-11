package plopik.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SessionHelper extends BaseHelper{
//    WebDriverWait wait;

    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    protected void login(String username, String password) {
//        wait = new WebDriverWait(wd,10);
        type(By.name("loginfmt"), username);
        click(By.xpath("//input[contains(@type, 'submit')]"));
//        wait.until(visibilityOfElementLocated(By.name("passwd")));
        waitElement(By.name("passwd"), 10);
        type(By.name("passwd"), password);
        click(By.xpath("//input[contains(@type, 'submit')]"));
//        wait.until(visibilityOfElementLocated(By.id("idBtn_Back")));
//        wd.findElement(By.id("idBtn_Back")).click();
    }

}

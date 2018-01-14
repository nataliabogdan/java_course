package plopik.test.applicationManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends BaseHelper {


    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void login(String loginName, String password) {
        type(By.name("loginfmt"), loginName);
        click(By.xpath("//input[contains(@type, 'submit')]"));
        waitElementIsVisible(By.name("passwd"), 10);
        type(By.name("passwd"), password);
        click(By.xpath("//input[contains(@type, 'submit')]"));
    }
}


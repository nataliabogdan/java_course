package plopik.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends BaseHelper{


    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    protected void login(String username, String password) {
        type(By.name("loginfmt"), username);
        click(By.xpath("//input[contains(@type, 'submit')]"));
        waitElement(By.name("passwd"), 10);
        type(By.name("passwd"), password);
        click(By.xpath("//input[contains(@type, 'submit')]"));

    }

}

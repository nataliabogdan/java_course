package plopik.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper {
    private FirefoxDriver wd;

    public NavigationHelper(FirefoxDriver wd) {
        this.wd = wd;
    }

    public void gotoGroupPage() {
        //different selectors
        //wd.findElement(By.xpath("//li[contains(@class,'admin')]/a")).click(); //first variant
        //wd.findElement(By.xpath("//ul//a[contains(@href, 'group.php')]")).click(); //second variant

        wd.findElementByXPath("//a[@href='group.php']").click(); //third variant
    }

    public void gotoContactPage() {
        wd.findElementByXPath("//a[contains(text(),'home')]").click();
    }


    public void returnToGroupPage() {
        wd.findElement(By.linkText("group page")).click();
    }

    public void returnToContactPage() {
        wd.findElementByXPath("//a[contains(text(), 'home')]").click();
    }
}

package plopik.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends BaseHelper {

    public NavigationHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void gotoGroupPage() {
        //different selectors
        //wd.findElement(By.xpath("//li[contains(@class,'admin')]/a")).click(); //first variant
        //wd.findElement(By.xpath("//ul//a[contains(@href, 'group.php')]")).click(); //second variant
        click(By.xpath("//a[@href='group.php']"));

        //wd.findElementByXPath("//a[@href='group.php']").click(); //third variant
    }

    public void gotoContactPage() {
        click(By.xpath("//a[contains(text(),'home')]"));
    }


    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void returnToContactPage() {
        click(By.xpath("//a[contains(text(), 'home')]"));
    }
}

package plopik.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends BaseHelper {

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void gotoGroupPage() {
        //different selectors
        //wd.findElement(By.xpath("//li[contains(@class,'admin')]/a")).click(); //first variant
        //wd.findElement(By.xpath("//ul//a[contains(@href, 'group.php')]")).click(); //second variant


        if (isElementPresent(By.tagName("h1"))
                && wd.findElement(By.tagName("h1")).getText().equals("Groups")
                && isElementPresent(By.name("new"))) {
            return;
        } else {
            click(By.xpath("//a[@href='group.php']"));
        }

        //wd.findElementByXPath("//a[@href='group.php']").click(); //third variant
    }

    public void gotoContactPage() {
        if (isElementPresent(By.id("maintable"))) {
            return;
        } else {
            click(By.xpath("//a[contains(text(),'home')]"));
        }
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void returnToContactPage() {
        click(By.xpath("//a[contains(text(), 'home')]"));
    }


}

package plopik.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import plopik.addressbook.model.ContactData;
import plopik.addressbook.model.GroupData;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    FirefoxDriver wd;

    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public void init() {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook");
        login("admin", "secret");
    }

    public void login(String username, String password) {
        wd.findElement(By.id("LoginForm")).click();
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys(username);
        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys(password);
        wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
    }

    public void returnToGroupPage() {
        wd.findElement(By.linkText("group page")).click();
    }

    public void submitGroupCreation() {
        wd.findElement(By.name("submit")).click();
    }

    public void fillGroupForm(GroupData groupData) {
        wd.findElement(By.name("group_name")).click();
        wd.findElement(By.name("group_name")).clear();
        wd.findElement(By.name("group_name")).sendKeys(groupData.getName());
        wd.findElement(By.name("group_header")).click();
        wd.findElement(By.name("group_header")).clear();
        wd.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
        wd.findElement(By.name("group_footer")).click();
        wd.findElement(By.name("group_footer")).clear();
        wd.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
    }

    public void initGroupCreation() {
        wd.findElement(By.name("new")).click();
    }

    public void gotoGroupPage() {
        //different selectors
        //wd.findElement(By.xpath("//li[contains(@class,'admin')]/a")).click(); //first variant
        //wd.findElement(By.xpath("//ul//a[contains(@href, 'group.php')]")).click(); //second variant

        wd.findElementByXPath("//a[@href='group.php']").click(); //third variant
    }

    public void stop() {
        wd.quit();
    }

    public void gotoContactPage() {
        wd.findElementByXPath("//a[contains(text(),'home')]").click();
    }

    public void initContactCreation() {
        wd.findElementByXPath("//a[@href='edit.php']").click();
    }

    public void fillContactForm(ContactData contactData) {
        wd.findElementByName("firstname").click();
        wd.findElementByName("firstname").clear();
        wd.findElementByName("firstname").sendKeys(contactData.getFirstName());
        wd.findElementByName("lastname").click();
        wd.findElementByName("lastname").clear();
        wd.findElementByName("lastname").sendKeys(contactData.getLastName());
        wd.findElementByName("address").click();
        wd.findElementByName("address").clear();
        wd.findElementByName("address").sendKeys(contactData.getAddress());
    }

    public void submitContactCreation() {
        wd.findElementByName("submit").click();
    }

    public void returnToContactPage() {
        wd.findElementByXPath("//a[contains(text(), 'home')]").click();
    }

    public void deleteGroup() {
        wd.findElement(By.name("delete")).click();
    }

    public void deleteContact(){
        wd.findElementByXPath("//input[contains(@value, 'Delete')]").click();
    }

    public void selectGroup() {
        wd.findElementByXPath("//span/input[contains(@type, 'checkbox')]").click();
    }

    public void selectContact(){
        wd.findElementByXPath("//input[contains(@name, 'selected[]')]").click();
    }

    public void acceptAlert(){
        wd.switchTo().alert().accept();

    }
}

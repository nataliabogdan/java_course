package plopik.addressbook.appmanager;

import org.openqa.selenium.firefox.FirefoxDriver;
import plopik.addressbook.model.ContactData;

public class ContactHelper {
    private FirefoxDriver wd;

    public ContactHelper(FirefoxDriver wd) {
        this.wd = wd;
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


    public void deleteContact() {
        wd.findElementByXPath("//input[contains(@value, 'Delete')]").click();
    }

    public void selectContact() {
        wd.findElementByXPath("//input[contains(@name, 'selected[]')]").click();
    }
}

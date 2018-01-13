package plopik.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import plopik.addressbook.model.ContactData;

public class ContactHelper extends BaseHelper {


    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void initContactCreation() {
        click(By.xpath("//a[@href='edit.php']"));
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("address"), contactData.getAddress());

        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }


    public void deleteContact() {
        click(By.xpath("//input[contains(@value, 'Delete')]"));
        acceptAlert();
    }

    public void selectContact() {
        click(By.xpath("//input[contains(@name, 'selected[]')]"));
    }

    public void initContactModification() {
        click(By.xpath("//a[contains(@href, '')]/img[contains(@title, 'Edit')]"));
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public void createContact(ContactData contactData, boolean creation ) {
        initContactCreation();
        fillContactForm(contactData, creation);
        submitContactCreation();
    }

    public boolean isContactExist() {
        return isElementPresent(By.xpath("//input[contains(@name, 'selected[]')]"));
    }
}

package plopik.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import plopik.addressbook.model.ContactData;

public class ContactHelper extends HelperBase{


    public ContactHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void initContactCreation() {
        click(By.xpath("//a[@href='edit.php']"));
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("address"), contactData.getAddress());
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

}

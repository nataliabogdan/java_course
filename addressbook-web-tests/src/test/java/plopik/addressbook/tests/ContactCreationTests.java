package plopik.addressbook.tests;

import org.testng.annotations.Test;
import plopik.addressbook.model.ContactData;


public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.gotoContactPage();
        app.initContactCreation();
        app.fillContactForm(new ContactData("Natalia", "Dzikun", "Ulm"));
        app.submitContactCreation();
        app.returnToContactPage();
    }


}

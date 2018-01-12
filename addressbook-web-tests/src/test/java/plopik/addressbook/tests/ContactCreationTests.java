package plopik.addressbook.tests;

import org.testng.annotations.Test;
import plopik.addressbook.model.ContactData;


public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getNavigationHelper().gotoContactPage();
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForm(new ContactData("Natalia", "Dzikun", null));
        app.getContactHelper().submitContactCreation();
        app.getNavigationHelper().returnToContactPage();
    }


}

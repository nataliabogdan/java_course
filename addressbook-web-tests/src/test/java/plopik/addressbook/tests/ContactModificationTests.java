package plopik.addressbook.tests;

import org.testng.annotations.Test;
import plopik.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification(){
        app.getNavigationHelper().gotoContactPage();
        app.getContactHelper().selectContact();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("Natalia", "Dzikun", "editaddress", null), false);
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().returnToContactPage();
    }
}

package plopik.addressbook.tests;

import org.testng.annotations.Test;
import plopik.addressbook.model.ContactData;


public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getNavigationHelper().gotoContactPage();
        app.getContactHelper().createContact(new ContactData("Natalia", "Dzikun", null, "group1"), true);
        app.getNavigationHelper().returnToContactPage();
    }




}

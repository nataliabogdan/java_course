package plopik.addressbook.tests;

import org.testng.annotations.Test;
import plopik.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().gotoContactPage();
        if(! app.getContactHelper().isContactExist()){
            app.getContactHelper().createContact(new ContactData("Natalia", "Dzikun", null, "group1"), true);
            app.getNavigationHelper().returnToContactPage();
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteContact();
        app.getNavigationHelper().returnToContactPage();

    }
}

package plopik.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import plopik.addressbook.model.ContactData;


public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getNavigationHelper().gotoContactPage();
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().createContact(new ContactData("Natalia", "Dzikun", null, "group1"), true);
        app.getNavigationHelper().returnToContactPage();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before + 1);
    }
}

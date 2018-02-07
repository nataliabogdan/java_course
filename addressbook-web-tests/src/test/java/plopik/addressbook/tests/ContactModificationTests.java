package plopik.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import plopik.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification(){
        app.getNavigationHelper().gotoContactPage();
        if(! app.getContactHelper().isContactExist()){
            app.getContactHelper().createContact(new ContactData("Natalia", "Dzikun", null, "group1"), true);
            app.getNavigationHelper().returnToContactPage();
        }
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().selectContact(0);
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("Natalia", "Dzikun", "editaddress", null), false);
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().returnToContactPage();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before);
    }
}

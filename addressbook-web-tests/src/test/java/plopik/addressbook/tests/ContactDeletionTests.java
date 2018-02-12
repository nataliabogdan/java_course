package plopik.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import plopik.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().gotoContactPage();
        if (!app.getContactHelper().isContactExist()) {
            app.getContactHelper().createContact(new ContactData("Natalia", "Dzikun", null, "group1"), true);
            app.getNavigationHelper().returnToContactPage();
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(0); //select first contact
        app.getContactHelper().deleteContact();
        app.getNavigationHelper().returnToContactPage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1); //удаляем индекс, переменная before ссылается на старый список в котором удален ненужный элемент
        Assert.assertEquals(before, after);

    }
}

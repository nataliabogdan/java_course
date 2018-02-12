package plopik.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import plopik.addressbook.model.ContactData;
import plopik.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;


public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getNavigationHelper().gotoContactPage();
        List<ContactData> before = app.getContactHelper().getContactList();
        ContactData contact = new ContactData("Natalia", "Dzikun", null, "group1");
        app.getContactHelper().createContact(contact, true);
        app.getNavigationHelper().returnToContactPage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);

        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);// упорядочиваем список
        after.sort(byId);
        Assert.assertEquals(after, before);// преобразуем списки в множества и сравниваем
    }
}

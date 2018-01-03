package plopik.addressbook;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        gotoContactPage();
        selectContact();
        deleteContact();
        acceptAllert();
        returnToContactPage();

    }
}

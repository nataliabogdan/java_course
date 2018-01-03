package plopik.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        app.gotoContactPage();
        app.selectContact();
        app.deleteContact();
        app.acceptAlert();
        app.returnToContactPage();

    }
}

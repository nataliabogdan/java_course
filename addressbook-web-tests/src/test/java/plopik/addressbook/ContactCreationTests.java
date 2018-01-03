package plopik.addressbook;

import org.testng.annotations.Test;


public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        gotoContactPage();
        initContactCreation();
        fillContactForm(new ContactData("Natalia", "Dzikun", "Ulm"));
        submitContactCreation();
        returnToContactPage();
    }


}

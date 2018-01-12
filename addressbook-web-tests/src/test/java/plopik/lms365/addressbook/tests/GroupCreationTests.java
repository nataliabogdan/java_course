package plopik.lms365.addressbook.tests;

import org.testng.annotations.Test;
import plopik.lms365.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {


    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData("group1", null, "edit3"));
        app.getGroupHelper().submitGroupCreation();
        app.getNavigationHelper().returnToGroupPage();
    }

}
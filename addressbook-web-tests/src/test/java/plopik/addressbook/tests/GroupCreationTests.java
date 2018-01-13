package plopik.addressbook.tests;

import org.testng.annotations.Test;
import plopik.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {


    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().createGroup(new GroupData("group1", null, "edit3"));
    }

}
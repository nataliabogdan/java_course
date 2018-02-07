package plopik.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import plopik.addressbook.model.GroupData;

public class GroupModificationTests extends TestBase {

    @Test
    public void testGroupModification() {
        app.getNavigationHelper().gotoGroupPage();
        if (!app.getGroupHelper().isGroupExist()) {
            app.getGroupHelper().createGroup(new GroupData("group1", null, "edit3"));

        }
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().selectGroup(before - 1);
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("group1", "edit2", "edit3"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before);
    }
}

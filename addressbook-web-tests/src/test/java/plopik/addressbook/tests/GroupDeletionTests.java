package plopik.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import plopik.addressbook.model.GroupData;

public class GroupDeletionTests extends TestBase {


    @Test
    public void testGroupDeletion() {
        app.getNavigationHelper().gotoGroupPage();
        if(!app.getGroupHelper().isGroupExist())
        {
            app.getGroupHelper().createGroup(new GroupData("group1", null, "edit3"));
        }
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().selectGroup(before - 1); //select the last group
        app.getGroupHelper().deleteGroup();
        app.getGroupHelper().returnToGroupPage();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before - 1);

    }


}

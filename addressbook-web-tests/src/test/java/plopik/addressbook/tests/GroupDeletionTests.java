package plopik.addressbook.tests;
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
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteGroup();
        app.getGroupHelper().returnToGroupPage();
    }


}

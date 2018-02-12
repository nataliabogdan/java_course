package plopik.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import plopik.addressbook.model.GroupData;

import java.util.Arrays;
import java.util.List;

public class GroupDeletionTests extends TestBase {


    @Test
    public void testGroupDeletion() {
        app.getNavigationHelper().gotoGroupPage();
        if(!app.getGroupHelper().isGroupExist())
        {
            app.getGroupHelper().createGroup(new GroupData("group1", null, "edit3"));
        }
        List<GroupData> before = app.getGroupHelper().getGroupList();
//        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().selectGroup(before.size() - 1); //select the last group
        app.getGroupHelper().deleteGroup();
        app.getGroupHelper().returnToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1); //удаляем индекс, переменная before ссылается на старый список в котором удален ненужный элемент
        Assert.assertEquals(before, after);

    }
}

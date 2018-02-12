package plopik.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import plopik.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupModificationTests extends TestBase {

    @Test
    public void testGroupModification() {
        app.getNavigationHelper().gotoGroupPage();
        if (!app.getGroupHelper().isGroupExist()) {
            app.getGroupHelper().createGroup(new GroupData("group1", null, "edit3"));
        }
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(before.size() - 1);
        app.getGroupHelper().initGroupModification();
        GroupData group = new GroupData(before.get(before.size() - 1).getId(),"group1", "edit2", "edit3"); //сохраняем старый идентификатор
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);//удаляем из списка изменяемую группу
        before.add(group);// добавляем в список новую отредактированную группу
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));// преобразуем списки в множества и сравниваем

    }
}

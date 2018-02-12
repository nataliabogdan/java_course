package plopik.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import plopik.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {


    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().gotoGroupPage();
        List<GroupData> before = app.getGroupHelper().getGroupList();
        GroupData group = new GroupData("group1", null, "edit3");
        app.getGroupHelper().createGroup(group);
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() + 1);


//        int max = 0;
//        for (GroupData g: after) { // цикл по всем элементам, ищем элемент с максимальным идентификатором
//            if (g.getId() > max){
//                max = g.getId(); //мак присваеваем новый айди
//            }
//        }

        group.setId(after.stream().max(Comparator.comparingInt(GroupData::getId)).get().getId()); //превращаем список в поток
        before.add(group);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));// преобразуем списки в множества и сравниваем

    }
}
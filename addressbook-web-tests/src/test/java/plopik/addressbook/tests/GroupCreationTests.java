package plopik.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import plopik.addressbook.model.GroupData;

import java.util.Comparator;
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
//                max = g.getId(); //макс присваеваем новый айди
//            }

        before.add(group);
        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);// упорядочиваем список
        after.sort(byId);
        Assert.assertEquals(after, before);// преобразуем списки в множества и сравниваем

    }
}
package plopik.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import plopik.addressbook.model.GroupData;

public class GroupHelper extends BaseHelper {

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void submitGroupCreation() {
        wd.findElement(By.name("submit")).click();
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void deleteGroup() {
        click(By.name("delete"));
    }

    public void selectGroup(int index) {
        wd.findElements(By.xpath("//span/input[contains(@type, 'checkbox')]")).get(index).click();
//        click(By.xpath("//span/input[contains(@type, 'checkbox')]"));
    }

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }


    public boolean isGroupExist() {
        return isElementPresent(By.xpath("//span/input[contains(@type, 'checkbox')]"));
    }

    public void createGroup(GroupData groupData) {
        initGroupCreation();
        fillGroupForm(groupData);
        submitGroupCreation();
        returnToGroupPage();
    }

    public int getGroupCount() {
        return wd.findElements(By.name("selected[]")).size();
    }
}

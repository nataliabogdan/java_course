package plopik.lms365.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends BaseHelper {

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void goToCourseCatalog() {
        wd.get("https://lms365qa.sharepoint.com/sites/basic flow/_layouts/15/appredirect.aspx?instance_id={2fb42468-c7ae-4329-9e56-ebe12927573b}");
    }

    public void returnToCourseListPage() {
//        if(isElementPresent(By.xpath("//div[@id='btn-page-header']"))
//                && wd.findElement(By.xpath("//div[text()='Create Course']")).getText().equals("Create Course"))
//        {
//            return;
//        }
        wd.findElement(By.xpath("//i[contains(@class, 'ms-Icon--Home')]")).click();
    }
}

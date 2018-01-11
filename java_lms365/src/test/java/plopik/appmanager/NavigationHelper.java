package plopik.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends BaseHelper {

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void goToCourseCatalog() {
        wd.get("https://lms365qa.sharepoint.com/sites/basic flow/_layouts/15/appredirect.aspx?instance_id={2fb42468-c7ae-4329-9e56-ebe12927573b}");
    }

    public void returnToCourseListPage() {
//        click(By.cssSelector("i[data-icon-name=IconLink]"));
        click(By.cssSelector("span.icon-left-arrow"));
    }
}

package plopik.test.applicationManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CourseHelper extends BaseHelper {

    public CourseHelper(WebDriver wd) {
        super(wd);
    }


    public void fillCourseForm(String courseName, String shortDescription, String courseCategory) {
        type(By.id("CourseName"), courseName);
        type(By.id("Description"), shortDescription);
        typeCategory(By.cssSelector("#token-input-Categories_SelectedItems"), courseCategory);
    }

    public void returnToCourseListPage() {
        wd.findElement(By.xpath("//i[contains(@class, 'ms-Icon--Home')]")).click();
    }

    public void submitCourseCreation() {
        click(By.cssSelector("a.create-course"));
        waitElementIsVisible(By.cssSelector("div.courseCreatedInfo"), 10);
    }

    public void initCourseCreation() {
        click(By.xpath("//i[contains(@data-icon-name, 'Add')]"));
        click(By.xpath("//button[contains(@name, 'e-Learning')]"));
    }

    public void typeCategory(By locator, String text) {
        wd.findElement(locator).clear();
        click(By.xpath("//div/ul/li[contains(text(), '" + text + "')]"));
    }
}

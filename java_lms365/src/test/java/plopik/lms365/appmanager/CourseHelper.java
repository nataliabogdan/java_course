package plopik.lms365.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import plopik.lms365.model.CourseData;

import java.util.concurrent.TimeUnit;

public class CourseHelper extends BaseHelper {

    public CourseHelper(WebDriver wd) {
        super(wd);
    }

    public void initElearningCourseCreation() {
        click(By.xpath("//i[contains(@data-icon-name, 'Add')]"));
        click(By.xpath("//button[contains(@name, 'e-Learning')]"));
    }

    public void fillCourseForm(CourseData courseData) {
        type(By.id("CourseName"), courseData.getCourseName());
        type(By.id("Description"), courseData.getShortDescription());
        typeCategory(By.cssSelector("#token-input-Categories_SelectedItems"), courseData.getCourseCategory());
    }

    private void typeCategory(By locator, String text) {
        wd.findElement(locator).clear();
//        System.out.println(wd.findElement(By.xpath("//div/ul/li[contains(text(), 'elearning category')]")).getText());
        wd.findElement(By.xpath("//div/ul/li[contains(text(), '" + text + "')]")).click();
//        try {
//            wd.findElement(By.xpath("//div[23]/ul/li[contains(text(), 'elearning category')]")).click();
//            Thread.sleep(5000);
//        } catch (Exception ex){
//            System.out.println("Error");
//        }
    }

    public void submitCourseCreation() {
        click(By.cssSelector("a.create-course"));
        waitElementIsVisible(By.cssSelector("div.courseCreatedInfo"), 10);
    }

    public void checkCourseInList(String courseName) {
        //System.out.println(wd.findElement(By.xpath("//div[@class = 'ms-List-page']//span[@title = '" + text + "']")).getText());
        Assert.assertEquals(wd.findElement(By.xpath("//div[@class = 'ms-List-page']//span[@title = '" + courseName + "']")).getText(), courseName);
    }

    public void filterByCourseName(String courseName) {
        if (courseName != null) {
            waitElementIsClickable(By.cssSelector("input[placeholder='Search']"), 10);
            click(By.cssSelector("input[placeholder='Search']"));
            type(By.cssSelector("input[placeholder='Search']"), courseName);
            wd.findElement(By.cssSelector("input[placeholder='Search']")).sendKeys(Keys.ENTER);
            waitElementIsVisible(By.xpath("//div[@class = 'ms-List-page']"), 10);
        }
    }

    public void checkCourseNotInList() {
        //System.out.println(wd.findElement(By.xpath("//div[@class = 'ms-List-page']//div[text()]")).getText());
        Assert.assertEquals(wd.findElement(By.xpath("//div[@class = 'ms-List-page']//div[text()]")).getText(), "No item(s) found.");
    }

    public void selectCourseByName(String courseName) {
        if (courseName != null) {
            waitElementIsNotVisible(By.xpath("//div/span[text()='" + courseName + "']/../../..//div[contains(@class, 'ms-Spinner')]"), 80);
            click(By.xpath("//div[@class='ms-List-page']//span[contains(text(),'" + courseName + "')]//.."));
        }
        click(By.xpath("//div[@class='ms-List-page']//span[contains(text(),'')]"));
    }


    public void deleteCourse() {
        click(By.xpath("//i[@data-icon-name='Trash']"));
        click(By.xpath("//span//button[@class= 'ms-Button ms-Button--primary css-18s71b6']"));
//        waitElementIsVisible(By.xpath("//div[contains(@class,'ef-dialog-container')]"),1);
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        waitElementIsNotVisible(By.xpath("//span//button[@class= 'ms-Button ms-Button--primary css-18s71b6']"), 5);
    }

    public boolean isCourseExist() {
        return isElementPresent(By.xpath("//div[@class='ms-List-page']//span[contains(text(),'')]"));
    }
}

package plopik.lms365.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CourseHelper extends BaseHelper {

    public CourseHelper(WebDriver wd) {
        super(wd);
    }

    public void initElearningCourseCreation() {
        click(By.xpath("//i[contains(@data-icon-name, 'Add')]"));
        click(By.xpath("//button[contains(@name, 'e-Learning')]"));
    }

    public void fillCourseForm(String courseName, String shortDescription, String courseCategory ) {
        type(By.id("CourseName"), courseName);
        type(By.id("Description"), shortDescription);
        typeCategory(By.cssSelector("#token-input-Categories_SelectedItems"), courseCategory);
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
        waitElement(By.cssSelector("div.courseCreatedInfo"), 10);
    }

    public void checkCourseInList(String courseName) {
        click(By.cssSelector("input#SearchBox22"));
        type(By.cssSelector("input#SearchBox22"), courseName);
        wd.findElement(By.cssSelector("input#SearchBox22")).sendKeys(Keys.ENTER);
        waitElement(By.xpath("//div[@class = 'ms-List-page']//span[@title = '" + courseName + "']"), 10);
        //System.out.println(wd.findElement(By.xpath("//div[@class = 'ms-List-page']//span[@title = '" + text + "']")).getText());
        Assert.assertEquals(wd.findElement(By.xpath("//div[@class = 'ms-List-page']//span[@title = '" + courseName + "']")).getText(), courseName);
    }
}

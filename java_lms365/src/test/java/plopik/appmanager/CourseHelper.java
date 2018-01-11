package plopik.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class CourseHelper extends BaseHelper {

    public CourseHelper(WebDriver wd) {
        super(wd);
    }

    public void initElearningCourseCreation() {
        click(By.xpath("//i[contains(@data-icon-name, 'Add')]"));
        click(By.xpath("//button[contains(@name, 'e-Learning')]"));
    }

    public void fillCourseForm() {
        type(By.id("CourseName"), "aelearning8");
        type(By.id("Description"), "description1");
        typeCategory(By.cssSelector("#token-input-Categories_SelectedItems"), "elearning category");
    }

    private void typeCategory(By locator, String text) {
        wd.findElement(locator).clear();
//        System.out.println(wd.findElement(By.xpath("//div/ul/li[contains(text(), 'elearning category')]")).getText());
        wd.findElement(By.xpath("//div/ul/li[contains(text(), 'elearning category')]")).click();
//        try {
//            wd.findElement(By.xpath("//div[23]/ul/li[contains(text(), 'elearning category')]")).click();
//            Thread.sleep(5000);
//        } catch (Exception ex){
//            System.out.println("Error");
//        }

    }

    public void submitCourseCreation() {
        click(By.cssSelector("a.create-course"));

    }
}

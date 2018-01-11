package plopik.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        type(By.id("CourseName"), "aelearning");
        type(By.id("Description"), "description1");
        typeCategory(By.cssSelector("#token-input-Categories_SelectedItems"), "elearning category");
    }

    private void typeCategory(By locator, String text) {
//        wd.findElement(locator).click();
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
        waitElement(By.cssSelector("li.token-input-dropdown-item-sharepoint, token-input-dropdown-item2-sharepoint"), 10);
        wd.findElement(locator).sendKeys(Keys.ENTER);
//        click(By.xpath("//div[contains(@class, 'tooltip-element-form')]//li[contains(text(), 'elearning category')]"));
//        wd.findElement(By.cssSelector("li.token-input-dropdown-item-sharepoint, token-input-dropdown-item2-sharepoint")).sendKeys(Keys.ENTER);
//        wd.findElement(By.cssSelector("li.token-input-dropdown-item-sharepoint, li.token-input-dropdown-item2-sharepoint"))
//        waitElement(By.xpath("//div[contains(@class, 'tooltip-element-form')]//li[contains(text(), '" + text + "')]`)"), 10);
//        wd.findElement(By.xpath("//div[contains(@class, 'tooltip-element-form')]//li[contains(text(), 'elearning category')])")).sendKeys(Keys.ENTER);
//        wd.findElement(By.xpath("//div[contains(@class, 'tooltip-element-form')]//li[contains(text(), '" + text + "')]`)")).click();

    }

    public void submitCourseCreation() {
        click(By.cssSelector("a.create-course"));
        wd.findElement(By.cssSelector("span.icon-left-arrow")).isDisplayed();
        waitElement(By.cssSelector("span.icon-left-arrow"), 10);
    }
}

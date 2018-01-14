package plopik.test;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    ChromeDriver wd;
    WebDriverWait wait;

    public static boolean isAlertPresent(ChromeDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException ex) {
            return false;
        }
    }

    protected void login(String loginName, String password) {
        type(By.name("loginfmt"), loginName);
        click(By.xpath("//input[contains(@type, 'submit')]"));
        waitElementIsVisible(By.name("passwd"), 10);
        type(By.name("passwd"), password);
        click(By.xpath("//input[contains(@type, 'submit')]"));
    }

    private void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    private void click(By locator) {
        wd.findElement(locator).click();
    }

    private void waitElementIsVisible(By locator, int seconds) {
        wait = new WebDriverWait(wd, seconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    protected void fillCourseForm(String courseName, String shortDescription, String courseCategory) {
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

    protected void initCourseCreation() {
        click(By.xpath("//i[contains(@data-icon-name, 'Add')]"));
        click(By.xpath("//button[contains(@name, 'e-Learning')]"));
    }

    protected void goToCourseCatalog() {
        wd.get("https://lms365qa.sharepoint.com/sites/basic flow/_layouts/15/appredirect.aspx?instance_id={2fb42468-c7ae-4329-9e56-ebe12927573b}");
    }

    private void typeCategory(By locator, String text) {
        wd.findElement(locator).clear();
        click(By.xpath("//div/ul/li[contains(text(), '" + text + "')]"));
    }

    protected void init() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        wd.get("https://lms365qa.sharepoint.com/sites/basic flow/SitePages/Home.aspx");
        login("t3@lms365qa.onmicrosoft.com", "!QAZ2wsx");
    }

    protected void stop() {
        wd.quit();
    }
}

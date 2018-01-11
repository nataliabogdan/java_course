package plopik.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;
    WebDriverWait wait;

    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private CourseHelper courseHelper;
    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        if (browser == BrowserType.FIREFOX) {
            wd = new FirefoxDriver();
        } else if (browser == BrowserType.CHROME) {
            wd = new ChromeDriver();
        } else if (browser == BrowserType.IE) {
            wd = new InternetExplorerDriver();
        }
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("https://lms365qa.sharepoint.com/sites/basic flow");
        sessionHelper = new SessionHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        courseHelper = new CourseHelper(wd);
        sessionHelper.login("t3@lms365qa.onmicrosoft.com", "!QAZ2wsx");
    }

    public void stop() {
        wd.quit();
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public CourseHelper getCourseHelper() {
        return courseHelper;
    }
}

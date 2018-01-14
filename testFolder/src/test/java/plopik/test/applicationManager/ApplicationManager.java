package plopik.test.applicationManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;

    private NavigationHelper navigationHelper;
    private SessionHelper sessionHelper;
    private CourseHelper courseHelper;


    public void init() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        wd.get("https://lms365qa.sharepoint.com/sites/basic flow/SitePages/Home.aspx");
        sessionHelper = new SessionHelper(wd);
        courseHelper = new CourseHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper.login("t3@lms365qa.onmicrosoft.com", "!QAZ2wsx");
    }

    public void stop() {
        wd.quit();
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }

    public CourseHelper getCourseHelper() {
        return courseHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
}

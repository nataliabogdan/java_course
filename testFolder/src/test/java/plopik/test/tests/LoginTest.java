package plopik.test.tests;

import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void testLogin() {
        app.getNavigationHelper().goToCourseCatalog();
        app.getCourseHelper().initCourseCreation();
        app.getCourseHelper().fillCourseForm("e1qw", "qqq", "elearning category");
        app.getCourseHelper().submitCourseCreation();
        app.getCourseHelper().returnToCourseListPage();
    }

}

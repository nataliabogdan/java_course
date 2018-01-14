package plopik.test;

import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void testLogin() {
        app.goToCourseCatalog();
        app.initCourseCreation();
        app.fillCourseForm("e1q", "qqq", "elearning category");
        app.submitCourseCreation();
        app.returnToCourseListPage();
    }

}

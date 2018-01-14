package plopik.test;

import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void testLogin() {
        goToCourseCatalog();
        initCourseCreation();
        fillCourseForm("e1q", "qqq", "elearning category");
        submitCourseCreation();
        returnToCourseListPage();
    }

}

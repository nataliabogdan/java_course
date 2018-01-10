package plopik.tests;

import org.testng.annotations.Test;

public class CourseCreationTests extends TestBase {

    @Test
    public void testGoToCourseCatalog(){
        app.getNavigationHelper().goToCourseCatalog();
    }

}

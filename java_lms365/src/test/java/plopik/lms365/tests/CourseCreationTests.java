package plopik.lms365.tests;

import org.testng.annotations.Test;
import plopik.lms365.model.CourseData;

public class CourseCreationTests extends TestBase {

    @Test
    public void testGoToCourseCatalog(){
        CourseData courseData = new CourseData("e15", "desc1", "elearning category");

        app.getNavigationHelper().goToCourseCatalog();
        app.getCourseHelper().initElearningCourseCreation();
        app.getCourseHelper().fillCourseForm(courseData.getCourseName(), courseData.getShortDescription(), courseData.getCourseCategory());
        app.getCourseHelper().submitCourseCreation();
        app.getNavigationHelper().returnToCourseListPage();
        app.getCourseHelper().checkCourseInList(courseData.getCourseName());
    }

}

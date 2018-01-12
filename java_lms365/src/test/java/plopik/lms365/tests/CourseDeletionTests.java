package plopik.lms365.tests;

import org.testng.annotations.Test;
import plopik.lms365.model.CourseData;

public class CourseDeletionTests extends TestBase{

    @Test
    public void testCourseDeletion(){
        CourseData courseData = new CourseData("e15", null, null);
        app.getNavigationHelper().goToCourseCatalog();
        app.getCourseHelper().selectCourse(courseData.getCourseName());
        app.getCourseHelper().deleteCourse();
        app.getCourseHelper().filterByCourseName(courseData.getCourseName());
        app.getCourseHelper().checkCourseNotInList();

    }
}

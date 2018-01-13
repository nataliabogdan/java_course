package plopik.lms365.tests;

import org.testng.annotations.Test;
import plopik.lms365.model.CourseData;

public class CourseDeletionTests extends TestBase{

    @Test
    public void testCourseDeletion(){
        CourseData courseData = new CourseData(null, null, null);
        app.getNavigationHelper().goToCourseCatalog();
        if(! app.getCourseHelper().isCourseExist()){
            app.getCourseHelper().initElearningCourseCreation();
            app.getCourseHelper().fillCourseForm(new CourseData("e30", "desc1", "elearning category"));
            app.getCourseHelper().submitCourseCreation();
            app.getNavigationHelper().returnToCourseListPage();
        }
        app.getCourseHelper().selectCourseByName(courseData);
        app.getCourseHelper().deleteCourse();
        app.getCourseHelper().filterByCourseName(courseData);
//        app.getCourseHelper().checkCourseNotInList(); //hidden because if we select random course

    }
}

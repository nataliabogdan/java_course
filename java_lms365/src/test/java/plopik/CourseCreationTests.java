package plopik;

import org.testng.annotations.Test;

public class CourseCreationTests extends TestBase{

    @Test
    public void testGoToCourseCatalog(){
        wd.get("https://lms365qa.sharepoint.com/sites/basic flow/_layouts/15/appredirect.aspx?instance_id={2fb42468-c7ae-4329-9e56-ebe12927573b}");

    }

}

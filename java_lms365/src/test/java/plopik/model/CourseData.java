package plopik.model;

public class CourseData {
    private final String courseName;
    private final String shortDescription;
    private final String courseCategory;

    public CourseData(String courseName, String shortDescription, String courseCategory){
        this.courseName = courseName;
        this.shortDescription = shortDescription;
        this.courseCategory = courseCategory;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getCourseCategory() {
        return courseCategory;
    }
}

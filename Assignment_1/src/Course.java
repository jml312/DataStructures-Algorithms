// Stores information of a course
public class Course {

    // the ID of the course
    private String courseID;

    // the complete name of the course
    private String courseName;

    // the initial capacity limit of the course
    private int capacity;

    public Course(String courseID, String courseName, int capacity) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.capacity = capacity;
    }

    // gets the ID of a course
    public String getCourseID() {
        return courseID;
    }

    // sets the ID of a course
    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    // gets the name of a course
    public String getCourseName() {
        return courseName;
    }

    // sets the name of a course
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    // gets the capacity of a course
    public int getCapacity() {
        return capacity;
    }

    // sets the capacity of a course
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    // string representation of a Course
    @Override
    public String toString() {
        return "courseID: " + courseID + ", courseName: " + courseName + ", capacity: " + capacity;
    }
}

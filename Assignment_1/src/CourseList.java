import java.util.Scanner;

// Stores a list of courses
public class CourseList {

    // Stores a list of courses; set to a size of 10
    private final Course[] listOfCourses = new Course[10];

    // Stores the number of courses in the list of courses
    private int coursesInList = 0;

    // returns the current size of the list of courses array; the number of courses in the list
    public int size() {
        return coursesInList;
    }

    // adds a new course object to the ith index
    // if the i index does not have a course before it, the course is added to the next null element of the list
    // otherwise the course is added and all courses after are moved down a slot to the right
    // the edge case of a full list is ignored
    // increments courses in list after an add
    public void addCourse(int i, Course course) {
        // checks if the ith index is not null
        if (listOfCourses[i] != null) {
            // loops from the last course to the ith index
            for (int j = size() - 1; j >= i; j--) {
                listOfCourses[j + 1] = listOfCourses[j];
            }
            listOfCourses[i] = course;
        }
        // if the ith index is null
        else {
            listOfCourses[size()] = course;
        }
        coursesInList++;
    }

    // deletes the i-th element of the list and moves all elements down one
    // returns true if the element is removed
    // returns false if i is greater than the length of the list of courses
    // decrements courses in list if a course is deleted
    public boolean removeCourse(int i) {
        // checks if i is greater than the length of the list of courses
        if (listOfCourses.length < i) {
           return false;
        }
        // if the element to be removed is not null, the courses in the list is decremented
        if (listOfCourses[i] != null) {
            coursesInList--;
        }
        listOfCourses[i] = null;

        // loops through the length of the list from the first element
        for (int j = 1; j < listOfCourses.length; j++) {
            // checks if the current element is not null and the previous element is null
            // if so the element is moved backwards
            if (listOfCourses[j] != null && listOfCourses[j-1] == null) {
                listOfCourses[j-1] = listOfCourses[j];
                listOfCourses[j] = null;
            }
        }
        return true;
    }

    // changes the capacity of a class given a course ID and a capacity
    // returns true if that course is found and altered
    // returns false if that course is not found
    public boolean changeCapacity(String courseID, int capacity) {
        // looping through each course in the list of courses
        for (Course course : listOfCourses) {
            // checks if the course is not null and the course ID is equal to the input course ID
            if (course != null && course.getCourseID() == courseID) {
                course.setCapacity(capacity);
                return true;
            }
        }
        return false;
    }

    // returns a course from a given index
    // returns null if the i given is not in the list of courses
    public Course getCourseWithIndex(int i) {
       // checks if the i is greater than the length of the list of courses
        if (listOfCourses.length < i) {
            return null;
        }
        return listOfCourses[i];
    }

    // searches for a course given a course ID
    // returns the index if found
    // returns -1 if not found
    public int searchCourseID(String courseID) {
        // loops through the length of the list of courses
        for (int i = 0; i < listOfCourses.length; i++) {
            // checks if the course is not null and its course ID is equal to the input course ID
            if (listOfCourses[i] != null && listOfCourses[i].getCourseID() == courseID) {
                return i;
            }
        }
        return -1;
    }

    // searches for a course given a course name
    // returns the index if found
    // returns -1 if not found
    public int searchCourseName(String courseName) {
        // loops through the length of the list of courses
        for (int i = 0; i < listOfCourses.length; i++) {
            // checks if the course is not null and its course name is equal to the input course name
            if (listOfCourses[i] != null && listOfCourses[i].getCourseName() == courseName) {
                return i;
            }
        }
        return -1;
    }

    // prints the course list
    public void printCourseList() {
        // used to number the courses printed out in the course list
        int index = 0;
        // loop through each course in the course list
        for (Course course : listOfCourses) {
            System.out.println(index + ". " + course);
            index++;
        }
    }
}
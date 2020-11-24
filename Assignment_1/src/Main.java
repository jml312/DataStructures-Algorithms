public class Main {

    public static void main(String[] args) {

        CourseList courseList = new CourseList();

        // size method
        System.out.println("Operation: get the size of the course list");
        System.out.println("List with no courses:");
        courseList.printCourseList();
        // returns 0
        System.out.println("Size of the course list currently (should be 0) => Output: " + courseList.size());

        System.out.println();
        courseList.addCourse(1, new Course("1", "Data Structures", 50));
        System.out.println("List after adding a course:");
        courseList.printCourseList();
        // returns 1
        System.out.println("Size of the course list currently (should be 1) => Output: " + courseList.size());

        System.out.println();
        courseList.removeCourse(0);
        System.out.println("List after removing a course:");
        courseList.printCourseList();
        // returns 0
        System.out.println("Size of the course list currently (should be 0) => Output: " + courseList.size());

        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println();

        // addCourse method
        System.out.println("Operation: add a course to index 0, index 0 again (pushing the first course down one), and to the end of the list by passing an index at a null spot of 8");
        System.out.println("List before operation:");
        courseList.printCourseList();

        System.out.println();
        courseList.addCourse(0, new Course("1", "Linear Algebra", 50));
        courseList.addCourse(0, new Course("2", "Discrete Mathematics", 100));
        courseList.addCourse(8, new Course("3", "Introduction to Java", 200));
        System.out.println("List after operation:");
        courseList.printCourseList();

        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println();

        // removeCourse method
        System.out.println("Operation: remove a course with a valid index");
        System.out.println("List before operation:");
        courseList.printCourseList();
        System.out.println("Removing a course from index 1, the second spot (should return true) => Output: " + courseList.removeCourse(1));
        System.out.println("List after operation:");
        courseList.printCourseList();

        System.out.println();
        System.out.println("Operation: remove a course with an invalid index");
        System.out.println("List before operation:");
        courseList.printCourseList();
        System.out.println("Removing a course with an index out of range of 100 (should return false) => Output: " + courseList.removeCourse(100));
        System.out.println("List after operation:");
        courseList.printCourseList();

        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println();

        // changeCapacity method
        System.out.println("Operation: change the capacity of a course with a valid course ID");
        System.out.println("Current List:");
        courseList.printCourseList();
        System.out.println("Changing the capacity to 50 with a valid course ID of 2 (will return true) => Output: " + courseList.changeCapacity("2", 50));
        System.out.println("Discrete Mathematics course after the capacity is changed to 50 => Output: " + courseList.getCourseWithIndex(0));

        System.out.println();
        System.out.println("Operation: change the capacity of a course with an invalid course ID");
        System.out.println("Current List:");
        courseList.printCourseList();
        System.out.println("Changing the capacity to 20 with an invalid course ID of 20 (will return false) => Output: " + courseList.changeCapacity("20", 20));
        System.out.println("Discrete Mathematics course after the capacity is unsuccessfully changed => Output: " + courseList.getCourseWithIndex(0));


        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println();

        // getCourseWithIndex method
        System.out.println("Operation: get a course from a valid index");
        System.out.println("Current list:");
        courseList.printCourseList();
        System.out.println("Getting the course at the first spot by passing an index of 0 => Output: " + courseList.getCourseWithIndex(0));

        System.out.println();
        System.out.println("Operation: get a course from an invalid index");
        System.out.println("Current list:");
        courseList.printCourseList();
        System.out.println("Getting the course at the 100th spot by passing an index of 100 (should return null) => Output: " + courseList.getCourseWithIndex(100));

        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println();

        // searchCourseID method
        System.out.println("Operation: search for a course with a valid course ID");
        System.out.println("Current list:");
        courseList.printCourseList();
        System.out.println("Getting the index of the course with an ID of 2 (should return 0) => Output: " + courseList.searchCourseID("2"));

        System.out.println();
        System.out.println("Operation: search for a course with an invalid course ID");
        System.out.println("Current list:");
        courseList.printCourseList();
        System.out.println("Getting the index of the course with an invalid ID of 100 (should return -1) => Output: " + courseList.searchCourseID("100"));

        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println();

        // searchCourseName method
        System.out.println("Operation: search for a course with a valid course name");
        System.out.println("Current list:");
        courseList.printCourseList();
        System.out.println("Getting the index of the course with the name of Discrete Mathematics (should return 0) => Output: " + courseList.searchCourseName("Discrete Mathematics"));

        System.out.println();
        System.out.println("Operation: search for a course with an invalid course name");
        System.out.println("Current list:");
        courseList.printCourseList();
        System.out.println("Getting the index of the course with an invalid name of English (should return -1) => Output: " + courseList.searchCourseName("English"));

    }
}

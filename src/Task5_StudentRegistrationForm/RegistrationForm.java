package Task5_StudentRegistrationForm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Course {
    private String courseCode;
    private String title;
    private String description;
    private int capacity;
    private String schedule;
    private List<Student> enrolledStudents;

    public Course(String courseCode, String title, String description, int capacity, String schedule) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getSchedule() {
        return schedule;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void enrollStudent(Student student) {
        if (enrolledStudents.size() < capacity) {
            enrolledStudents.add(student);
            System.out.println(student.getName() + " successfully registered for " + title);
        } else {
            System.out.println("Course is full. " + student.getName() + " cannot register for " + title);
        }
    }

    public void removeStudent(Student student) {
        enrolledStudents.remove(student);
        System.out.println(student.getName() + " successfully removed from " + title);
    }
}

class Student {
    private int studentId;
    private String name;
    private List<Course> registeredCourses;

    public Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerForCourse(Course course) {
        registeredCourses.add(course);
        course.enrollStudent(this);
    }

    public void dropCourse(Course course) {
        registeredCourses.remove(course);
        course.removeStudent(this);
    }
}

class RegistrationForm {
    private List<Course> courses;
    private List<Student> students;

    public RegistrationForm() {
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayCourseList() {
        System.out.println("Available Courses:");
        for (Course course : courses) {
            System.out.println("Course Code: " + course.getCourseCode());
            System.out.println("Title: " + course.getTitle());
            System.out.println("Description: " + course.getDescription());
            System.out.println("Capacity: " + course.getEnrolledStudents().size() + "/" + course.getCapacity());
            System.out.println("Schedule: " + course.getSchedule());
            System.out.println("---------------");
        }
    }

    public void displayStudentRegistrations(Student student) {
        System.out.println("Registrations for " + student.getName() + ":");
        for (Course course : student.getRegisteredCourses()) {
            System.out.println("Course Code: " + course.getCourseCode());
            System.out.println("Title: " + course.getTitle());
            System.out.println("---------------");
        }
    }

    public static void main(String[] args) {
    	RegistrationForm system = new RegistrationForm();
        Scanner scanner = new Scanner(System.in);

        Course c1 = new Course("CSE101", "Introduction to Computer Science", "Fundamentals of programming", 30, "Mon-Wed-Fri");
        Course c2 = new Course("MAT201", "Software Engineer", "Java,SQL,React,SpringBoot", 25, "Tue-Thu");
        system.addCourse(c1);
        system.addCourse(c2);

        Student s1 = new Student(1, "John Doe");
        Student s2 = new Student(2, "Jane Smith");
        system.addStudent(s1);
        system.addStudent(s2);

        int choice;
        do {
            System.out.println("\n1. Display Course Listings");
            System.out.println("2. Display Student Registrations");
            System.out.println("3. Register for a Course");
            System.out.println("4. Drop a Course");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    system.displayCourseList();
                    break;
                case 2:
                    System.out.print("Enter student ID: ");
                    int studentId = scanner.nextInt();
                    Student student = system.findStudentById(studentId);
                    if (student != null) {
                        system.displayStudentRegistrations(student);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter student ID: ");
                    int studentIdToRegister = scanner.nextInt();
                    System.out.print("Enter course code: ");
                    String courseCodeToRegister = scanner.next();

                    Student studentToRegister = system.findStudentById(studentIdToRegister);
                    Course courseToRegister = system.findCourseByCode(courseCodeToRegister);

                    if (studentToRegister != null && courseToRegister != null) {
                        studentToRegister.registerForCourse(courseToRegister);
                    } else {
                        System.out.println("Student or course not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter student ID: ");
                    int studentIdToDrop = scanner.nextInt();
                    System.out.print("Enter course code: ");
                    String courseCodeToDrop = scanner.next();

                    Student studentToDrop = system.findStudentById(studentIdToDrop);
                    Course courseToDrop = system.findCourseByCode(courseCodeToDrop);

                    if (studentToDrop != null && courseToDrop != null) {
                        studentToDrop.dropCourse(courseToDrop);
                    } else {
                        System.out.println("Student or course not found.");
                    }
                    break;
                case 0:
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

        } while (choice != 0);

        scanner.close();
    }

    private Student findStudentById(int studentId) {
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                return student;
            }
        }
        return null;
    }

    private Course findCourseByCode(String courseCode) {
        for (Course course : courses) {
            if (course.getCourseCode().equalsIgnoreCase(courseCode)) {
                return course;
            }
        }
        return null;
    }
}


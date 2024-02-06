package StudentInformation;

import java.util.*;
public class Student {
    static Scanner scanner = new Scanner(System.in);

    String name;
    int age;
    String address;

    String course;
    int yearLevel;
    char section;
    boolean regularStudent;

    public void setName() {
        System.out.print("Name: ");
        name = scanner.next();
    }

    public void setAge() {
        System.out.print("Age: ");
        age = scanner.nextInt();
    }

    public void setAddress() {
        System.out.print("Address: ");
        scanner.nextLine();
        address = scanner.next();
    }

    public void setCourse() {
        System.out.print("Course: ");
        course = scanner.next();
    }

    public void setYearLevel() {
        System.out.print("Year Level: ");
        yearLevel = scanner.nextInt();
    }

    public void setSection() {
        System.out.print("Section: ");
        section = scanner.next().charAt(0);
    }

    public void getName() {
        System.out.println("Name: " + name);
    }

    public void getAge() {
        System.out.println("Age: " + age);
    }

    public void getAddress() {
        System.out.println("Address: " + address);
    }

    public void getCourse() {
        if (course.equalsIgnoreCase("BSIT") || course.equalsIgnoreCase("BS Info Tech")) {
            System.out.println("Course: Bachelor of Science in Information Technology");
        } else if (course.equalsIgnoreCase("BSIS") || course.equalsIgnoreCase("BS Info Sys")) {
            System.out.println("Course: Bachelor of Science in Information System");
        } else {
            System.out.print("Course:");
            System.err.println("Course not recognized.");
        }
    }

    public void getYearLevel() {
        System.out.println("Year Level: " + yearLevel);
    }

    public void getSection() {
        System.out.println("Section: " + section);
    }

    public void getRegularStudent() {
        if (regularStudent) {
            System.out.println("Status: Regular StudentInformation.Student");
        } else {
            System.out.println("Status: Irregular StudentInformation.Student");
        }
    }
}
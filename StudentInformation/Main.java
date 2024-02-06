package StudentInformation;

import java.util.*;
public class Main{
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();

        boolean addMoreStudent = true;
        while (addMoreStudent) {
            Student student = new Student();
            //Personal Information
            student.setName();
            student.setAge();
            student.setAddress();

            //School Information
            student.setCourse();
            student.setYearLevel();
            student.setSection();

            System.out.print("Are you a regular or irregular student? ");
            String answer = scanner.next();

            if (answer.equalsIgnoreCase("Regular")) {
                student.regularStudent = true;
            } else if (answer.equalsIgnoreCase("Irregular")) {
                student.regularStudent = false;
            }

            students.add(student);

            System.out.println("The student has been added");

            System.out.println();
            System.out.print("Do you want to add more student? (Y/N): ");
            char response = scanner.next().charAt(0);
            addMoreStudent = response == 'Y' || response == 'y';
            System.out.println();
        }

        //Outputs
        System.out.println("List of Students: ");
        int j = 1;
        for (Student student : students) {
            System.out.println("Student " + j + " Information:");
            student.getName();
            student.getAge();
            student.getAddress();
            student.getCourse();
            student.getYearLevel();
            student.getSection();
            student.getRegularStudent();
            j++;
            System.out.println();
        }
    }

}

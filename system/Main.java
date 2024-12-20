package school.management.system;

import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Teacher Anwar = new Teacher(1,"Anwar",10000);
        Teacher Rupinder = new Teacher (2,"Rupinder ", 20000);
        Teacher Grami = new Teacher(3,"Grami", 20000);

        List<Teacher> teacherList = new ArrayList<>();
        teacherList.add(Anwar);
        teacherList.add(Rupinder);
        teacherList.add(Grami);

        Student Khushi = new Student(1,"Khushi",12);
        Student Harsh = new Student(2,"Harsh",12);
        Student Noor = new Student(3,"Noor", 10);
        Student Hetvi = new Student(4,"Hetvi",12);

        List<Student> studentList = new ArrayList<>();
        studentList.add(Khushi);
        studentList.add(Harsh);
        studentList.add(Noor);
        studentList.add(Hetvi);

        School NESSS = new School(teacherList , studentList );
        System.out.println(NESSS.getTotalMoneyEarned());

        boolean run = true;

        while (run){
            System.out.println("\n===== School Management System ======");
            System.out.println("1. Pay Student Fees");
            System.out.println("2. Pay Teacher Salary");
            System.out.println("3. View Financial Summary");
            System.out.println("4. Add a Student");
            System.out.println("5. Add a Teacher");
            System.out.println("6. Student Details");
            System.out.println("7. Teacher Details");
            System.out.println("8. Exit");
            System.out.print("\nEnter Your Choice: ");
            int choice = scan.nextInt();

            switch (choice){
                case 1: //Paying student's salary
                    System.out.print("Enter Student ID: ");
                    int studId = scan.nextInt();
                    Student student = findStudentById(studentList, studId);
                    if (student!= null) {//The student has valid registered ID
                        System.out.println("Student Name: "+ student.getName());
                        System.out.print("Enter Amount to pay: ");
                        int amount = scan.nextInt();
                        student.payFees(amount);
                        System.out.println("Payment successful. Updated fees for: "+ student.getName());
                        System.out.println("Amount Paid: $"+ student.getFeesPaid());
                        System.out.println("Amount remaining: $"+ student.getRemainingFees());
                    }else{
                        System.out.println("Student not found in our Database.");
                    }
                    break;

                case 2: //Paying Teacher's Salary
                    System.out.print("Enter Teacher ID: ");
                    int teacherId = scan.nextInt();
                    Teacher teacher = findTeacherById(teacherList , teacherId);
                    if (teacher!= null){
                        //if Teacher has valid registered ID
                        NESSS.payTeacherSalary(teacher);
                    }else {
                        System.out.println("Teacher not found in our Database.");
                    }
                    break;

                case 3: // View Financial summary report
                    NESSS.getFinancialSummary();
                    break;

                case 4: //Adding a student
                    System.out.print("Enter Student Name: ");
                    scan.nextLine();  //to consume the empty line
                    String newStudentName = scan.nextLine();
                    System.out.print("Enter Student Grade: ");
                    int grade = scan.nextInt();
                    int newStudentId = studentList.size() + 1;
                    Student newStudent = new Student(newStudentId , newStudentName, grade);
                    studentList.add(newStudent);
                    NESSS.addAStudent(newStudent);
                    System.out.println("Student added successfully.");
                    break;

                case 5: // Adding A teacher
                    System.out.print("Enter Teacher Name: ");
                    scan.nextLine();
                    String newTeacherName = scan.nextLine();
                    System.out.print("Enter Salary: $");
                    int salary = scan.nextInt();
                    int newTeacherId = teacherList.size() + 1;
                    Teacher newTeacher = new Teacher(newTeacherId , newTeacherName , salary);
                    teacherList.add(newTeacher);
                    NESSS.addATeacher(newTeacher);
                    System.out.println("Teacher Added Successfully.");
                    break;

                case 6: //Details of a Student
                    System.out.print("Enter Student ID: ");
                    int studentIdToFind = scan.nextInt();
                    Student studentToFind = findStudentById(studentList , studentIdToFind);
                    if (studentToFind!= null){
                        System.out.println(studentToFind);
                    }else{
                        System.out.println("Student not found in the Database.");
                    }
                    break;

                case 7: //Details of Teacher
                    System.out.print("Enter Teacher ID: ");
                    int teacherIdToFind = scan.nextInt();
                    Teacher teacherToFind = findTeacherById(teacherList , teacherIdToFind);
                    if (teacherToFind!= null){
                        System.out.println(teacherToFind);
                    }else{
                        System.out.println("Teacher not found in the Database.");
                    }
                    break;

                case 8: //exit the System
                    run = false;
                    System.out.println("Exiting School Management System...");
                    break;
                default:
                    System.out.println("Invalid choice. Please Select between 1 to 8");
            }
        }
    }

    /**
     * Helper method to find the Student by the user entered ID
     * @param studentList - the array of all the Registered students
     * @param id - id of the student that you want to find
     * @return - the student object that matches the entered ID
     */
    private static Student findStudentById (List<Student> studentList , int id){
        for (Student student: studentList){
            if (student.getId() == id){
                return student;
            }
        }
        return null;
    }

    /**
     * Helper method to find the Teacher by the user entered ID
     * @param teacherList - the array of all the Registered Teachers
     * @param id - id of the Teacher you want to find
     * @return - the teacher object that matches the entered ID
     */

    private static Teacher findTeacherById (List<Teacher> teacherList , int id){
        for (Teacher teacher: teacherList){
            if (teacher.getId() == id){
                return teacher;
            }
        }
        return null;
    }
}
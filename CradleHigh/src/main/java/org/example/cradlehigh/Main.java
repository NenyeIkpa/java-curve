package org.example.cradlehigh;

import org.example.cradlehigh.db.Db;
import org.example.cradlehigh.users.Applicant;
import org.example.cradlehigh.users.Student;
import org.example.cradlehigh.users.UserType;
import org.example.cradlehigh.users.staff.academic.Principal;
import org.example.cradlehigh.users.staff.academic.Teacher;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Principal principal = new Principal("Daisy", "Young", 42, 'F', "daisy.young@gmail.com", "+2348038889292", UserType.PRINCIPAL);

        Teacher t1 = new Teacher("Martha", "Newman",32,'F',"martha.newman@gmail.com", "+2348037772525", UserType.TEACHER);
        Teacher t2 = new Teacher("John", "Decker",30,'M',"john.deckern@gmail.com", "+234803777210105", UserType.TEACHER);
        Teacher t3 = new Teacher("Jack", "Wu",34,'M',"jack.wu@gmail.com", "+2348037772525", UserType.TEACHER);
        Teacher t4 = new Teacher("Andie", "Jones",26,'F',"andie.jones@gmail.com", "+2348037755243", UserType.TEACHER);
        Teacher t5 = new Teacher("Queen", "Bee",28,'F',"queen.bee@gmail.com", "+2348036662743", UserType.TEACHER);
        Db db = new Db();

        db.setTeacher(t1);
        db.setTeacher(t2);
        db.setTeacher(t3);
        db.setTeacher(t4);
        db.setTeacher(t5);



        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("********  Welcome to Cradle High  ********8");
            System.out.println("To apply, press 1\nTo login, press 2\nTo exit, press 99");
            int selection = scanner.nextInt();
            if (selection == 2) {
                System.out.println("***** LOGIN ******");
                System.out.println("1. Student\n2. Teacher\n0. Admin");
                int loginOption = scanner.nextInt();
                scanner.nextLine();
                if (loginOption == 1 ) {
                    System.out.println("Enter student id");
                    String id = scanner.nextLine();
                    for (Student s: principal.getStudents()) {
                        if (s.getId() == id) {
                            System.out.println("Please enter password:");
                            String passwd = scanner.nextLine();
                            if (Objects.equals(passwd, "STUDENT")) {
                                principal.printStudent(id);
                            }
                        } else {
                            System.out.println("This ID does not exist.");
                            continue;
                        }
                    }
                } else if (loginOption == 2) {
                    principal.printTeachers();
//                    System.out.println("Enter teacher id");
//                    String id = scanner.nextLine();
//                    for (Teacher t: principal.getTeachers()) {
//                        System.out.println(t);
//                        if (Objects.equals(t.getId(), id)) {
//                            System.out.println("Please enter password:");
//                            String passwd = scanner.nextLine();
//                            if (Objects.equals(passwd, "TEACHER")) {
//                                principal.printTeacher(id);
//                            }
//                        } else {
//                            System.out.println("This ID does not exist.");
//                            continue;
//                        }
//                    }
                } else if (loginOption == 0) {
                    System.out.println("Please enter password:");
                    String passwd = scanner.nextLine();
                    if (Objects.equals(passwd, principal.getPassword())) {
                        actAsAdmin(principal);
                        // System.out.println("Hello World!");
                    } else {
                        System.out.println("Wrong password");
                        continue;
                    }
                }
            } else if (selection == 99) {
                break;
            }else if (selection == 1) {
               principal.acceptApplication(applyToCradleHigh());
                continue;

            }
        }
    }

    public static Applicant applyToCradleHigh() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your first name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter your last name:");
        String lastName = scanner.nextLine();
        System.out.println("Enter your age:");
        int age = scanner.nextInt();
        System.out.println("Gender:\n\t1 Male\n\t2 Female");
        scanner.nextLine();
        int g = scanner.nextInt();
        char gender = g == 1 ? 'M' : 'F';
        System.out.println("Enter your phone number:");
        scanner.nextLine();
        String phone = scanner.nextLine();
        System.out.println("Enter your email:");
        String email = scanner.nextLine();
        System.out.println("Class applied for:");
        String classApplied = scanner.nextLine();
        Applicant a = new Applicant(firstName, lastName, age, gender, phone, email, classApplied, UserType.APPLICANT);
        return a;
    }


    public static void actAsAdmin(Principal principal) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. View students\n2. View applicants\n3. Admit Students\n4. Expel student");
            int choice = scanner.nextInt();
                if (choice == 1) {
                    principal.getStudents();
                    System.out.println("To continue, press 1\nTo exit, press 0");
                    int option = scanner.nextInt();
                    if (option == 0) {
                        break;
                    } else {
                        continue;
                    }
                } else if (choice == 2) {
                    principal.printApplicants();
                    System.out.println("To continue, press 1\nTo exit, press 0");
                    int option = scanner.nextInt();
                    if (option == 0) {
                        break;
                    } else {
                        continue;
                    }
                } else if (choice == 3) {
                    principal.admitStudent(principal.getApplicants());
                    System.out.println("Rejected Applicants:");
                    principal.getRejectedApplicants();
                    System.out.println("Students:");
                    principal.getStudents();
                    System.out.println("To continue, press 1\nTo exit, press 0");
                    int option = scanner.nextInt();
                    if (option == 0) {
                        break;
                    } else {
                        continue;
                    }
                } else if (choice == 4) {
                    System.out.println("Enter student's first name");
                    scanner.nextLine();
                    String firstname = scanner.nextLine();
                    System.out.println("Enter student's last name");
                    String lastname = scanner.nextLine();
                    String id = principal.getStudent(firstname, lastname);
                    if (!Objects.equals(id, null)) {
                        principal.expelStudent(id);
                        principal.getStudents();
                    }
                    System.out.println("To continue, press 1\nTo exit, press 0");
                    int option = scanner.nextInt();
                    if (option == 0) {
                        break;
                    } else {
                        continue;
                    }
                } else {
                    System.out.println("Wrong input. Try again!");
                    continue;
                }
            }
        scanner.close();
    }
}
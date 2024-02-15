package org.example.cradlehigh;

import org.example.cradlehigh.db.Db;
import org.example.cradlehigh.model.users.Applicant;
import org.example.cradlehigh.model.users.Student;
import org.example.cradlehigh.model.users.staff.academic.Principal;
import org.example.cradlehigh.model.users.staff.academic.Teacher;

import java.util.Objects;
import java.util.Scanner;

public class Main {
   public static Db db = new Db();
   static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Principal principal = new Principal("Daisy", "Young", 42, 'F', "daisy.young@gmail.com", "+2348038889292");


        while (true) {
            System.out.println("********  Welcome to Cradle High  ********8");
            System.out.println("To apply, press 1\nTo login, press 2\nTo exit, press 99");
            int selection = scanner.nextInt();
            if (selection == 2) {
                System.out.println("***** LOGIN ******");
                System.out.println("1. Student\n2. Teacher\n0. Admin");
                int loginOption = scanner.nextInt();
                scanner.nextLine();
                if (loginOption == 1) {
                    System.out.println("Enter student id");
                    String sId = scanner.nextLine();
                    for (Student s : db.getStudents()) {
                        if (Objects.equals(s.getId(), sId)) {
                            System.out.println("Please enter password:");
                            String passwd = scanner.nextLine();
                            if (Objects.equals(passwd, "STUDENT")) {
                                System.out.println(s);
                            }
                        }
                    }
                    System.out.println("This ID does not exist.");
                } else if (loginOption == 2) {
                    System.out.println("Enter teacher id");
                    String id = scanner.nextLine();
                    for (Teacher t : db.getTeachers()) {
                        System.out.println(t);
                        if (Objects.equals(t.getId(), id)) {
                            System.out.println("Please enter password:");
                            String passwd = scanner.nextLine();
                            if (Objects.equals(passwd, "TEACHER")) {
                                System.out.println(t);
                            }
                        }
                    }
                    System.out.println("This ID does not exist.");
                } else if (loginOption == 0) {
                    System.out.println("Please enter password:");
                    String passwd = scanner.nextLine();
                    if (Objects.equals(passwd, principal.getPassword())) {
                        actAsAdmin(principal);
                        // System.out.println("Hello World!");
                    } else {
                        System.out.println("Wrong password");
                    }
                }
            } else if (selection == 99) {
                scanner.close();
                break;
            } else if (selection == 1) {
                db.setApplicant(applyToCradleHigh());
            }
        }
    }

    public static Applicant applyToCradleHigh() {
        System.out.println("Enter your first name:");
        scanner.nextLine();
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
        Applicant a = new Applicant(firstName, lastName, age, gender, email, phone, classApplied);
        System.out.println(a);
        System.out.println("Application received!");
        return a;
    }


    public static void actAsAdmin(Principal principal) {
        while (true) {
            System.out.println("1. View students\n2. View applicants\n3. Admit Students\n4. Expel student\n99. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                db.printStudents();
            } else if (choice == 2) {
                db.printApplicants();
            } else if (choice == 3) {
                for (Applicant a : db.getApplicants()) {
                    principal.admitStudent(a);
                }
                db.getApplicants().clear();
                System.out.println("Rejected Applicants:");
                principal.getRejectedApplicants();
                System.out.println("Students:");
                db.printStudents();
            } else if (choice == 4) {
                System.out.println("Enter student's id");
                String id = scanner.nextLine();
                if (!Objects.equals(id, null)) {
                    principal.expelStudent(id);
                }
            } else if (choice == 99) {
                return;
            } else {
                System.out.println("Wrong input. Try again!");
            }
        }
    }
}
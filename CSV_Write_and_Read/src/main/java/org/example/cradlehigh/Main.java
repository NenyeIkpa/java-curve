package org.example.cradlehigh;

import org.example.cradlehigh.db.Db;
import org.example.cradlehigh.model.users.Student;
import org.example.cradlehigh.model.users.staff.academic.Teacher;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Main {
    public static Db db = new Db();

    public static void main(String[] args) {
        System.out.println("Hello world!");
        List<Student> studentList = List.of(
                new Student("Jane", "Doe", 14, 'F', "jane.doe@gmail.com", "+23456789", "SSS1"),
                new Student("Raphael", "Jones", 12, 'M', "raphael.jones@gmail.com", "+12345678", "JSS1"),
                new Student("Olu", "Jenkins", 13, 'M', "olu.jenkins@gmail.com", "1229876763", "JSS2"),
                new Student("Edu", "Boy", 14, 'M', "edu.boy@gmail.com", "+1098754432", "SSS1"),
                new Student("Lola", "Davies", 15, 'F', "lola.davies@gmail.com", "+34568899073", "SSS2")
        );

        List<Teacher> teacherList = List.of(
                new Teacher("Andrew", "Simmons", 34, 'M', "andy.simmons@gmail.com", "+234156789"),
                new Teacher("Mary", "Atkins", 30, 'F', "mary.atkins@gmail.com", "+234789658780"),
                new Teacher("James", "Bond", 42, 'M', "james.bond@gmail.com", "+23456790879"),
                new Teacher("Joseph", "Arithmea", 44, 'M', "jo.arith@gmail.com", "+2347890655"),
                new Teacher("Samantha", "Edet", 45, 'F', "sam.edet@gmail.com", "+234123567")
        );
        String desktopPath = System.getProperty("user.home") + "/Desktop";
        String content;
        try {
            Writer br = new BufferedWriter(new FileWriter(desktopPath + "/java-curve/student_file.csv"));
            for (Student s : studentList) {
                content = s.toString() + "\n";
                br.write(content);
            }
            br.close();
            OutputStream fr = new FileOutputStream(desktopPath + "/java-curve/teacher_file.csv");
            for (Teacher t : teacherList) {
                content = t.toString() + "\n";
                fr.write(content.getBytes(StandardCharsets.UTF_8));
            }
            System.out.println("Success!");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.printf("Total number of students: %d\n", db.getStudents().size());
        System.out.printf("Total number of teachers: %d\n", db.getTeachers().size());

        try {
            BufferedReader br = new BufferedReader(new FileReader(desktopPath + "/java-curve/student_file.csv"));
            String readLine;
            while ((readLine = br.readLine()) != null) {
                String[] output = readLine.split(", ");
                    Student studentFromCSVFile = new Student(
                            output[1].split("=")[1],
                            output[2].split("=")[1],
                            Integer.parseInt(output[3].split("=")[1].replaceAll("'", "")),
                            output[4].split("=")[1].charAt(0),
                            output[5].split("=")[1],
                            output[6].split("=")[1],
                            output[7].split("=")[1]
                    );
                    db.setStudent(studentFromCSVFile);
                    System.out.println(readLine);
            }
            System.out.println("***********************************************************");
            System.out.printf("Total number of students: %d\n", db.getStudents().size());
            System.out.println("***********************************************************");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        try {
            BufferedReader br = new BufferedReader(new FileReader(desktopPath + "/java-curve/teacher_file.csv"));
            String readLine;
            while ((readLine = br.readLine()) != null) {
                String[] output = readLine.split(", ");
                Teacher teacherFromCSVFile = new Teacher(
                        output[1].split("=")[1],
                        output[2].split("=")[1],
                        Integer.parseInt(output[3].split("=")[1].replaceAll("'", "")),
                        output[4].split("=")[1].charAt(0),
                        output[5].split("=")[1],
                        output[6].split("=")[1]
                );
                db.setTeacher(teacherFromCSVFile);
                System.out.println(readLine);
            }
            System.out.println("***********************************************************");
            System.out.printf("Total number of teachers: %d\n", db.getTeachers().size());
            System.out.println("***********************************************************");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}